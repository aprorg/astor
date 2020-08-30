/* This file is part of the OWL API.
 * The contents of this file are subject to the LGPL License, Version 3.0.
 * Copyright 2014, The University of Manchester
 * 
 * This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License along with this program.  If not, see http://www.gnu.org/licenses/.
 *
 * Alternatively, the contents of this file may be used under the terms of the Apache License, Version 2.0 in which case, the provisions of the Apache License Version 2.0 are applicable instead of those above.
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License. */
package org.semanticweb.owlapi.debugging;

import static org.semanticweb.owlapi.util.OWLAPIPreconditions.*;
import static org.semanticweb.owlapi.util.OWLAPIStreamUtils.add;

import java.io.Serializable;
import java.util.*;

import javax.annotation.Nullable;

import org.semanticweb.owlapi.model.*;
import org.semanticweb.owlapi.util.OWLEntityCollector;

import com.google.common.collect.Multimap;
import com.google.common.collect.MultimapBuilder;

/**
 * @author Matthew Horridge, The University Of Manchester, Bio-Health
 *         Informatics Group
 * @since 2.0.0
 */
public class JustificationMap {

    private final Set<OWLAxiom> axioms;
    private final Set<OWLAxiom> rootAxioms = new HashSet<>();
    private final Set<OWLAxiom> usedAxioms = new HashSet<>();
    private final Multimap<OWLAxiom, OWLAxiom> map = MultimapBuilder.hashKeys().arrayListValues().build();
    private final Multimap<OWLEntity, OWLAxiom> axiomsByLHS = MultimapBuilder.hashKeys().arrayListValues().build();
    private final OWLClassExpression desc;

    /**
     * Instantiates a new justification map.
     * 
     * @param desc
     *        the class expression
     * @param axioms
     *        the axioms
     */
    public JustificationMap(OWLClassExpression desc, Set<OWLAxiom> axioms) {
        this.axioms = checkNotNull(axioms, "axioms cannot be null");
        this.desc = checkNotNull(desc, "desc cannot be null");
        createMap();
    }

    private void createMap() {
        for (OWLAxiom ax : axioms) {
            OWLAxiomPartExtractor extractor = new OWLAxiomPartExtractor();
            ax.accept(extractor);
            Set<OWLEntity> lhscollected = new HashSet<>();
            OWLEntityCollector lhsCollector = new OWLEntityCollector(lhscollected);
            extractor.getLHS().forEach(l -> l.accept(lhsCollector));
            lhscollected.forEach(l -> axiomsByLHS.put(l, ax));
        }
        buildChildren(desc);
    }

    /**
     * Gets the axioms by lhs.
     * 
     * @param lhs
     *        the lhs
     * @return the axioms by lhs
     */
    private Set<OWLAxiom> getAxiomsByLHS(OWLEntity lhs) {
        Set<OWLAxiom> ts = new TreeSet<>(new OWLAxiomComparator());
        ts.addAll(axiomsByLHS.get(lhs));
        return ts;
    }

    private void buildChildren(OWLClassExpression seed) {
        // Return the axioms that have the entity on the LHS
        Set<OWLAxiom> result = new HashSet<>();
        seed.signature().forEach(e -> {
            Set<OWLAxiom> axs = getAxiomsByLHS(e);
            result.addAll(axs);
            usedAxioms.addAll(axs);
        } );
        rootAxioms.addAll(result);
        buildChildren(result);
    }

    private void buildChildren(Set<OWLAxiom> axiomSet) {
        List<Set<OWLAxiom>> axiomChildren = new ArrayList<>();
        for (OWLAxiom ax : axiomSet) {
            Set<OWLAxiom> children = build(ax);
            children.forEach(a -> map.put(a, ax));
            axiomChildren.add(children);
        }
        axiomChildren.forEach(c -> buildChildren(c));
    }

    /**
     * Builds the.
     * 
     * @param parentAxiom
     *        the parent axiom
     * @return the sets the
     */
    private Set<OWLAxiom> build(OWLAxiom parentAxiom) {
        usedAxioms.add(parentAxiom);
        OWLAxiomPartExtractor extractor = new OWLAxiomPartExtractor();
        parentAxiom.accept(extractor);
        Set<OWLAxiom> result = new HashSet<>();
        extractor.getRHS().stream().flatMap(o -> o.signature()).flatMap(e -> getAxiomsByLHS(e).stream())
                .filter(ax -> usedAxioms.add(ax)).forEach(ax -> result.add(ax));
        return result;
    }

    /**
     * Gets the root axioms.
     * 
     * @return the root axioms
     */
    public Set<OWLAxiom> getRootAxioms() {
        return rootAxioms;
    }

    /**
     * Gets the child axioms.
     * 
     * @param ax
     *        the axiom whose children are to be retrieved
     * @return children of ax
     */
    public Collection<OWLAxiom> getChildAxioms(OWLAxiom ax) {
        return map.get(ax);
    }

    /** The Class OWLAxiomPartExtractor. */
    private static class OWLAxiomPartExtractor implements OWLAxiomVisitor {

        private final Set<OWLObject> rhs = new HashSet<>();
        private final Set<OWLObject> lhs = new HashSet<>();

        /**
         * Gets the rhs.
         * 
         * @return the rhs
         */
        public Set<OWLObject> getRHS() {
            return rhs;
        }

        /**
         * Gets the lhs.
         * 
         * @return the lhs
         */
        public Set<OWLObject> getLHS() {
            return lhs;
        }

        /** Instantiates a new oWL axiom part extractor. */
        OWLAxiomPartExtractor() {}

        @Override
        public void visit(OWLSubClassOfAxiom axiom) {
            rhs.add(axiom.getSuperClass());
            lhs.add(axiom.getSubClass());
        }

        @Override
        public void visit(OWLNegativeObjectPropertyAssertionAxiom axiom) {
            rhs.add(axiom.getObject());
            rhs.add(axiom.getProperty());
            lhs.add(axiom.getSubject());
        }

        @Override
        public void visit(OWLAsymmetricObjectPropertyAxiom axiom) {
            rhs.add(axiom.getProperty());
        }

        @Override
        public void visit(OWLReflexiveObjectPropertyAxiom axiom) {
            rhs.add(axiom.getProperty());
        }

        @Override
        public void visit(OWLDisjointClassesAxiom axiom) {
            add(axiom.classExpressions(), rhs);
            add(axiom.classExpressions(), lhs);
        }

        @Override
        public void visit(OWLDataPropertyDomainAxiom axiom) {
            rhs.add(axiom.getDomain());
            lhs.add(axiom.getProperty());
        }

        @Override
        public void visit(OWLObjectPropertyDomainAxiom axiom) {
            rhs.add(axiom.getDomain());
            lhs.add(axiom.getProperty());
        }

        @Override
        public void visit(OWLEquivalentObjectPropertiesAxiom axiom) {
            add(axiom.properties(), rhs);
            add(axiom.properties(), lhs);
        }

        @Override
        public void visit(OWLNegativeDataPropertyAssertionAxiom axiom) {
            rhs.add(axiom.getProperty());
            rhs.add(axiom.getObject());
            lhs.add(axiom.getSubject());
        }

        @Override
        public void visit(OWLDifferentIndividualsAxiom axiom) {
            add(axiom.individuals(), rhs);
            add(axiom.individuals(), lhs);
        }

        @Override
        public void visit(OWLDisjointDataPropertiesAxiom axiom) {
            add(axiom.properties(), rhs);
            add(axiom.properties(), lhs);
        }

        @Override
        public void visit(OWLDisjointObjectPropertiesAxiom axiom) {
            add(axiom.properties(), rhs);
            add(axiom.properties(), lhs);
        }

        @Override
        public void visit(OWLObjectPropertyRangeAxiom axiom) {
            rhs.add(axiom.getRange());
            lhs.add(axiom.getProperty());
        }

        @Override
        public void visit(OWLObjectPropertyAssertionAxiom axiom) {
            rhs.add(axiom.getProperty());
            rhs.add(axiom.getObject());
            lhs.add(axiom.getSubject());
        }

        @Override
        public void visit(OWLFunctionalObjectPropertyAxiom axiom) {
            rhs.add(axiom.getProperty());
        }

        @Override
        public void visit(OWLSubObjectPropertyOfAxiom axiom) {
            rhs.add(axiom.getSuperProperty());
            lhs.add(axiom.getSubProperty());
        }

        @Override
        public void visit(OWLDisjointUnionAxiom axiom) {
            add(axiom.classExpressions(), rhs);
            rhs.add(axiom.getOWLClass());
            lhs.add(axiom.getOWLClass());
            add(axiom.classExpressions(), lhs);
        }

        @Override
        public void visit(OWLSymmetricObjectPropertyAxiom axiom) {
            rhs.add(axiom.getProperty());
        }

        @Override
        public void visit(OWLDataPropertyRangeAxiom axiom) {
            rhs.add(axiom.getRange());
            lhs.add(axiom.getProperty());
        }

        @Override
        public void visit(OWLFunctionalDataPropertyAxiom axiom) {
            rhs.add(axiom.getProperty());
        }

        @Override
        public void visit(OWLEquivalentDataPropertiesAxiom axiom) {
            add(axiom.properties(), rhs);
            add(axiom.properties(), lhs);
        }

        @Override
        public void visit(OWLClassAssertionAxiom axiom) {
            rhs.add(axiom.getClassExpression());
            lhs.add(axiom.getIndividual());
        }

        @Override
        public void visit(OWLEquivalentClassesAxiom axiom) {
            add(axiom.classExpressions(), rhs);
            add(axiom.classExpressions(), lhs);
        }

        @Override
        public void visit(OWLDataPropertyAssertionAxiom axiom) {
            rhs.add(axiom.getProperty());
            lhs.add(axiom.getSubject());
        }

        @Override
        public void visit(OWLTransitiveObjectPropertyAxiom axiom) {
            rhs.add(axiom.getProperty());
        }

        @Override
        public void visit(OWLIrreflexiveObjectPropertyAxiom axiom) {
            rhs.add(axiom.getProperty());
        }

        @Override
        public void visit(OWLSubDataPropertyOfAxiom axiom) {
            rhs.add(axiom.getSuperProperty());
        }

        @Override
        public void visit(OWLInverseFunctionalObjectPropertyAxiom axiom) {
            rhs.add(axiom.getProperty());
        }

        @Override
        public void visit(OWLSameIndividualAxiom axiom) {
            add(axiom.individuals(), rhs);
            add(axiom.individuals(), lhs);
        }

        @Override
        public void visit(OWLSubPropertyChainOfAxiom axiom) {
            rhs.add(axiom.getSuperProperty());
            lhs.addAll(axiom.getPropertyChain());
        }

        @Override
        public void visit(OWLInverseObjectPropertiesAxiom axiom) {
            add(axiom.properties(), rhs);
            add(axiom.properties(), lhs);
        }

        @Override
        public void visit(SWRLRule rule) {}
    }

    /** The Class OWLAxiomComparator. */
    private static class OWLAxiomComparator implements OWLAxiomVisitor, Comparator<OWLAxiom>, Serializable {

        private int result;

        /** Instantiates a new oWL axiom comparator. */
        OWLAxiomComparator() {}

        @Override
        public void visit(OWLSubClassOfAxiom axiom) {
            result = 0;
        }

        @Override
        public void visit(OWLEquivalentClassesAxiom axiom) {
            result = 1;
        }

        @Override
        public void visit(OWLDisjointClassesAxiom axiom) {
            result = 2;
        }

        @Override
        public int compare(@Nullable OWLAxiom o1, @Nullable OWLAxiom o2) {
            result = 0;
            verifyNotNull(o1).accept(this);
            int result1 = result;
            verifyNotNull(o2).accept(this);
            int result2 = result;
            int diff = result2 - result1;
            if (diff != 0) {
                return diff;
            } else {
                return -1;
            }
        }
    }
}

java -cp astor.jar fr.inria.main.evolution.AstorMain \
-location /Users/cuong/IdeaProjects/jrelifix/BugsDataset/languagetool-core \
-dependencies /Users/cuong/IdeaProjects/jrelifix/BugsDataset/languagetool-core/target/dependency:/Users/cuong/IdeaProjects/jrelifix/BugsDataset/languagetool-language-modules/fr/target/dependency:/Users/cuong/IdeaProjects/jrelifix/BugsDataset/languagetool-language-modules/fr/target/classes \
-faultfile /Users/cuong/IdeaProjects/jrelifix/SusFiles/PerfectFL/languagetool-org-languagetool-393031702.txt \
-mode jgenprog \
-srcjavafolder /src/main/java \
-srctestfolder /../languagetool-language-modules/fr/src/test/java \
-binjavafolder /target/classes \
-bintestfolder /../languagetool-language-modules/fr/target/test-classes \
-stopfirst true
/*
 * Copyright 2014-2018 Web Firm Framework
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * @author WFF
 */
package com.webfirmframework.wffweb.tag.html.attribute.event.form;

import com.webfirmframework.wffweb.tag.html.attribute.AttributeNameConstants;
import com.webfirmframework.wffweb.tag.html.attribute.event.AbstractEventAttribute;
import com.webfirmframework.wffweb.tag.html.attribute.event.ServerAsyncMethod;
import com.webfirmframework.wffweb.tag.html.identifier.AAttributable;

/**
 *
 * <code>onfocus</code> attribute for the element. This attribute is supported
 * by multiple tags.
 *
 * @since 2.0.0
 * @author WFF
 *
 */
public class OnFocus extends AbstractEventAttribute implements AAttributable {

    private static final long serialVersionUID = 1_0_0L;

    {
        super.setAttributeName(AttributeNameConstants.ONFOCUS);
        init();
    }

    public OnFocus() {
    }

    public OnFocus(final ServerAsyncMethod serverAsyncMethod) {
        setServerAsyncMethod(null, serverAsyncMethod, null, null);
    }

    public OnFocus(final String preJsFunctionBody,
            final ServerAsyncMethod serverAsyncMethod,
            final String jsFilterFunctionBody,
            final String postJsFunctionBody) {
        setServerAsyncMethod(preJsFunctionBody, serverAsyncMethod,
                jsFilterFunctionBody, postJsFunctionBody);
    }

    public OnFocus(final String value) {
        setAttributeValue(value);
    }

    /**
     * invokes only once per object
     *
     * @author WFF
     * @since 2.0.0
     */
    @Override
    protected void init() {
        // to override and use this method
    }

}

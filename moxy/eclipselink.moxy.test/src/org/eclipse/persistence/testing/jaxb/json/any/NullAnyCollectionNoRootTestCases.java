/*******************************************************************************
 * Copyright (c) 2012, 2015  Oracle and/or its affiliates. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0
 * which accompanies this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *     Blaise Doughan - 2.4.2 - initial implementation
 ******************************************************************************/
package org.eclipse.persistence.testing.jaxb.json.any;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.eclipse.persistence.jaxb.JAXBContextProperties;
import org.eclipse.persistence.testing.jaxb.json.JSONMarshalUnmarshalTestCases;

public class NullAnyCollectionNoRootTestCases extends JSONMarshalUnmarshalTestCases {

    private String JSON = "org/eclipse/persistence/testing/jaxb/json/any/NoAnyCollectionNoRoot.json";

    public NullAnyCollectionNoRootTestCases(String name) throws Exception {
        super(name);
        setClasses(new Class[] {Root.class});
        setControlJSON(JSON);
    }

    @Override
    protected JAXBElement<Root> getControlObject() {
        Root root = new Root();
        root.setItems(null);
        return new JAXBElement<Root>(new QName(""), Root.class, root);
    }


    @Override
    public JAXBElement<Root> getReadControlObject() {
        return new JAXBElement<Root>(new QName(""), Root.class, new Root());
    }

    @Override
    public Map getProperties() {
        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put(JAXBContextProperties.MEDIA_TYPE, "application/json");
        properties.put(JAXBContextProperties.JSON_INCLUDE_ROOT, false);
        return properties;
    }

    public Class getUnmarshalClass() {
        return Root.class;
    }

}

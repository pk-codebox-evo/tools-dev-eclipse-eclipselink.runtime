/*******************************************************************************
 * Copyright (c) 2013, 2015  Oracle and/or its affiliates. All rights reserved.
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
package org.eclipse.persistence.testing.jaxb.json.wrapper;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.eclipse.persistence.jaxb.JAXBContextProperties;
import org.eclipse.persistence.testing.jaxb.json.JSONMarshalUnmarshalTestCases;

public class BinaryCollectionTestCases extends JSONMarshalUnmarshalTestCases {

    private static final String JSON = "org/eclipse/persistence/testing/jaxb/json/wrapper/BinaryCollection.json";

    public BinaryCollectionTestCases(String name) throws Exception {
        super(name);
        setClasses(new Class[] {BinaryCollectionRoot.class});
        setControlJSON(JSON);
    }

    @Override
    protected JAXBElement<BinaryCollectionRoot> getControlObject() {
        BinaryCollectionRoot root = new BinaryCollectionRoot();
        root.getWrapperItems().add("Hello".getBytes());
        root.getWrapperItems().add("World".getBytes());
        root.getXmlPathItems().add("foo".getBytes());
        root.getXmlPathItems().add("bar".getBytes());
        return new JAXBElement<BinaryCollectionRoot>(new QName(""), BinaryCollectionRoot.class, root);
    }

    @Override
    public Class getUnmarshalClass() {
        return BinaryCollectionRoot.class;
    }

    @Override
    public Map getProperties() {
        Map<String, Object> properties = new HashMap<String, Object>(3);
        properties.put(JAXBContextProperties.MEDIA_TYPE, "application/json");
        properties.put(JAXBContextProperties.JSON_INCLUDE_ROOT, false);
        properties.put(JAXBContextProperties.JSON_WRAPPER_AS_ARRAY_NAME, true);
        return properties;
    }

}

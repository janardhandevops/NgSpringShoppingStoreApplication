package com.techie.shoppingstore.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ProductAttributeTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link ProductAttribute}
     *   <li>{@link ProductAttribute#setAttributeName(String)}
     *   <li>{@link ProductAttribute#setAttributeValue(String)}
     * </ul>
     */
    @Test
    public void testConstructor() {
        ProductAttribute actualProductAttribute = new ProductAttribute();
        actualProductAttribute.setAttributeName("Attribute Name");
        actualProductAttribute.setAttributeValue("42");
        assertEquals("Attribute Name", actualProductAttribute.getAttributeName());
        assertEquals("42", actualProductAttribute.getAttributeValue());
    }
}


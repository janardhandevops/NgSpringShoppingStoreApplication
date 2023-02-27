package com.techie.shoppingstore.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FacetValueDtoTest {
    /**
     * Method under test: {@link FacetValueDto#canEqual(Object)}
     */
    @Test
    public void testCanEqual() {
        assertFalse((new FacetValueDto()).canEqual("Other"));
    }

    /**
     * Method under test: {@link FacetValueDto#canEqual(Object)}
     */
    @Test
    public void testCanEqual2() {
        FacetValueDto facetValueDto = new FacetValueDto();
        assertTrue(facetValueDto.canEqual(new FacetValueDto()));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link FacetValueDto#FacetValueDto()}
     *   <li>{@link FacetValueDto#setCount(Integer)}
     *   <li>{@link FacetValueDto#setFacetValueName(String)}
     * </ul>
     */
    @Test
    public void testConstructor() {
        FacetValueDto actualFacetValueDto = new FacetValueDto();
        actualFacetValueDto.setCount(3);
        actualFacetValueDto.setFacetValueName("42");
        assertEquals(3, actualFacetValueDto.getCount().intValue());
        assertEquals("42", actualFacetValueDto.getFacetValueName());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link FacetValueDto#FacetValueDto(String, Integer)}
     *   <li>{@link FacetValueDto#setCount(Integer)}
     *   <li>{@link FacetValueDto#setFacetValueName(String)}
     * </ul>
     */
    @Test
    public void testConstructor2() {
        FacetValueDto actualFacetValueDto = new FacetValueDto("42", 3);
        actualFacetValueDto.setCount(3);
        actualFacetValueDto.setFacetValueName("42");
        assertEquals(3, actualFacetValueDto.getCount().intValue());
        assertEquals("42", actualFacetValueDto.getFacetValueName());
    }

    /**
     * Method under test: {@link FacetValueDto#equals(Object)}
     */
    @Test
    public void testEquals() {
        assertNotEquals(new FacetValueDto(), null);
        assertNotEquals(new FacetValueDto(), "Different type to FacetValueDto");
    }

    /**
     * Method under test: {@link FacetValueDto#equals(Object)}
     */
    @Test
    public void testEquals2() {
        FacetValueDto facetValueDto = new FacetValueDto();
        assertEquals(facetValueDto, facetValueDto);
        int expectedHashCodeResult = facetValueDto.hashCode();
        assertEquals(expectedHashCodeResult, facetValueDto.hashCode());
    }

    /**
     * Method under test: {@link FacetValueDto#equals(Object)}
     */
    @Test
    public void testEquals3() {
        FacetValueDto facetValueDto = new FacetValueDto();
        FacetValueDto facetValueDto1 = new FacetValueDto();
        assertEquals(facetValueDto, facetValueDto1);
        int expectedHashCodeResult = facetValueDto.hashCode();
        assertEquals(expectedHashCodeResult, facetValueDto1.hashCode());
    }

    /**
     * Method under test: {@link FacetValueDto#equals(Object)}
     */
    @Test
    public void testEquals4() {
        FacetValueDto facetValueDto = new FacetValueDto("42", 3);
        assertNotEquals(facetValueDto, new FacetValueDto());
    }

    /**
     * Method under test: {@link FacetValueDto#equals(Object)}
     */
    @Test
    public void testEquals5() {
        FacetValueDto facetValueDto = new FacetValueDto();
        assertNotEquals(facetValueDto, new FacetValueDto("42", 3));
    }

    /**
     * Method under test: {@link FacetValueDto#equals(Object)}
     */
    @Test
    public void testEquals6() {
        FacetValueDto facetValueDto = new FacetValueDto();
        facetValueDto.setCount(3);
        assertNotEquals(facetValueDto, new FacetValueDto());
    }

    /**
     * Method under test: {@link FacetValueDto#equals(Object)}
     */
    @Test
    public void testEquals7() {
        FacetValueDto facetValueDto = new FacetValueDto("42", 3);
        FacetValueDto facetValueDto1 = new FacetValueDto("42", 3);

        assertEquals(facetValueDto, facetValueDto1);
        int expectedHashCodeResult = facetValueDto.hashCode();
        assertEquals(expectedHashCodeResult, facetValueDto1.hashCode());
    }

    /**
     * Method under test: {@link FacetValueDto#equals(Object)}
     */
    @Test
    public void testEquals8() {
        FacetValueDto facetValueDto = new FacetValueDto();

        FacetValueDto facetValueDto1 = new FacetValueDto();
        facetValueDto1.setCount(3);
        assertNotEquals(facetValueDto, facetValueDto1);
    }
}


package com.techie.shoppingstore.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class FacetDtoTest {
    /**
     * Method under test: {@link FacetDto#canEqual(Object)}
     */
    @Test
    public void testCanEqual() {
        assertFalse((new FacetDto()).canEqual("Other"));
    }

    /**
     * Method under test: {@link FacetDto#canEqual(Object)}
     */
    @Test
    public void testCanEqual2() {
        FacetDto facetDto = new FacetDto();
        assertTrue(facetDto.canEqual(new FacetDto()));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link FacetDto#FacetDto()}
     *   <li>{@link FacetDto#setFacetName(String)}
     *   <li>{@link FacetDto#setFacetValueDto(List)}
     * </ul>
     */
    @Test
    public void testConstructor() {
        FacetDto actualFacetDto = new FacetDto();
        actualFacetDto.setFacetName("Facet Name");
        ArrayList<FacetValueDto> facetValueDtoList = new ArrayList<>();
        actualFacetDto.setFacetValueDto(facetValueDtoList);
        assertEquals("Facet Name", actualFacetDto.getFacetName());
        assertSame(facetValueDtoList, actualFacetDto.getFacetValueDto());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link FacetDto#FacetDto(String, List)}
     *   <li>{@link FacetDto#setFacetName(String)}
     *   <li>{@link FacetDto#setFacetValueDto(List)}
     * </ul>
     */
    @Test
    public void testConstructor2() {
        FacetDto actualFacetDto = new FacetDto("Facet Name", new ArrayList<>());
        actualFacetDto.setFacetName("Facet Name");
        ArrayList<FacetValueDto> facetValueDtoList = new ArrayList<>();
        actualFacetDto.setFacetValueDto(facetValueDtoList);
        assertEquals("Facet Name", actualFacetDto.getFacetName());
        assertSame(facetValueDtoList, actualFacetDto.getFacetValueDto());
    }

    /**
     * Method under test: {@link FacetDto#equals(Object)}
     */
    @Test
    public void testEquals() {
        assertNotEquals(new FacetDto(), null);
        assertNotEquals(new FacetDto(), "Different type to FacetDto");
    }

    /**
     * Method under test: {@link FacetDto#equals(Object)}
     */
    @Test
    public void testEquals2() {
        FacetDto facetDto = new FacetDto();
        assertEquals(facetDto, facetDto);
        int expectedHashCodeResult = facetDto.hashCode();
        assertEquals(expectedHashCodeResult, facetDto.hashCode());
    }

    /**
     * Method under test: {@link FacetDto#equals(Object)}
     */
    @Test
    public void testEquals3() {
        FacetDto facetDto = new FacetDto();
        FacetDto facetDto1 = new FacetDto();
        assertEquals(facetDto, facetDto1);
        int expectedHashCodeResult = facetDto.hashCode();
        assertEquals(expectedHashCodeResult, facetDto1.hashCode());
    }

    /**
     * Method under test: {@link FacetDto#equals(Object)}
     */
    @Test
    public void testEquals4() {
        FacetDto facetDto = new FacetDto("Facet Name", new ArrayList<>());
        assertNotEquals(facetDto, new FacetDto());
    }

    /**
     * Method under test: {@link FacetDto#equals(Object)}
     */
    @Test
    public void testEquals5() {
        FacetDto facetDto = new FacetDto();
        assertNotEquals(facetDto, new FacetDto("Facet Name", new ArrayList<>()));
    }

    /**
     * Method under test: {@link FacetDto#equals(Object)}
     */
    @Test
    public void testEquals6() {
        FacetDto facetDto = new FacetDto();
        facetDto.setFacetValueDto(new ArrayList<>());
        assertNotEquals(facetDto, new FacetDto());
    }

    /**
     * Method under test: {@link FacetDto#equals(Object)}
     */
    @Test
    public void testEquals7() {
        FacetDto facetDto = new FacetDto("Facet Name", new ArrayList<>());
        FacetDto facetDto1 = new FacetDto("Facet Name", new ArrayList<>());

        assertEquals(facetDto, facetDto1);
        int expectedHashCodeResult = facetDto.hashCode();
        assertEquals(expectedHashCodeResult, facetDto1.hashCode());
    }

    /**
     * Method under test: {@link FacetDto#equals(Object)}
     */
    @Test
    public void testEquals8() {
        FacetDto facetDto = new FacetDto();

        FacetDto facetDto1 = new FacetDto();
        facetDto1.setFacetValueDto(new ArrayList<>());
        assertNotEquals(facetDto, facetDto1);
    }
}


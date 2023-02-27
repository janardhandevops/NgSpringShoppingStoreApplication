package com.techie.shoppingstore.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class SearchQueryDtoTest {
    /**
     * Method under test: {@link SearchQueryDto#canEqual(Object)}
     */
    @Test
    public void testCanEqual() {
        assertFalse((new SearchQueryDto()).canEqual("Other"));
    }

    /**
     * Method under test: {@link SearchQueryDto#canEqual(Object)}
     */
    @Test
    public void testCanEqual2() {
        SearchQueryDto searchQueryDto = new SearchQueryDto();

        SearchQueryDto searchQueryDto1 = new SearchQueryDto();
        searchQueryDto1.setFilters(new ArrayList<>());
        searchQueryDto1.setTextQuery("Text Query");
        assertTrue(searchQueryDto.canEqual(searchQueryDto1));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link SearchQueryDto}
     *   <li>{@link SearchQueryDto#setFilters(List)}
     *   <li>{@link SearchQueryDto#setTextQuery(String)}
     * </ul>
     */
    @Test
    public void testConstructor() {
        SearchQueryDto actualSearchQueryDto = new SearchQueryDto();
        ArrayList<SearchQueryDto.Filter> filterList = new ArrayList<>();
        actualSearchQueryDto.setFilters(filterList);
        actualSearchQueryDto.setTextQuery("Text Query");
        assertSame(filterList, actualSearchQueryDto.getFilters());
        assertEquals("Text Query", actualSearchQueryDto.getTextQuery());
    }

    /**
     * Method under test: {@link SearchQueryDto#equals(Object)}
     */
    @Test
    public void testEquals() {
        SearchQueryDto searchQueryDto = new SearchQueryDto();
        searchQueryDto.setFilters(new ArrayList<>());
        searchQueryDto.setTextQuery("Text Query");
        assertNotEquals(searchQueryDto, null);
    }

    /**
     * Method under test: {@link SearchQueryDto#equals(Object)}
     */
    @Test
    public void testEquals2() {
        SearchQueryDto searchQueryDto = new SearchQueryDto();
        searchQueryDto.setFilters(new ArrayList<>());
        searchQueryDto.setTextQuery("Text Query");
        assertNotEquals(searchQueryDto, "Different type to SearchQueryDto");
    }

    /**
     * Method under test: {@link SearchQueryDto#equals(Object)}
     */
    @Test
    public void testEquals3() {
        SearchQueryDto searchQueryDto = new SearchQueryDto();
        searchQueryDto.setFilters(new ArrayList<>());
        searchQueryDto.setTextQuery("Text Query");
        assertEquals(searchQueryDto, searchQueryDto);
        int expectedHashCodeResult = searchQueryDto.hashCode();
        assertEquals(expectedHashCodeResult, searchQueryDto.hashCode());
    }

    /**
     * Method under test: {@link SearchQueryDto#equals(Object)}
     */
    @Test
    public void testEquals4() {
        SearchQueryDto searchQueryDto = new SearchQueryDto();
        searchQueryDto.setFilters(new ArrayList<>());
        searchQueryDto.setTextQuery("Text Query");

        SearchQueryDto searchQueryDto1 = new SearchQueryDto();
        searchQueryDto1.setFilters(new ArrayList<>());
        searchQueryDto1.setTextQuery("Text Query");
        assertEquals(searchQueryDto, searchQueryDto1);
        int expectedHashCodeResult = searchQueryDto.hashCode();
        assertEquals(expectedHashCodeResult, searchQueryDto1.hashCode());
    }

    /**
     * Method under test: {@link SearchQueryDto#equals(Object)}
     */
    @Test
    public void testEquals5() {
        SearchQueryDto.Filter filter = new SearchQueryDto.Filter();
        filter.setFrom("jane.doe@example.org");
        filter.setKey("Text Query");
        filter.setTo("alice.liddell@example.org");
        filter.setValue("42");

        ArrayList<SearchQueryDto.Filter> filterList = new ArrayList<>();
        filterList.add(filter);

        SearchQueryDto searchQueryDto = new SearchQueryDto();
        searchQueryDto.setFilters(filterList);
        searchQueryDto.setTextQuery("Text Query");

        SearchQueryDto searchQueryDto1 = new SearchQueryDto();
        searchQueryDto1.setFilters(new ArrayList<>());
        searchQueryDto1.setTextQuery("Text Query");
        assertNotEquals(searchQueryDto, searchQueryDto1);
    }

    /**
     * Method under test: {@link SearchQueryDto#equals(Object)}
     */
    @Test
    public void testEquals6() {
        SearchQueryDto searchQueryDto = new SearchQueryDto();
        searchQueryDto.setFilters(new ArrayList<>());
        searchQueryDto.setTextQuery(null);

        SearchQueryDto searchQueryDto1 = new SearchQueryDto();
        searchQueryDto1.setFilters(new ArrayList<>());
        searchQueryDto1.setTextQuery("Text Query");
        assertNotEquals(searchQueryDto, searchQueryDto1);
    }

    /**
     * Method under test: {@link SearchQueryDto#equals(Object)}
     */
    @Test
    public void testEquals7() {
        SearchQueryDto searchQueryDto = new SearchQueryDto();
        searchQueryDto.setFilters(new ArrayList<>());
        searchQueryDto.setTextQuery("com.techie.shoppingstore.dto.SearchQueryDto");

        SearchQueryDto searchQueryDto1 = new SearchQueryDto();
        searchQueryDto1.setFilters(new ArrayList<>());
        searchQueryDto1.setTextQuery("Text Query");
        assertNotEquals(searchQueryDto, searchQueryDto1);
    }

    /**
     * Method under test: {@link SearchQueryDto#equals(Object)}
     */
    @Test
    public void testEquals8() {
        SearchQueryDto searchQueryDto = new SearchQueryDto();
        searchQueryDto.setFilters(new ArrayList<>());
        searchQueryDto.setTextQuery(null);

        SearchQueryDto searchQueryDto1 = new SearchQueryDto();
        searchQueryDto1.setFilters(new ArrayList<>());
        searchQueryDto1.setTextQuery(null);
        assertEquals(searchQueryDto, searchQueryDto1);
        int expectedHashCodeResult = searchQueryDto.hashCode();
        assertEquals(expectedHashCodeResult, searchQueryDto1.hashCode());
    }
}


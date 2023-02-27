package com.techie.shoppingstore.service;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techie.shoppingstore.dto.SearchQueryDto;
import com.techie.shoppingstore.model.Category;
import com.techie.shoppingstore.repository.CategoryRepository;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Optional;

import org.elasticsearch.client.RestHighLevelClient;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@ContextConfiguration(classes = {SearchService.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class SearchServiceTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @MockBean
    private CategoryRepository categoryRepository;

    @MockBean
    private ObjectMapper objectMapper;

    @MockBean
    private ProductMapper productMapper;

    @MockBean
    private RestHighLevelClient restHighLevelClient;

    @Autowired
    private SearchService searchService;

    /**
     * Method under test: {@link SearchService#searchWithFilters(SearchQueryDto, String)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testSearchWithFilters() throws IOException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.elasticsearch.client.RestHighLevelClient.performRequest(RestHighLevelClient.java:1256)
        //       at org.elasticsearch.client.RestHighLevelClient.performRequestAndParseEntity(RestHighLevelClient.java:1231)
        //       at org.elasticsearch.client.RestHighLevelClient.search(RestHighLevelClient.java:730)
        //       at com.techie.shoppingstore.service.SearchService.performSearch(SearchService.java:245)
        //       at com.techie.shoppingstore.service.SearchService.searchWithFilters(SearchService.java:98)
        //   In order to prevent searchWithFilters(SearchQueryDto, String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   searchWithFilters(SearchQueryDto, String).
        //   See https://diff.blue/R013 to resolve this issue.

        Category category = new Category();
        category.setId(123L);
        category.setName("Name");
        category.setPossibleFacets(new ArrayList<>());
        Optional<Category> ofResult = Optional.of(category);
        when(this.categoryRepository.findByName((String) any())).thenReturn(ofResult);

        SearchQueryDto searchQueryDto = new SearchQueryDto();
        searchQueryDto.setFilters(new ArrayList<>());
        searchQueryDto.setTextQuery("Text Query");
        this.searchService.searchWithFilters(searchQueryDto, "Category Name");
    }

    /**
     * Method under test: {@link SearchService#searchWithFilters(SearchQueryDto, String)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testSearchWithFilters2() throws IOException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.elasticsearch.client.RestHighLevelClient.performRequest(RestHighLevelClient.java:1256)
        //       at org.elasticsearch.client.RestHighLevelClient.performRequestAndParseEntity(RestHighLevelClient.java:1231)
        //       at org.elasticsearch.client.RestHighLevelClient.search(RestHighLevelClient.java:730)
        //       at com.techie.shoppingstore.service.SearchService.performSearch(SearchService.java:245)
        //       at com.techie.shoppingstore.service.SearchService.searchWithFilters(SearchService.java:98)
        //   In order to prevent searchWithFilters(SearchQueryDto, String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   searchWithFilters(SearchQueryDto, String).
        //   See https://diff.blue/R013 to resolve this issue.

        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("/");

        Category category = new Category();
        category.setId(123L);
        category.setName("Name");
        category.setPossibleFacets(stringList);
        Optional<Category> ofResult = Optional.of(category);
        when(this.categoryRepository.findByName((String) any())).thenReturn(ofResult);

        SearchQueryDto searchQueryDto = new SearchQueryDto();
        searchQueryDto.setFilters(new ArrayList<>());
        searchQueryDto.setTextQuery("Text Query");
        this.searchService.searchWithFilters(searchQueryDto, "Category Name");
    }

    /**
     * Method under test: {@link SearchService#searchWithFilters(SearchQueryDto, String)}
     */
//    @Test
//    public void testSearchWithFilters3() throws IOException {
//        when(this.categoryRepository.findByName((String) any())).thenReturn(Optional.empty());
//
//        SearchQueryDto searchQueryDto = new SearchQueryDto();
//        searchQueryDto.setFilters(new ArrayList<>());
//        searchQueryDto.setTextQuery("Text Query");
//        thrown.expect(SpringStoreException.class);
//        this.searchService.searchWithFilters(searchQueryDto, "Category Name");
//        verify(this.categoryRepository).findByName((String) any());
//    }

    /**
     * Method under test: {@link SearchService#searchWithFilters(SearchQueryDto, String)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testSearchWithFilters4() throws IOException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.elasticsearch.client.RestHighLevelClient.performRequest(RestHighLevelClient.java:1256)
        //       at org.elasticsearch.client.RestHighLevelClient.performRequestAndParseEntity(RestHighLevelClient.java:1231)
        //       at org.elasticsearch.client.RestHighLevelClient.search(RestHighLevelClient.java:730)
        //       at com.techie.shoppingstore.service.SearchService.performSearch(SearchService.java:245)
        //       at com.techie.shoppingstore.service.SearchService.searchWithFilters(SearchService.java:98)
        //   In order to prevent searchWithFilters(SearchQueryDto, String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   searchWithFilters(SearchQueryDto, String).
        //   See https://diff.blue/R013 to resolve this issue.

        Category category = new Category();
        category.setId(123L);
        category.setName("Name");
        category.setPossibleFacets(new ArrayList<>());
        Optional<Category> ofResult = Optional.of(category);
        when(this.categoryRepository.findByName((String) any())).thenReturn(ofResult);

        SearchQueryDto.Filter filter = new SearchQueryDto.Filter();
        filter.setFrom("jane.doe@example.org");
        filter.setKey("Key");
        filter.setTo("alice.liddell@example.org");
        filter.setValue("42");

        ArrayList<SearchQueryDto.Filter> filterList = new ArrayList<>();
        filterList.add(filter);
        SearchQueryDto searchQueryDto = mock(SearchQueryDto.class);
        when(searchQueryDto.getTextQuery()).thenReturn("Text Query");
        when(searchQueryDto.getFilters()).thenReturn(filterList);
        doNothing().when(searchQueryDto).setFilters((java.util.List<SearchQueryDto.Filter>) any());
        doNothing().when(searchQueryDto).setTextQuery((String) any());
        searchQueryDto.setFilters(new ArrayList<>());
        searchQueryDto.setTextQuery("Text Query");
        this.searchService.searchWithFilters(searchQueryDto, "Category Name");
    }

    /**
     * Method under test: {@link SearchService#searchWithFilters(SearchQueryDto, String)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testSearchWithFilters5() throws IOException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.elasticsearch.client.RestHighLevelClient.performRequest(RestHighLevelClient.java:1256)
        //       at org.elasticsearch.client.RestHighLevelClient.performRequestAndParseEntity(RestHighLevelClient.java:1231)
        //       at org.elasticsearch.client.RestHighLevelClient.search(RestHighLevelClient.java:730)
        //       at com.techie.shoppingstore.service.SearchService.performSearch(SearchService.java:245)
        //       at com.techie.shoppingstore.service.SearchService.searchWithFilters(SearchService.java:98)
        //   In order to prevent searchWithFilters(SearchQueryDto, String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   searchWithFilters(SearchQueryDto, String).
        //   See https://diff.blue/R013 to resolve this issue.

        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("foo");
        stringList.add("/");

        Category category = new Category();
        category.setId(123L);
        category.setName("Name");
        category.setPossibleFacets(stringList);
        Optional<Category> ofResult = Optional.of(category);
        when(this.categoryRepository.findByName((String) any())).thenReturn(ofResult);

        SearchQueryDto.Filter filter = new SearchQueryDto.Filter();
        filter.setFrom("jane.doe@example.org");
        filter.setKey("Key");
        filter.setTo("alice.liddell@example.org");
        filter.setValue("42");

        ArrayList<SearchQueryDto.Filter> filterList = new ArrayList<>();
        filterList.add(filter);
        SearchQueryDto searchQueryDto = mock(SearchQueryDto.class);
        when(searchQueryDto.getTextQuery()).thenReturn("Text Query");
        when(searchQueryDto.getFilters()).thenReturn(filterList);
        doNothing().when(searchQueryDto).setFilters((java.util.List<SearchQueryDto.Filter>) any());
        doNothing().when(searchQueryDto).setTextQuery((String) any());
        searchQueryDto.setFilters(new ArrayList<>());
        searchQueryDto.setTextQuery("Text Query");
        this.searchService.searchWithFilters(searchQueryDto, "Category Name");
    }

    /**
     * Method under test: {@link SearchService#search(SearchQueryDto)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testSearch() throws IOException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.elasticsearch.client.RestHighLevelClient.performRequest(RestHighLevelClient.java:1256)
        //       at org.elasticsearch.client.RestHighLevelClient.performRequestAndParseEntity(RestHighLevelClient.java:1231)
        //       at org.elasticsearch.client.RestHighLevelClient.search(RestHighLevelClient.java:730)
        //       at com.techie.shoppingstore.service.SearchService.performSearch(SearchService.java:245)
        //       at com.techie.shoppingstore.service.SearchService.search(SearchService.java:106)
        //   In order to prevent search(SearchQueryDto)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   search(SearchQueryDto).
        //   See https://diff.blue/R013 to resolve this issue.

        SearchQueryDto searchQueryDto = new SearchQueryDto();
        searchQueryDto.setFilters(new ArrayList<>());
        searchQueryDto.setTextQuery("Text Query");
        this.searchService.search(searchQueryDto);
    }

    /**
     * Method under test: {@link SearchService#search(SearchQueryDto)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testSearch2() throws IOException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.elasticsearch.client.RestHighLevelClient.performRequest(RestHighLevelClient.java:1256)
        //       at org.elasticsearch.client.RestHighLevelClient.performRequestAndParseEntity(RestHighLevelClient.java:1231)
        //       at org.elasticsearch.client.RestHighLevelClient.search(RestHighLevelClient.java:730)
        //       at com.techie.shoppingstore.service.SearchService.performSearch(SearchService.java:245)
        //       at com.techie.shoppingstore.service.SearchService.search(SearchService.java:106)
        //   In order to prevent search(SearchQueryDto)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   search(SearchQueryDto).
        //   See https://diff.blue/R013 to resolve this issue.

        SearchQueryDto searchQueryDto = mock(SearchQueryDto.class);
        when(searchQueryDto.getFilters()).thenReturn(new ArrayList<>());
        when(searchQueryDto.getTextQuery()).thenReturn("Text Query");
        doNothing().when(searchQueryDto).setFilters((java.util.List<SearchQueryDto.Filter>) any());
        doNothing().when(searchQueryDto).setTextQuery((String) any());
        searchQueryDto.setFilters(new ArrayList<>());
        searchQueryDto.setTextQuery("Text Query");
        this.searchService.search(searchQueryDto);
    }

    /**
     * Method under test: {@link SearchService#search(SearchQueryDto)}
     */
//    @Test
//    public void testSearch3() throws IOException {
//        SearchQueryDto searchQueryDto = mock(SearchQueryDto.class);
//        when(searchQueryDto.getFilters()).thenThrow(new SpringStoreException("An error occurred"));
//        when(searchQueryDto.getTextQuery()).thenReturn("Text Query");
//        doNothing().when(searchQueryDto).setFilters((List<SearchQueryDto.Filter>) any());
//        doNothing().when(searchQueryDto).setTextQuery((String) any());
//        searchQueryDto.setFilters(new ArrayList<>());
//        searchQueryDto.setTextQuery("Text Query");
//        thrown.expect(SpringStoreException.class);
//        this.searchService.search(searchQueryDto);
//        verify(searchQueryDto).getTextQuery();
//        verify(searchQueryDto).getFilters();
//        verify(searchQueryDto).setFilters((List<SearchQueryDto.Filter>) any());
//        verify(searchQueryDto).setTextQuery((String) any());
//    }

    /**
     * Method under test: {@link SearchService#search(SearchQueryDto)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testSearch4() throws IOException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.elasticsearch.client.RestHighLevelClient.performRequest(RestHighLevelClient.java:1256)
        //       at org.elasticsearch.client.RestHighLevelClient.performRequestAndParseEntity(RestHighLevelClient.java:1231)
        //       at org.elasticsearch.client.RestHighLevelClient.search(RestHighLevelClient.java:730)
        //       at com.techie.shoppingstore.service.SearchService.performSearch(SearchService.java:245)
        //       at com.techie.shoppingstore.service.SearchService.search(SearchService.java:106)
        //   In order to prevent search(SearchQueryDto)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   search(SearchQueryDto).
        //   See https://diff.blue/R013 to resolve this issue.

        SearchQueryDto.Filter filter = new SearchQueryDto.Filter();
        filter.setFrom("jane.doe@example.org");
        filter.setKey("/");
        filter.setTo("alice.liddell@example.org");
        filter.setValue("42");

        ArrayList<SearchQueryDto.Filter> filterList = new ArrayList<>();
        filterList.add(filter);
        SearchQueryDto searchQueryDto = mock(SearchQueryDto.class);
        when(searchQueryDto.getFilters()).thenReturn(filterList);
        when(searchQueryDto.getTextQuery()).thenReturn("Text Query");
        doNothing().when(searchQueryDto).setFilters((java.util.List<SearchQueryDto.Filter>) any());
        doNothing().when(searchQueryDto).setTextQuery((String) any());
        searchQueryDto.setFilters(new ArrayList<>());
        searchQueryDto.setTextQuery("Text Query");
        this.searchService.search(searchQueryDto);
    }

    /**
     * Method under test: {@link SearchService#search(SearchQueryDto)}
     */
//    @Test
//    public void testSearch5() throws IOException {
//        SearchQueryDto searchQueryDto = mock(SearchQueryDto.class);
//        when(searchQueryDto.getFilters()).thenThrow(new SpringStoreException("An error occurred"));
//        when(searchQueryDto.getTextQuery()).thenReturn("");
//        doNothing().when(searchQueryDto).setFilters((List<SearchQueryDto.Filter>) any());
//        doNothing().when(searchQueryDto).setTextQuery((String) any());
//        searchQueryDto.setFilters(new ArrayList<>());
//        searchQueryDto.setTextQuery("Text Query");
//        thrown.expect(SpringStoreException.class);
//        this.searchService.search(searchQueryDto);
//        verify(searchQueryDto).getTextQuery();
//        verify(searchQueryDto).getFilters();
//        verify(searchQueryDto).setFilters((List<SearchQueryDto.Filter>) any());
//        verify(searchQueryDto).setTextQuery((String) any());
//    }

    /**
     * Method under test: {@link SearchService#search(SearchQueryDto)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testSearch6() throws IOException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.elasticsearch.client.RestHighLevelClient.performRequest(RestHighLevelClient.java:1256)
        //       at org.elasticsearch.client.RestHighLevelClient.performRequestAndParseEntity(RestHighLevelClient.java:1231)
        //       at org.elasticsearch.client.RestHighLevelClient.search(RestHighLevelClient.java:730)
        //       at com.techie.shoppingstore.service.SearchService.performSearch(SearchService.java:245)
        //       at com.techie.shoppingstore.service.SearchService.search(SearchService.java:106)
        //   In order to prevent search(SearchQueryDto)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   search(SearchQueryDto).
        //   See https://diff.blue/R013 to resolve this issue.

        SearchQueryDto.Filter filter = new SearchQueryDto.Filter();
        filter.setFrom("jane.doe@example.org");
        filter.setKey("/");
        filter.setTo("alice.liddell@example.org");
        filter.setValue("42");

        SearchQueryDto.Filter filter1 = new SearchQueryDto.Filter();
        filter1.setFrom("jane.doe@example.org");
        filter1.setKey("/");
        filter1.setTo("alice.liddell@example.org");
        filter1.setValue("42");

        ArrayList<SearchQueryDto.Filter> filterList = new ArrayList<>();
        filterList.add(filter1);
        filterList.add(filter);
        SearchQueryDto searchQueryDto = mock(SearchQueryDto.class);
        when(searchQueryDto.getFilters()).thenReturn(filterList);
        when(searchQueryDto.getTextQuery()).thenReturn("Text Query");
        doNothing().when(searchQueryDto).setFilters((java.util.List<SearchQueryDto.Filter>) any());
        doNothing().when(searchQueryDto).setTextQuery((String) any());
        searchQueryDto.setFilters(new ArrayList<>());
        searchQueryDto.setTextQuery("Text Query");
        this.searchService.search(searchQueryDto);
    }

    /**
     * Method under test: {@link SearchService#search(SearchQueryDto)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testSearch7() throws IOException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: [multi_match] requires query value
        //       at org.elasticsearch.index.query.MultiMatchQueryBuilder.<init>(MultiMatchQueryBuilder.java:195)
        //       at org.elasticsearch.index.query.QueryBuilders.multiMatchQuery(QueryBuilders.java:79)
        //       at com.techie.shoppingstore.service.SearchService.createFullTextSearchQuery(SearchService.java:231)
        //       at com.techie.shoppingstore.service.SearchService.performFullTextSearch(SearchService.java:220)
        //       at com.techie.shoppingstore.service.SearchService.search(SearchService.java:103)
        //   In order to prevent search(SearchQueryDto)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   search(SearchQueryDto).
        //   See https://diff.blue/R013 to resolve this issue.

        SearchQueryDto searchQueryDto = mock(SearchQueryDto.class);
        when(searchQueryDto.getFilters()).thenReturn(new ArrayList<>());
        when(searchQueryDto.getTextQuery()).thenReturn(null);
        doNothing().when(searchQueryDto).setFilters((java.util.List<SearchQueryDto.Filter>) any());
        doNothing().when(searchQueryDto).setTextQuery((String) any());
        searchQueryDto.setFilters(new ArrayList<>());
        searchQueryDto.setTextQuery("Text Query");
        this.searchService.search(searchQueryDto);
    }

//    @Test
//    public Method getCreateFullTextSearchQuery() throws NoSuchMethodException, SecurityException, InvocationTargetException, IllegalAccessException {
//        Method method = SearchQueryDto.class.getDeclaredMethod("createFullTextSearchQuery", String.class,String.class);
//        method.setAccessible(true);
//        SearchQueryDto searchQueryDto=new SearchQueryDto();
//        method.invoke(searchQueryDto,"test","test");
//        return method;
//    }
//    @Test
//    public Method getPerformFullTextSearch() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalAccessException, InvocationTargetException {
//        Method method = SearchQueryDto.class.getDeclaredMethod("performFullTextSearch", SearchQueryDto.class,String.class);
//        method.setAccessible(true);
//        SearchQueryDto searchQueryDto=new SearchQueryDto();
//        SearchQueryDto actualSearchQueryDto = new SearchQueryDto();
//        ArrayList<SearchQueryDto.Filter> filterList = new ArrayList<>();
//        actualSearchQueryDto.setFilters(filterList);
//        actualSearchQueryDto.setTextQuery("Text Query");
//        method.invoke(searchQueryDto,actualSearchQueryDto,"test");
//        return method;
//    }
}


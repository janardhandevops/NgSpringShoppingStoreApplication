package com.techie.shoppingstore.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.techie.shoppingstore.dto.CategoryDto;
import com.techie.shoppingstore.model.Category;
import com.techie.shoppingstore.repository.CategoryRepository;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {CategoryService.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class CategoryServiceTest {
    @MockBean
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryService categoryService;

    /**
     * Method under test: {@link CategoryService#findAll()}
     */
    @Test
    public void testFindAll() {
        when(this.categoryRepository.findAll()).thenReturn(new ArrayList<>());
        assertTrue(this.categoryService.findAll().isEmpty());
        verify(this.categoryRepository).findAll();
    }

    /**
     * Method under test: {@link CategoryService#findAll()}
     */
    @Test
    public void testFindAll2() {
        Category category = new Category();
        category.setId(123L);
        category.setName("Name");
        category.setPossibleFacets(new ArrayList<>());

        ArrayList<Category> categoryList = new ArrayList<>();
        categoryList.add(category);
        when(this.categoryRepository.findAll()).thenReturn(categoryList);
        List<CategoryDto> actualFindAllResult = this.categoryService.findAll();
        assertEquals(1, actualFindAllResult.size());
        assertEquals("Name", actualFindAllResult.get(0).getCategoryNames());
        verify(this.categoryRepository).findAll();
    }

    /**
     * Method under test: {@link CategoryService#findAll()}
     */
    @Test
    public void testFindAll3() {
        Category category = new Category();
        category.setId(123L);
        category.setName("Name");
        category.setPossibleFacets(new ArrayList<>());

        Category category1 = new Category();
        category1.setId(123L);
        category1.setName("Name");
        category1.setPossibleFacets(new ArrayList<>());

        ArrayList<Category> categoryList = new ArrayList<>();
        categoryList.add(category1);
        categoryList.add(category);
        when(this.categoryRepository.findAll()).thenReturn(categoryList);
        List<CategoryDto> actualFindAllResult = this.categoryService.findAll();
        assertEquals(2, actualFindAllResult.size());
        assertEquals("Name", actualFindAllResult.get(0).getCategoryNames());
        assertEquals("Name", actualFindAllResult.get(1).getCategoryNames());
        verify(this.categoryRepository).findAll();
    }
}


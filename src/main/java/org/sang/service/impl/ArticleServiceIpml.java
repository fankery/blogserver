package org.sang.service.impl;

import org.sang.bean.Category;
import org.sang.mapper.ArticleMapper;
import org.sang.mapper.CategoryMapper;
import org.sang.service.ArticleService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author fanker
 */
@Service
public class ArticleServiceIpml implements ArticleService2 {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public void export(Map<String, Object> param) {
        List<Category> allCategories = categoryMapper.getAllCategories();
    }
}

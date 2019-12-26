package org.sang.service.impl;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.sang.bean.Category;
import org.sang.mapper.CategoryMapper;
import org.sang.service.CategoryService2;
import org.sang.utils.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author fanker
 */
@Service
public class CategoryService2Impl implements CategoryService2 {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> getAllCategories(Map<String, Object> param) {
        pagination(param);
        return categoryMapper.getAllCategories(param);
    }

    private void pagination(Map<String, Object> param) {
        Integer pageNum = (Integer) param.get("pageNum");
        Integer pageSize = (Integer) param.get("pageSize");
        int begin = pageNum * pageSize + 1;
        int end = begin + pageSize;
        param.put("begin", begin);
        param.put("end", end);
    }


    @Override
    public void export(Map<String, Object> param, HttpServletResponse response) {
        List<Category> allCategories = categoryMapper.getAllCategories();

        //excel文件名
        String fileName = "用户表" + System.currentTimeMillis() + ".xlsx";
        //sheet名
        String sheetName = "用户信息表";
        Map<String, Object> headMap = util();

        Workbook workbook = ExcelUtil.getHSSFWorkbook(sheetName, headMap, allCategories);
        ExcelUtil.writeToResponse(workbook, response, fileName);
    }


    private Map<String, Object> util() {
        Map<String, Object> headMap = new HashMap<>(16);
        headMap.put("id", "编号");
        headMap.put("cateName", "栏目名称");
        headMap.put("date", "启用时间");
        return headMap;
    }
}

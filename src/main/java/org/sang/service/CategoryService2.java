package org.sang.service;

import org.sang.bean.Category;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @author fanker
 */
public interface CategoryService2 {
    /**
     * 栏目管理-导出栏目
     *
     * @param param
     * @param response
     * @return Workbook
     */
    void export(Map<String, Object> param, HttpServletResponse response);

    /**
     * 栏目管理-获取栏目列表
     *
     * @param param
     * @return
     */
    List<Category> getAllCategories(Map<String, Object> param);
}

package org.sang.controller;

import org.apache.poi.ss.usermodel.Workbook;
import org.sang.bean.Category;
import org.sang.bean.RespBean;
import org.sang.service.CategoryService;
import org.sang.service.CategoryService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * 超级管理员专属Controller
 * @author fanker
 */
@RestController
@RequestMapping("/admin/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @Autowired
    private CategoryService2 categoryService2;

    @PostMapping("/categoryList")
    @ResponseBody
    public List<Category> getAllCategories(@RequestBody Map<String,Object> param) {
        return categoryService2.getAllCategories(param);
    }

    @RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
    public RespBean deleteById(@PathVariable String ids) {
        boolean result = categoryService.deleteCategoryByIds(ids);
        if (result) {
            return new RespBean("success", "删除成功!");
        }
        return new RespBean("error", "删除失败!");
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public RespBean addNewCate(Category category) {

        if ("".equals(category.getCateName()) || category.getCateName() == null) {
            return new RespBean("error", "请输入栏目名称!");
        }

        int result = categoryService.addCategory(category);

        if (result == 1) {
            return new RespBean("success", "添加成功!");
        }
        return new RespBean("error", "添加失败!");
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public RespBean updateCate(Category category) {
        int i = categoryService.updateCategoryById(category);
        if (i == 1) {
            return new RespBean("success", "修改成功!");
        }
        return new RespBean("error", "修改失败!");
    }

    @PostMapping("export")
    public void export(@RequestBody Map<String, Object> param, HttpServletResponse response) {
        categoryService2.export(param, response);
    }
}

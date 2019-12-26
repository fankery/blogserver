package org.sang.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.sang.bean.Category;

import java.util.List;
import java.util.Map;

/**
 * @author sang
 * @date 2017/12/19
 */
@Mapper
public interface CategoryMapper {
    /**
     * 栏目管理-获取所有栏目
     *
     * @return list
     */
    List<Category> getAllCategories();

    /**
     * 栏目管理-获取栏目列表
     *
     * @return list
     */
    List<Category> getAllCategories(Map<String, Object> param);

    int deleteCategoryByIds(@Param("ids") String[] ids);

    int updateCategoryById(Category category);

    int addCategory(Category category);
}

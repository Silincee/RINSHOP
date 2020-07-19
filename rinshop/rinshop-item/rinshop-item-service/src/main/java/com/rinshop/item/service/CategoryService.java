package com.rinshop.item.service;

import com.rinshop.item.mapper.CategoryMapper;
import com.rinshop.item.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: rinshop
 * @description:
 * @author: Silince
 * @create: 2020-07-19 20:33
 **/
@Service
public class CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    /**
    * @description: 根据父节点的id查询子节点(pid)集合
    * @param: [pid]
    * @return: java.util.List<com.rinshop.item.pojo.Category>
    * @author: Silince
    * @date: 2020-07-19
    */
    public List<Category> queryCategoriesByPid(Long pid) {
        Category record = new Category();
        record.setParentId(pid);
        return categoryMapper.select(record);
    }
}

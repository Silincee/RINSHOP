package com.rinshop.item.controller;

import com.rinshop.item.pojo.Category;
import com.rinshop.item.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @program: rinshop
 * @description:
 * @author: Silince
 * @create: 2020-07-19 20:35
 **/
@Controller
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /** 
    * @description: 根据父节点的id查询子节点(pid) 
    * @param: [pid] 
    * @return: org.springframework.http.ResponseEntity<java.util.List<com.rinshop.item.pojo.Category>> 
    * @author: Silince 
    * @date: 2020-07-19 
    */ 
    @GetMapping("list")
    public ResponseEntity<List<Category>> queryCategoriesByPid(@RequestParam(value = "pid", defaultValue = "0") Long pid) {
        if (pid == null || pid < 0) {
            // 400: 参数不合法
            //return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            //return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            return ResponseEntity.badRequest().build();
        }
        List<Category> categories = categoryService.queryCategoriesByPid(pid);
        if (CollectionUtils.isEmpty(categories)) {
            // 404 资源服务器未找到
            //return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            return ResponseEntity.notFound().build();
        }
        // 200 查询成功
        return ResponseEntity.ok(categories);

    }
}

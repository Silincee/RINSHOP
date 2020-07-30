package com.rinshop.item.controller;

import com.rinshop.common.pojo.PageResult;
import com.rinshop.item.pojo.Brand;
import com.rinshop.item.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @program: rinshop
 * @description:
 * @author: Silince
 * @create: 2020-07-21 20:58
 **/
@Controller
@RequestMapping("brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    /**
    * @description: 根据查询条件分页并排序查询品牌信息
    * @param: [key, page, rows, sortBy, desc]
    * @return: org.springframework.http.ResponseEntity<com.rinshop.common.pojo.PageResult<com.rinshop.item.pojo.Brand>>
    * @author: Silince
    * @date: 2020-07-21
    */
    @GetMapping("page")
    public ResponseEntity<PageResult<Brand>> queryBrandByPage(
            @RequestParam(value = "key",required = false)String key,
            @RequestParam(value = "page",defaultValue = "1")Integer page,
            @RequestParam(value = "rows",defaultValue = "5")Integer rows,
            @RequestParam(value = "sortBy",required = false)String sortBy,
            @RequestParam(value = "desc",required = false)boolean desc
    ){
        System.out.println("BrandController -> queryBrandByPage");
        PageResult<Brand> result=brandService.queryBrandByPage(key,page,rows,sortBy,desc);
        if (CollectionUtils.isEmpty(result.getItems())){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }


    /**
     * @description: 新增品牌
     * @param: [brand, cids]
     * @return: void
     * @author: Silince
     * @date: 2020-07-24
     */
    @PostMapping
    public ResponseEntity<Void> saveBrand(Brand brand, @RequestParam("cids")List<Long> cids){
        this.brandService.saveBrand(brand,cids);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}

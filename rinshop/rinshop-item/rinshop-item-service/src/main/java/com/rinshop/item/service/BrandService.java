package com.rinshop.item.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rinshop.common.pojo.PageResult;
import com.rinshop.item.mapper.BrandMapper;
import com.rinshop.item.pojo.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.List;

/**
 * @program: rinshop
 * @description:
 * @author: Silince
 * @create: 2020-07-21 20:48
 **/
@Service
public class BrandService {
    @Autowired
    private BrandMapper brandMapper;

    /**
    * @description: 根据查询条件分页并排序查询品牌信息
    * @param: [key, page, rows, sortBy, desc]
    * @return: com.rinshop.common.pojo.PageResult<com.rinshop.item.pojo.Brand>
    * @author: Silince
    * @date: 2020-07-21
    */
    public PageResult<Brand> queryBrandByPage(String key, Integer page, Integer rows, String sortBy, boolean desc) {
        // 初始化example对象
        Example example = new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();
        // 根据name模糊查询或根据首字母查询
        if (StringUtil.isNotEmpty(key)){
            criteria.andLike("name","%"+key+"%").orEqualTo("letter",key);
        }
        // 添加分页条件
        PageHelper.startPage(page,rows);
        // 添加排序条件
        if (StringUtil.isNotEmpty(sortBy)){
            example.setOrderByClause(sortBy+" "+(desc?"desc":"asc"));
        }

        List<Brand> brands = brandMapper.selectByExample(example);
        // 包装成pageInfo对象
        PageInfo<Brand> pageInfo = new PageInfo<>(brands);
        // 包装成分页结果集返回
        return new PageResult<>(pageInfo.getTotal(), pageInfo.getList());
    }
}

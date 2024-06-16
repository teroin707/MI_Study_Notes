package com.itheima.mapper;

import com.itheima.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BrandMapper {
    List<Brand> selectAll();

    Brand selectById(int id);

    // List<Brand> selectByCondition(@Param("status") int status, @Param("companyName") String companyName, @Param("brandName") String brandName);
    // List<Brand> selectByCondition(Brand brand);
    List<Brand> selectByCondition(Map map);
    List<Brand> selectByConditionSingle(Map map);
    void add(Brand brand);
    int update(Brand brand);
    int updateSingle(Brand brand);
    void deleteById(int id);
    void deleteByIds(@Param("ids") int[] ids);
}

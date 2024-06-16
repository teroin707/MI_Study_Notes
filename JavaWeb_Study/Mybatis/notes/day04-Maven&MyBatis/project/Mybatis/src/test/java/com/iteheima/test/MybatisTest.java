package com.iteheima.test;

import com.itheima.mapper.BrandMapper;
import com.itheima.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MybatisTest {
    @Test
    public void testSelectAll() throws IOException {
        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象，执行查询
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = brandMapper.selectAll();
        System.out.println(brands);

        //4. 关闭SqlSession
        sqlSession.close();
    }
    @Test
    public void testSelectById() throws IOException {
        int id = 1;
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = brandMapper.selectById(id);
        System.out.println(brand);
        sqlSession.close();
    }
    @Test
    public void testSelectByCondition() throws IOException {
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";
        // 参数处理
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        // Brand brand = new Brand();
        // brand.setStatus(status);
        // brand.setCompanyName(companyName);
        // brand.setBrandName(brandName);

        Map map = new HashMap();
        map.put("status", status);
        /*map.put("companyName", companyName);
        map.put("brandName", brandName);*/

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand>  brands = brandMapper.selectByCondition(map);
        System.out.println(brands);
        sqlSession.close();
    }
    @Test
    public void testSelectByConditionSingle() throws IOException {
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";
        // 参数处理
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        // Brand brand = new Brand();
        // brand.setStatus(status);
        // brand.setCompanyName(companyName);
        // brand.setBrandName(brandName);

        Map map = new HashMap();
        map.put("status", status);
        /*map.put("companyName", companyName);
        map.put("brandName", brandName);*/

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand>  brands = brandMapper.selectByConditionSingle(map);
        System.out.println(brands);
        sqlSession.close();
    }
    @Test
    public void testadd() throws IOException {
        int status = 1;
        String companyName = "波导手机";
        String brandName = "波导";
        // 参数处理
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);



        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        brandMapper.add(brand);
        // sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testadd2() throws IOException {
        int status = 1;
        String companyName = "波导手机";
        String brandName = "波导";
        // 参数处理
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);



        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        brandMapper.add(brand);
        Integer id = brand.getId();
        System.out.println(id);
        // sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testupdate() throws IOException {
        int status = 1;
        String companyName = "波导手机";
        String brandName = "波导";
        String description = "波导手机，手机中的战斗机";
        int ordered = 100;
        int id = 7;

        Brand brand = new Brand();
        brand.setId(id);
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(description);
        brand.setOrdered(ordered);




        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        int count = brandMapper.update(brand);
        System.out.println(count);
        // sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testupdateSingle() throws IOException {
        int status = 1;
        String companyName = "波导手机";
        String brandName = "波导";
        String description = "手机中的战斗机";
        int ordered = 100;
        int id = 7;

        Brand brand = new Brand();
        brand.setId(id);
        // brand.setStatus(status);
        // brand.setCompanyName(companyName);
        // brand.setBrandName(brandName);
        brand.setDescription(description);
        // brand.setOrdered(ordered);




        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        int count = brandMapper.updateSingle(brand);
        System.out.println(count);
        // sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testdeleteById() throws IOException {

        int id = 7;

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        brandMapper.deleteById(id);
        // sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testdeleteByIds() throws IOException {

        int[] ids = {8,9};

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        brandMapper.deleteByIds(ids);
        // sqlSession.commit();
        sqlSession.close();
    }
}

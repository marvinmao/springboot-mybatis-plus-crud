package com.lqf.crud;
/**
 * .
 */

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lqf.crud.bean.crm.User;
import com.lqf.crud.bean.crm.VersionInfo5;
import com.lqf.crud.dao.crm.UserMapper;
import com.lqf.crud.dao.crm.VersionInfo5Mapper;
import com.lqf.crud.service.crm.VersionInfo5Service;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @author: maofujiang
 * @Date: 2020-3-18
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class VersionTests {

    @Autowired
    private VersionInfo5Mapper mapper;

    @Autowired
    private VersionInfo5Service versionInfo5ServiceImpl;

    @Test
    public void selectOne() {
        QueryWrapper<VersionInfo5> queryWrapper = new QueryWrapper<>();

        List<VersionInfo5> list = mapper.selectList(queryWrapper);
        System.out.println(JSON.toJSONString(list));
    }

    @Test
    public void list() {
        QueryWrapper<VersionInfo5> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("id",3).eq("new_cloumn", " ");
        List<VersionInfo5> list = versionInfo5ServiceImpl.list(null);
        System.out.println(JSON.toJSONString(list));
    }

    @Test
    public void saveOrUpdate() {
        VersionInfo5 t = new VersionInfo5();
        t.setId(5);
        t.setNewCloumn("11");

        boolean save = versionInfo5ServiceImpl.saveOrUpdate(t);
        System.out.println(JSON.toJSONString(save));
    }

    @Test
    public void remove() {
        QueryWrapper<VersionInfo5> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id","3");

        boolean remove = versionInfo5ServiceImpl.remove(queryWrapper);
        System.out.println(JSON.toJSONString(remove));
    }

    @Test
    public void saveOrUpdateBatch() {
        List<VersionInfo5> list = new ArrayList<>();
        VersionInfo5 t = new VersionInfo5();
        t.setId(8);
        t.setVersion("8888");
        t.setDeleteFlag(0);
        list.add(t);
        VersionInfo5 t2 = new VersionInfo5();
//        t2.setId(4);
        t2.setVersion("111");
        t2.setDeleteFlag(0);
        t2.setNewCloumn("this is new column");
        list.add(t2);
        boolean save = versionInfo5ServiceImpl.saveOrUpdateBatch(list);
        System.out.println(JSON.toJSONString(save));
    }

}

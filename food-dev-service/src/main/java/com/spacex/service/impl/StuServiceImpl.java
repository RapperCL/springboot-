package com.spacex.service.impl;

import com.spacex.mapper.StuMapper;
import com.spacex.pojo.Stu;
import com.spacex.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StuServiceImpl implements StuService {


    @Autowired
    public StuMapper stuMapper;
    @Override
    public Stu StuInfo(int id) {
        return stuMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveStu() {

        Stu stu=new Stu();
        stu.setAge(10);
        stu.setName("xxx");
        stuMapper.insert(stu);
    }

    @Override
    public void updateStu(int id) {

    }
}

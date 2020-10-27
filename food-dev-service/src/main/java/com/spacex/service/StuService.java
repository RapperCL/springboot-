package com.spacex.service;

import com.spacex.pojo.Stu;

public interface StuService {


    public Stu  StuInfo(int id);

    public void saveStu();

    public void updateStu(int id);

}

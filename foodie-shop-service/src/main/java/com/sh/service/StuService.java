package com.sh.service;

import com.sh.pojo.Stu;

/**
 * @Author lee
 * @Description
 * @Date 2019/11/21 22:43
 **/
public interface StuService {

    public Stu getStuInfo(int id);

    public void saveStu();

    public void updateStu(int id);

    public void deleteStu(int id);
}

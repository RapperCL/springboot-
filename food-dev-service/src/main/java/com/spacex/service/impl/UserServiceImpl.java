package com.spacex.service.impl;

import com.spacex.mapper.UsersMapper;
import com.spacex.pojo.Users;
import com.spacex.pojo.bo.UserBO;
import com.spacex.service.UserService;
import com.spacex.utils.MD5Utils;
import com.spacex.utils.Sex;
import org.n3r.idworker.Sid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    private static final String USER_FACE = "http://122.152.205.72:88/group1/M00/00/05/CpoxxFw_8_qAIlFXAAAcIhVPdSg994.png";
    @Autowired
    public UsersMapper usersMapper;

    //获取该类的日志
    private static Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private Sid sid;
    @Override
    public boolean queryUsernameIsExist(String username) {
        logger.info("info;执行之前");
        long start=System.currentTimeMillis();

        Example userExample=new Example(Users.class);
        //建立关联
        Example.Criteria userCriteria =userExample.createCriteria();
        //设置条件
        userCriteria.andEqualTo("username",username);

        Users result=usersMapper.selectOneByExample(userExample);

        long end=System.currentTimeMillis();
        if(end-start>100)
            logger.error("error: 执行过了100毫秒");
        return result==null?false:true;
    }

    public Users CreateUser(UserBO userBO){

        Users user=new Users();
        user.setUsername(userBO.getUsername());
        user.setId(sid.nextShort());
        //对密码进行MD5加密
        try {
            user.setPassword(MD5Utils.getMD5Str(userBO.getPassword()));
        }catch (Exception e){
            e.printStackTrace();
        }
        //默认头像
        user.setFace(USER_FACE  );

        //默认性别为保密
        user.setSex(Sex.secret.type);

        user.setCreatedTime(new Date());
        user.setUpdatedTime(new Date());
        usersMapper.insert(user);
        return user;
    }

    //开启一个事务来查询
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Users queryUserForLogin(String username, String password) {
        Example userExample=new Example(Users.class);
        //建立关联
        Example.Criteria userCriteria =userExample.createCriteria();

        try{
            password=MD5Utils.getMD5Str(password);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        userCriteria.andEqualTo("username",username);
        userCriteria.andEqualTo("password",password);

        Users result=usersMapper.selectOneByExample(userExample);

        return result;
    }
}

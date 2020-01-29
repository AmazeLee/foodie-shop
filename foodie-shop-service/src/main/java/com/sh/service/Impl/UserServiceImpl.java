package com.sh.service.Impl;

import com.sh.enums.Sex;
import com.sh.mapper.UsersMapper;
import com.sh.pojo.Users;
import com.sh.pojo.bo.UserBO;
import com.sh.service.UserService;
import com.sh.utils.DateUtil;
import com.sh.utils.MD5Utils;
import org.n3r.idworker.Sid;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @Author lee
 * @Description
 * @Date 2019/12/7 22:21
 **/
@Service
public class UserServiceImpl implements UserService {

    @Resource
    public UsersMapper usersMapper;

    @Resource
    public Sid sid;

    private static final String USER_FACE = "https://c-ssl.duitang.com/uploads/item/201802/20/20180220165946_RiGPS.thumb.700_0.jpeg";

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public boolean queryUsernameIsExist(String username) {

        Example userExample = new Example(Users.class);
        Example.Criteria userCriteria = userExample.createCriteria();

        userCriteria.andEqualTo("username", username);

        Users result = usersMapper.selectOneByExample(userExample);

        return result == null ? false : true;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Users createUser(UserBO userBO) throws Exception {

        String userId = sid.nextShort();
        Users user = new Users();
        user.setId(userId);
        user.setUsername(userBO.getUsername());
        // 加密设置密码
        user.setPassword(MD5Utils.getMD5Str(userBO.getPassword()));
        // 默认用户昵称为用户名
        user.setNickname(userBO.getUsername());
        // 默认头像
        user.setFace(USER_FACE);
        // 设置默认的生日
        user.setBirthday(DateUtil.stringToDate("1990-01-01"));
        user.setSex(Sex.secret.type);

        user.setCreatedTime(new Date());
        user.setUpdatedTime(new Date());

        usersMapper.insert(user);
        return user;
    }
}

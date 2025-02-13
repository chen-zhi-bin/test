package com.phase.three.service.impl;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.phase.three.mapper.UserMapper;
import com.phase.three.entity.PageData;
import com.phase.three.pojo.Result;
import com.phase.three.pojo.User;
import com.phase.three.pojo.dto.UserDto;
import com.phase.three.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public PageData<User> selectByPage(int currentPage, int pageSize, UserDto user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>()
                .like(user!=null&&user.getName() != null, "name", user.getName())
                .eq(user!=null&&user.getAge() != null, "age", user.getAge())
                .like(user!=null&&user.getEmail() != null, "email", user.getEmail());
        Page<User> userPage = userMapper.selectPage(new Page<User>(currentPage, pageSize), queryWrapper);
        PageData<User> data = new PageData<>();
        data.setData(userPage.getRecords());
        data.setTotal(userPage.getTotal());
        return data;
    }

    @Override
    public boolean addUser(UserDto user) {
        User userBean = new User();
        userBean.setId(IdUtil.getSnowflakeNextId());
        if (user.getName()!=null) {
            userBean.setName(user.getName());
        }
        if (user.getAge()!=null) {
            userBean.setAge(user.getAge());
        }
        if (user.getEmail()!=null){
            userBean.setEmail(user.getEmail());
        }
        userBean.setDeleted(0);
        int row = userMapper.insert(userBean);
        return row>0;
    }

    @Override
    public Result deleteByIds(List<Long> ids) {
        int row = userMapper.deleteByIds(ids);
        Result result = new Result();
        if (row > 0) {
            result.setCode(200);
            result.setMsg("删除成功");
            return result;
        }
        result.setMsg("删除失败");
        return result;
    }
}
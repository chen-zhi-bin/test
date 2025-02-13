package com.phase.three.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.phase.three.entity.PageData;
import com.phase.three.pojo.Result;
import com.phase.three.pojo.User;
import com.phase.three.pojo.dto.UserDto;

import java.util.List;

public interface IUserService extends IService<User> {
    PageData<User> selectByPage(int currentPage, int pageSize, UserDto user);

    boolean addUser(UserDto user);

    Result deleteByIds(List<Long> ids);
}
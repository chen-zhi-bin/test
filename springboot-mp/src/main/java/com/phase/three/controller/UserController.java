package com.phase.three.controller;

import com.phase.three.entity.PageData;
import com.phase.three.pojo.Result;
import com.phase.three.pojo.User;
import com.phase.three.pojo.dto.UserDto;
import com.phase.three.service.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "用户管理")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @Operation(summary = "搜索")
    @PostMapping("/search/{currentPage}/{pageSize}")
    public PageData<User> searchUserListByPage(@PathVariable("currentPage")int currentPage,
                                               @PathVariable("pageSize")int pageSize,
                                               @RequestBody UserDto user){
        System.out.println(user);
        return userService.selectByPage(currentPage,pageSize,user);
    }

    @Operation(summary = "添加")
    @PostMapping("/add")
    public boolean addUser(@RequestBody UserDto user){
        return userService.addUser(user);
    }

    @Operation(summary = "删除")
    @DeleteMapping("/delete")
    public Result deleteUser(@RequestBody List<Long> ids){
//        System.out.println(ids);
//        return new Result();
        return userService.deleteByIds(ids);
    }

    @Operation(summary = "修改")
    @PutMapping("/update")
    public Result update(@RequestBody User user){
        boolean updateRow = userService.updateById(user);
        Result result = new Result();
        if (updateRow) {
            result.setMsg("修改成功");
            result.setCode(200);
            return result;
        }
        result.setCode(202);
        result.setMsg("修改失败");
        return result;
    }

}
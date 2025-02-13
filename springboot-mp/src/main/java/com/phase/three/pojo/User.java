package com.phase.three.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_user")
public class User {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @TableField("name")
    private String name;
    private Integer age;
    private String email;
    @TableField(fill = FieldFill.INSERT) //插入时填充字段
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)//插入和修改时填充字段
    private Date updateTime;
    @TableLogic
    private Integer deleted;
}

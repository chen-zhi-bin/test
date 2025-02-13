package com.phase.three.pojo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Tag(name = "User")
public class UserDto {
    @Schema(description = "用户名",example = "用户名")
    private String name;
    @Schema(description = "年龄")
    private Integer age;
    @Schema(description = "邮箱")
    private String email;
}

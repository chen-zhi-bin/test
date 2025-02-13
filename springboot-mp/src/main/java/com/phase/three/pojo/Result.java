package com.phase.three.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Result {
    //code
    private Integer code;
    //msg
    private String msg;
    //data
    private Object data;

}

package com.ext.common.domain.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@Data
/**
 *  用户信息表
 */
@ApiModel(value = "用户信息表")
public class UserInfoDTO implements Serializable {

    private String userCode;
    private String userName;

}

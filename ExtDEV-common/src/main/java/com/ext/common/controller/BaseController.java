package com.ext.common.controller;

import com.ext.common.domain.dto.UserInfoDTO;

public class BaseController {

    protected UserInfoDTO getUserInfo(){
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        userInfoDTO.setUserCode("admin");
        userInfoDTO.setUserName("超级管理员");
        return userInfoDTO;
    }


}

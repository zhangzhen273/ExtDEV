package com.ext.sys.controller;

import com.ext.common.annotations.OperationLogAnnotation;
import com.ext.common.controller.BaseController;
import com.ext.common.domain.dto.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserInfoController extends BaseController{

    @PostMapping("/queryUserList")
    @ApiOperation("查询用户列表")
    @OperationLogAnnotation
    public Result queryUserList(){
        return Result.success();
    }



}

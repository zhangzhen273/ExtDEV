package com.ext.common.domain.dto;

import lombok.Data;

import java.util.Date;

@Data
public class OperationDTO {
    private String operationUrl;
    private String operationName;
    private String paramterJsonStr;
    private String resultJsonStr;
    private String userCode;
    private String userName;
    private Date createtime;
}

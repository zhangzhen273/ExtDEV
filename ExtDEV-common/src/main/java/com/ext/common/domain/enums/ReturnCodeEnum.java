package com.ext.common.domain.enums;

public enum  ReturnCodeEnum {

    SUCCESS("0000","执行成功"),
    PARAMTER_ERROR("9998","参数异常"),
    ERROR("9999","执行失败");

    private ReturnCodeEnum(){

    }
    private ReturnCodeEnum(String code,String codeDesc){

    }

    private String code;
    private String codeDesc;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodeDesc() {
        return codeDesc;
    }

    public void setCodeDesc(String codeDesc) {
        this.codeDesc = codeDesc;
    }
}

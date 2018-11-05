package com.ext.common.domain.dto;

import com.ext.common.domain.enums.ReturnCodeEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable{

    public Result(){
        super();
    }

    public Result(String code, String codeDesc,String msg,  T data) {
        this.code = code;
        this.msg = msg;
        this.codeDesc = codeDesc;
        this.data = data;
    }

    public Result(String code, String codeDesc,String msg) {
        this.code = code;
        this.msg = msg;
        this.codeDesc = codeDesc;
    }

    /**
     *  返回码
     */
    @ApiModelProperty(value = "返回码")
    private String code;
    /**
     *  返回消息
     */
    @ApiModelProperty(value = "返回消息")
    private String msg;

    /**
     * 返回码描述
     */
    @ApiModelProperty(value = "返回码描述")
    private String codeDesc;

    /**
     * 返回数据
     */
    @ApiModelProperty(value = "返回数据")
    private T data;

    /**
     *  执行成功
     * @return
     */
    public static Result success(){
        return new Result(ReturnCodeEnum.SUCCESS.getCode(),ReturnCodeEnum.SUCCESS.getCodeDesc(),"执行成功");
    }
    /**
     *  执行成功
     * @param data
     * @param <T>
     * @return
     */
    public static<T> Result<T> success(T data){
        return new Result(ReturnCodeEnum.SUCCESS.getCode(),ReturnCodeEnum.SUCCESS.getCodeDesc(),"执行成功",data);
    }


    /**
     * 执行异常
     * @param msg
     * @return
     */
    public static Result error(String msg){
        return new Result(ReturnCodeEnum.ERROR.getCode(),ReturnCodeEnum.ERROR.getCodeDesc(),msg);
    }

    /**
     * 参数异常
     * @param msg
     * @return
     */
    public static Result paramterError(String msg){
        return new Result(ReturnCodeEnum.PARAMTER_ERROR.getCode(),ReturnCodeEnum.PARAMTER_ERROR.getCodeDesc(),msg);
    }


    /**
     * 构建返回值
     * @param code 返回编码
     * @param codeDesc 描述
     * @param msg 返回消息
     * @return
     */
    public static Result buildResult(String code,String codeDesc,String msg){
        return new Result(ReturnCodeEnum.PARAMTER_ERROR.getCode(),ReturnCodeEnum.PARAMTER_ERROR.getCodeDesc(),msg);
    }


}

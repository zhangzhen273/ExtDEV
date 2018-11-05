package com.ext.common.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PageResult extends Result{

    /**
     * 记录总数
     */
    @ApiModelProperty(value="记录总数")
    private long count;


    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}

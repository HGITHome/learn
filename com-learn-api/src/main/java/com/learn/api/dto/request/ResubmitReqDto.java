package com.learn.api.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "请求dto")
public class ResubmitReqDto implements Serializable {

    @ApiModelProperty(name = "id",value = "主键id")
    private Long id;

    @ApiModelProperty(name = "username",value = "用户名")
    private String username;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}

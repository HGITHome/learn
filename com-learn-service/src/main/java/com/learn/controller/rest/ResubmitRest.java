package com.learn.controller.rest;

import com.learn.api.annotation.Resubmit;
import com.learn.api.dto.request.ResubmitReqDto;
import com.learn.api.rest.RestResponse;
import com.learn.biz.IResubmitService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@ResponseBody
@RequestMapping("/resubmit")
@ApiModel(value = "测试重复提交")
public class ResubmitRest {

    @Resource
    private IResubmitService resubmitService;

    @ApiOperation(value = "测试重复提交")
    @PostMapping(value = "/save")
    @Resubmit
    public RestResponse testResubmit(@RequestBody ResubmitReqDto resubmitReqDto){
        resubmitService.testResubmit(resubmitReqDto.getId());
        return RestResponse.VOID;
    }
}

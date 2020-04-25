package com.learn.controller.rest;

import com.learn.api.dto.TaskDefine;
import com.learn.biz.IQuartzJobService;
import com.learn.biz.job.SayHelloJobLogic;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.quartz.JobKey;
import org.quartz.SchedulerException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * ClassName: TestWQuartz
 *
 * @description: ${description}
 * Date:      2020/4/24 17:25
 * author     xiake
 * version    V1.0
 */
@ApiModel(description = "定时任务类")
@RestController
@RequestMapping("/quartz")
public class QuartzController {

    @Resource
    private IQuartzJobService quartzJobService;

    //假如 这个定时任务的 名字叫做HelloWorld, 组名GroupOne
    private final JobKey jobKey = JobKey.jobKey("HelloWorld", "GroupOne");



    /**
     * 启动 hello world
     */
    @GetMapping("/startHelloWorldJob")
    @ApiOperation(value = "启动定时任务")
    public String startHelloWorldJob() throws SchedulerException {

        //创建一个定时任务
        TaskDefine task = TaskDefine.builder()
                .jobKey(jobKey)
                //定时任务 的cron表达式
                .cronExpression("0/2 * * * * ? ")
                //定时任务 的具体执行逻辑
                .jobClass(SayHelloJobLogic.class)
                //定时任务 的描述
                .description("这是一个测试的 任务")
                .build();

        quartzJobService.scheduleJob(task);
        return "startHelloWorldJob success";
    }

    /**
     * 暂停 hello world
     */
    @GetMapping("/pauseHelloWorldJob")
    @ApiOperation(value = "暂停定时任务")
    public String pauseHelloWorldJob() throws SchedulerException {
        quartzJobService.pauseJob(jobKey);
        return "pauseHelloWorldJob success";
    }

    /**
     * 恢复 hello world
     */
    @GetMapping("/resumeHelloWorldJob")
    @ApiOperation(value = "恢复定时任务")
    public String resumeHelloWorldJob() throws SchedulerException {
        quartzJobService.resumeJob(jobKey);
        return "resumeHelloWorldJob success";
    }

    /**
     * 删除 hello world
     */
    @GetMapping("/deleteHelloWorldJob")
    @ApiOperation(value = "删除定时任务")
    public String deleteHelloWorldJob() throws SchedulerException {
        quartzJobService.deleteJob(jobKey);
        return "deleteHelloWorldJob success";
    }

    /**
     * 修改 hello world 的cron表达式
     */
    @GetMapping("/modifyHelloWorldJobCron")
    @ApiOperation(value = "修改定时任务")
    public String modifyHelloWorldJobCron() {

        //这是即将要修改cron的定时任务
        TaskDefine modifyCronTask = TaskDefine.builder()
                .jobKey(jobKey)
                //定时任务 的cron表达式
                .cronExpression("0/5 * * * * ? ")
                //定时任务 的具体执行逻辑
                .jobClass(SayHelloJobLogic.class)
                //定时任务 的描述
                .description("这是一个测试的 任务")
                .build();
        if (quartzJobService.modifyJobCron(modifyCronTask)) {
            return "modifyHelloWorldJobCron success";
        }
        else {
            return "modifyHelloWorldJobCron fail";
        }
    }


}

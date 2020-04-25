package com.learn.controller.runner;

import com.learn.api.dto.TaskDefine;
import com.learn.biz.IQuartzJobService;
import org.quartz.JobKey;
import org.quartz.SchedulerException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * ClassName: AppStarted
 *
 * @description: ${description}
 * Date:      2020/4/24 17:31
 * author     xiake
 * version    V1.0
 */
@Component
public class AppStarted implements CommandLineRunner {

    @Resource
    private IQuartzJobService quartzJobService;

    //假如 这个定时任务的 名字叫做HelloWorld, 组名GroupOne
    private final JobKey jobKey = JobKey.jobKey("HelloWorld", "GroupOne");

    @Override
    public void run(String... strings) throws Exception {
//        createScheduler();
    }

}

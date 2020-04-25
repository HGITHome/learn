package com.learn.biz.job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * ClassName: SayHelloJobLogic
 *
 * @description: ${description}
 * Date:      2020/4/24 17:22
 * author     xiake
 * version    V1.0
 */
@Slf4j
@DisallowConcurrentExecution
public class SayHelloJobLogic implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        String time = LocalDateTime.ofInstant(
                new Date().toInstant(),
                ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        //写你自己的逻辑
        log.info(time + " : SayHelloJob.execute , hello world  ! ");

    }
}

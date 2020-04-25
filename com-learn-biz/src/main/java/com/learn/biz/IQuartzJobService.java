package com.learn.biz;

/**
 * ClassName: QuartzJobService
 *
 * @description: ${description}
 * Date:      2020/4/24 17:24
 * author     xiake
 * version    V1.0
 */

import com.learn.api.dto.TaskDefine;
import org.quartz.*;

/**
 * Created by EalenXie on 2019/7/10 13:49.
 * 核心其实就是Scheduler的功能 , 这里只是非常简单的示例说明其功能
 * 如需根据自身业务进行扩展 请参考 {@link org.quartz.Scheduler}
 */

public interface IQuartzJobService {


    /**
     * 创建和启动 定时任务
     * {@link org.quartz.Scheduler#scheduleJob(JobDetail, Trigger)}
     *
     * @param define 定时任务
     */
    void scheduleJob(TaskDefine define) throws SchedulerException ;

    /**
     * 暂停Job
     * {@link org.quartz.Scheduler#pauseJob(JobKey)}
     */
    void pauseJob(JobKey jobKey) throws SchedulerException;

    /**
     * 恢复Job
     * {@link org.quartz.Scheduler#resumeJob(JobKey)}
     */
    void resumeJob(JobKey jobKey) throws SchedulerException ;

    /**
     * 删除Job
     * {@link org.quartz.Scheduler#deleteJob(JobKey)}
     */
    void deleteJob(JobKey jobKey) throws SchedulerException;

    /**
     * 修改Job 的cron表达式
     */
    boolean modifyJobCron(TaskDefine define) ;

    /**
     * 获取定时任务的定义
     * JobDetail是任务的定义,Job是任务的执行逻辑
     *
     * @param jobKey      定时任务的名称 组名
     * @param description 定时任务的 描述
     * @param jobDataMap  定时任务的 元数据
     * @param jobClass    {@link org.quartz.Job} 定时任务的 真正执行逻辑定义类
     */
    JobDetail getJobDetail(JobKey jobKey, String description, JobDataMap jobDataMap, Class<? extends Job> jobClass) ;

    /**
     * 获取Trigger (Job的触发器,执行规则)
     *
     * @param jobKey         定时任务的名称 组名
     * @param description    定时任务的 描述
     * @param jobDataMap     定时任务的 元数据
     * @param cronExpression 定时任务的 执行cron表达式
     */
    Trigger getTrigger(JobKey jobKey, String description, JobDataMap jobDataMap, String cronExpression) ;


}
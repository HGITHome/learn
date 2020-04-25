package com.learn.controller.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * ClassName: BeanFactory
 *
 * @description: ${description}
 * Date:      2020/4/24 17:35
 * author     xiake
 * version    V1.0
 */

@Configuration
@Primary
public class QuartzBeanFactoryConfig {

    @Autowired
    SchedulerFactoryBean schedulerFactoryBean;

//    @Bean
//    public Scheduler createScheduler(){
//        return schedulerFactoryBean.getScheduler();
//    }

}

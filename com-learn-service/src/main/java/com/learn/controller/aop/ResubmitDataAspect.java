package com.learn.controller.aop;

import com.alibaba.fastjson.JSONObject;
import com.learn.api.annotation.Resubmit;
import com.learn.biz.utils.Md5Util;
import com.learn.biz.utils.RedisUtil;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Method;

@Aspect
@Component
public class ResubmitDataAspect {
private final  static Logger logger = LoggerFactory.getLogger(ResubmitDataAspect.class);
    @Resource
    private Md5Util md5Util;

    @Resource
    private RedisUtil redisUtil;

    private final static String DATA = "data";
    private final static Object PRESENT = new Object();

    @Around("@annotation(com.learn.api.annotation.Resubmit)")
    public Object handleResubmit(ProceedingJoinPoint joinPoint) throws Throwable {
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        //获取注解信息
        Resubmit annotation = method.getAnnotation(Resubmit.class);
        int delaySeconds = annotation.delaySeconds();
        Object[] pointArgs = joinPoint.getArgs();
        String key = "";
        //获取第一个参数
        Object firstParam = pointArgs[0];
        if (firstParam instanceof Object) {
            //解析参数
            JSONObject requestDTO = JSONObject.parseObject(firstParam.toString());
            JSONObject data = JSONObject.parseObject(requestDTO.getString(DATA));
            if (data != null) {
                StringBuffer sb = new StringBuffer();
                data.forEach((k, v) -> {
                    sb.append(v);
                });
                //生成加密参数 使用了content_MD5的加密方式
                key = md5Util.handleKey(sb.toString());
            }
        }
        //执行锁
        Long lock = 0L;
        try {
            //设置解锁key
            lock = redisUtil.sSetAndTime(key,delaySeconds, PRESENT);
            if (lock > 0) {
                //放行
                return joinPoint.proceed();
            } else {
                //响应重复提交异常
                throw new RuntimeException("重复提交表单!");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return true;
    }
}

package com.learn.biz;

import org.springframework.web.bind.annotation.RequestParam;

public interface IResubmitService {

    /**
     * 测试重复提交
     * @param id
     */
    void testResubmit(Long id);
}

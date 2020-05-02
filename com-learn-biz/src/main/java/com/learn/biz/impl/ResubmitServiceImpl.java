package com.learn.biz.impl;

import com.learn.biz.IResubmitService;
import org.springframework.stereotype.Service;

@Service
public class ResubmitServiceImpl implements IResubmitService {
    @Override
    public void testResubmit(Long id) {
        System.out.println("id---->:"+id);
    }
}

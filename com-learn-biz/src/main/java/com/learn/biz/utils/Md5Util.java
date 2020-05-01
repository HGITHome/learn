package com.learn.biz.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

@Component
public class Md5Util {

    public  String handleKey(String param) {
        return DigestUtils.md5Hex(param == null ? "" : param);
    }

}

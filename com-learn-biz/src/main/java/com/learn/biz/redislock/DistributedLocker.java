package com.learn.biz.redislock;

import org.redisson.api.RLock;

import java.util.concurrent.TimeUnit;

public interface DistributedLocker {
    /**
     * 一直获取锁，获取不到则阻塞
     * @param lockKey
     * @return
     */
    RLock lock(String lockKey);

    /**
     * 获取锁，设置过期时间
     * @param lockKey
     * @param timeout
     * @return
     */
    RLock lock(String lockKey, long timeout);

    /**
     * 获取锁，设置过期时间，时间单位
     * @param lockKey
     * @param unit
     * @param timeout
     * @return
     */
    RLock lock(String lockKey, TimeUnit unit, long timeout);

    /**
     * 尝试获取锁
     * @param lockKey
     * @param unit
     * @param waitTime
     * @param leaseTime
     * @return
     */
    boolean tryLock(String lockKey, TimeUnit unit, long waitTime, long leaseTime);

    /**
     * 释放锁
     * @param lockKey
     */
    void unlock(String lockKey);

    /**
     * 释放锁
     * @param lock
     */
    void unlock(RLock lock);

}

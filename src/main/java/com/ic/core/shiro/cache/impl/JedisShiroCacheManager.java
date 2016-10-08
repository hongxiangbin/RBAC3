package com.ic.core.shiro.cache.impl;

import org.apache.shiro.cache.Cache;

import com.ic.core.shiro.cache.JedisManager;
import com.ic.core.shiro.cache.JedisShiroCache;
import com.ic.core.shiro.cache.ShiroCacheManager;

/**
 * 
 * JRedis管理
 * 
 */
public class JedisShiroCacheManager implements ShiroCacheManager {

    private JedisManager jedisManager;

    @Override
    public <K, V> Cache<K, V> getCache(String name) {
        return new JedisShiroCache<K, V>(name, getJedisManager());
    }

    @Override
    public void destroy() {
    	//如果和其他系统，或者应用在一起就不能关闭
    	//getJedisManager().getJedis().shutdown();
    }

    public JedisManager getJedisManager() {
        return jedisManager;
    }

    public void setJedisManager(JedisManager jedisManager) {
        this.jedisManager = jedisManager;
    }
}

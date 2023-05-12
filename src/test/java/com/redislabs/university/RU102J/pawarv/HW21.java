package com.redislabs.university.RU102J.pawarv;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class HW21 {
    public static void main(String[] args) {

        insert(0, "25.0");
        insert(1, "26.1");
        insert(2, "22.1");
        insert(3, "25.0");


    }

    private static void insert(Integer minuteOfDay, String measurement) {
        JedisPool jedisPool = new JedisPool(new JedisPoolConfig(), "localhost", 6379);

        try (Jedis jedis = jedisPool.getResource()) {
            jedis.zadd("metrics", minuteOfDay, measurement);
        }
        jedisPool.close();
    }

    // zrange metrics 0 -1
}

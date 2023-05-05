package com.redislabs.university.RU102J.pawarv;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class HW12 {
    public static void main(String[] args) {
        JedisPool jedisPool = new JedisPool(new JedisPoolConfig(), "localhost", 6379);

        try (Jedis jedis = jedisPool.getResource()) {
            for (int i = 0; i < 3; i++) {
                System.out.println("Inside for i:" + i);

                jedis.set(String.valueOf(i), "0");
                jedis.get(String.valueOf(i));
            }
            System.out.println("Out side main");
        }

        jedisPool.close();
    }
}

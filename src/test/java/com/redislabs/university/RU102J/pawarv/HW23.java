package com.redislabs.university.RU102J.pawarv;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Response;
import redis.clients.jedis.Transaction;

public class HW23 {
    public static void main(String[] args) {

        runTransaction();

    }

    private static void runTransaction() {
        JedisPool jedisPool = new JedisPool(new JedisPoolConfig(), "localhost", 6379);

        try (Jedis jedis = jedisPool.getResource()) {
            jedis.set("a", "foo");
            jedis.set("b", "bar");
            jedis.set("c", "baz");
            Transaction t = jedis.multi();

            Response<String> r1 = t.set("b", "1");
            Response<Long> r2 = t.incr("a");
            Response<String> r3 = t.set("c", "100");

            t.exec();
            r1.get();
            r2.get();
            r3.get();
        }
        jedisPool.close();
    }

}

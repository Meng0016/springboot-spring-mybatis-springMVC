package com.example.thymeleaf;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
class ThymeleafApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testRedis() {
        RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
        ValueOperations<String, String> operations = redisTemplate.opsForValue();

        operations.set("hello","world");

        String hello = operations.get("hello");
        System.out.println(hello);
    }

}

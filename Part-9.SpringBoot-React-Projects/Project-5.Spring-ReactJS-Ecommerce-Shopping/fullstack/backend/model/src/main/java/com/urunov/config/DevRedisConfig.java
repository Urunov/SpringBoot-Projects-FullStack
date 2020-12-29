//package com.urunov.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
//import org.springframework.core.env.Environment;
//import org.springframework.data.redis.connection.RedisPassword;
//import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//
//import java.util.Objects;
//
///**
// * User: hamdamboy
// * Project: model
// * Github: @urunov
// */
//
//@Configuration
//@Profile("dev")
//public class DevRedisConfig {
//
//    @Autowired
//    Environment environment;
//
//    @Bean
//    JedisConnectionFactory jedisConnectionFactory()
//    {
//        System.out.println("Loading DEv profile redis config....");
//
//        RedisStandaloneConfiguration redisStandaloneConfiguration =
//            new RedisStandaloneConfiguration(Objects.requireNonNull(environment.getProperty("REDIST_HOST")),
//        Integer.parseInt(Objects.requireNonNull(environment.getProperty("REDIS_PORT"))));
//
//        redisStandaloneConfiguration.
//                setPassword(RedisPassword.of(Objects.requireNonNull(environment.getProperty("REDIS_PASSWORD"))));
//
//        return new JedisConnectionFactory(redisStandaloneConfiguration);
//    }
//
//    @Bean
//    public RedisTemplate<String, Object> redisTemplate(){
//        RedisTemplate<String, Object> template = new RedisTemplate<>();
//
//        template.setConnectionFactory(jedisConnectionFactory());
//        return template;
//    }
//}

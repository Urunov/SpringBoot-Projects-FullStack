package com.urunov.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.Protocol;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * User: hamdamboy
 * Project: model
 * Github: @urunov
 */
@Configuration
@Profile("prod")
public class ProdRedisConfig {

    @Bean
    public JedisConnectionFactory jedisConnectionFactory(){

        try {
            System.out.println("Loading Prod profile redis config ... ");

            String redistogoUrl = System.getenv("REDIS_URL");
            URI redistogoUri = new URI(redistogoUrl);

            JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();

            jedisConnectionFactory.setUsePool(true);
            jedisConnectionFactory.setHostName(redistogoUri.getHost());
            jedisConnectionFactory.setPort(redistogoUri.getPort());
            jedisConnectionFactory.setTimeout(Protocol.DEFAULT_TIMEOUT);
            jedisConnectionFactory.setPassword(redistogoUri.getUserInfo().split(":", 2)[1]);

            return jedisConnectionFactory;
        } catch (URISyntaxException e)
        {
            e.printStackTrace();
            return null;
        }
    }


    @Bean
    public RedisTemplate<String, Object> redisTemplate()
    {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        return template;
    }
}

package io.pivotal.cf.fusion.signer;

import feign.Feign;
import feign.auth.BasicAuthRequestInterceptor;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.util.Properties;

@Configuration
@PropertySource("classpath:test.properties")
public class TestConfig {

    @Bean
    public String uuid() {
        return env.getProperty("uuid");
    }

    @Bean
    public String hash() {
        return env.getProperty("hash");
    }

    @Autowired
    private Environment env;

    @Bean
    public Properties cloudProperties() {
        Properties p = new Properties();
        p.put("test", "hello");
        return p;
    }

    @Bean
    public FusionRepository fusionRepository() {
        return Feign.builder()
                .encoder(new GsonEncoder()).decoder(new GsonDecoder())
                .requestInterceptor(new BasicAuthRequestInterceptor(env.getProperty("userId"), env.getProperty("userPw")))
                .target(FusionRepository.class, getUri());
    }

    private String getUri() {
        return "http://" + env.getProperty("fusionHost") + ":" + env.getProperty("fusionPort");
    }
}

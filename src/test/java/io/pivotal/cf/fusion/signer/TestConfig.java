package io.pivotal.cf.fusion.signer;

import feign.Feign;
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
                .target(FusionRepository.class, getUri());
    }

    private String getUri() {
        return "http://" + env.getProperty("userId") + ":" + env.getProperty("userPw") + "@" + env.getProperty("fusionHost") + ":" + env.getProperty("fusionPort");
    }
}

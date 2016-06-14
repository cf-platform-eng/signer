package io.pivotal.cf.fusion.signer;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Configuration
@Profile("cloud")
public class CloudConfig extends AbstractCloudConfig {

    @Bean
    public FusionRepository fusionRepository() {
        return connectionFactory().service("fusion", FusionRepository.class);
    }

//    @Bean
//    public MessageDigest digest() throws NoSuchAlgorithmException {
//        return MessageDigest.getInstance("SHA-256");
//    }

}
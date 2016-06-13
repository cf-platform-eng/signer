package io.pivotal.cf.signer;

import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("cloud")
public class CloudConfig extends AbstractCloudConfig {

    @Bean
    public FusionRepository fusionRepository() {
        return connectionFactory().service("fusion", FusionRepository.class);
    }

//    @Bean
//    public Properties cloudProperties() {
//        return properties();
//    }
}
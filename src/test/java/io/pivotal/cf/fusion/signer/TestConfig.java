package io.pivotal.cf.fusion.signer;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class TestConfig {

    @Bean
    public Properties cloudProperties() {
        Properties p = new Properties();
        p.put("test", "hello");
        return p;
    }

    @Bean
    public FusionRepository fusionRepository() {
        return Mockito.mock(FusionRepository.class);
    }
}

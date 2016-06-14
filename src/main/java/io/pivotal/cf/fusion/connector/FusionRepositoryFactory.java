package io.pivotal.cf.fusion.connector;

import feign.Feign;
import feign.auth.BasicAuthRequestInterceptor;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import io.pivotal.cf.fusion.signer.FusionRepository;
import org.apache.log4j.Logger;

public class FusionRepositoryFactory {

    private static final Logger LOG = Logger.getLogger(FusionRepositoryFactory.class);

    public FusionRepository create(FusionServiceInfo info) {

        LOG.debug("creating fusionRepo with info: " + info);

        return Feign.builder()
                .encoder(new GsonEncoder()).decoder(new GsonDecoder())
                .requestInterceptor(new BasicAuthRequestInterceptor(info.getUsername(), info.getPassword()))
                .target(FusionRepository.class, info.getUri());
    }
}

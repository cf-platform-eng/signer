package io.pivotal.cf.fusion.connector;

import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import io.pivotal.cf.fusion.signer.FusionRepository;
import org.apache.log4j.Logger;

import java.net.URL;

public class FusionRepositoryFactory {

    private static final Logger LOG = Logger.getLogger(FusionRepositoryFactory.class);

    public FusionRepository create(String url) {

        LOG.info("creating fusionRepo with uri: " + url);

        return Feign.builder()
                .encoder(new GsonEncoder()).decoder(new GsonDecoder())
                .target(FusionRepository.class, url);
    }

    public FusionRepository create(URL url) {
        return create(url.toString());
    }
}

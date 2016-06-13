package io.pivotal.cf.fusion.connector;

import io.pivotal.cf.fusion.signer.FusionRepository;
import org.apache.log4j.Logger;
import org.springframework.cloud.service.AbstractServiceConnectorCreator;
import org.springframework.cloud.service.ServiceConnectorConfig;

public class FusionRepositoryConnectionCreator extends AbstractServiceConnectorCreator<FusionRepository, FusionServiceInfo> {

    private static final Logger LOG = Logger.getLogger(FusionRepositoryConnectionCreator.class);

    @Override
    public FusionRepository create(FusionServiceInfo serviceInfo, ServiceConnectorConfig serviceConnectorConfig) {
        LOG.info("creating fusion repo wth uri: " + serviceInfo.getUri());
        return new FusionRepositoryFactory().create(serviceInfo.getUri());
    }
}

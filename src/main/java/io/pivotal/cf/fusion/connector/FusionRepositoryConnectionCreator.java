package io.pivotal.cf.fusion.connector;

import io.pivotal.cf.fusion.signer.FusionRepository;
import org.apache.log4j.Logger;
import org.springframework.cloud.service.AbstractServiceConnectorCreator;
import org.springframework.cloud.service.ServiceConnectorConfig;

public class FusionRepositoryConnectionCreator extends AbstractServiceConnectorCreator<FusionRepository, FusionServiceInfo> {

    private static final Logger LOG = Logger.getLogger(FusionRepositoryConnectionCreator.class);

    @Override
    public FusionRepository create(FusionServiceInfo serviceInfo, ServiceConnectorConfig serviceConnectorConfig) {
        LOG.debug("creating fusion repo wth service info: " + serviceInfo);
        return new FusionRepositoryFactory().create(serviceInfo);
    }
}
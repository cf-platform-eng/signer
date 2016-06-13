package io.pivotal.cf.signer;

import org.apache.log4j.Logger;
import org.springframework.cloud.cloudfoundry.CloudFoundryServiceInfoCreator;
import org.springframework.cloud.cloudfoundry.Tags;

import java.util.Map;

public class FusionCFServiceInfoCreator extends CloudFoundryServiceInfoCreator<FusionServiceInfo> {

    private static final Logger LOG = Logger.getLogger(FusionCFServiceInfoCreator.class);

    public FusionCFServiceInfoCreator() {
        super(new Tags("fusion"), FusionServiceInfo.URI_SCHEME);
    }

    @Override
    public FusionServiceInfo createServiceInfo(Map<String, Object> serviceData) {
        LOG.info("Returning fusion service info: " + serviceData.toString());

        Map<String, Object> credentials = getCredentials(serviceData);
        String id = getId(serviceData);
        String uri = getUriFromCredentials(credentials);

        return new FusionServiceInfo(id, uri);
    }
}
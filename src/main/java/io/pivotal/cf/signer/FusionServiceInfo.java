package io.pivotal.cf.signer;

import org.springframework.cloud.service.UriBasedServiceInfo;

public class FusionServiceInfo extends UriBasedServiceInfo {

    public static final String URI_SCHEME = "http";

    public FusionServiceInfo(String id, String host, int port, String username, String password, String greeting) {
        super(id, URI_SCHEME, host, port, username, password, greeting);
    }

    public FusionServiceInfo(String id, String uri) {
        super(id, uri);
    }
}

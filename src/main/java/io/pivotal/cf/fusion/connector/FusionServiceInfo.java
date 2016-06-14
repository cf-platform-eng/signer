package io.pivotal.cf.fusion.connector;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.cloud.service.ServiceInfo;

public class FusionServiceInfo implements ServiceInfo {

    static final String URI_SCHEME = "http";

    private String uri;
    private String username;
    private String password;
    private String id;

    public FusionServiceInfo(String id, String uri, String username, String password) {
        this.id = id;
        this.uri = uri;
        this.username = username;
        this.password = password;
    }

    public String getUri() {
        return uri;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getId() {
        return id;
    }

    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}

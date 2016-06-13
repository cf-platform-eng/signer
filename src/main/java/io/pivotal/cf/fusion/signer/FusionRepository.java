package io.pivotal.cf.fusion.signer;

import feign.Headers;
import feign.RequestLine;
import org.springframework.stereotype.Repository;

@Repository
public interface FusionRepository {

    @Headers("Content-Type: application/json")
    @RequestLine("GET /create-user")
    void getUser();

}

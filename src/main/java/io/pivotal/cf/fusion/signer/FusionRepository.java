package io.pivotal.cf.fusion.signer;

import feign.Headers;
import feign.RequestLine;
import io.pivotal.cf.fusion.model.SignRequest;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface FusionRepository {

    @Headers("Content-Type: application/json")
    @RequestLine("POST /signature")
    Map<String, Object> signature(Map<String, Object> request);
}
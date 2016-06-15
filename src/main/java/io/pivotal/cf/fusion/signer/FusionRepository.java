package io.pivotal.cf.fusion.signer;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@Repository
public interface FusionRepository {

    @Headers("Content-Type: application/json")
    @RequestLine("POST /signature")
    Map<String, Object> signature(Map<String, Object> request);

    @Headers("Content-Type: application/json")
    @RequestLine("GET /provenance/{uuid}")
    List<Object> provenance(@Param(value = "uuid") String uuid);

    @Headers("Content-Type: application/json")
    @RequestLine("GET /signature/{uuid}")
    Map<String, Object> signature(@Param(value = "uuid") String uuid);

    @Headers("Content-Type: application/json")
    @RequestLine("POST /verification")
    Map<String, Object> verify(@RequestBody Map<String, Object> request);
}
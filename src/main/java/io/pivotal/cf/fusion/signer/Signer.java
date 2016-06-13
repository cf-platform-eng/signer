package io.pivotal.cf.fusion.signer;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

@Service
public class Signer {

    public String sign(String entry) {
        return DigestUtils.sha256Hex(entry);
    }
}

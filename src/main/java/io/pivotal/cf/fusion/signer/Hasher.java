package io.pivotal.cf.fusion.signer;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
class Hasher {

    String hashAndEncode(String s) {
        return new String(encode(hash(s)));
    }

    byte[] hash(String s) {
        return DigestUtils.getSha256Digest().digest(s.getBytes());
    }

    byte[] encode(byte[] b) {
        return Base64.getEncoder().encode(b);
    }
}
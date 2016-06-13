package io.pivotal.cf.signer;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Properties;

@RestController
@RequestMapping("/signer")
class SignerController {

    private static final Logger LOG = Logger.getLogger(SignerController.class);

    @Autowired
    private Signer signer;

    @Autowired
    private FusionRepository fusionRepository;

    @Autowired
    Properties cloudProperties;

    @RequestMapping(value = "/{entry}", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    String sign(@PathVariable String entry) {
        if (entry == null || entry.length() < 1) {
            return null;
        }
        return getSignature(entry);
    }

    private String getSignature(String entry) {
        String s = signer.sign(entry);
        LOG.info(entry + ": " + s);
        return s;
    }

    @RequestMapping(value = "/props}", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    Properties props() {
        //fusionRepository.getUser();
        return cloudProperties;
    }
}
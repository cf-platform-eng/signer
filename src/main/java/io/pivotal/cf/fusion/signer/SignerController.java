package io.pivotal.cf.fusion.signer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/signer")
class SignerController {

    @Autowired
    private Hasher hasher;

    @Autowired
    private FusionRepository fusionRepository;


    @RequestMapping(value = "/{entry}", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    Map<String, Object> sign(@PathVariable String entry) {
        if (entry == null || entry.length() < 1) {
            return null;
        }
        return fusionRepository.signature(hasher.hash(entry));
    }
}
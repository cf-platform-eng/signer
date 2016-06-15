package io.pivotal.cf.fusion.signer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
class SignerController {

    @Autowired
    private Hasher hasher;

    @Autowired
    private FusionRepository fusionRepository;

    @RequestMapping(value = "/sign/{entry}", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    Map<String, Object> sign(@PathVariable String entry) {
        if (entry == null || entry.length() < 1) {
            return null;
        }

        Map<String, Object> request = new HashMap<>();
        Map<String, Object> response = new HashMap<>();

        String encodedHash = hasher.hashAndEncode(entry);
        request.put("base64EncodedDataHash", encodedHash);

        response.putAll(fusionRepository.signature(request));
        response.put("entry", entry);
        response.put("encodedHash", encodedHash);

        return response;
    }

    @RequestMapping(value = "/provenance/{uuid}", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    List<Object> provenance(@PathVariable String uuid) {
        if (uuid == null || uuid.length() < 1) {
            return null;
        }

        return fusionRepository.provenance(uuid);
    }

    @RequestMapping(value = "/signature/{uuid}", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    Map<String, Object> signature(@PathVariable String uuid) {
        if (uuid == null || uuid.length() < 1) {
            return null;
        }

        return fusionRepository.signature(uuid);
    }

    @RequestMapping(value = "/verification", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    Map<String, Object> verification(@RequestBody Map<String, Object> request) {
        if (request == null) {
            return null;
        }

        return fusionRepository.verify(request);
    }
}
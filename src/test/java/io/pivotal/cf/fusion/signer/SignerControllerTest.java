package io.pivotal.cf.fusion.signer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class})
public class SignerControllerTest {

    @Autowired
    private SignerController signerController;

    @Autowired
    private String uuid;

    @Autowired
    private String hash;

    @Test
    public void testSign() {
        Map<String, Object> resp = signerController.sign("test");
        assertNotNull(resp);
        assertEquals(3, resp.size());
        assertNotNull(resp.get("signatureUUID"));
        assertEquals("test", resp.get("entry"));
        assertEquals("n4bQgYhMfWWaL+qgxVrQFaO/TxsrC4Is0V1sFbDwCgg=", resp.get("encodedHash"));
    }

    @Test
    public void testProvenance() {
        List<Object> resp = signerController.provenance(uuid);
        assertNotNull(resp);
        assertEquals(1, resp.size());
    }

    @Test
    public void testSignature() {
        Map<String, Object> resp = signerController.signature(uuid);
        assertNotNull(resp);
        assertEquals(11, resp.size());
    }

    @Test
    public void testVerify() {
        Map<String, Object> request = new HashMap<>();
        request.put("signatureUUID", uuid);
        request.put("base64EncodedDataHash", hash);
        Map<String, Object> resp = signerController.verification(request);
        assertNotNull(resp);
        assertEquals(5, resp.size());
    }
}
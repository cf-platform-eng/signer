package io.pivotal.cf.fusion.signer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class})
public class SignerControllerTest {

    @Autowired
    private SignerController signerController;

    @Test
    public void testSigner() {
        Map<String, Object> resp = signerController.sign("test");
        assertNotNull(resp);
        assertEquals(3, resp.size());
        assertNotNull(resp.get("signatureUUID"));
        assertEquals("test", resp.get("entry"));
        assertEquals("n4bQgYhMfWWaL+qgxVrQFaO/TxsrC4Is0V1sFbDwCgg=", resp.get("encodedHash"));
    }
}

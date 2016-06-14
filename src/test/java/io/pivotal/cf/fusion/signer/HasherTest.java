package io.pivotal.cf.fusion.signer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class})
public class HasherTest {

    @Autowired
    private Hasher hasher;

    @Test
    public void testHash() {
        assertNotNull(hasher.hash("test"));
    }

    @Test
    public void testEncode() {
        assertEquals("dGVzdA==", new String(hasher.encode("test".getBytes())));
    }

    @Test
    public void testHashAndEncode() {
        assertEquals("n4bQgYhMfWWaL+qgxVrQFaO/TxsrC4Is0V1sFbDwCgg=", hasher.hashAndEncode("test"));
    }
}
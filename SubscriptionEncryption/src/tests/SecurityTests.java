package tests;

import com.hs1.Security;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SecurityTests {
    private static Security security;
    int[] expectedArr = {672, 832, 840, 920, 256, 840, 920, 256, 776, 256, 672, 808, 920, 928, 256, 664, 928, 912, 840, 880, 824, 264};
    String expectedStr = "This is a Test String!";

    @BeforeAll
    static void setUp() {
        security = new Security(3);
    }

    @Test
    @DisplayName("Encode will shift characters in array by correct values")
    public void testEncode() {
        assertArrayEquals(security.encode(expectedStr), expectedArr);
    }

    @Test
    @DisplayName("Decode will shift characters back to original values")
    public void testDecode() {
        assertEquals(security.decode(expectedArr), expectedStr);
    }
}

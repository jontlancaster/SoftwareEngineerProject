package tests;

import com.hs1.FileUtil;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class FileUtilTests {
    private static int[] expectedArr = {1, 2, 3};
    private static File file;

    @BeforeAll
    static void setUp() throws IOException {
        file = new File("SubscriptionEncryption/src/tests", "testFile.txt");
        FileWriter writer = new FileWriter(file, false);
        writer.write(Arrays.toString(expectedArr));
        writer.close();
    }

    @Test
    @DisplayName("It should take a string turn it back into an int array")
    void testGetEncodedDataFromFile() {
        assertArrayEquals(FileUtil.getEncodedDataFromFile(Arrays.toString(expectedArr)), expectedArr);
    }

    @AfterAll
    static public void deleteFile() {
        file.delete();
    }
}



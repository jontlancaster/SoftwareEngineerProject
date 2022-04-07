package com.hs1;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class FileUtil {

    public static void writeToFile(int[] arrToWrite) {
        //going to try to write to output.txt
        //if output.txt exists, we will overwrite
        try {
            FileWriter writer = new FileWriter("output.txt", false);
            writer.write(Arrays.toString(arrToWrite));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getFileContents() throws IOException {
        return Files.readString(Path.of("output.txt"));
    }

    //converting string back to int[]
    public static int[] getEncodedDataFromFile(String fileString) {

        //we need to get rid of stuff from the file and get it back into an array
        String[] string = fileString.replaceAll("\\[", "")
                .replaceAll("]", "")
                .split(", ");

        int[] encodedArr = new int[string.length];

        //loop through our values, add them back to array as an integer
        for (int i = 0; i < string.length; i++) {
            encodedArr[i] = Integer.parseInt(string[i]);
        }

        return encodedArr;
    }
}

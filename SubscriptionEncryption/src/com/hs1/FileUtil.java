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
    public static int[] convertFileContents(String fileContentsStr) {

        //we need to get file contents back into an array
        String[] fileContentsArr = fileContentsStr.replaceAll("\\[", "")
                .replaceAll("]", "")
                .split(", ");

        int[] contentsArr = new int[fileContentsArr.length];

        //loop through our string values and convert them to int for decode
        for (int i = 0; i < fileContentsArr.length; i++) {
            contentsArr[i] = Integer.parseInt(fileContentsArr[i]);
        }

        return contentsArr;
    }
}

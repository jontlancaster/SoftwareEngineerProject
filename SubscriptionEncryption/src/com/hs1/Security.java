package com.hs1;

public class Security {
    private final int shift;

    public Security(int shift) {
        this.shift = shift;
    }

    /*
    To obfuscate, I'm creating converting each item in the json string to an array of each character's unicode code
    then I am shifting the code by a random number that will be used to un-obfuscate the string from the file later.
    A constraint here would be a larger data set causing machine to run out of memory
    */

    public int[] encode(String clearText) {
        int[] encodedOutput = new int[clearText.length()];

        //loop through our string and shift it the random number of bits
        for (int i = 0; i < clearText.length(); i++) {
            int characterNumVal = Character.codePointAt(clearText, i);
            encodedOutput[i] = characterNumVal << this.shift;
        }

        return encodedOutput;
    }

    public String decode(int[] encodedArr) {
        StringBuilder decodedString = new StringBuilder();

        for (int j : encodedArr) {
            int t = j >> this.shift;
            decodedString.append((char) t);
        }

        return decodedString.toString();
    }
}

package bullscows;

import java.util.*;

public class SimpleNumberGenerator {
    private final int length;
    private String generatedString;
    private char lastDigit;

    public SimpleNumberGenerator(int length) {
        this.length = length;
    }

    private void setGeneratedString() {
        Random random = new Random();
        List<Integer> digits = new ArrayList<>();

// Create a list of digits from 0 to 9
        for (int i = 0; i < 10; i++) {
            digits.add(i);
        }

// Add lowercase letters ('a' to 'z') using ASCII values
        if (length > 10) {
            int firstLetter = 97;
            int lastLetter = 97 + length - 10;

            for (int asciiValue = firstLetter; asciiValue <= lastLetter; asciiValue++) {
                digits.add(asciiValue);
            }
        }

        // Shuffle the digits list and select the first 'length' digits to form the answer
        // and assure that first digit is not 0
        while (digits.get(0) == 0) {
            Collections.shuffle(digits);
        }
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < length; i++) {
            answer.append(digits.get(i));
        }
        generatedString = answer.toString();
    }

    public String getGeneratedString() {
        setGeneratedString();
        return generatedString;
    }

    public char getLastDigit() {
        return lastDigit;
    }

    public void setLastDigit(int length) {
        // ASCII value of 0 is 48
        this.lastDigit = lastDigit;
    }
}
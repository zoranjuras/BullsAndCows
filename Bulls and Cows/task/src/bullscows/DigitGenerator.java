package bullscows;

import java.util.*;

public class DigitGenerator {
    private final int length;
    private final int numberOfSymbols;
    private static final int FIRST_LETTER = 97;
    private String generatedString;
    private char lastLetter;
    private char lastDigit;
    private String startingMessage;
    private String printedStars;

    public DigitGenerator(int length, int numberOfSymbols) {
        this.length = length;
        this.numberOfSymbols = numberOfSymbols;
    }

    private void setGeneratedString() {
        Random random = new Random();
        List<Character> alphanumerics = new ArrayList<>();

        // Create a list of alphanumerics
        int numberOfDigits = (Math.min(numberOfSymbols, 10));
        for (int i = 0; i < numberOfDigits; i++) {
            // ASCII value of 0 is 48
            alphanumerics.add((char) (i + 48));
        }
        // Add lowercase letters ('a' to 'z') using ASCII values
        if (numberOfSymbols > 10) {
            setLastLetter ((char) (FIRST_LETTER + numberOfSymbols - 11));

            for (int asciiValue = FIRST_LETTER; asciiValue <= getLastLetter(); asciiValue++) {
                alphanumerics.add((char) asciiValue);
            }
        }
        // Shuffle the alphanumerics list
        Collections.shuffle(alphanumerics);

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < length; i++) {
            answer.append(alphanumerics.get(i));
        }
        generatedString = answer.toString();
    }

    public String getGeneratedString() {
        setGeneratedString();
        return generatedString;
    }

    public String getPrintedStars() {
        setPrintedStars(length);
        return printedStars;
    }

    public void setPrintedStars(int length) {
        StringBuilder stars = new StringBuilder();
        for (int i = 0; i < length; i++) {
            stars.append('*');
        }
        printedStars = stars.toString();
    }

    public void setStartingMessage() {
        StringBuilder message = new StringBuilder();
        message.append("The secret is prepared: ");
        message.append(getPrintedStars());
        message.append(" (0-");
        message.append(getLastDigit());

        if (numberOfSymbols <= 10) {
            message.append(").");
        }
        else {
            if (numberOfSymbols == 11) {
                message.append(", a).");
            }
            else {
                message.append(", a-");
                message.append(getLastLetter());
                message.append(").");

            }
        }
        startingMessage = message.toString();
    }

    public String getStartingMessage() {
        setStartingMessage();
        return startingMessage;
    }

    public char getLastDigit() {
        setLastDigit(numberOfSymbols);
        return lastDigit;
    }

    public void setLastDigit(int numberOfSymbols) {
        lastDigit = (numberOfSymbols > 10) ? '9' : (char) ('0' + numberOfSymbols - 1);
    }

    public char getLastLetter() {
        return lastLetter;
    }

    public void setLastLetter(char lastLetter) {
        this.lastLetter = lastLetter;
    }
}
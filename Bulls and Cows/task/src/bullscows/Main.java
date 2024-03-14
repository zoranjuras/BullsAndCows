package bullscows;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Input the length of the secret code:");

        int secretStringLength = 0;
        String entry = null;
        try {
            entry = scanner.nextLine();
            secretStringLength = Integer.parseInt(entry);
        } catch (NumberFormatException e) {
            System.out.printf("Error: \"%s\" isn't a valid number.", entry);
            System.exit(0);
        }

        if (secretStringLength < 1) {
            System.out.println("Error: it's not possible to generate a code with a length of 0.");
            System.exit(0);
        }

        System.out.println("Input the number of possible symbols in the code:");

        int numberOfSymbols = Integer.parseInt(scanner.next());

        if (numberOfSymbols < secretStringLength) {
            System.out.printf("Error: it's not possible to generate a code with a length of %d with %d unique symbols.", secretStringLength, numberOfSymbols);
            System.exit(0);
        }

        if (numberOfSymbols > 36) {
            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
            System.exit(0);
        }

        System.out.println("Okay, let's start a game!");

//        NumberGenerator ng = new NumberGenerator(secretStringLength);
        DigitGenerator sng = new DigitGenerator(secretStringLength, numberOfSymbols);

        String secretString = sng.getGeneratedString();
        System.out.println(sng.getStartingMessage());

        String guess;

        int bulls = 0;
        int cows = 0;
        int turn = 0;
        String sBulls = "bull";
        String sCows = "cow";

        while (bulls < secretStringLength) {
            turn++;
            System.out.printf("Turn %d: \n", turn);
            guess = scanner.next();
            for (int i = 0; i < guess.length(); i++) {
                if (guess.contains(String.valueOf(secretString.charAt(i)))) {
                    cows++;
                }
                if (secretString.charAt(i) == guess.charAt(i)) {
                    bulls++;
                    cows--;
                }
            }
            if (bulls > 1) {
                sBulls = "bulls";
            }
            if (cows > 1) {
                sCows = "cows";
            }
            if (bulls == 0 && cows == 0) {
                System.out.println("Grade: None\n");
            } else if (bulls != 0 && cows == 0) {
                System.out.printf("Grade: %d %s\n", bulls, sBulls);
                if (bulls == secretStringLength) {
                    System.out.println("Congratulations! You guessed the secret code.");
                    break;
                }
            } else if (cows != 0 && bulls == 0) {
                System.out.printf("Grade: %d %s\n", cows, sCows);
            } else {
                System.out.printf("Grade: %d %s and %d %s\n", bulls, sBulls, cows, sCows);
            }
            bulls = 0;
            cows = 0;
        }
    }
}



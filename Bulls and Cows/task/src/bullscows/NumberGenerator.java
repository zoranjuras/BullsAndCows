package bullscows;

public class NumberGenerator {
    private final int length;
    private String generatedString;

    protected NumberGenerator(int length) {
        this.length = length;
    }

    private void setGeneratedString() {
        StringBuilder sb = new StringBuilder();
        char c;
        int index;

        while (sb.length() < length) {
            String tmpString = getPseudoRandomNumber();
            for (int i = 0; i < tmpString.length(); i++) {
                c = tmpString.charAt(i);
                index = sb.indexOf(String.valueOf(c));
                if (index == -1) {
                    sb.append(c);
                    if (sb.length() == length) {
                        break;
                    }
                }
            }
        }
        generatedString = sb.toString();
    }

    public String getGeneratedString() {
        setGeneratedString();
        return generatedString;
    }

    private String getPseudoRandomNumber () {
        long pseudoRandomNumber = System.nanoTime();
        while (pseudoRandomNumber % 10 == 0) {
            pseudoRandomNumber /= 10;
        }
        StringBuilder sb = new StringBuilder();

        while (pseudoRandomNumber > 0) {
            sb.append(pseudoRandomNumber % 10);
            pseudoRandomNumber /= 10;
        }
        return sb.toString();
    }
}

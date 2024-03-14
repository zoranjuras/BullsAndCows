import java.util.*;

class Main {
    private static void printCommon(int[] firstArray, int[] secondArray) {
        Arrays.sort(firstArray);
        Arrays.sort(secondArray);
        HashMap<Integer, Boolean> mutual = new HashMap<>();
        StringBuilder result = new StringBuilder();

        int i = 0, j = 0;
        while (i < firstArray.length && j < secondArray.length) {
            if (firstArray[i] == secondArray[j]) {
                if (!mutual.containsKey(firstArray[i])) {
                    mutual.put(firstArray[i], true);
                    result.append(firstArray[i]).append(" ");
                }
                i++;
                j++;
            } else if (firstArray[i] < secondArray[j]) {
                i++;
            } else {
                j++;
            }
        }

        System.out.print(result.toString().trim());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] firstArray = new int [n];
        int[] secondArray = new int [n];
        for (int i = 0; i < n; ++i) { 
            firstArray[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; ++i) { 
            secondArray[i] = scanner.nextInt();
        }

        printCommon(firstArray,secondArray);
    }
}
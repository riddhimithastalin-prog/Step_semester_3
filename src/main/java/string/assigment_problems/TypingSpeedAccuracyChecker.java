package string.assigment_problems;

import java.util.Scanner;

public class TypingSpeedAccuracyChecker {

    public static void checkTypingAccuracy(String original, String typed) {

        int matchedCharacters = 0;
        int firstMismatchPosition = -1;

        for (int i = 0; i < original.length(); i++) {

            if (original.charAt(i) == typed.charAt(i)) {
                matchedCharacters++;
            } else if (firstMismatchPosition == -1) {
                firstMismatchPosition = i + 1;
            }
        }

        double accuracy = (double) matchedCharacters / original.length() * 100;

        System.out.println("Matched: " + matchedCharacters + "/" + original.length());
        System.out.printf("Accuracy: %.2f%%%n", accuracy);

        if (firstMismatchPosition == -1) {
            System.out.println("No Mismatches");
        } else {
            char originalCharacter = original.charAt(firstMismatchPosition - 1);
            char typedCharacter = typed.charAt(firstMismatchPosition - 1);

            System.out.println("First Mismatch at position "
                    + firstMismatchPosition
                    + " ('" + originalCharacter
                    + "' vs '" + typedCharacter + "')");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter original passage: ");
        String original = sc.nextLine();

        System.out.print("Enter typed text: ");
        String typed = sc.nextLine();

        if (original.length() != typed.length()) {
            System.out.println("Error: Both strings must have equal length.");
        } else {
            checkTypingAccuracy(original, typed);
        }

        sc.close();
    }
}
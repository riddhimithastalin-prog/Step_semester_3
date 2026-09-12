package string.class_problems;

import java.util.Scanner;

public class BankTransactionReferenceGenerator {

    public static String normalizeReference(String raw) {

        raw = raw.trim();

        String bankCode = raw.substring(0, 3).toUpperCase();
        String remaining = raw.substring(3);

        return bankCode.concat(remaining);
    }

    public static String validateAndFormat(String reference) {

        if (reference.length() != 14) {
            return "Invalid Reference: Wrong length";
        }

        String bankCode = reference.substring(0, 3);
        String body = reference.substring(3);

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(bankCode.charAt(i))) {
                return "Invalid Reference: Non-letter bank code";
            }
        }

        for (int i = 0; i < body.length(); i++) {
            if (!Character.isDigit(body.charAt(i))) {
                return "Invalid Reference: Non-digit body";
            }
        }

        String date = body.substring(0, 6);
        String sequence = body.substring(6);

        return "[" + bankCode + "] DATE: "
                + date.substring(0, 2) + "/"
                + date.substring(2, 4) + "/"
                + date.substring(4, 6)
                + " | SEQ: " + sequence;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter transaction reference: ");
        String raw = sc.nextLine();

        String normalized = normalizeReference(raw);

        System.out.println(validateAndFormat(normalized));

        sc.close();
    }
}
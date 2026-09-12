package access.assigment_problems;

public class AccessChecker {

    static String classifyAccess(String fieldModifier, String accessorContext) {

        if (fieldModifier.equals("private")) {
            return accessorContext.equals("SAME_CLASS")
                    ? "ALLOWED" : "DENIED";
        }

        if (fieldModifier.equals("default")) {
            return (accessorContext.equals("SAME_CLASS")
                    || accessorContext.equals("SAME_PACKAGE"))
                    ? "ALLOWED" : "DENIED";
        }

        if (fieldModifier.equals("protected")) {
            return (accessorContext.equals("SAME_CLASS")
                    || accessorContext.equals("SAME_PACKAGE")
                    || accessorContext.equals("SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"))
                    ? "ALLOWED" : "DENIED";
        }

        if (fieldModifier.equals("public")) {
            return "ALLOWED";
        }

        return "DENIED";
    }

    static String summarizeByModifier(String[][] attempts) {

        int privateAllowed = 0, privateDenied = 0;
        int defaultAllowed = 0, defaultDenied = 0;
        int protectedAllowed = 0, protectedDenied = 0;
        int publicAllowed = 0, publicDenied = 0;

        for (String[] attempt : attempts) {

            String modifier = attempt[0];
            String context = attempt[1];

            String result = classifyAccess(modifier, context);

            if (modifier.equals("private")) {
                if (result.equals("ALLOWED")) privateAllowed++;
                else privateDenied++;
            } else if (modifier.equals("default")) {
                if (result.equals("ALLOWED")) defaultAllowed++;
                else defaultDenied++;
            } else if (modifier.equals("protected")) {
                if (result.equals("ALLOWED")) protectedAllowed++;
                else protectedDenied++;
            } else if (modifier.equals("public")) {
                if (result.equals("ALLOWED")) publicAllowed++;
                else publicDenied++;
            }
        }

        return "private: " + privateAllowed + " allowed / " + privateDenied + " denied"
                + " | default: " + defaultAllowed + " allowed / " + defaultDenied + " denied"
                + " | protected: " + protectedAllowed + " allowed / " + protectedDenied + " denied"
                + " | public: " + publicAllowed + " allowed / " + publicDenied + " denied";
    }

    static String firstDeniedAttempt(String[][] attempts) {

        for (int i = 0; i < attempts.length; i++) {

            String result = classifyAccess(attempts[i][0], attempts[i][1]);

            if (result.equals("DENIED")) {
                return attempts[i][0]
                        + " via "
                        + attempts[i][1]
                        + " (attempt #" + (i + 1) + ")";
            }
        }

        return "None Denied";
    }

    public static void main(String[] args) {

        String[][] attempts = {
                {"protected", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"},
                {"protected", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"},
                {"private", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"}
        };

        System.out.println(firstDeniedAttempt(attempts));
    }
}
package week5.assigment_problems;

public class ReferenceDeskSubclassReach {

    static String classifyAccess(String fieldModifier, String accessorContext) {
        if ("public".equals(fieldModifier)) return "ALLOWED";
        if ("private".equals(fieldModifier)) {
            return "SAME_CLASS".equals(accessorContext) ? "ALLOWED" : "DENIED";
        }
        if ("default".equals(fieldModifier)) {
            return ("SAME_CLASS".equals(accessorContext) || "SAME_PACKAGE".equals(accessorContext))
                    ? "ALLOWED" : "DENIED";
        }
        if ("protected".equals(fieldModifier)) {
            return ("SAME_CLASS".equals(accessorContext)
                    || "SAME_PACKAGE".equals(accessorContext)
                    || "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE".equals(accessorContext))
                    ? "ALLOWED" : "DENIED";
        }
        return "DENIED";
    }

    static String firstDeniedAttempt(String[][] attempts) {
        for (int i = 0; i < attempts.length; i++) {
            String modifier = attempts[i][0];
            String context = attempts[i][1];
            if ("DENIED".equals(classifyAccess(modifier, context))) {
                return modifier + " via " + context + " (attempt #" + (i + 1) + ")";
            }
        }
        return "None Denied";
    }

    public static void main(String[] args) {
        System.out.println(firstDeniedAttempt(new String[][] {
                {"public", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"},
                {"protected", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"},
                {"protected", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"}
        }));
        System.out.println(firstDeniedAttempt(new String[][] {
                {"public", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"},
                {"protected", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"}
        }));
    }
}

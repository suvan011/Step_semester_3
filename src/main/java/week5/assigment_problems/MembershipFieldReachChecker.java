package week5.assigment_problems;

public class MembershipFieldReachChecker {

    static class AccessChecker {
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
                return ("SAME_CLASS".equals(accessorContext) || "SAME_PACKAGE".equals(accessorContext))
                        ? "ALLOWED" : "DENIED";
            }
            return "DENIED";
        }

        static String summarizeByModifier(String[][] attempts) {
            String[] modifiers = {"private", "default", "protected", "public"};
            StringBuilder result = new StringBuilder();

            for (int m = 0; m < modifiers.length; m++) {
                int allowed = 0;
                int denied = 0;
                for (String[] attempt : attempts) {
                    if (modifiers[m].equals(attempt[0])) {
                        if ("ALLOWED".equals(classifyAccess(attempt[0], attempt[1]))) allowed++;
                        else denied++;
                    }
                }
                if (m > 0) result.append(" | ");
                result.append(modifiers[m]).append(": ")
                        .append(allowed).append(" allowed / ")
                        .append(denied).append(" denied");
            }
            return result.toString();
        }
    }

    static class LibraryMember {
        private String membershipPin;
        String branchCode;
        protected double finesOwed;
        public String displayName;
    }

    public static void main(String[] args) {
        System.out.println(AccessChecker.classifyAccess("private", "SAME_CLASS"));
        System.out.println(AccessChecker.summarizeByModifier(new String[][] {
                {"private", "SAME_CLASS"},
                {"private", "SAME_PACKAGE"},
                {"default", "SAME_PACKAGE"},
                {"default", "DIFFERENT_PACKAGE"},
                {"protected", "SAME_PACKAGE"},
                {"protected", "SAME_CLASS"},
                {"public", "DIFFERENT_PACKAGE"}
        }));
    }
}

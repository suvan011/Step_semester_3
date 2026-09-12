package week5.class_problems;

public class MovieTicketFieldVisibilityChecker {

    static class AccessChecker {
        static String classifyAccess(String fieldModifier, String accessorContext) {
            if ("public".equals(fieldModifier)) {
                return "ALLOWED";
            }
            if ("private".equals(fieldModifier)) {
                return "SAME_CLASS".equals(accessorContext) ? "ALLOWED" : "DENIED";
            }
            if ("default".equals(fieldModifier)) {
                return "SAME_CLASS".equals(accessorContext) || "SAME_PACKAGE".equals(accessorContext)
                        ? "ALLOWED" : "DENIED";
            }
            if ("protected".equals(fieldModifier)) {
                return "SAME_CLASS".equals(accessorContext) || "SAME_PACKAGE".equals(accessorContext)
                        ? "ALLOWED" : "DENIED";
            }
            return "DENIED";
        }

        static String summarizeBatch(String[][] attempts) {
            int allowed = 0;
            int denied = 0;
            for (String[] attempt : attempts) {
                if ("ALLOWED".equals(classifyAccess(attempt[0], attempt[1]))) {
                    allowed++;
                } else {
                    denied++;
                }
            }
            return "Allowed: " + allowed + " | Denied: " + denied;
        }
    }

    static class MovieTicket {
        private String seatNumber;
        String screenId;
        protected double ticketPrice;
        public String movieTitle;

        MovieTicket(String seatNumber, String screenId, double ticketPrice, String movieTitle) {
            this.seatNumber = seatNumber;
            this.screenId = screenId;
            this.ticketPrice = ticketPrice;
            this.movieTitle = movieTitle;
        }
    }

    public static void main(String[] args) {
        System.out.println(AccessChecker.classifyAccess("private", "SAME_CLASS"));
        System.out.println(AccessChecker.classifyAccess("protected", "DIFFERENT_PACKAGE"));
        System.out.println(AccessChecker.summarizeBatch(new String[][] {
                {"default", "SAME_PACKAGE"},
                {"default", "DIFFERENT_PACKAGE"},
                {"public", "DIFFERENT_PACKAGE"}
        }));
    }
}

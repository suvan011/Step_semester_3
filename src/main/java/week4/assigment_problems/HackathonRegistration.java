package week4.assigment_problems;

public class HackathonRegistration {
    static class Participant {
        private String name;
        private String teamName;
        private boolean registered;

        public Participant(String name, String teamName) {
            this.name = name;
            this.teamName = teamName;
            this.registered = true;
        }

        public Participant(String name) {
            this(name, "Unassigned");
        }

        public void printStatus() {
            System.out.println(name + " | " + teamName + " | Registered: " + registered);
        }
    }

    public static void main(String[] args) {
        String[] names = {"Ravi", "Meera", "Karthik", "Divya"};
        String[] teamNames = {"ByteBusters", "", "CodeCrafters", ""};
        for (int i = 0; i < names.length; i++) {
            Participant participant = teamNames[i].isEmpty()
                    ? new Participant(names[i])
                    : new Participant(names[i], teamNames[i]);
            participant.printStatus();
        }
    }
}

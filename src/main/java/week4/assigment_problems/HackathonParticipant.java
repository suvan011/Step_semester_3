package week4.assigment_problems;

public class HackathonParticipant {
    private String name;
    private String teamName;
    private boolean registered;

    public HackathonParticipant(String name, String teamName) {
        this.name = name;
        this.teamName = teamName;
        this.registered = true;
    }

    public HackathonParticipant(String name) {
        this(name, "Unassigned");
    }

    public void printStatus() {
        System.out.println(name + " | " + teamName + " | Registered: " + registered);
    }

    public static void main(String[] args) {
        String[] names = {"Ravi", "Meera", "Karthik", "Divya"};
        String[] teamNames = {"ByteBusters", "", "CodeCrafters", ""};

        for (int i = 0; i < names.length; i++) {
            HackathonParticipant participant;
            if (teamNames[i].isEmpty()) {
                participant = new HackathonParticipant(names[i]);
            } else {
                participant = new HackathonParticipant(names[i], teamNames[i]);
            }
            participant.printStatus();
        }
    }
}

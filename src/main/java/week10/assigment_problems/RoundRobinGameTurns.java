public class RoundRobinGameTurns {
    static class Node {
        String name; Node next;
        Node(String name) { this.name = name; }
    }
    static class CircularList {
        Node tail;
        void addLast(String name) {
            Node n = new Node(name);
            if (tail == null) { tail = n; n.next = n; }
            else { n.next = tail.next; tail.next = n; tail = n; }
        }
        void printTurns(int turns) {
            if (tail == null || turns <= 0) return;
            Node cur = tail.next;
            for (int i = 0; i < turns; i++) {
                System.out.print(cur.name);
                if (i < turns - 1) System.out.print(" ");
                cur = cur.next;
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        CircularList players = new CircularList();
        players.addLast("Asha"); players.addLast("Ravi"); players.addLast("Neha");
        players.printTurns(7);
    }
}
// addLast: O(1); printTurns(t): O(t).
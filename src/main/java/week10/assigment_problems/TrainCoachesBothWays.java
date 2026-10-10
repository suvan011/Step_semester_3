import java.util.*;

public class TrainCoachesBothWays {
    static class Node {
        String name; Node prev, next;
        Node(String name) { this.name = name; }
    }
    Node head, tail;

    void addLast(String name) {
        Node n = new Node(name);
        if (head == null) head = tail = n;
        else { tail.next = n; n.prev = tail; tail = n; }
    }
    boolean remove(String name) {
        Node cur = head;
        while (cur != null && !cur.name.equals(name)) cur = cur.next;
        if (cur == null) return false;
        if (cur.prev != null) cur.prev.next = cur.next;
        else head = cur.next;
        if (cur.next != null) cur.next.prev = cur.prev;
        else tail = cur.prev;
        return true;
    }
    void printForward() {
        System.out.print("Forward: ");
        for (Node cur = head; cur != null; cur = cur.next) {
            System.out.print(cur.name);
            if (cur.next != null) System.out.print(" <-> ");
        }
        System.out.println();
    }
    void printBackward() {
        System.out.print("Backward: ");
        for (Node cur = tail; cur != null; cur = cur.prev) {
            System.out.print(cur.name);
            if (cur.prev != null) System.out.print(" <-> ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        TrainCoachesBothWays train = new TrainCoachesBothWays();
        for (String name : new String[]{"Engine", "A1", "B1", "B2", "Guard"}) train.addLast(name);
        train.remove("B1");
        train.printForward();
        train.printBackward();
    }
}
// Finding a coach: O(n); unlinking after finding it: O(1). addLast: O(1).
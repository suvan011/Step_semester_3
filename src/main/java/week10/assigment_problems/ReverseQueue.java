import java.util.*;

public class ReverseQueue {
    static class Node {
        int data; Node next;
        Node(int data) { this.data = data; }
    }
    static Node reverse(Node head) {
        Node prev = null, cur = head;
        while (cur != null) {
            Node next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
    static Node build(String input) {
        Node dummy = new Node(0), tail = dummy;
        if (!input.trim().isEmpty() && !input.trim().equalsIgnoreCase("null"))
            for (String s : input.trim().split("\\s+")) {
                tail.next = new Node(Integer.parseInt(s)); tail = tail.next;
            }
        return dummy.next;
    }
    static void print(Node head) {
        while (head != null) { System.out.print(head.data + " -> "); head = head.next; }
        System.out.println("null");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextLine()) print(reverse(build(sc.nextLine())));
    }
}
// Time: O(n); additional space: O(1). No new nodes are created by reverse().
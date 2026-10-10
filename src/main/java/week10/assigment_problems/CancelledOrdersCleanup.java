import java.util.*;

public class CancelledOrdersCleanup {
    static class Node {
        int data; Node next;
        Node(int data){this.data=data;}
    }
    static Node removeAll(Node head,int code) {
        while(head!=null && head.data==code) head=head.next;
        Node current=head;
        while(current!=null && current.next!=null) {
            if(current.next.data==code) current.next=current.next.next;
            else current=current.next;
        }
        return head;
    }
    static Node build(String input) {
        Node dummy=new Node(0),tail=dummy;
        if(!input.trim().isEmpty() && !input.trim().equalsIgnoreCase("null"))
            for(String x:input.trim().split("\\s+")) {
                tail.next=new Node(Integer.parseInt(x)); tail=tail.next;
            }
        return dummy.next;
    }
    static void print(Node head) {
        while(head!=null){System.out.print(head.data+" -> ");head=head.next;}
        System.out.println("null");
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        if(!sc.hasNextLine()) return;
        Node head=build(sc.nextLine());
        int code=sc.hasNextInt()?sc.nextInt():0;
        print(removeAll(head,code));
    }
}
// Time: O(n); additional space: O(1) for removal (excluding list construction).
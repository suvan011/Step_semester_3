import java.util.*;
interface NotificationChannel { void send(String student,String title); }
class EmailChannel implements NotificationChannel { public void send(String s,String t){System.out.println("[Email → "+s+"] "+t);} }
class SmsChannel implements NotificationChannel { public void send(String s,String t){System.out.println("[SMS → "+s+"] "+t);} }
class AppChannel implements NotificationChannel { public void send(String s,String t){System.out.println("[App → "+s+"] "+t);} }
class Student {
    String name,department; List<NotificationChannel> channels;
    Student(String n,String d,NotificationChannel... c){name=n;department=d;channels=Arrays.asList(c);}
}
class Notice {
    String title; Set<String> departments;
    Notice(String t,String... d){title=t;departments=new HashSet<>(Arrays.asList(d));}
}
class NoticeBoard {
    List<Student> students=new ArrayList<>();
    void add(Student s){students.add(s);}
    void post(Notice n){
        if(n.title==null||n.title.isBlank()||n.departments.isEmpty()){System.out.println("Cannot post notice: Title and at least one target department are required.");return;}
        System.out.println("Notice '"+n.title+"' posted to "+String.join(", ",n.departments)+".");
        for(Student s:students)if(n.departments.contains(s.department))for(NotificationChannel c:s.channels)c.send(s.name,n.title);
    }
}
class NoticeDemo {
    public static void main(String[] args){
        NoticeBoard b=new NoticeBoard();b.add(new Student("Asha","CSE",new EmailChannel(),new AppChannel()));b.add(new Student("Ravi","ECE",new SmsChannel()));
        b.post(new Notice("Lab Closed Tomorrow","CSE"));b.post(new Notice("Fee Deadline Extended","CSE","ECE"));b.post(new Notice("Sports Day"));
    }
}
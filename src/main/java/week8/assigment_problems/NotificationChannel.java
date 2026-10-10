import java.util.*;
interface NotificationChannel {void send(String student,String title);}
class EmailChannel implements NotificationChannel {public void send(String s,String t){System.out.println("[Email → "+s+"] "+t);}}
class SmsChannel implements NotificationChannel {public void send(String s,String t){System.out.println("[SMS → "+s+"] "+t);}}
class AppChannel implements NotificationChannel {public void send(String s,String t){System.out.println("[App → "+s+"] "+t);}}
class NoticeStudent {
    String name,department; List<NotificationChannel> channels=new ArrayList<>();
    NoticeStudent(String n,String d){name=n;department=d;}
    NoticeStudent prefers(NotificationChannel c){channels.add(c);return this;}
}
class Notice {
    String title; Set<String> departments;
    Notice(String title,Set<String> departments){if(title==null||title.trim().isEmpty())throw new IllegalArgumentException("Notice title is required.");if(departments==null||departments.isEmpty())throw new IllegalArgumentException("At least one target department is required.");this.title=title;this.departments=new HashSet<>(departments);}
}
class NoticeBoard {
    List<NoticeStudent> students=new ArrayList<>();
    void addStudent(NoticeStudent s){students.add(s);}
    void post(String title,String... departments){
        try{Notice n=new Notice(title,new HashSet<>(Arrays.asList(departments)));System.out.println("Notice '"+n.title+"' posted to "+String.join(", ",n.departments)+".");
            for(NoticeStudent s:students)if(n.departments.contains(s.department))for(NotificationChannel c:s.channels)c.send(s.name,n.title);
        }catch(IllegalArgumentException e){System.out.println("Cannot post notice: "+e.getMessage());}
    }
}
class NoticeDemo {
    public static void main(String[] args){
        NoticeBoard b=new NoticeBoard();
        b.addStudent(new NoticeStudent("Asha","CSE").prefers(new EmailChannel()).prefers(new AppChannel()));
        b.addStudent(new NoticeStudent("Ravi","ECE").prefers(new SmsChannel()));
        b.post("Lab Closed Tomorrow","CSE");b.post("Fee Deadline Extended","CSE","ECE");b.post("Sports Day");
    }
}
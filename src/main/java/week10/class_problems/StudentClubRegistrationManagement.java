import java.util.*;

public class StudentClubRegistrationManagement {
    static class Student {
        String roll, name;
        Student(String r,String n){roll=r;name=n;}
        public boolean equals(Object o){return o instanceof Student && roll.equals(((Student)o).roll);}
        public int hashCode(){return roll.hashCode();}
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in); Set<Student> members=new LinkedHashSet<>();
        List<String> output=new ArrayList<>();
        while(sc.hasNextLine()){
            String line=sc.nextLine().trim(); if(line.isEmpty()) continue;
            String[] p=line.split("\\s+");
            Student s=new Student(p[1],p[2]);
            if(p[0].equals("ADD")) output.add(members.add(s)?"Added":"duplicate rejected");
            else if(p[0].equals("CONTAINS")) output.add("contains: "+members.contains(s));
        }
        int count=members.size();
        int addOutputs=0;
        for(String s:output) if(s.equals("Added")||s.equals("duplicate rejected")) addOutputs++;
        for(int i=0;i<output.size();i++){
            if(i==addOutputs) System.out.println("member count "+count);
            System.out.println(output.get(i));
        }
        if(addOutputs==output.size()) System.out.println("member count "+count);
    }
}
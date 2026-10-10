import java.util.*;

public class ClassMarksGridAnalysis {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        List<String> names=new ArrayList<>(); List<int[]> rows=new ArrayList<>();
        while(sc.hasNextLine()){
            String line=sc.nextLine().trim(); if(line.isEmpty()) continue;
            int open=line.indexOf('['), close=line.indexOf(']');
            if(open<0||close<0) continue;
            names.add(line.substring(0,open).trim());
            String[] marks=line.substring(open+1,close).split(",");
            int[] row=new int[3];
            for(int i=0;i<3;i++) row[i]=Integer.parseInt(marks[i].trim());
            rows.add(row);
        }
        if(rows.isEmpty()) return;
        int[] subject=new int[3], totals=new int[rows.size()];
        int top=0;
        StringBuilder out=new StringBuilder("Totals ");
        for(int i=0;i<rows.size();i++){
            int[] row=rows.get(i);
            for(int j=0;j<3;j++){ totals[i]+=row[j]; subject[j]+=row[j]; }
            if(totals[i]>totals[top]) top=i;
            if(i>0) out.append(", ");
            out.append(names.get(i)).append(" ").append(totals[i]);
        }
        System.out.println(out);
        System.out.printf(Locale.US,"averages %.2f, %.2f, %.2f%n",
            subject[0]/(double)rows.size(),subject[1]/(double)rows.size(),subject[2]/(double)rows.size());
        System.out.println("topper "+names.get(top)+" ("+totals[top]+")");
    }
}
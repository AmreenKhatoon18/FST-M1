package Activites;
import java.util.HashSet;
public class Activity10 {
public static void main(String[] args) {
    HashSet<String> hs = new HashSet<String>();
    hs.add("Mon");
    hs.add("tue");
    hs.add("Wed");
    hs.add("Thu");
    hs.add("Fri");
    hs.add("Sat");
    System.out.println("Actual HashSet: " + hs);
    System.out.println("Size of HashSet: " + hs.size());
    System.out.println("Remove a hashSet: " + hs.remove("Mon"));
    if(hs.remove("Tue")) {
        System.out.println("Tue removed from the Set");
    } else {
        System.out.println("Tue is not present in the Set");
    }
    System.out.println("Checking if Fri is present: " + hs.contains("Fri"));
    System.out.println("Updated HashSet: " + hs);
}
}

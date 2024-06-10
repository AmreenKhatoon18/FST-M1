package Activites;
import java.util.ArrayList;
public class Activity9 {
    public static void main(String[] args) {
        //declaring Arraylist of String objects
        ArrayList<String> myList = new ArrayList<String>();
        //Adding objects to Array List at default index
        myList.add("Amreen");
        myList.add("Simron");
        myList.add("Bandani");
        //Adding object at specific index
        myList.add(3, "Shahid");
        myList.add(1, "Farheen");
        
        System.out.println("Print All the Objects:");
        for(String s:myList){
            System.out.println(s);
        }
        
        System.out.println("3rd element in the list is: " + myList.get(2));
        System.out.println("Is Gulfam present in the list: " + myList.contains("Gulfam"));
        System.out.println("Size of ArrayList: " + myList.size());
        
        myList.remove("Farheen");
        
        System.out.println("New Size of ArrayList: " + myList.size());
    }
}


package Activites;
import java.util.HashMap;
public class Activity11 {
public static void main(String[] args) {
    HashMap<Integer, String> hash_map = new HashMap<Integer, String>();
    hash_map.put(1, "Violet");
    hash_map.put(2, "Indigo");
    hash_map.put(3, "Blue");
    hash_map.put(4, "Green");
    hash_map.put(5, "Yellow");
    System.out.println("The Actual Hashmap: " + hash_map);
        hash_map.remove(2);
        // Map after removing a colour
        System.out.println("After removing Indigo: " + hash_map);
        
        // Check if green exists
        if(hash_map.containsValue("Green")) {
            System.out.println("Green exists in the HashMap");
        } else {
            System.out.println("Green does not exist in the Map");
        }
        
        // Print the size of the Map
        System.out.println("Number of pairs in the HashMap is: " + hash_map.size());
}
}

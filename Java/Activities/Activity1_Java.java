package Activites;

public class Activity1 {
    public static void main(String[] args) {
        Car fortuner = new Car();
        fortuner.make = 2014;
        fortuner.Color = "Black";
        fortuner.Transmission = "Manual"; 
        fortuner.displayCharacteristics();
        fortuner.accelerate();
        fortuner.brake();
    }
    
}

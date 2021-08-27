import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Arrays;

import org.patriksanta.Car.Data.Car;
import org.patriksanta.Car.Data.CarList;

public class App {
    public static void printCar(Car car) {
        System.out.println("Name: " + car.getName());
        System.out.println("Category: " + Arrays.toString(car.getCategory()));
        System.out.println("Price: " + car.getPrice() + "Ft");
        System.out.println("Year: " + (car.getDate().getYear() + 1900) + ".");
        System.out.println("Distance: " + car.getDistance() + " km");
        System.out.println("-----");
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        CarList carList = new CarList();
        carList.read("C:\\Users\\Patrik Santa\\Prog\\Java\\carScraping\\carList.ser");
        CarAppFrame carAppFrame = new CarAppFrame(carList);
    }
}

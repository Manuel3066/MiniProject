import java.util.Scanner;

import Controller.CarHelper;
import Model.Car;

public class testProgram {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 CarHelper ch = new CarHelper();
		 
			Car toAdd = new Car(5, 50, 10000.99, "Truck", "Ford", "F-150", "2022", "Black", "v6", "Automatic", "Gas", "All Wheel Drive", false);
			ch.insertCar(toAdd);

	}

}

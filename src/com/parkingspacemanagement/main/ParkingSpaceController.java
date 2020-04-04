package com.parkingspacemanagement.main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.parkingpspacemanagement.models.Vehicle;

public class ParkingSpaceController {

	public static void main(String[] args) {

		System.out.println("Welcome to parking space management system");
		Map<String, Vehicle> vehiclesList = new HashMap<String, Vehicle>();
		while (true) {
			parkingOperations(vehiclesList);
		}
	}

	private static void parkingOperations(Map<String, Vehicle> vehiclesList) {
		Vehicle vehicle = new Vehicle();

		System.out.println(
				"Enter 1 for parking vehicle\nPress 2 for exiting vehicle\nPress 3 for showing status of parking space\n4 for exit");
		Scanner input = new Scanner(System.in);
		switch (input.next()) {
		case "1":
			getVehicleDetails(input, vehicle, vehiclesList);
			ParkingSpaceManager.assignParkingSlot(vehicle);
			break;
		case "2":
			System.out.println("Enter vehicle number:\n");
			Vehicle v = vehiclesList.get(input.next());

			ParkingSpaceManager.deAllocateParkingSlot(v);
			break;
		case "3":
			ParkingSpaceManager.parkingSpaceStatus();
			break;
		case "4":
			System.out.println("Thankyou for using our parking management system");
			ParkingSpaceManager.parkingSpaceStatus();
			System.exit(1);
			break;
		default:
			System.out.println("Wrong input! Try Again");
		}
	}

	private static void getVehicleDetails(Scanner input, Vehicle vehicle, Map<String, Vehicle> vehiclesList) {
		String licenseNumber;
		String type;
		System.out.println("Enter vehicle number:\n");
		licenseNumber = input.next();
		System.out.println("Enter vehicle type:<FOUR_WHEELER/TWO_WHEELER>\n");
		type = input.next();
		vehicle.setLicenseNumber(licenseNumber);
		vehicle.setType(type);
		vehiclesList.put(licenseNumber, vehicle);

	}

}

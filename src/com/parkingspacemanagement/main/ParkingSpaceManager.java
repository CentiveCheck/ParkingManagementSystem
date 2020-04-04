package com.parkingspacemanagement.main;

import java.util.Map;

import com.parkingpspacemanagement.models.ParkingSlot;
import com.parkingpspacemanagement.models.ParkingSpace;
import com.parkingpspacemanagement.models.Vehicle;

public class ParkingSpaceManager {

	public static ParkingSpace parkingSpace = new ParkingSpace();
	private static Map<String, Integer> parkingSlotMap = parkingSpace.getParkingMap();
	private static String FOUR_WHEELER = "FOUR_WHEELER";
	private static String TWO_WHEELER = "TWO_WHEELER";

	public static ParkingSpace assignParkingSlot(Vehicle vehicle) {
		vehicle.setEntryTime(System.currentTimeMillis());

		if (FOUR_WHEELER.equalsIgnoreCase(vehicle.getType())) {
			if (ParkingSlot.FOUR_WHEELER_SLOTS_COUNT <= ParkingSpace.TOTAL_FOUR_WHEELER_SLOTS) {
				parkingSlotMap.put(vehicle.getLicenseNumber(), ++ParkingSlot.FOUR_WHEELER_SLOTS_COUNT);
				parkingSpace.setParkingMap(parkingSlotMap);
				System.out.println("Vehicle:" + vehicle.getLicenseNumber() + " is allocated slot number:"
						+ ParkingSlot.FOUR_WHEELER_SLOTS_COUNT);
			}

		}
		if (TWO_WHEELER.equalsIgnoreCase(vehicle.getType())) {
			if (ParkingSlot.TWO_WHEELER_SLOTS_COUNT <= ParkingSpace.TOTAL_TWO_WHEELER_SLOTS) {
				parkingSlotMap.put(vehicle.getLicenseNumber(), ++ParkingSlot.TWO_WHEELER_SLOTS_COUNT);

				parkingSpace.setParkingMap(parkingSlotMap);
				System.out.println("Vehicle:" + vehicle.getLicenseNumber() + "is allocated slot:"
						+ ParkingSlot.TWO_WHEELER_SLOTS_COUNT);
			}

		}
		return parkingSpace;
	}

	public static void deAllocateParkingSlot(Vehicle v) {
		v.setExitTime(System.currentTimeMillis());
		Double parkingHours = new Double((v.getExitTime() - v.getEntryTime()) / (1000 * 60 * 60));
		if (FOUR_WHEELER.equalsIgnoreCase(v.getType())) {
			v.setParkingFees(parkingHours * ParkingSlot.HOURLY_4_WHEELER_CHARGE);
			--ParkingSlot.FOUR_WHEELER_SLOTS_COUNT;
		} else {
			v.setParkingFees(parkingHours * ParkingSlot.HOURLY_2_WHEELER_CHARGE);
			--ParkingSlot.TWO_WHEELER_SLOTS_COUNT;
		}
		System.out.println(
				"Vehicle:" + v.getLicenseNumber() + " is removed.\n" + "Parking charges are:" + v.getParkingFees());
		parkingSlotMap.remove(v.getLicenseNumber());
		parkingSpace.setParkingMap(parkingSlotMap);

	}

	public static void parkingSpaceStatus() {
		System.out.println("Current status of parking space:");
		System.out.println("ALLOCATED VEHICLES:" + ParkingSpaceManager.parkingSpace.getParkingMap()
				+ "\navailable slots for Four wheeler:"
				+ (ParkingSpace.TOTAL_FOUR_WHEELER_SLOTS - ParkingSlot.FOUR_WHEELER_SLOTS_COUNT)
				+ "\navailable slots for Two wheeler:"
				+ (ParkingSpace.TOTAL_TWO_WHEELER_SLOTS - ParkingSlot.TWO_WHEELER_SLOTS_COUNT));
	}

}

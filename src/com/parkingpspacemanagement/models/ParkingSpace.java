package com.parkingpspacemanagement.models;

import java.util.HashMap;
import java.util.Map;

public class ParkingSpace {

	public static int TOTAL_TWO_WHEELER_SLOTS = 100;

	public static int TOTAL_FOUR_WHEELER_SLOTS = 100;

	private Map<String, Integer> parkingMap = new HashMap<>();

	public static int getTOTAL_TWO_WHEELER_SLOTS() {
		return TOTAL_TWO_WHEELER_SLOTS;
	}

	public static void setTOTAL_TWO_WHEELER_SLOTS(int tOTAL_TWO_WHEELER_SLOTS) {
		TOTAL_TWO_WHEELER_SLOTS = tOTAL_TWO_WHEELER_SLOTS;
	}

	public static int getTOTAL_FOUR_WHEELER_SLOTS() {
		return TOTAL_FOUR_WHEELER_SLOTS;
	}

	public static void setTOTAL_FOUR_WHEELER_SLOTS(int tOTAL_FOUR_WHEELER_SLOTS) {
		TOTAL_FOUR_WHEELER_SLOTS = tOTAL_FOUR_WHEELER_SLOTS;
	}

	public Map<String, Integer> getParkingMap() {
		return parkingMap;
	}

	public void setParkingMap(Map<String, Integer> parkingMap) {
		this.parkingMap = parkingMap;
	}

}

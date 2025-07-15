package _04_Problems._01_ParkingLot.Parking;

import java.util.List;

import _04_Problems._01_ParkingLot.Vehicle;

public class ParkingLot {

	private List<ParkingFloor> parkingFloors;

	ParkingLot(List<ParkingFloor> parkingFloors) {
		this.parkingFloors = parkingFloors;
	}

	public ParkingSpot findAvailableParkingSpot(Vehicle vehicle) {
		for (ParkingFloor parkingFloor : parkingFloors)
			return parkingFloor.findAvailableParkingSpot(vehicle);

		return null;
	}

	public ParkingSpot parkVehicle(Vehicle vehicle) {

		ParkingSpot spot = findAvailableParkingSpot(vehicle);

		if (spot != null) {
			spot.parkVehicle(vehicle);
			return spot;
		}

		return null;
	}

	public boolean vacateVehicle(ParkingSpot spot, Vehicle vehicle) {

		if (spot.isOccupied() && spot.getVehicle().equals(vehicle)) {
			spot.vacateVehicle(vehicle);
			return true;
		}

		return false;
	}

	public ParkingSpot getSpotByNum(int spotNum) {

		for (ParkingFloor floor : parkingFloors) {

			for (ParkingSpot spot : floor.getParkingSpots()) {
				if (spot.getSpotNum() == spotNum)
					return spot;
			}
		}

		return null;
	}
}

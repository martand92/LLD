package _04_Problems._01_ParkingLot.Parking;

import java.util.*;

import _04_Problems._01_ParkingLot.Vehicle;

class ParkingFloor {

	private List<ParkingSpot> parkingSpots = new ArrayList<ParkingSpot>();
	private int floorNum;

	ParkingFloor(int numOfCarParkingSpots, int numOfBikeParkingSpots, int floorNum) {

		this.floorNum = floorNum;

		for (int i = 0; i < numOfCarParkingSpots; i++)
			this.parkingSpots.add(new CarParkingSpot(i + 1));

		for (int i = 0; i < numOfBikeParkingSpots; i++)
			this.parkingSpots.add(new BikeParkingSpot(i + 1));
	}

	public ParkingSpot findAvailableParkingSpot(Vehicle vehicle) {

		for (ParkingSpot parkingSpot : parkingSpots) {

			if (parkingSpot.canPark(vehicle))
				return parkingSpot;
		}

		return null;
	}

	public List<ParkingSpot> getParkingSpots() {
		return parkingSpots;
	}

}

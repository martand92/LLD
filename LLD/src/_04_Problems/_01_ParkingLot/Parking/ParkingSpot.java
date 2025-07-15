package _04_Problems._01_ParkingLot.Parking;

import _04_Problems._01_ParkingLot.Vehicle;

public abstract class ParkingSpot {

	private int spotNum;
	private Vehicle vehicle;
	private boolean isOccupied;
	private String spotType;

	public ParkingSpot(int spotNum, String spotType) {
		this.spotNum = spotNum;
		this.spotType = spotType;
	}

	public int getSpotNum() {
		return spotNum;
	}

	public boolean isOccupied() {
		return isOccupied;
	}

	public String getSpotType() {
		return spotType;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public abstract boolean canPark(Vehicle vehicle);

	public void parkVehicle(Vehicle vehicle) {
		this.isOccupied = true;
		this.vehicle = vehicle;
	}

	public void vacateVehicle(Vehicle vehicle) {
		this.isOccupied = false;
		this.vehicle = null;
	}
}

class CarParkingSpot extends ParkingSpot {
	CarParkingSpot(int spotNum) {
		super(spotNum, "car");
	}

	@Override
	public boolean canPark(Vehicle vehicle) {
		if (vehicle.getVehicleType().equals(getSpotType()) && !isOccupied())
			return true;

		return false;
	}
}

class BikeParkingSpot extends ParkingSpot {
	BikeParkingSpot(int spotNum) {
		super(spotNum, "bike");
	}

	@Override
	public boolean canPark(Vehicle vehicle) {
		if (vehicle.getVehicleType().equals(getSpotType()) && !isOccupied())
			return true;

		return false;
	}
}

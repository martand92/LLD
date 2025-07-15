package _04_Problems._01_ParkingLot;

public abstract class Vehicle {

	private String vehicleType;
	private String vehiclePlateNum;

	public Vehicle(String vehicleType, String vehiclePlateNum) {
		this.vehicleType = vehicleType;
		this.vehiclePlateNum = vehiclePlateNum;
	}

	public String getVehicleType() {
		return this.vehicleType;
	}

	public String getVehiclePlateNum() {
		return this.vehiclePlateNum;
	}

	public abstract int calculateFees(int hoursStayed);
}

class CarVehicle extends Vehicle {

	public CarVehicle(String vehicleType, String vehiclePlateNum) {
		super(vehicleType, vehiclePlateNum);
	}

	@Override
	public int calculateFees(int hoursStayed) {
		return hoursStayed * 10;
	}

}

class BikeVehicle extends Vehicle {

	BikeVehicle(String vehicleType, String vehiclePlateNum) {
		super(vehicleType, vehiclePlateNum);
	}

	@Override
	public int calculateFees(int hoursStayed) {
		return hoursStayed * 5;
	}
}

class VehicleFactory {

	public static Vehicle getVehicle(String type, String plateNum) {

		if (type.equals("car"))
			return new CarVehicle("car", plateNum);
		else
			return new BikeVehicle("bike", plateNum);
	}

}

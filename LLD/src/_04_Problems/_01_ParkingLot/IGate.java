package _04_Problems._01_ParkingLot;

import _04_Problems._01_ParkingLot.Parking.ParkingLot;
import _04_Problems._01_ParkingLot.Parking.ParkingSpot;

public interface IGate {

}

class EntryGate {

	private ParkingLot parkingLot;

	EntryGate(ParkingLot parkingLot) {
		this.parkingLot = parkingLot;
	}

	public void entryProcess() {

		// Create Vehicle
		Vehicle vehicle = VehicleFactory.getVehicle("car", "abc");

		// Park Vehicle
		ParkingSpot spot = parkingLot.parkVehicle(vehicle);

	}
}

class ExitGate {

	private ParkingLot parkingLot;
	private PaymentService paymentService;

	ExitGate(ParkingLot parkingLot, PaymentService paymentService) {
		this.parkingLot = parkingLot;
		this.paymentService = paymentService;
	}

	public void exitProcess() {
		
		
	}

}

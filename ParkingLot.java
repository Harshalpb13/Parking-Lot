import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private Map<Integer, Floor> floors;
    private int totalCapacity;

    public ParkingLot(int totalFloors, int carSpaces, int bikeSpaces, int truckSpaces) {
        floors = new HashMap<>();
        totalCapacity = totalFloors * (carSpaces + bikeSpaces + truckSpaces);

        for (int i = 1; i <= totalFloors; i++) {
            floors.put(i, new Floor(i, carSpaces, bikeSpaces, truckSpaces));
        }
    }

    public boolean checkAvailability(int floorNumber, String vehicleType) {
        if (floors.containsKey(floorNumber)) {
            return floors.get(floorNumber).checkAvailability(vehicleType);
        }
        return false;
    }

    public void parkVehicle(int floorNumber, String vehicleType, Vehicle vehicle) {
        if (checkAvailability(floorNumber, vehicleType)) {
            floors.get(floorNumber).parkVehicle(vehicleType, vehicle);
            System.out.println("Vehicle parked on floor " + floorNumber);
        } else {
            System.out.println("No space available for " + vehicleType + " on floor " + floorNumber);
        }
    }

    public void removeVehicle(int floorNumber, String vehicleType, String registrationNumber) {
        floors.get(floorNumber).removeVehicle(vehicleType, registrationNumber);
    }

    public void displayStatus() {
        for (Floor floor : floors.values()) {
            floor.displayStatus();
        }
    }
}

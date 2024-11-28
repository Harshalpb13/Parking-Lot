import java.util.HashMap;
import java.util.Map;

public class Floor {
    private int floorNumber;
    private Map<String, VehicleSpace[]> vehicleSpaces;
    private Map<String, Integer> availableSpaces;

    public Floor(int floorNumber, int carSpaces, int bikeSpaces, int truckSpaces) {
        this.floorNumber = floorNumber;
        vehicleSpaces = new HashMap<>();
        availableSpaces = new HashMap<>();
        vehicleSpaces.put("car", new VehicleSpace[carSpaces]);
        vehicleSpaces.put("bike", new VehicleSpace[bikeSpaces]);
        vehicleSpaces.put("truck", new VehicleSpace[truckSpaces]);

        for (int i = 0; i < carSpaces; i++) {
            vehicleSpaces.get("car")[i] = new VehicleSpace(i + 1);
        }
        for (int i = 0; i < bikeSpaces; i++) {
            vehicleSpaces.get("bike")[i] = new VehicleSpace(i + 1);
        }
        for (int i = 0; i < truckSpaces; i++) {
            vehicleSpaces.get("truck")[i] = new VehicleSpace(i + 1);
        }

        availableSpaces.put("car", carSpaces);
        availableSpaces.put("bike", bikeSpaces);
        availableSpaces.put("truck", truckSpaces);
    }

    public boolean checkAvailability(String vehicleType) {
        return availableSpaces.get(vehicleType) > 0;
    }

    public void parkVehicle(String vehicleType, Vehicle vehicle) {
        if (checkAvailability(vehicleType)) {
            for (VehicleSpace space : vehicleSpaces.get(vehicleType)) {
                if (!space.isOccupied()) {
                    space.parkVehicle(vehicle);
                    availableSpaces.put(vehicleType, availableSpaces.get(vehicleType) - 1);
                    break;
                }
            }
        }
    }

    public void removeVehicle(String vehicleType, String registrationNumber) {
        for (VehicleSpace space : vehicleSpaces.get(vehicleType)) {
            if (space.isOccupied() && space.getVehicle().getRegistrationNumber().equals(registrationNumber)) {
                space.removeVehicle();
                availableSpaces.put(vehicleType, availableSpaces.get(vehicleType) + 1);
                break;
            }
        }
    }

    public void displayStatus() {
        System.out.println("Floor " + floorNumber + " Status:");
        for (String vehicleType : vehicleSpaces.keySet()) {
            int available = 0;
            for (VehicleSpace space : vehicleSpaces.get(vehicleType)) {
                if (!space.isOccupied()) {
                    available++;
                }
            }
            System.out.println(vehicleType + ": " + available + " available, " + (vehicleSpaces.get(vehicleType).length - available) + " occupied.");
        }
    }
}

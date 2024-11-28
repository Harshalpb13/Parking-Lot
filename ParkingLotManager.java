

public class ParkingLotManager {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(2, 2, 2, 2);
        CostStrategy costStrategy = new CostStrategy();

        

        // Initialize Vehicles
        Vehicle vehicle1 = new Vehicle("KA-01-HH-1234", "Red", "car");
        Vehicle vehicle2 = new Vehicle("KA-01-HH-5678", "Blue", "bike");

        // Parking vehicles
        parkingLot.parkVehicle(1, "car", vehicle1);
        parkingLot.parkVehicle(1, "bike", vehicle2);

        // Display status
        parkingLot.displayStatus();

        // Calculate cost
        System.out.println("Parking cost for car (2 hours): ₹" + costStrategy.getCost("car", 2));
        System.out.println("Parking cost for bike (1 hour): ₹" + costStrategy.getCost("bike", 1));

        // Remove vehicle
        parkingLot.removeVehicle(1, "car", "KA-01-HH-1234");
        parkingLot.displayStatus();
    }
}

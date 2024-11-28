import java.util.HashMap;
import java.util.Map;

public class CostStrategy {
    private Map<String, Double> costPerHour;

    public CostStrategy() {
        costPerHour = new HashMap<>();
        costPerHour.put("bike", 10.0);
        costPerHour.put("car", 20.0);
        costPerHour.put("truck", 30.0);
    }

    public double getCost(String vehicleType, int hours) {
        return costPerHour.getOrDefault(vehicleType, 0.0) * hours;
    }
}

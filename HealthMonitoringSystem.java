// HealthData class to represent health metrics
class HealthData {
    double heartRate;
    double temperature;
    boolean isFallen;

    // Constructor
    public HealthData(double heartRate, double temperature, boolean isFallen) {
        this.heartRate = heartRate;
        this.temperature = temperature;
        this.isFallen = isFallen;
    }
}

// WearableDevice class to simulate the wearable device
class WearableDevice {
    // Simulate collecting health data
    public HealthData collectHealthData() {
        // In a real-world scenario, you would read data from sensors
        // For simplicity, let's generate random data here
        double heartRate = Math.random() * 100 + 60;
        double temperature = Math.random() * 2 + 98.0;
        boolean isFallen = Math.random() < 0.05; // 5% chance of falling

        return new HealthData(heartRate, temperature, isFallen);
    }
}

// MobileApp class to simulate the mobile app
class MobileApp {
    // Display health data
    public void displayHealthData(HealthData healthData) {
        System.out.println("Heart Rate: " + healthData.heartRate);
        System.out.println("Temperature: " + healthData.temperature);
        System.out.println("Fall Detection: " + (healthData.isFallen ? "Fallen" : "Not Fallen"));
    }

    // Send emergency notification
    public void sendEmergencyNotification() {
        System.out.println("Emergency Notification: Immediate assistance required!");
    }
}

public class HealthMonitoringSystem {
    public static void main(String[] args) {
        WearableDevice wearableDevice = new WearableDevice();
        MobileApp mobileApp = new MobileApp();

        // Simulate continuous monitoring
        for (int i = 0; i < 10; i++) {
            HealthData healthData = wearableDevice.collectHealthData();
            mobileApp.displayHealthData(healthData);

            // Check for emergency (e.g., fall detection)
            if (healthData.isFallen) {
                mobileApp.sendEmergencyNotification();
            }

            // Simulate a delay between data collections
            try {
                Thread.sleep(1000); // 1-second interval
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

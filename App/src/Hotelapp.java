import java.util.HashMap;
import java.util.Map;

// -------------------- ABSTRACT CLASS --------------------
abstract class Room {
    protected int numberOfBeds;
    protected int squareFeet;
    protected double pricePerNight;

    public Room(int numberOfBeds, int squareFeet, double pricePerNight) {
        this.numberOfBeds = numberOfBeds;
        this.squareFeet = squareFeet;
        this.pricePerNight = pricePerNight;
    }

    public void displayRoomDetails() {
        System.out.println("Beds: " + numberOfBeds);
        System.out.println("Size: " + squareFeet + " sq.ft");
        System.out.println("Price per night: ₹" + pricePerNight);
    }
}

// -------------------- ROOM TYPES --------------------
class SingleRoom extends Room {
    public SingleRoom() {
        super(1, 250, 1500.0);
    }
}

class DoubleRoom extends Room {
    public DoubleRoom() {
        super(2, 400, 2500.0);
    }
}

class SuiteRoom extends Room {
    public SuiteRoom() {
        super(3, 750, 5000.0);
    }
}

// -------------------- ROOM INVENTORY --------------------
class RoomInventory {

    // HashMap to store availability
    private Map<String, Integer> roomAvailability;

    // Constructor
    public RoomInventory() {
        roomAvailability = new HashMap<>();
        initializeInventory();
    }

    // Initialize default values
    private void initializeInventory() {
        roomAvailability.put("Single", 5);
        roomAvailability.put("Double", 3);
        roomAvailability.put("Suite", 2);
    }

    // Get availability
    public Map<String, Integer> getRoomAvailability() {
        return roomAvailability;
    }

    // Update availability
    public void updateAvailability(String roomType, int count) {
        roomAvailability.put(roomType, count);
    }
}

// -------------------- MAIN CLASS --------------------
public class Hotelapp {

    public static void main(String[] args) {

        // Create inventory (centralized)
        RoomInventory inventory = new RoomInventory();

        // Create room objects
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        System.out.println("===== ROOM DETAILS =====");

        System.out.println("\n--- Single Room ---");
        single.displayRoomDetails();
        System.out.println("Available: " + inventory.getRoomAvailability().get("Single"));

        System.out.println("\n--- Double Room ---");
        doubleRoom.displayRoomDetails();
        System.out.println("Available: " + inventory.getRoomAvailability().get("Double"));

        System.out.println("\n--- Suite Room ---");
        suite.displayRoomDetails();
        System.out.println("Available: " + inventory.getRoomAvailability().get("Suite"));

        // Example update
        System.out.println("\nUpdating availability...");
        inventory.updateAvailability("Single", 4);

        System.out.println("Updated Single Room Availability: " +
                inventory.getRoomAvailability().get("Single"));

        System.out.println("\n===== END =====");
    }
}
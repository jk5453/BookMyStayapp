import java.util.Arrays;

public class UseCase19_TrainConsistManagement {

    public static boolean binarySearch(String[] bogieIds, String key) {
        int low = 0;
        int high = bogieIds.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int result = key.compareTo(bogieIds[mid]);

            if (result == 0) {
                return true;
            } else if (result < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("UC19: Binary Search for Bogie ID");

        String[] bogieIds = {"BG309", "BG101", "BG550", "BG205", "BG412"};

        Arrays.sort(bogieIds);

        String key = "BG309";

        System.out.println("Sorted Bogie IDs:");
        for (String id : bogieIds) {
            System.out.println(id);
        }

        boolean found = binarySearch(bogieIds, key);

        if (found) {
            System.out.println("Bogie " + key + " Found using Binary Search.");
        } else {
            System.out.println("Bogie " + key + " NOT Found.");
        }

        System.out.println("UC19 search completed...");
    }
}
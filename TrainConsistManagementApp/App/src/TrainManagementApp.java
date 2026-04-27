public class UseCase20TrainConsist {


    public static boolean searchBogie(String[] bogieIds, String searchId) {

     
        if (bogieIds == null || bogieIds.length == 0) {
            throw new IllegalStateException(
                "No bogies available in train. Cannot perform search."
            );
        }

        
        for (String id : bogieIds) {
            if (id.equals(searchId)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        
        String[] bogieIds = {};  
        String searchId = "BG101";

        try {
            boolean result = searchBogie(bogieIds, searchId);
            System.out.println("Search Result: " + result);
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nExecution completed...");
    }
}
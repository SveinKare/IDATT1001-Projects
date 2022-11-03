import java.util.Scanner;
/**
 * User client. 
 */
public class Client {
    private static Scanner scanner = new Scanner(System.in);
    private static EventRegister register = new EventRegister();

    public static void main(String[] args) {
        initializeRegister();
        boolean quit = false;
        do {
            try {
                showMenu();
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch(choice){
                    case 1:
                        menuOpt1();
                        break;
                    case 2:
                        menuOpt2();
                        break;
                    case 3:
                        menuOpt3();
                        break;
                    case 4:
                        quit = true;
                        break;
                    default:
                        System.out.println("Please enter a valid selection.");
                }
            } catch (Exception e) {
                System.out.println("That input is invalid. Please try again. ");
                scanner.nextLine();
            }
        } while(!quit);
        scanner.close();
    }

    /**
     * Initializes an EventRegister object with a couple of events. 
     * 
     * @return An EventRegister object with 5 events registered. 
     */
    private static void initializeRegister() {
        register.regEvent("Thing", "Park", "Someone", "Social", 202211091800.);
        register.regEvent("Another Thing", "Park", "Someone else", "Social", 202211031400.);
        register.regEvent("Yet another Thing", "Concert Hall", "Organizers", "Concert", 202212241900.);
        register.regEvent("A fourth Thing", "Home", "John", "Anti-Social", 202212131500.);
        register.regEvent("The Final Thing", "Hotel", "Hotel Management", "Dinner", 202211141400.);
    }

    /**
     * Shows menu for initial options. 
     */
    private static void showMenu() {
        System.out.println("Type a number to choose an option: ");
        System.out.println("1. Register a new event");
        System.out.println("2. Search for an event");
        System.out.println("3. List all events");
        System.out.println("4. Quit");
    }

    /**
     * Shows sub-menu for option 1. 
     */
    private static void menuOpt1() {
        System.out.println("Input a name for the event: ");
        String name = scanner.nextLine();
        System.out.println("Input the location of the event: ");
        String place = scanner.nextLine();
        System.out.println("Input the organizer for the event: ");
        String organizer = scanner.nextLine();
        System.out.println("Input the type of event: ");
        String type = scanner.nextLine();
        System.out.println("Input the time and date of the event in the format YYYYMMDDHHMM: ");
        double timeandDate = scanner.nextDouble();
        System.out.println("Your event was successfully registered.");
        register.regEvent(name, place, organizer, type, timeandDate);
    }

    private static void menuOpt2() {
        System.out.println("Select a category to search by: ");
        System.out.println("1. Specific date");
        System.out.println("2. Between two dates");
        System.out.println("3. Location");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch(choice) {
            case 1:
                System.out.println("Input a date in the format YYYYMMDD: ");
                int date = scanner.nextInt();
                scanner.nextLine();
                System.out.println("The following events are taking place at that date:\n" + register.eventsOnDate(date));
                break;
            case 2:
                System.out.println("From date (YYYYMMDD):");
                int dateFrom = scanner.nextInt();
                scanner.nextLine();
                System.out.println("To date (YYYYMMDD):");
                int dateTo = scanner.nextInt();
                scanner.nextLine();
                System.out.println("The following events are taking place in that timeframe:\n" + register.eventsFromToDate(dateFrom, dateTo));
                break;
            case 3:
                System.out.println("Type the name of the location:");
                String location = scanner.nextLine();
                System.out.println("The following events are planned for this location:\n" + register.eventsAtPlace(location));
                break;
        }
    }
    private static void menuOpt3() {
        boolean quit = false;
        do {
            System.out.println("Please select which category you would like to sort by: ");
            System.out.println("1. Location");
            System.out.println("2. Type");
            System.out.println("3. Time and date");
            
            int selection = scanner.nextInt();
            scanner.nextLine();
            switch(selection) {
                case 1:
                    System.out.println("Sorted by location: " + register.sortByLocation());
                    quit = true;
                    break;
                case 2:
                    System.out.println("Sorted by type: " + register.sortByType());
                    quit = true;
                    break;
                case 3:
                    System.out.println("Sorted by time and date: " + register.sortByDate());
                    quit = true;
                    break;
                default:
                    System.out.println("That selection is invalid. Please try again. ");
                    break;
            }
        } while(!quit);
    }
}

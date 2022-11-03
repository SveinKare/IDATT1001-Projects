import java.util.ArrayList;
import java.util.Scanner;

/*
 * User client
 */
public class Client {   
    private static Scanner scanner = new Scanner(System.in);
    private static MenuRegister register = new MenuRegister();
    public static void main(String[] args) {
        boolean quit = false;
        initializeRegister();
        do {
            try {
                showMenu();
                int selection = scanner.nextInt();
                scanner.nextLine();
                switch(selection) {
                    case 1:
                        regNewDish();
                        break;
                    case 2:
                        searchByName();
                        break;
                    case 3:
                        searchByType();
                        break;
                    case 4:
                        regNewMenu();
                        break;
                    case 5:
                        menusInRange();
                        break;
                    case 6:
                        quit = true;
                        break;
                    default:
                        System.out.println("That number is not a valid selection");
                        break;
                }
            } catch (Exception e) {
                System.out.println("That input is invalid, please try again.");
            }
        } while(!quit);
    }

    private static void initializeRegister() {
        register.regNewDish("Carbonara", "Main course", 150, "Do stuff");
        register.regNewDish("Spaghetti and meatballs", "Main course", 100, "Cook in a pan");
        register.regNewDish("Ice cream", "Dessert", 50, "Scoop it");
        register.regNewDish("Breadsticks", "Appetizer", 40, "Stick bread");
        register.regNewDish("Queen Mauds", "Dessert", 150, "Cognac and eggs");
        ArrayList<String> newMenu = new ArrayList<>();
        newMenu.add("Carbonara");
        newMenu.add("Breadsticks");
        newMenu.add("Ice cream");
        register.regNewMenu(newMenu);
    }

    private static void showMenu() {
        System.out.println("Type a number to select an option: ");
        System.out.println("1. Register a new dish");
        System.out.println("2. Search for a dish by name");
        System.out.println("3. Search for all dishes of a certain type");
        System.out.println("4. Register new menu");
        System.out.println("5. Find all menus in a certain price range");
        System.out.println("6. Quit");
    }

    private static void regNewDish() {
        System.out.println("Input a name for the dish: ");
        String name = scanner.nextLine();
        System.out.println("Input the type of the dish: ");
        String type = scanner.nextLine();
        System.out.println("Input a price for the dish (must be greater than 0): ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Input the recipe for the dish: ");
        String recipe = scanner.nextLine();
        register.regNewDish(name, type, price, recipe);
    }

    private static void searchByName() {
        System.out.println("Input the name of the dish you would like to find: ");
        String name = scanner.nextLine();
        System.out.println(register.getDish(name));
    }

    private static void searchByType() {
        System.out.println("Input what type of dishes you would like to find: ");
        String type = scanner.nextLine();
        System.out.println(register.dishesOfType(type));
    }

    private static void regNewMenu() {
        ArrayList<String> newMenu = new ArrayList<String>();
        System.out.println("How many dishes would you like to add?");
        int amount = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Here is the selection of dishes:\n" + register.getAllDishes() + "\nPlease input your selections: ");
        for (int i = 0; i < amount; i++) {
            newMenu.add(scanner.nextLine());
            System.out.println("Dish added");
        }
        register.regNewMenu(newMenu);
        System.out.println("Your menu has been registered.");
    }

    private static void menusInRange() {
        System.out.println("From: ");
        double from = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("To: ");
        double to = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Here are your menus:\n" + register.menusInRange(from, to));
    }
}

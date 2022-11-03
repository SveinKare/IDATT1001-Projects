import java.util.Scanner;

public class Client {
  private static PropertyRegister register = new PropertyRegister();
  private static Scanner scanner = new Scanner(System.in);
  public static void main(String[] args) {
    initializerRegister();
    showMenu();
  }

  private static void initializerRegister() {
    register.regProperty(1445, "Gloppen", 77, 631, 1017.6, "Jens Olsen", "");
    register.regProperty(1445, "Gloppen", 77, 131, 661.3, "Nicolay Madsen", "Syningom");
    register.regProperty(1445, "Gloppen", 75, 19, 650.6, "Evilyn Jensen", "Fugletun");
    register.regProperty(1445, "Gloppen", 74, 188, 1457.2, "Karl Ove Bråten", "");
    register.regProperty(1445, "Gloppen", 69, 47, 1339.4, "Elsa Indregård", "Høiberg");
  }
  private static void showMenu() {
    boolean quit = false;
    while (!quit) {
      try {
        System.out.println("Select an option by typing a number");
        System.out.println("1. Register a new property");
        System.out.println("2. Show a list of all properties currently registered");
        System.out.println("3. Search for a property");
        System.out.println("4. Show average area of the properties currently registered");
        System.out.println("5. Quit");
        int selection = scanner.nextInt();
        scanner.nextLine();
        switch (selection) {
          case 1 -> {
            System.out.println("Type in the information needed.");
            System.out.println("Municipality number (must be in the range 101-5054):");
            int muniNum = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Municipality name: ");
            String muniName = scanner.nextLine();
            System.out.println("Lot number: ");
            int lotNum = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Section number: ");
            int secNum = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Area (square meters): ");
            double area = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("Name of the owner: ");
            String ownerName = scanner.nextLine();
            System.out.println("Lot name (optional): ");
            String lotName = scanner.nextLine();
            register.regProperty(muniNum, muniName, lotNum, secNum, area, ownerName, lotName);
          }
          case 2 -> System.out.println(register);
          case 3 -> {
            System.out.println("Type the municipality number, lot number, and section number in the format ####-##/##:");
            String ID = scanner.nextLine();
            System.out.println("\n" + register.getProperty(ID) + "\n");
          }
          case 4 ->
                  System.out.println("The average area of the properties registered is " + register.averageAreaOfProperties());
          case 5 -> quit = true;
          default -> System.out.println("That is not a valid selection, please try again. ");
        }
      } catch (Exception e) {
        System.out.println("An error occurred: " + e.getMessage() + "\nPlease try again.");
      }
    }
  }
}

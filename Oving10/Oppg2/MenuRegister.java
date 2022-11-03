import java.util.ArrayList;

/**
 * This class contains registers of dishes and menus. 
 */
public class MenuRegister {
    private ArrayList<Dish> dishes;
    private ArrayList<Menu> menus;

    /**
     * Constructor. Initializes dish and menu arraylists.
     */
    public MenuRegister() {
        dishes = new ArrayList<Dish>();
        menus = new ArrayList<Menu>();
    }

    /**
     * Method to register a new dish. Checks that name is not null, and that price is greater than 0.
     * 
     * @param name (String)
     * @param type (String)
     * @param price (double)
     * @param recipe (String)
     */
    public void regNewDish(String name, String type, double price, String recipe) {
        if (price < 0) {
            throw new IllegalArgumentException("The price of a dish cannot be less than 0.");
        } else if (name == null){
            throw new IllegalArgumentException("The dish must have a name.");
        } else {
            dishes.add(new Dish(name, type, price, recipe));
        }
    }

    /**
     * Method to create a new menu. Takes an arraylist of dish names as parameter and finds them in the "dishes" ArrayList. 
     * 
     * @param dishNames (ArrayList<String>) A list of dish names. 
     */
    public void regNewMenu(ArrayList<String> dishNames) {
        ArrayList<Dish> newMenu = new ArrayList<Dish>();
        for (String name:dishNames) {
            for (Dish dish:dishes) {
                if (dish.getName().equalsIgnoreCase(name)) {
                    newMenu.add(dish);
                    break;
                }
            }
        }
        menus.add(new Menu(newMenu));
    }

    /**
     * Method to search for a dish by name. 
     * 
     * @param dishName (String) Name of the dish. 
     * @return The String returned by the toString() method of the dish. 
     */
    public String getDish(String dishName) {
        for (Dish dish:dishes) {
            if (dish.getName().equalsIgnoreCase(dishName)) {
                return dish.toString();
            }
        }
        return "No dishes matching that name could be found.";
    }

    /**
     * Method for finding all dishes of a certain type. 
     * 
     * @param type (String)
     * @return A string listing all the dishes of the given type.
     */
    public String dishesOfType(String type) {
        String dishList = "";
        for (Dish dish:dishes) {
            if (dish.getType().equalsIgnoreCase(type)) {
                dishList += dish;
            }
        }
        return dishList;
    }
    
    /**
     * Method to get a list of all the dishes currently registered. 
     * 
     * @return A string listing all the dishes. 
     */
    public String getAllDishes() {
        String dishList = "";
        for (Dish dish:dishes) {
            dishList += dish;
        }
        return dishList;
    }

    /**
     * Method for finding all menus in a given pricerange.
     * 
     * @param from (double)
     * @param to (double)
     * @return A string listing all the menus in the given range. 
     */
    public String menusInRange(double from, double to) {
        String menuList = "";
        double totalPrice;
        for (Menu menu:menus) {
            totalPrice = menu.getTotalPrice();
            if(totalPrice >= from && totalPrice <= to) {
                menuList += menu;
            }
        }
        return menuList;
    }

}

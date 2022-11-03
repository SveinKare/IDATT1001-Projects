import java.util.ArrayList;

/**
 * This class represents a menu containing a selection of dishes. 
 */
public class Menu {
    private ArrayList<Dish> dishes;

    /**
     * Constructor.
     * 
     * @param dishes (ArrayList<Dish>) Must contain at least one dish. 
     */
    public Menu(ArrayList<Dish> dishes) {
        if (dishes.size() > 0){
            this.dishes = new ArrayList<Dish>();
            for (Dish dish:dishes) {
                this.dishes.add(new Dish(dish.getName(), dish.getType(), dish.getPrice(), dish.getRecipe()));
            }
        } else {
            throw new IllegalArgumentException("The menu must contain at least one dish.");
        }
    }

    /**
     * Method for finding the total cost of all the dishes in the menu.
     * 
     * @return The total cost as a double.
     */
    public double getTotalPrice() {
        double total = 0;
        for (Dish dish:dishes) {
            total += dish.getPrice();
        }
        return total;
    }

    @Override
    public String toString() {
        String dishList = "\n***\nDishes:\n";
        for (Dish dish:dishes) {
            dishList += "\nName: " + dish.getName() + "\nType: " + dish.getType() + "\nPrice: " + dish.getPrice() + "\n";
        }
        dishList += "\nTotal Price: " + getTotalPrice() + "\n***\n";
        return dishList;
    } 
}

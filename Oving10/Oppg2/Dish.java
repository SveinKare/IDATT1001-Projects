/**
 * This class represents a dish, with attributes containing details about the dish. 
 */
public class Dish {
    private final String name;
    private final String type;
    private final double price;
    private final String recipe;

    /**
     * Constructor.
     * 
     * @param name (String) Name of the dish
     * @param type (String) The type of dish (dessert, main course etc.)
     * @param price (double) Price of the dish
     * @param recipe (String) The recipe for the dish
     */
    public Dish(String name, String type, double price, String recipe) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.recipe = recipe;
    }

    /**
     * Get-method for name
     * @return name (String)
     */
    public String getName() {
        return name;
    }

    /**
     * Get-method for type
     * @return type (String)
     */
    public String getType() {
        return type;
    }

    /**
     * Get-method for price
     * @return price (double)
     */
    public double getPrice() {
        return price;
    }

    /**
     * Get-method for recipe
     * @return recipe (String)
     */
    public String getRecipe() {
        return recipe;
    }

    @Override
    public String toString() {
        return "\nName: " + name + 
        "\nType: " + type + 
        "\nPrice: " + price +
        "\nRecipe: " + recipe + "\n";
    }
}

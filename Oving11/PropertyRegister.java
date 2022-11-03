import java.util.ArrayList;

/**
 * A class containing a register of properties.
 * This class uses ArrayList. This is to facilitate adding and removing elements in a quick and clear manner.
 */
public class PropertyRegister {
  private final ArrayList<Property> properties;

  public PropertyRegister() {
    properties = new ArrayList<>();
  }

  /**
   * Method to register a new property using composition.
   * Checks for duplicates by comparing the "ID" of the property to the ones registered.
   *
   * @param municipalityNumber (int)
   * @param municipalityName (String)
   * @param lotNumber (int)
   * @param sectionNumber (int)
   * @param lotName (String)
   * @param area (double)
   * @param nameOfOwner (String)
   * @throws IllegalArgumentException Throws exception if the property given as parameter already exists.
   */
  public void regProperty(int municipalityNumber,
                          String municipalityName,
                          int lotNumber,
                          int sectionNumber,
                          double area,
                          String nameOfOwner,
                          String lotName) throws IllegalArgumentException{
    for (Property property:properties) {
      if (municipalityNumber == property.getMunicipalityNumber()
              && lotNumber == property.getLotNumber()
              && sectionNumber == property.getSectionNumber()) {
        throw new IllegalArgumentException("That property has already been registered.");
      }
    }
    properties.add(new Property(municipalityNumber, municipalityName, lotNumber, sectionNumber, area, nameOfOwner, lotName));
  }

  /**
   * Method for finding a property based on an ID.
   *
   * @param ID (String)
   * @return The property object with matching ID.
   */
  public Property getProperty(String ID) {
    for (Property property:properties) {
      if (property.getPropertyID().equals(ID)) {
        return property;
      }
    }
    throw new IllegalArgumentException("That property does not exist.");
  }



  /**
   * Method for removing a property from the register.
   *
   * @param ID (String) The municipality number, lot number and section number in the format ####-##/##.
   */
  public void deleteProperty(String ID) {
    properties.remove(getProperty(ID));
  }

  /**
   * Method for finding how many properties are currently registered.
   *
   * @return (int)
   */
  public int getAmountRegistered() {
    return properties.size();
  }

  /**
   * Method to calculate average area of all the properties in the register.
   *
   * @return (double)
   */
  public double averageAreaOfProperties() {
    double totalArea = 0;
    for (Property property : properties) {
      totalArea += property.getArea();
    }
    totalArea /= properties.size();
    return (double)Math.round(totalArea*100)/100;
  }

  /**
   * Method to search for properties by lot number. Returns a list of the relevant objects.
   *
   * @param lotNumber (int)
   * @return ArrayList containing the objects being searched for.
   */
  public ArrayList<Property> searchByLotNumber(int lotNumber) {
    ArrayList<Property> propertyList = new ArrayList<>();
    for (Property property : properties) {
      if (property.getLotNumber() == lotNumber) {
        propertyList.add(property);
      }
    }
    return propertyList;
  }

  @Override
  public String toString() {
    String propertyList = "";
    for (Property property : properties) {
      propertyList += "\n" + property + "\n";
    }
    return propertyList;
  }
}

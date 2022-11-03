/**
 * This class represents a property in the real world. Contains information about the lot.
 * The class has set methods for lotName and nameOfOwner, as these are the only variables likely to change.
 */
public class Property {
  private final int municipalityNumber;
  private final String municipalityName;
  private final int lotNumber;
  private final int sectionNumber;
  private final double area;
  private String nameOfOwner;
  private String lotName;

  /**
   * Constructor with a lot name given.
   *
   * @param municipalityNumber (int)
   * @param municipalityName (String)
   * @param lotNumber (int)
   * @param sectionNumber (int)
   * @param area (double)
   * @param nameOfOwner (String)
   * @param lotName (String)
   */
  public Property(int municipalityNumber,
                  String municipalityName,
                  int lotNumber,
                  int sectionNumber,
                  double area,
                  String nameOfOwner,
                  String lotName) {
    if (municipalityNumber < 101 || municipalityNumber > 5054) {
      throw new IllegalArgumentException("Municipality number must be a number in the range 101-5054.");
    }
    if (lotNumber <= 0) {
      throw new IllegalArgumentException("Lot number must be greater than 0.");
    }
    if (sectionNumber <= 0) {
      throw new IllegalArgumentException("Section number must be greater than 0.");
    }
    if (area <=0) {
      throw new IllegalArgumentException("Area must be a number greater than 0.");
    }
    this.municipalityNumber = municipalityNumber;
    this.municipalityName = municipalityName;
    this.lotNumber = lotNumber;
    this.sectionNumber = sectionNumber;
    this.lotName = lotName;
    this.area = area;
    this.nameOfOwner = nameOfOwner;
  }

  public int getMunicipalityNumber() {
    return municipalityNumber;
  }

  public String getMunicipalityName() {
    return municipalityName;
  }

  public int getLotNumber() {
    return lotNumber;
  }

  public int getSectionNumber() {
    return sectionNumber;
  }

  public String getLotName() {
    return lotName;
  }

  public double getArea() {
    return area;
  }

  public String getNameOfOwner() {
    return nameOfOwner;
  }

  /**
   * Method to combine municipality number, lot number, and section number to a single id in the format ####-##/##.
   *
   * @return A string containing an ID.
   */
  public String getPropertyID() {
    return municipalityNumber + "-" + lotNumber + "/" + sectionNumber;
  }

  public void setLotName(String name) {
    lotName = name;
  }

  public void setOwner(String name) {
    nameOfOwner = name;
  }

  @Override
  public String toString() {
    return "Municipality number: " + municipalityNumber
            + "\nMunicipality name: " + municipalityName
            + "\nLot number: " + lotNumber
            + "\nSection number: " + sectionNumber
            + "\nArea: " + area
            + "\nName of owner: " + nameOfOwner
            + "\nLot name: " + lotName;
  }
}

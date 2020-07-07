public class ProductRecord {

  private String name;
  private double price;
  private int colorCode;
  private int styleCode;
  private int materialCode;
  private int patternCode;
  
  public ProductRecord(String name, double price, int colorCode, int styleCode, int materialCode, int patternCode) {
    this.name = name;
    this.price = price;
    this.colorCode = validateRange(colorCode, 10000, 10021);
    this.styleCode = validateRange(styleCode, 10, 12);
    this.materialCode = validateRange(materialCode, 500, 520);
    this.patternCode = validateRange(patternCode, 0, 4);
  }
  
  private int validateRange(int value, int lower, int upper) {
    if (value < lower || value > upper) {
      throw new IllegalArgumentException("Value should be between " + lower + " and " + upper + ".");
    }
    return value;
  }
  
  public void setPrice(double price) {
    this.price = price;
  }
  
  public String getName() {
    return name;
  }
  
  public double getPrice() {
    return price;
  }
  
  public int getColorCode() {
    return colorCode;
  }
  
  public int getStyleCode() {
    return styleCode;
  }
  
  public int getMaterialCode() {
    return materialCode;
  }
  
  public int getPatternCode() {
    return patternCode;
  }
  
  public int hashCode() {
      String Name = getName();
      int nameHashCode = Name.hashCode();
      int hashCode = 17;
      hashCode = 31 * hashCode + nameHashCode;
      hashCode = 31 * hashCode + getColorCode();
      hashCode = 31 * hashCode + getStyleCode();
      hashCode = 31 * hashCode + getMaterialCode();
      hashCode = 31 * hashCode + getPatternCode();
      hashCode = hashCode * 37; 

      /*
      String name = getName();
      for (int i = 0; i < name.length(); i++)
      {
        int value = name.codeAtPoint(i);
        hashCode = 31 * hashCode + value; 
      }
      */
      return hashCode; 
  }
}
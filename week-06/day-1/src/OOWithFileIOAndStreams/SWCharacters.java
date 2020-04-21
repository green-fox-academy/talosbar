package OOWithFileIOAndStreams;

public class SWCharacters {

  private String name;
  private String height;
  private String mass;
  private String hairColor;
  private String skinColor;
  private String eyeColor;
  private String birthYear;
  private String gender;

  public SWCharacters() {
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setHeight(String height) {
    this.height = height;
  }

  public void setMass(String mass) {
    this.mass = mass;
  }

  public void setHairColor(String hairColor) {
    this.hairColor = hairColor;
  }

  public void setSkinColor(String skinColor) {
    this.skinColor = skinColor;
  }

  public void setEyeColor(String eyeColor) {
    this.eyeColor = eyeColor;
  }

  public void setBirthYear(String birthYear) {
    this.birthYear = birthYear;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public Integer getHeightAsNumber() {
    if (!height.equals("unknown")) {
      return Integer.parseInt(height);
    }
    return null;
  }

  public Double getMassAsNumber() {
    if (mass.contains(",")) {
      mass = mass.replace(",", "");
    }
    if (!mass.equals("unknown")) {
      return Double.parseDouble(mass);
    }
    return null;
  }

  public String toString() {
    return this.name + " is " + this.height + " cm height, her/his mass is " + this.mass + " kg, her/his hair color is "
        + this.hairColor + ", her/his skin color is " + this.skinColor + ", her/his eye color is "
        + this.eyeColor + ", her/his birth year is " + this.birthYear + ", and her/his gender is " + this.gender + ".";
  }

  public String getGender() {
    return gender;
  }

  public String getName() {
    return name;
  }

  public String getBirthYear() {
    return birthYear;
  }
}

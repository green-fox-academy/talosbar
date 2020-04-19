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

  public Integer getMassAsNumber() {
    if (!mass.equals("unknown")) {
      return Integer.parseInt(mass);
    }
    return null;
  }


//  public Integer getMassAsNumber() {
//    if (mass.equals("unknown")) {
//      mass.replace("unknown", "0");
//    }
//    Integer.parseInt(mass);
//    return Integer.valueOf(mass);
//  }

//  public Integer getMassAsNumber() {
//    try {
//      Integer.parseInt(mass);
//    }
//    catch (NumberFormatException e) {
//      throw new RuntimeException("The string can't be converted into a number");
//    }
//    return Integer.valueOf(mass);
//  }
  public Integer getAge() {
    if (!mass.equals("unknown")) {
      return 2020 - Integer.parseInt(birthYear);
    }
    return null;
  }

  public String getGender() {
    return gender;
  }

  public String toString() {
    return this.name + " is " + this.height + " cm height, her/his mass is " + this.mass + " kg, her/his hair color is " + this.hairColor + ", her/his skin color is " + this.skinColor + ", her/his eye color is " + this.eyeColor + ", her/his birth year is " + this.birthYear + ", and her/his gender is " + this.gender + ".";
  }

  public static String getName() {
    return name;
  }

  public String getHairColor() {
    return hairColor;
  }

  public String getSkinColor() {
    return skinColor;
  }

  public String getEyeColor() {
    return eyeColor;
  }
}

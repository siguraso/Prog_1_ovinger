import java.util.Comparator;

public class Arrangement {
  // variables
  int arrangementID;
  String name;
  String arranger;
  String location;
  String typeOfArrangement;
  long time;

  //constructor
  public Arrangement(int arrangementID, long time,  String name, String arranger, String location,
      String typeOfArrangement) {
    this.arrangementID = arrangementID;
    this.name = name;
    this.arranger = arranger;
    this.location = location;
    this.typeOfArrangement = typeOfArrangement;
    this.time = time;
  }


  //get-methods

  public int getArrangementID() {
    return this.arrangementID;
  }

  public long getTime() {
    return this.time;
  }

  public String getName() {
    return this.name;
  }

  public String getArranger() {
    return this.arranger;
  }

  public String getLocation() {
    return this.location;
  }

  public String getTypeOfArrangement() {
    return this.typeOfArrangement;
  }

  // set-methods

  public void setArrangementID(int arrangementID) {
    this.arrangementID = arrangementID;
  }

  public void setTime(int time) {
    this.time = time;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setArranger(String arranger) {
    this.arranger = arranger;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public void setTypeOfArrangement(String typeOfArrangement) {
    this.typeOfArrangement = typeOfArrangement;
  }

}

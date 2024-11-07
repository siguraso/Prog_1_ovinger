import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class ArrangementRegister {
  ArrayList<Arrangement> arrangements;

  public ArrangementRegister(ArrayList<Arrangement> arrangements) {
    this.arrangements = arrangements;
  }

  // comparator


  // methods
  public Arrangement getArrangement(int index) {
    return this.arrangements.get(index);
  }

  ArrayList<Arrangement> getArrangements() {
    return this.arrangements;
  }

  public ArrayList<Arrangement> searchByLocation(String location) {
    ArrayList<Arrangement> searchResults = new ArrayList<>();

    for (Arrangement arrangement : arrangements) {
      if (arrangement.getLocation().equalsIgnoreCase(location)) {
        searchResults.add(arrangement);
      }
    }

    searchResults.sort(Comparator.comparing(Arrangement::getTime));

    return searchResults;
  }

  public ArrayList<Arrangement> searchByDate(String date) {
    ArrayList<Arrangement> searchResults = new ArrayList<>();

    for (Arrangement arrangement : arrangements) {
      String timeString = arrangement.getTime() + "";
      String dateOnly = timeString.substring(0, timeString.length() - 4);

      if (date.equalsIgnoreCase((dateOnly))) {
        searchResults.add(arrangement);
      }
    }

    searchResults.sort(Comparator.comparing(Arrangement::getTime));

    return searchResults;
  }

  public ArrayList<Arrangement> searchBetweenDates(long start, long end) {
    ArrayList<Arrangement> searchResults = new ArrayList<>();

    // sets the time of the given dates to 12 am.
    start = 10000;
    end = (end*10000) + 2359;


    for (Arrangement arrangement : arrangements) {
      if (arrangement.getTime() >= start && arrangement.getTime() <= end) {
        searchResults.add(arrangement);
      }
    }

    searchResults.sort(Comparator.comparing(Arrangement::getTime));

    return searchResults;
  }

  public void addArrangement(Arrangement arrangement) {
    this.arrangements.add(arrangement);
  }

  public void sortArrangements() {
    this.arrangements.sort(Comparator.comparing(Arrangement::getLocation)
        .thenComparing(Arrangement::getTypeOfArrangement)
        .thenComparing(Arrangement::getTime));
  }

}

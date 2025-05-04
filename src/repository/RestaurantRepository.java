package repository;

import model.Restaurant;
import java.io.*;
import java.util.*;

public class RestaurantRepository {
  private final String filename = "restaurants.txt";

  public List<Restaurant> findAll() {
    List<Restaurant> list = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
      String line;
      while ((line = br.readLine()) != null) {
        list.add(Restaurant.fromString(line));
      }
    } catch (IOException e) {}
    return list;
  }

  public void saveAll(List<Restaurant> restaurants) {
    try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
      for (Restaurant r : restaurants) {
        pw.println(r);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

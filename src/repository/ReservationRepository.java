package repository;

import model.Reservation;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReservationRepository {
  private final String filename = "reservations.txt";

  public List<Reservation> findAll() {
    List<Reservation> reservations = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
      String line;
      while ((line = br.readLine()) != null) {
        reservations.add(Reservation.fromString(line));
      }
    } catch (IOException e) {
      // ignore si fichier inexistant
    }
    return reservations;
  }

  public void saveAll(List<Reservation> reservations) {
    try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
      for (Reservation r : reservations) {
        pw.println(r);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

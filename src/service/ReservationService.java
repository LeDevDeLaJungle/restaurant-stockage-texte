package service;

import model.Reservation;
import repository.ReservationRepository;

import java.util.List;

public class ReservationService {
  private final ReservationRepository repository = new ReservationRepository();
  private List<Reservation> reservations;
  private int nextId = 1;

  public ReservationService() {
    reservations = repository.findAll();
    for (Reservation r : reservations) {
      if (r.getId() >= nextId) nextId = r.getId() + 1;
    }
  }

  public List<Reservation> list() { return reservations; }

  public void add(int clientId, int restaurantId, String date, int nbPersonnes) {
    Reservation r = new Reservation(nextId++, clientId, restaurantId, date, nbPersonnes);
    reservations.add(r);
    repository.saveAll(reservations);
  }

  public boolean update(int id, String date, int nbPersonnes) {
    for (Reservation r : reservations) {
      if (r.getId() == id) {
        r.setDate(date);
        r.setNbPersonnes(nbPersonnes);
        repository.saveAll(reservations);
        return true;
      }
    }
    return false;
  }

  public boolean delete(int id) {
    boolean removed = reservations.removeIf(r -> r.getId() == id);
    if (removed) repository.saveAll(reservations);
    return removed;
  }
}

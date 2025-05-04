package model;

public class Reservation {
  private int id;
  private int clientId;
  private int restaurantId;
  private String date;
  private int nbPersonnes;

  public Reservation(int id, int clientId, int restaurantId, String date, int nbPersonnes) {
    this.id = id;
    this.clientId = clientId;
    this.restaurantId = restaurantId;
    this.date = date;
    this.nbPersonnes = nbPersonnes;
  }

  public int getId() { return id; }
  public int getClientId() { return clientId; }
  public int getRestaurantId() { return restaurantId; }
  public String getDate() { return date; }
  public int getNbPersonnes() { return nbPersonnes; }

  public void setDate(String date) { this.date = date; }
  public void setNbPersonnes(int nbPersonnes) { this.nbPersonnes = nbPersonnes; }

  @Override
  public String toString() {
    return id + ";" + clientId + ";" + restaurantId + ";" + date + ";" + nbPersonnes;
  }

  public static Reservation fromString(String line) {
    String[] parts = line.split(";");
    return new Reservation(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), parts[3], Integer.parseInt(parts[4]));
  }
}
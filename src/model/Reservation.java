package model;

public class Reservation {
  private int id;
  private String nomClient;
  private String date;
  private int nbPersonnes;

  public Reservation(int id, String nomClient, String date, int nbPersonnes) {
    this.id = id;
    this.nomClient = nomClient;
    this.date = date;
    this.nbPersonnes = nbPersonnes;
  }

  public int getId() {
    return id;
  }

  public String getNomClient() {
    return nomClient;
  }

  public String getDate() {
    return date;
  }

  public int getNbPersonnes() {
    return nbPersonnes;
  }

  public void setNomClient(String nomClient) {
    this.nomClient = nomClient;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public void setNbPersonnes(int nbPersonnes) {
    this.nbPersonnes = nbPersonnes;
  }

  @Override
  public String toString() {
    return id + ";" + nomClient + ";" + date + ";" + nbPersonnes;
  }

  public static Reservation fromString(String line) {
    String[] parts = line.split(";");
    return new Reservation(Integer.parseInt(parts[0]), parts[1], parts[2], Integer.parseInt(parts[3]));
  }
}

package model;

public class Client {
  private int id;
  private String nom;

  public Client(int id, String nom) {
    this.id = id;
    this.nom = nom;
  }

  public int getId() { return id; }
  public String getNom() { return nom; }

  public void setNom(String nom) { this.nom = nom; }

  @Override
  public String toString() {
    return id + ";" + nom;
  }

  public static Client fromString(String line) {
    String[] parts = line.split(";");
    return new Client(Integer.parseInt(parts[0]), parts[1]);
  }
}

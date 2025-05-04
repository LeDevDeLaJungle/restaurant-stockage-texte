package model;

public class Restaurant {
  private int id;
  private String nom;

  public Restaurant(int id, String nom) {
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

  public static Restaurant fromString(String line) {
    String[] parts = line.split(";");
    return new Restaurant(Integer.parseInt(parts[0]), parts[1]);
  }
}
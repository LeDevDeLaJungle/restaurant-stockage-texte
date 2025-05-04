package controller;

import model.Reservation;
import service.ReservationService;

import java.util.List;
import java.util.Scanner;

public class ReservationController {
  private final ReservationService service = new ReservationService();
  private final Scanner scanner = new Scanner(System.in);

  public void start() {
    while (true) {
      System.out.println("\n1. Lister les réservations");
      System.out.println("2. Ajouter une réservation");
      System.out.println("3. Modifier une réservation");
      System.out.println("4. Supprimer une réservation");
      System.out.println("5. Quitter");
      System.out.print("Choix : ");
      int choix = scanner.nextInt();
      scanner.nextLine();

      switch (choix) {
        case 1 -> list();
        case 2 -> add();
        case 3 -> update();
        case 4 -> delete();
        case 5 -> { return; }
        default -> System.out.println("Choix invalide");
      }
    }
  }

  private void list() {
    List<Reservation> reservations = service.list();
    if (reservations.isEmpty()) {
      System.out.println("Aucune réservation trouvée.");
    } else {
      for (Reservation r : reservations) {
        System.out.println(r.getId() + " - " + r.getNomClient() + " - " + r.getDate() + " - " + r.getNbPersonnes() + " pers");
      }
    }
  }

  private void add() {
    System.out.print("Nom client : ");
    String nom = scanner.nextLine();
    System.out.print("Date (ex: 2025-05-04) : ");
    String date = scanner.nextLine();
    System.out.print("Nombre de personnes : ");
    int nb = scanner.nextInt();
    scanner.nextLine();
    service.add(nom, date, nb);
    System.out.println("Réservation ajoutée.");
  }

  private void update() {
    System.out.print("ID de la réservation à modifier : ");
    int id = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Nouveau nom client : ");
    String nom = scanner.nextLine();
    System.out.print("Nouvelle date : ");
    String date = scanner.nextLine();
    System.out.print("Nouveau nombre de personnes : ");
    int nb = scanner.nextInt();
    scanner.nextLine();
    if (service.update(id, nom, date, nb)) {
      System.out.println("Réservation modifiée.");
    } else {
      System.out.println("ID non trouvé.");
    }
  }

  private void delete() {
    System.out.print("ID de la réservation à supprimer : ");
    int id = scanner.nextInt();
    scanner.nextLine();
    if (service.delete(id)) {
      System.out.println("Réservation supprimée.");
    } else {
      System.out.println("ID non trouvé.");
    }
  }
}

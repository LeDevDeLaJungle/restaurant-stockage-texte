package controller;
import service.*;
import model.*;

import java.util.*;

public class MainController {
  private final ClientService clientService = new ClientService();
  private final RestaurantService restaurantService = new RestaurantService();
  private final ReservationService reservationService = new ReservationService();
  private final Scanner scanner = new Scanner(System.in);

  public void start() {
    while (true) {
      System.out.println("\n1. Lister les réservations");
      System.out.println("2. Ajouter une réservation");
      System.out.println("3. Modifier une réservation");
      System.out.println("4. Supprimer une réservation");
      System.out.println("5. Lister les clients");
      System.out.println("6. Ajouter un client");
      System.out.println("7. Lister les restaurants");
      System.out.println("8. Ajouter un restaurant");
      System.out.println("9. Quitter");
      System.out.print("Choix : ");
      int choix = scanner.nextInt();
      scanner.nextLine();

      switch (choix) {
        case 1 -> listReservations();
        case 2 -> addReservation();
        case 3 -> updateReservation();
        case 4 -> deleteReservation();
        case 5 -> listClients();
        case 6 -> addClient();
        case 7 -> listRestaurants();
        case 8 -> addRestaurant();
        case 9 -> { return; }
        default -> System.out.println("Choix invalide");
      }
    }
  }

  private void listReservations() {
    for (Reservation r : reservationService.list()) {
      Client c = clientService.getById(r.getClientId());
      Restaurant res = restaurantService.getById(r.getRestaurantId());
      System.out.println(r.getId() + " - Client: " + c.getNom() + " | Restaurant: " + res.getNom() + " | Date: " + r.getDate() + " | Personnes: " + r.getNbPersonnes());
    }
  }

  private void addReservation() {
    listClients();
    System.out.print("ID du client : ");
    int clientId = scanner.nextInt();
    scanner.nextLine();

    listRestaurants();
    System.out.print("ID du restaurant : ");
    int restaurantId = scanner.nextInt();
    scanner.nextLine();

    System.out.print("Date (ex: 2025-05-04) : ");
    String date = scanner.nextLine();
    System.out.print("Nombre de personnes : ");
    int nb = scanner.nextInt();
    scanner.nextLine();

    reservationService.add(clientId, restaurantId, date, nb);
    System.out.println("Réservation ajoutée.");
  }

  private void updateReservation() {
    listReservations();
    System.out.print("ID de la réservation à modifier : ");
    int id = scanner.nextInt();
    scanner.nextLine();

    System.out.print("Nouvelle date : ");
    String date = scanner.nextLine();
    System.out.print("Nouveau nombre de personnes : ");
    int nb = scanner.nextInt();
    scanner.nextLine();

    if (reservationService.update(id, date, nb)) {
      System.out.println("Réservation modifiée.");
    } else {
      System.out.println("ID non trouvé.");
    }
  }

  private void deleteReservation() {
    listReservations();
    System.out.print("ID de la réservation à supprimer : ");
    int id = scanner.nextInt();
    scanner.nextLine();

    if (reservationService.delete(id)) {
      System.out.println("Réservation supprimée.");
    } else {
      System.out.println("ID non trouvé.");
    }
  }

  private void listClients() {
    for (Client c : clientService.list()) {
      System.out.println(c.getId() + " - " + c.getNom());
    }
  }

  private void addClient() {
    System.out.print("Nom du client : ");
    String nom = scanner.nextLine();
    clientService.add(nom);
    System.out.println("Client ajouté.");
  }

  private void listRestaurants() {
    for (Restaurant r : restaurantService.list()) {
      System.out.println(r.getId() + " - " + r.getNom());
    }
  }

  private void addRestaurant() {
    System.out.print("Nom du restaurant : ");
    String nom = scanner.nextLine();
    restaurantService.add(nom);
    System.out.println("Restaurant ajouté.");
  }
}
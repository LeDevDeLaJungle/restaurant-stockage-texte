# Restaurant Reservation Manager

Une application Java en ligne de commande permettant de gérer les réservations d’un restaurant, en suivant une architecture en couches, avec persistance des données dans des fichiers texte.

## Structure du projet

restaurant/
- model/ # Entités : Client, Restaurant, Reservation
- dao/ # Accès aux fichiers texte
- service/ # Logique métier
- controller/ # Interface utilisateur via terminal
- Main.java # Point d'entrée de l'application


## Fonctionnalités

- Ajouter / Lister les clients
- Ajouter / Lister les restaurants
- CRUD complet sur les réservations :
  - Créer
  - Lire
  - Mettre à jour
  - Supprimer

## Persistance

Les données sont sauvegardées dans les fichiers suivants :
- `clients.txt`
- `restaurants.txt`
- `reservations.txt`

## Lancer l'application

### 1. Compilation

```bash
javac Main.java controller/*.java service/*.java dao/*.java model/*.java
```

2. Exécution

```bash
java Main
```

📝 Exemple d’utilisation

1. Lister les réservations
2. Ajouter une réservation
3. Modifier une réservation
4. Supprimer une réservation
5. Lister les clients
6. Ajouter un client
7. Lister les restaurants
8. Ajouter un restaurant
9. Quitter

package service;

import model.Restaurant;
import repository.RestaurantRepository;

import java.util.*;

public class RestaurantService {
  private final RestaurantRepository repository = new RestaurantRepository();
  private List<Restaurant> restaurants;
  private int nextId = 1;

  public RestaurantService() {
    restaurants = repository.findAll();
    for (Restaurant r : restaurants) {
      if (r.getId() >= nextId) nextId = r.getId() + 1;
    }
  }

  public List<Restaurant> list() { return restaurants; }

  public void add(String nom) {
    Restaurant r = new Restaurant(nextId++, nom);
    restaurants.add(r);
    repository.saveAll(restaurants);
  }

  public Restaurant getById(int id) {
    for (Restaurant r : restaurants) {
      if (r.getId() == id) return r;
    }
    return null;
  }
}
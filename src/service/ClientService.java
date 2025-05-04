package service;

import model.Client;
import repository.ClientRepository;

import java.util.List;

public class ClientService {
  private final ClientRepository repository = new ClientRepository();
  private List<Client> clients;
  private int nextId = 1;

  public ClientService() {
    clients = repository.findAll();
    for (Client c : clients) {
      if (c.getId() >= nextId) nextId = c.getId() + 1;
    }
  }

  public List<Client> list() { return clients; }

  public void add(String nom) {
    Client c = new Client(nextId++, nom);
    clients.add(c);
    repository.saveAll(clients);
  }

  public Client getById(int id) {
    for (Client c : clients) {
      if (c.getId() == id) return c;
    }
    return null;
  }
}

package repository;

import model.Client;
import java.io.*;
import java.util.*;

public class ClientRepository {
  private final String filename = "clients.txt";

  public List<Client> findAll() {
    List<Client> list = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
      String line;
      while ((line = br.readLine()) != null) {
        list.add(Client.fromString(line));
      }
    } catch (IOException e) {}
    return list;
  }

  public void saveAll(List<Client> clients) {
    try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
      for (Client c : clients) {
        pw.println(c);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
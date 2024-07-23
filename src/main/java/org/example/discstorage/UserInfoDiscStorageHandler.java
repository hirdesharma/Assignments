package org.example.discstorage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Set;
import java.util.TreeSet;
import org.example.exceptions.InvalidArgument;
import org.example.model.User;

public class UserInfoDiscStorageHandler {
  public void saveUserInfoToDiscStorage(Set<User> user) {
    String filename = "userInfo.ser";
    try {
      FileOutputStream file = new FileOutputStream(filename);
      ObjectOutputStream out = new ObjectOutputStream(file);
      out.writeObject(user);

      out.close();
      file.close();

      System.out.println("User Info Saved to the Disk Storage");
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException ex) {
      throw new InvalidArgument("IO exception is caught");
    }
  }

  public Set<User> getUsersFromDisk() {
    Set<User> users = new TreeSet<>();
    String filename = "userInfo.ser";
    try {
      FileInputStream file = new FileInputStream(filename);
      ObjectInputStream objectInputStream = new ObjectInputStream(file);
      users = (Set<User>) objectInputStream.readObject();
    } catch (FileNotFoundException e) {
      System.out.println("No User details stored in disk yet.");
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    return users;
  }
}

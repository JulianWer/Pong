package persistence;

import ui.Player;

import java.io.*;
import java.util.ArrayList;

public class PersistenceService {

    public void playerSave(Player arr) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Spieler.ser"));
        oos.writeObject(arr);
        oos.close();
    }

    public Player loadData() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Spieler.ser"));
        Player pl = (Player) ois.readObject();
        return pl;
    }
}

package persistence;

import java.io.*;
import java.util.ArrayList;

import gui.Player;

public class PersistenceService {

    public void playerSave(ArrayList<Player> arr ) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Spieler.ser"));
        oos.writeObject(arr);
        oos.close();
    }

    public ArrayList<Player> loadData() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Spieler.ser"));
        @SuppressWarnings("unchecked")
		ArrayList<Player> pl = (ArrayList<Player>) ois.readObject();
        return pl;
    }
}

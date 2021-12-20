package gui;

import javax.swing.*;
import java.io.Serializable;

public class Player implements Serializable {
    private  String name;

    public Player(String plyr) {
        this.name = plyr;
    }

    public String getName() {
        return name;
    }
}

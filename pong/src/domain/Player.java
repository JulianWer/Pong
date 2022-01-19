package domain;

import java.io.Serializable;

public class Player implements Serializable {
    private  String name;

    public Player(String plyr) {
        this.name = plyr;
    }

    public String getName() {
        return name;
    }

    public boolean equals(Player p){
        return p.getName().equals(this.name);
    }
}

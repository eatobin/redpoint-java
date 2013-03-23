package RedPointMaven;

import java.util.ArrayList;

public class Player2 {
    String playerName;
    ArrayList<String> pastGivees;

    public Player2(String playerName, String gifteeYearZero) {
        this.playerName = playerName;
        pastGivees = new ArrayList<String>();
        pastGivees.add(0, gifteeYearZero);
    }

    public String getPlayerName() {
        return playerName;
    }

    public boolean addGiftee(String newGiftee) {
        return pastGivees.add(newGiftee);
    }

    public String returnGiftee(int giftYear) {
        return pastGivees.get(giftYear);
    }
}

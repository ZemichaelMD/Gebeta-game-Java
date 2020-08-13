/**
 * Authored by Zemichael Mehretu May, 2020
 ******************** Gebeta Game ****************************
 */

public class Player {

    //constructor
    int playerNumber = 1, holeToPlay = 1, score = 0;
    String playerName = "Player";
    boolean playing = true;

    public Player (int playerNumber) {
        this.playerNumber = playerNumber;
        this.playerName = "Player" + playerNumber;
        System.out.println(playerName + " is Ready!");

    }
    public void Play() {
        playing = true;
    }

    public void Stop() {
        playing = false;
    }

}

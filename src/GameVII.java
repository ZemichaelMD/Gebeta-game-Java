/**
 * Authored by Zemichael Mehretu May, 2020
 ******************** Gebeta Game ****************************
 */

import java.util.*;

public class GameVII {

    private String gameStatus = "!started";
    private int numberOfHoles = 12;
    private int numberInHand = 4;
    private final Map mapOfHoles = new HashMap();
    private int scoreHole = 4;
    private int playingHole = 0;
    private int score = 0;
    Scanner GetInput = new Scanner(System.in);

    public Integer GetValueOfHole(int key){
       return (Integer) mapOfHoles.get("H" + key);
    }

    public void SetValueOfHole(int key, int value){
      mapOfHoles.put("H" + key, value);
    }

    public Integer GetValueOfNextHoleTo(int key){
        return (Integer) mapOfHoles.get("H" + (key+1));
    }

    public String GetNameOfHole(int key){
        return "H" + key;
    }

    public int AddOneToHole(int key){
       return GetValueOfHole(key)+1;
    }

    public void MakeHoleZero(int key){
        SetValueOfHole(key,0);
    }

    public int ScoreHole(int key){
        //player = playingPlayer;
        SetValueOfHole(key,0);
        return GetValueOfHole(key);
    }

    public void PrintHoles(){
        String gameBoardP1 []= {String.valueOf(GetValueOfHole(1)),"|", String.valueOf(GetValueOfHole(2)),
                                "|", String.valueOf(GetValueOfHole(3)),"|", String.valueOf(GetValueOfHole(4)),"|",
                                String.valueOf(GetValueOfHole(5)),"|", String.valueOf(GetValueOfHole(6))};

        String gameBoardP2 []= {String.valueOf(GetValueOfHole(7)),"|", String.valueOf(GetValueOfHole(8)),
                                 "|", String.valueOf(GetValueOfHole(9)),"|", String.valueOf(GetValueOfHole(10)),"|",
                                String.valueOf(GetValueOfHole(11)),"|", String.valueOf(GetValueOfHole(12))};

        for(int i=0;i<gameBoardP1.length;i++){
        System.out.print(gameBoardP1[i]);
        }
        System.out.print("\n");
        for(int i=0;i<gameBoardP2.length;i++){
            System.out.print(gameBoardP2[i]);
        }
        System.out.print("\n");
    }

    public void makeHoleObject(int holeValue, String holeName){



    }

    public void MakeHoles(int numberOfHoles) {

        //Set Names of Holes using number of holes  by a for loop???? YEAAAAHHHH BABY!
        int holeNumber = 1;
        int holeValue = 4;
        this.numberOfHoles =numberOfHoles;
        for (int i = 1; i <= numberOfHoles; i++) {

            //using hash maps instead of actual hole objects
            SetValueOfHole(holeNumber, holeValue);

            //Make hole objects
            Hole holeNo = new Hole(4, "H" + i);

            //Check id everything is set
            System.out.println("MAP : The Value in H" + holeNumber + " is " + GetValueOfHole(holeNumber));

            holeNumber++;

        }   //end setting holes in the map.

        System.out.println("Done Making Holes!!!");
        System.out.println("The number of playable holes is : " + mapOfHoles.size());
    }

    public void SelectPlayer(int playingPlayer){

    }

    public void CheckAllHoles(){
        for (int i = 1; i <= numberOfHoles; i++){
            System.out.println(GetNameOfHole(i)+ " has "+ GetValueOfHole(i) + " Teters.");}
        }

    public void closeLoop() {
        if (playingHole == 13){
            playingHole = 1;
        }
    }

    private void DropTeterLoop(){
        while (numberInHand != 0) {
            //Loop playing Holes
            closeLoop();

            //Incriment the teters in the hole by 1
            SetValueOfHole(playingHole, AddOneToHole(playingHole));
            System.out.println("The value of H"+ playingHole +" is set to " + GetValueOfHole(playingHole));
            numberInHand --;

            if (numberInHand == 0){
                if (GetValueOfHole(playingHole)==4){
                    ScoreHole(playingHole);
                }
                System.out.println("Out of Teters in hand!");
                PlayHole(playingHole);
            }
            playingHole ++;
        }

    }

    public void PlayHole (int holeNumber) {

        if (GetValueOfHole(playingHole) == 1){
            System.out.println("You landed on empty hole. Playing Next Player. Please Select another hole: ");
            PrintHoles();
            playingHole = GetInput.nextInt();
            PlayHole(playingHole);
        }
        //Get the number in hand to the rock
        numberInHand = GetValueOfHole(playingHole);
        //*****make exception here for error handling

        //zero the teters in hand
        System.out.println("Playing H" + playingHole+". The hole value was " + GetValueOfHole(playingHole) + " But is set to 0");
        MakeHoleZero(playingHole);

        playingHole++;
        DropTeterLoop();

        //Bug!!!! Playing H12. The hole value was 0 But is set to 0


    }

    public void Play(){

        if (gameStatus == "!started"){
            gameStatus = "Started";
            MakeHoles(12);

            Player Player1  = new Player(1);
            Player Player2  = new Player(2);

            //Ask player to play a hole;
            System.out.print("*****Welcome to my awesome game!****** \nPlease select a hole to get started : \n");
            PrintHoles();

            playingHole = GetInput.nextInt();
            PlayHole(playingHole);

        }

    }

}

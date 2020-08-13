import java.util.*;

public class Game {

    /* Make Methods and Variables for all!!!!
    1 - When game is called it creates x amount of holes in two raws? YES!!!
    2 - Declares names accordingly to them? YES!!!!
    3 - Asks user input to select a raw and then a number from the row?
    4 - Asks direction to start the game
    6 - It grabs number in the selected hole into number in hand and make that hole hold Zero.
    5 - Starts adding numbers until **NUMBER IN THE HAND ENDS?
    */

    //Make two players
    Player player1 = new Player(1), player2 = new Player(2);


    Scanner getText = new Scanner(System.in);
    int numberOfHoles = 12;
    int numberInHand= 4;
    int playingHoleNumber = 0;
    int indexOfNextPlayingHole = 0;
    int playingPlayer = 1;


    //Make an object to store the playing hole and manipulate it. Get the next hole and store it as nextHole.
    Hole thisHole = new Hole(0, "Name");
    Hole nextHole = new Hole(0,"Name");

    //Create arraylist of Holes and set names
    ArrayList<Hole> holes = new ArrayList<Hole>(numberOfHoles);

    //create hashMap to store element name as a key and value as a value.
    Map mapOfHoles = new HashMap();
    private int x;
    public Integer GetValueByKey (int key){
        x = (Integer) mapOfHoles.get("H" + key);
        return x;
    }


    //****************Methods***************

    //Make a function to generate holeNames.
    public void MakeHoles() {

        //Set Names of Holes using number of holes  by a for loop???? YEAAAAHHHH BABY!
        int holeNumber = 1;
        int holeValue = 4;
        for (int i = numberOfHoles; i >= 1; i--) {

            //using hash maps instead of actual hole objects
            mapOfHoles.put("H"+ holeNumber, holeValue);

            //Check id everything is set
            System.out.println("MAP : The Value in H" + holeNumber + " is " + mapOfHoles.get("H"+ holeNumber));

            //Print the actual index of the holes in ArrayList
            holeNumber++;

        }   //end setting holes in the array.

        System.out.println("Done Making Holes!!!");
        System.out.println("The number of playable holes is : " + mapOfHoles.size());
        }


        /**
        *Everything set! holes, H1 to H12 in an arraylist is ready to play.
        ************************** Game ****************************
         */

        //make a function to alternate the playing player
        public void NextPlayer (){

        }

        //Make a function to ask current player to select a playing hole //Players alternate as well.
        public void AskToSelectHole(){

            //Alternate player number 1 and 2 play status.
            if (player1.playing){
                player2.Stop();
            }
            else {
                player2.Play();
            }

            System.out.println("Player " + playingPlayer + " playing..." + "Player " + playingPlayer + ", please select Hole to play : ");
            playingHoleNumber = GetValueByKey(playingHoleNumber);
        }

        //Make a function to hold number and increment it for next move.
        public int PlayHole(int playingHoleNumber){
            indexOfNextPlayingHole = playingHoleNumber + 1;
            return this.playingHoleNumber++;
    }

        //Function to start playing
        public void Play() {

            //Ask Player to select Hole
            AskToSelectHole();

            //Check what we have
            System.out.println("You are playing H" + playingHoleNumber + ". Value was " + GetValueByKey (playingHoleNumber) + " but was set to Zero");

            //SetPlaying hole value to zero
            mapOfHoles.put("H" + playingHoleNumber , 0);

            //and store it back and ask the next one to play
            while (numberInHand != 0) {

                //Code to reset the thing!
                if (playingHoleNumber == 11){
                    playingHoleNumber = -1;
                }

                //Increment the number and get the playing hole from the array
                PlayHole(playingHoleNumber);

                //put the incremented value to next hole
                mapOfHoles.put("H" + playingHoleNumber , GetValueByKey(playingHoleNumber)+1);

                numberInHand --;

                //Print Results!
                System.out.println("The Value in H" + playingHoleNumber + " is " + GetValueByKey(playingHoleNumber) +1);
                System.out.println("You have "+ numberInHand + " rocks at hand now.");

                if (numberInHand == 0){

                    if (GetValueByKey(playingHoleNumber + 1) == 1){
                        Play();
                    }

                    numberInHand = GetValueByKey(playingHoleNumber + 1);

                    System.out.println("You are playing H" + (playingHoleNumber + 1) + ". Value was " + GetValueByKey(playingHoleNumber + 1) + " but was set to Zero");

                    mapOfHoles.put("H" + (playingHoleNumber +1), 0);

                    System.out.println("the next hole H"+ (playingHoleNumber + 1) + " value is  " + GetValueByKey(playingHoleNumber +1));

                }
            }
    }

        //Reset Game
        public void ResetGame(){
            MakeHoles();
            AskToSelectHole();
    }

}

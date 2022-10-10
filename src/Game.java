
import java.util.ArrayList;

public class Game {
    public FileIO fileIO = new FileIO();
    private TextUI textUI = new TextUI();
    private ArrayList<Player> players = new ArrayList();
    private Board board;
    private Player currentPlayer;
    public void gameSetup() {
        //**********************
        // Load af spiller data
        // **********************
        ArrayList<String> data =  fileIO.readGameData();
        if(data == null){
            data = textUI.getUserInput("Skriv spillernavn. Tast Q for at quitte",6);
        }
        this.createPlayers(data);
        //**********************
        // Load af felt data og bygge boardet
        // **********************
        String[] fieldData = fileIO.readBoardData();
        board = new Board(fieldData);


        runGame();

    }

    public void saveGame(){
        FileIO.writeGameData(players);
    }
    /* TODO: Increase modularity for readability in this class by...
        1. moving the code that rolls the dice and moves the player to a method called throwAndMove()
        2. moving the code that calls the onLand method to a method called landAndAct()
        3. limit the code in runGame to run a game loop, where..
        3.a the next player is found
        3.b the user is prompted to either continue or quit the game
    *
    * */
    private void runGame(){

        String input = "";

        int count = 0;

        while(!input.equalsIgnoreCase("q")) {

            currentPlayer = players.get(count);
            count++;
            throwAndMove();
            input = textUI.getUserInput("Fortsætte(C) eller Afslutte (Q) ?");
            if(count == players.size()){
                count = 0;
            }
        }

    }
    private void throwAndMove(){

        System.out.println("Det er "+currentPlayer.getName()+"'s tur. \n"+currentPlayer.getName()+ "står på felt "+currentPlayer.getPosition() );

        int result = 1; //Dice.rollDiceSum();
        int newPos = currentPlayer.updatePos(result);
        //System.out.println("Current player NEW position: "+currentPlayer.getPosition());
        Field f = board.getField(newPos);
        landAndAct(f);
    }

    private void landAndAct(Field f){

        String msg = f.onLand(currentPlayer);


        String choice = textUI.getUserInput(msg);
        f.processChoice(choice, currentPlayer);
    }


    private void createPlayers(ArrayList<String> data){
        for (String s : data) {
            String[] values = s.replaceAll(" ","").split(","); //split arrayet så vi får adskildt de to værdier
            int balance;

            if (values.length > 1) {
                balance = Integer.parseInt(values[1]);
            } else {
                balance = Integer.parseInt("30000");
            }
            Player p = new Player(values[0], balance); // brug de to værdier til at lave en ny Player instans

            players.add(p);                            // tilføj Player instansen til array'et af spillere

        }

    }

    public void displayPlayers() {
        for (Player p:players) {
            System.out.println(p);
        }
    }
}

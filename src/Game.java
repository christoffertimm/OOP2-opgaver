
import java.util.ArrayList;

public class Game {
    private FileIO fileIO = new FileIO();
    private TextUI textUI = new TextUI();
    private ArrayList<Player> players = new ArrayList();
    private Board board;

    public void gameSetup() {
        //**********************
        // Load af spiller data
        // **********************
        ArrayList<String> data =  fileIO.readGameData();
        if(data == null){
            data = textUI.getUserInput("Skriv spillernavn. Tast Q for at quitte",6);
        }
        this.createPlayers(data);
        //players.get(0).buy(4000);
        //FileIO.writeGameData(players);

        //**********************
        // Load af felt data og bygge boardet
        // **********************
        String[] fieldData = fileIO.readBoardData();
        board = new Board(fieldData);
        System.out.println(board.getField(1));
        runGame();

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
        Player currentPlayer = players.get(0);
        System.out.println("Current player position: "+currentPlayer.getPosition());
        int result = Dice.rollDiceSum();
        int newPos = currentPlayer.updatePos(result);
        System.out.println("Current player NEW position: "+currentPlayer.getPosition());
        Field f = board.getField(newPos);
        String msg = f.onLand();
        System.out.println(msg);

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

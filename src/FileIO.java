import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class FileIO {


    public ArrayList<String> readGameData() {
        File file = new File("Data/gamedata_.csv");
        ArrayList<String> data = new ArrayList<>();
        try {
            Scanner input = new Scanner(file);
            input.nextLine();//ignorer header

            while (input.hasNextLine()) {
                data.add(input.nextLine());//“Egon: 30000”
            }
        } catch (FileNotFoundException e) {
            data = null;
        }
        return data;
    }


    public static void writeGameData(ArrayList<Player> players) {
        try {
            FileWriter writer = new FileWriter("gamedata.csv");
            for (Player p : players) {
                writer.write(p.getName() + "," + p.getAmount()+"\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}







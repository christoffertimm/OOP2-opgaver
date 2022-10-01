import java.util.ArrayList;
import java.util.Scanner;

public class TextUI {
    static Scanner scan = new Scanner(System.in);

    //recieves a message and displays it to the user
    //prompts the user for a reponse

    String getUserInput(String msg){
        //besked fra systemet
        System.out.println(msg);
        //svar fra bruger
        String input = scan.nextLine();
        return input;
    }


    public int getUserChoice(ArrayList<String> arr){
        String msg =  "Du har følgende valgmuligheder";
        System.out.println(msg);

        for(int i = 0; i<arr.size(); i++){

            System.out.println(i+1+". "+arr.get(i));
        }
        int choice = scan.nextInt();
        return choice;
    }
}


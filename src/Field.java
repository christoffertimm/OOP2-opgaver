/* TODO: Make this class a super class by...
    1. removing attributes that are not common to ALL field types (cost, income, seriesID, owner)
    2. adding onLand, onReject and processResonse methods
*
*
* */
public class Field {
    private int ID;
    private String label;
    protected int cost;
    private int income;



    public  Field(int ID, String label, int cost, int income){
        this.ID = ID;
        this.label = label;
        this.cost = cost;
        this.income = income;
    }

    @Override
    public String toString() {
        return ID + ": " + label;
    }


    public String onLand(Player p){
        String s = p.getName()+ " er landet på " + this;

        return s;
    }

    protected String getLabel(){
        return this.label;
    }

    public void processChoice(String choice, Player p) {
        if(choice.equalsIgnoreCase("J")){
            onAccept(p);

        }else{
            onReject(p);

        }

    }
    protected String onAccept(Player p){
        return "";
    }
    protected String onReject(Player p){
        return "";
    }


}
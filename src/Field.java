public class Field {
    private int ID;
    private String label;
    private int cost;
    private int income;
    private int seriesID;
    private Player owner;

    public  Field(int ID, String label, int cost, int income, int seriesID, Player owner){
        this.ID = ID;
        this.label = label;
        this.cost = cost;
        this.income = income;
        this.seriesID = seriesID;
        this.owner = owner;

    }

    @Override
    public String toString() {
        return ID + "" + label;
    }

    public String onLand(){
       return "du er landet på: " + ID + label;
    }

}
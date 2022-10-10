public class Plot extends Field  {
    private int seriesID;
    private Player owner;
    private String option;


    public Plot(int ID, String label, int cost, int income, int seriesID){
        super(ID, label,cost, income);
        this.seriesID = seriesID;
    }

    @Override
    public String toString() {
        String s = super.toString();
        return s+" tilhører serie: "+this.seriesID;
    }
    @Override
    public String onLand(Player p){
        String s = super.onLand(p);
        if (this.owner == null){
            option = "buy";
            s += "\n Vil du købe "+this.getLabel()+" . Tast J for ja N for nej.";

        }
        return s;
    }
    @Override
    protected String onAccept(Player p){
        String s="";

        if(option.equals("buy")){
            s = "Grunden er din!";

            p.buy(this.cost);

        }
        return "";
    }
    @Override
    protected String onReject(Player p){
        return "";
    }

}

public class Chance extends Field {
    public Chance(int id, String label, int cost, int income) {
        super(id, label, cost, income);
    }
    @Override
    public String onLand(Player p){
        String s = super.onLand(p);
               s+= "\n Træk et kort fra bunken";

        return s;
    }

}

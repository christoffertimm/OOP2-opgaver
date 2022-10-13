public class Tax extends Field{
    public Tax(int ID, String label, int cost, int income) {
        super(ID, label, cost, income);

    }

    @Override
    public String onLand(Player p) {
        String s = super.onLand(p);
        s += "\n Vil du betale fast beløb? Tast J for ja \n (Ellers trækker vi et beløb der svarer til 10 % af dine aktiver)";
        return s;
    }

    @Override
    protected String onAccept(Player p) {
        p.pay(this.cost);
        return p.getName()+" har nu betalt et fast beløb";
    }



    @Override
    protected String onReject(Player p) {

        float calcTax = p.getBalance()*0.1f;
        /*Todo: skriv metoden calculateAssets jvf. Task 1.a, så den kaldes fra linjen herunder, som du indkommenterer når metoden er skrevet*/
        //calcTax += calculateAssets(Player p);

        p.pay((int) calcTax);
        return "Vi har trukket 10 % af dine aktiver";
    }
}

public class ChanceCard {
    private String text;
    private  int income;
    private int expenses;

    public ChanceCard(String text, int income, int expenses) {
        this.text = text;
        this.income = income;
        this.expenses = expenses;
    }

    public String getText() {
        return text;
    }

    public int getIncome() {
        return income;
    }

    public int getExpenses() {
        return expenses;
    }
}

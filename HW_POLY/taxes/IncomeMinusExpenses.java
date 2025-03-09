package taxes;

public class IncomeMinusExpenses extends TaxSystem{
    @Override
    public int calcTaxFor(int debit, int credit) {
        return Math.max(((debit - credit) * 15 / 100), 0);
    }

    @Override
    public String getName() {
        return "Доходы минус расходы";
    }
}

package taxes;

public class Incom extends TaxSystem{
    @Override
    public int calcTaxFor(int debit, int credit) {
        return debit * 6 / 100;
    }

    @Override
    public String getName() {
        return "Доходы";
    }
}

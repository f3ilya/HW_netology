import taxes.TaxSystem;

public class Company {
    private String title;
    private int debit;
    private int credit;
    private TaxSystem taxSystem;

    public Company(String title, TaxSystem taxSystem) {
        this.title = title;
        this.taxSystem = taxSystem;
        debit = 0;
        credit = 0;
    }

    public void shiftMoney(int amount) {
        if (amount > 0) {
            debit += amount;
        } else if (amount < 0) {
            credit += Math.abs(amount);
        }
    }

    public void payTaxes() {
        int tax = taxSystem.calcTaxFor(debit, credit);
        System.out.println("Компания " + title + " уплатила налог в размере: " + tax + " руб.");
        debit = 0;
        credit = 0;
    }

    public int applyDeals(Deal[] deals) {
        for (int i = 0; i < deals.length; i++) {
            this.debit += deals[i].getDebitChange();
            this.credit += deals[i].getCreditChange();
            System.out.println(deals[i].getComment());
        }
        int debit = this.debit;
        int credit = this.credit;
        payTaxes();
        return debit - credit;
    }

    public void setTaxSystem(TaxSystem taxSystem) {
        this.taxSystem = taxSystem;
    }

    public String getTitle() {
        return title;
    }

    public int getDebit() {
        return debit;
    }

    public int getCredit() {
        return credit;
    }

    public TaxSystem getTaxSystem() {
        return taxSystem;
    }
}

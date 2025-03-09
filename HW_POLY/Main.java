import taxes.Incom;
import taxes.IncomeMinusExpenses;
import taxes.TaxSystem;

public class Main {
    public static void main(String[] args) {
        Company cocaCola = new Company("Coca-Cola", new TaxSystem());
        cocaCola.shiftMoney(2000);
        cocaCola.shiftMoney(-100);
        printCompany(cocaCola);
        cocaCola.setTaxSystem(new Incom());
        printCompany(cocaCola);
        cocaCola.payTaxes();
        printCompany(cocaCola);

        System.out.println();
        Company pepsi = new Company("Pepsi", new TaxSystem());
        pepsi.shiftMoney(2000);
        pepsi.setTaxSystem(new IncomeMinusExpenses());
        printCompany(pepsi);
        Deal[] deals = {
                new Expenditure("Завод", 2000),
                new Sale("Банки с напитком", 500),
                new Expenditure("Расходники", 400),
                new Sale("Банки с напитком", 5000)
        };
        printCompany(pepsi);
        System.out.println("Разница между доходами и расходами на момент оплаты налогов составила: " +
                pepsi.applyDeals(deals) + " руб.");
    }

    public static void printCompany(Company company) {
        System.out.println("Компания: " + company.getTitle() + ". Доходы: " + company.getDebit() + " руб. Расходы: " +
                company.getCredit() + " руб. УСН: " + company.getTaxSystem().getName());
    }
}
import java.util.Scanner;

public class Main {
    public static int earnings = 0;
    public static int spendings = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            textMenu();
            String input = scanner.nextLine();
            if (input.equals("end"))
                break;
            checkAnswer(input, scanner);
        }
        System.out.println("\nПрограмма завершена!");
    }

    public static void textMenu() {
        System.out.println("\nВыберите операцию и введите её номер:");
        System.out.println("1. Добавить новый доход");
        System.out.println("2. Добавить новый расход");
        System.out.println("3. Выбрать систему налогообложения");
    }

    public static void checkAnswer(String input, Scanner scanner) {
        int operation = Integer.parseInt(input);
        switch (operation) {
            case 1:
                System.out.println("Введите сумму дохода:");
                earnings += Integer.parseInt(scanner.nextLine());
                break;
            case 2:
                System.out.println("Введите сумму расхода:");
                spendings += Integer.parseInt(scanner.nextLine());
                break;
            case 3:
                compareTax();
                break;
            default:
                System.out.println("Такой операции нет");
        }
    }

    public static void compareTax () {
        int taxEarnings = taxEarnings();
        int taxEarningsMinusSpendings = taxEarningsMinusSpendings();
        if (taxEarnings < taxEarningsMinusSpendings) {
            System.out.println("\nМы советуем вам УСН доходы");
            System.out.println("Ваш налог составит: " + taxEarnings + " рублей");
            System.out.println("Налог на другой системе: " + taxEarningsMinusSpendings + " рублей");
            System.out.println("Экономия: " + (taxEarningsMinusSpendings - taxEarnings) + " рублей");
        } else {
            System.out.println("\nМы советуем вам УСН доходы минус расходы");
            System.out.println("Ваш налог составит: " + taxEarningsMinusSpendings + " рублей");
            System.out.println("Налог на другой системе: " + taxEarnings + " рублей");
            System.out.println("Экономия: " + (taxEarnings - taxEarningsMinusSpendings) + " рублей");
        }
    }

    public static int taxEarnings() {
        return earnings * 6 / 100;
    }

    public static int taxEarningsMinusSpendings() {
        int tax = (earnings - spendings) * 15 / 100;
        if (tax >= 0)
            return tax;
        else
            return 0;
    }
}
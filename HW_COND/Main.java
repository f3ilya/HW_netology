import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int score = 0;
        while (true) {
            System.out.println("Введите год:");
            int year = scanner.nextInt();
            System.out.println("Введите количество дней:");
            int days = scanner.nextInt();
            int amount = countDays(year);
            if (days != amount) {
                System.out.println("Неправильно! В этом году " + amount + " дней!");
                break;
            }
            score++;
        }
        System.out.println("Набрано очков: " + score);
    }

    public static int countDays(int year) {
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
            return 366;
        else
            return 365;
    }
}
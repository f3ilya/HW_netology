import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PasswordChecker passwordChecker = new PasswordChecker();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите мин. длину пароля: ");
        try {
            passwordChecker.setMinLength(Integer.parseInt(scanner.nextLine()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        System.out.print("Введите макс. допустимое количество повторений символа подряд: ");
        try {
            passwordChecker.setMaxRepeats(Integer.parseInt(scanner.nextLine()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        while (true) {
            System.out.print("Введите пароль или end: ");
            String password = scanner.nextLine();
            if (password.equals("end")) {
                break;
            }
            try {
                if (passwordChecker.verify(password)) {
                    System.out.println("Подходит!\n");
                } else {
                    System.out.println("Не подходит!\n");
                }
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
                break;
            }
        }
        System.out.println("Программа завершена");
    }
}
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<>();

        while (true) {
            printMenu();
            if (inputValidation(list, scanner)) {
                break;
            }
        }
    }

    public static boolean inputValidation(List<String> list, Scanner scanner) {
        switch (scanner.nextLine()) {
            case "0":
                System.out.println("Программа завершена!");
                return true;
            case "1":
                addTask(list, scanner);
                break;
            case "2":
                break;
            case "3":
                removeIndex(list, scanner);
                break;
            case "4":
                removeName(list, scanner);
                break;
            case "5":
                removeKeyword(list, scanner);
                break;
            default:
                System.out.println("Некорректный ввод. Введите значение от '0' до '5'.");
                return false;
        }
        printToDoList(list);
        return false;
    }

    public static void addTask(List<String> list, Scanner scanner) {
        System.out.println();
        System.out.print("Введите название задачи: ");
        String str = scanner.nextLine();
        if (str.isEmpty()) {
            System.out.println("Не получилось добавить задачу! :(");
            return;
        }
        list.add(str);
        System.out.println("Добавлено!");
    }

    public static void printToDoList(List<String> list) {
        if (list.isEmpty()) {
            System.out.println();
            System.out.println("Ваш список дел пуст!");
        } else {
            System.out.println();
            System.out.println("Ваш список дел:");
            for (int i = 0; i < list.size(); i++) {
                System.out.println(i + 1 + ". " + list.get(i));
            }
        }
    }

    public static void removeIndex(List<String> list, Scanner scanner) {
        if (!list.isEmpty()) {
            try {
                System.out.println();
                System.out.print("Введите номер для удаления: ");
                list.remove(Integer.parseInt(scanner.nextLine()) - 1);
            } catch (Exception e) {
                System.out.println("Задача с таким номер не найдена! :(");
                return;
            }
            System.out.println("Удалено!");
        }
    }

    public static void removeName(List<String> list, Scanner scanner) {
        if (!list.isEmpty()) {
            System.out.println();
            System.out.print("Введите задачу для удаления: ");
            if (list.remove(scanner.nextLine())) {
                System.out.println("Удалено!");
                return;
            }
            System.out.println("Задача с таким названием не найдена! :(");
        }
    }

    public static void removeKeyword(List<String> list, Scanner scanner) {
        if (!list.isEmpty()) {
            List<Integer> listIndex = new ArrayList<>();
            System.out.println();
            System.out.print("Введите ключевое слово для удаления: ");
            String keyword = scanner.nextLine();
            for (int i = list.size() - 1; i >= 0; i--) {
                if (list.get(i).toLowerCase().contains(keyword.toLowerCase())) {
                    listIndex.add(i);
                }
            }
            if (!listIndex.isEmpty()) {
                for (int i : listIndex) {
                    list.remove(i);
                }
                System.out.println("Удалено!");
                return;
            }
            System.out.println("Задачи с таким ключевым словом в названии не найдены! :(");
        }
    }

    public static void printMenu() {
        System.out.println();
        System.out.print("Выберите операцию:\n" +
                "0. Выход из программы\n" +
                "1. Добавить дело\n" +
                "2. Показать дела\n" +
                "3. Удалить дело по номеру\n" +
                "4. Удалить дело по названию\n" +
                "5. Удалить дела по ключевому слову в названии\n" +
                "Ваш выбор: ");
    }
}
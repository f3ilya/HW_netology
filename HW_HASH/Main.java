import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<Address, Integer> costPerAddress = new HashMap<>();
        Set<String> check = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        int totalCost = 0;
        int checkUnique = 0;

        Address address1 = new Address("Россия", "Казань");
        Address address2 = new Address("Россия", "Москва");
        Address address3 = new Address("Россия", "Новосибирск");
        Address address4 = new Address("Россия", "Сочи");
        Address address5 = new Address("Россия", "Санкт-Петербург");
        Address address6 = new Address("Казахстан", "Астана");
        Address address7 = new Address("Беларусь", "Минск");
        Address address8 = new Address("Сербия", "Белград");
        costPerAddress.put(address1, 200);
        costPerAddress.put(address2, 100);
        costPerAddress.put(address3, 400);
        costPerAddress.put(address4, 300);
        costPerAddress.put(address5, 350);
        costPerAddress.put(address6, 600);
        costPerAddress.put(address7, 500);
        costPerAddress.put(address8, 800);

        while (true) {
            System.out.println("Заполнение нового заказа.");
            System.out.print("Введите страну: ");
            String country = scanner.nextLine();
            if (country.equals("end")) {
                break;
            }
            System.out.print("Введите город: ");
            String city = scanner.nextLine();
            if (city.equals("end")) {
                break;
            }
            System.out.print("Введите вес (кг): ");
            String str = scanner.nextLine();
            if (str.equals("end")) {
                break;
            }
            int weight;
            try {
                weight = Integer.parseInt(str);
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод. Введено слишком большое значение или же не числовое.");
                continue;
            }
            Integer cost = costPerAddress.get(new Address(country, city));
            if (cost != null) {
                if (check.add(country)) {
                    checkUnique++;
                }
                totalCost += cost * weight;
                System.out.println("Стоимость доставки составит: " + cost * weight + " руб.");
                System.out.println("Общая стоимость всех доставок: " + totalCost + " руб.");
                System.out.println("Количество уникальных стран: " + checkUnique);
                System.out.println();
            } else {
                System.out.println("Доставки по этому адресу нет");
                System.out.println();
            }
        }
        System.out.println("Завершение программы!");
    }
}
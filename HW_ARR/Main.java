import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] products = {"Молоко", "Хлеб", "Гречневая крупа"};
        int[] prices = {50, 14, 80};
        int[] check = new int[3];
        int[] count = new int[3];
        int sumProducts = 0;

        System.out.println("Список товаров для покупки:");
        for (int i = 0; i < products.length; i++) {
            System.out.println(i+1 + ". " + products[i] + " " + prices[i] + " руб/шт");
        }

        while (true) {
            int productNumber = 0;
            int productCount = 0;

            System.out.println("Выберите товар и количество или введите `end`");
            String input = scanner.nextLine();
            if (input.equals("end"))
                break;

            String[] parts = input.split(" ");
            productNumber = Integer.parseInt(parts[0]) - 1;
            productCount = Integer.parseInt(parts[1]);
            check[productNumber] += prices[productNumber] * productCount;
            count[productNumber] += productCount;
        }
        for (int i : check) {
            sumProducts += i;
        }

        System.out.println("Ваша корзина:");
        for (int i = 0; i < products.length; i++) {
            if (count[i] != 0)
                System.out.println(products[i] + " " + count[i] + " шт " + prices[i] + " руб/шт " + check[i] + " руб в сумме");
        }
        System.out.println("Итого " + sumProducts + " руб");
    }
}
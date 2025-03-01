import java.util.Random;
import java.util.Scanner;

public class Main {
    public static final int SIZE = 8;

    public static void main(String[] args) {
        int[][] colors = putMatrix();

        printMatrix(colors);
        rotatedMatrix(colors);
    }

    public static void rotatedMatrix(int[][] colors) {
        System.out.println("Выберите угол поворота. Для этого введите '90', '180' или '270'.");
        Scanner scanner = new Scanner(System.in);
        int[][] rotatedColors = new int[SIZE][SIZE];

        while (true) {
            String input = scanner.nextLine();
            if (!input.equals("90") && !input.equals("180") && !input.equals("270")) {
                System.out.println("Введите правильное значение. Для этого введите '90', '180' или '270'.");
                continue;
            }
            int angle = Integer.parseInt(input);
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                if(angle == 90)
                    rotatedColors[i][j] = colors[SIZE - j - 1][i];
                else if (angle == 180)
                    rotatedColors[i][j] = colors[SIZE - i - 1][SIZE - j - 1];
                else
                    rotatedColors[i][j] = colors[j][SIZE - i - 1];
                }
            }
            break;
        }
        printMatrix(rotatedColors);
    }

    public static int[][] putMatrix() {
        int[][] colors = new int[SIZE][SIZE];

        Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                colors[i][j] = random.nextInt(256);
            }
        }
        return colors;
    }

    public static void printMatrix(int[][] colors) {
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.format("%4d", colors[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
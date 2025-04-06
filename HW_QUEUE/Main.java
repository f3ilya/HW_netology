import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        List<String> firstClients = List.of("Anya", "Sveta", "Olya", "Alexandra", "Ruslana", "Olesya", "Vika");
        queue.addAll(firstClients);

        while (!queue.isEmpty()) {
            String client = queue.poll();
            System.out.println(client + " сделал новый маникюр");
            if (Math.random() < 0.5) {
                queue.add("a friend of " + client);
            }
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Author author = new Author("Marina", "Andreeva", 3);

        Book book = new Book("My book", 2004, author, 100);
        System.out.println(book.estimatePrice());
        System.out.println(book.isBig());
        System.out.println(book.matches("eva"));
    }
}
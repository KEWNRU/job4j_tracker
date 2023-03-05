package ru.job4j.pojo;

public class Library {

    public static void main(String[] args) {
        Book a = new Book("C++");
        Book b = new Book("C#");
        Book c = new Book("Java");
        Book d = new Book("Clean code");
        Book[] books = new Book[4];
        books[0] = a;
        books[1] = b;
        books[2] = c;
        books[3] = d;
        for (int i = 0; i < books.length; i++) {
            Book bk = books[i];
            System.out.println(bk.getName());
        }
        System.out.println("Replace C++ to Clean code");
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (int i = 0; i < books.length; i++) {
            Book bk = books[i];
            System.out.println(bk.getName());
        }
        System.out.println("Only Clean Code");
        for (int i = 0; i < books.length; i++) {
            Book bk = books[i];
            if ("Clean Code".equals(bk.getName())) {
                System.out.println(bk.getName());
            }
        }
    }
}



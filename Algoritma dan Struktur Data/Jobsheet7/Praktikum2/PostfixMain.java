package Praktikum2;

import java.util.Scanner;

public class PostfixMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String to, from;
        System.out.print("Masukkan ekspresi matematika (Infix): ");
        from = sc.nextLine();
        from = from.trim();
        from = from + ")";

        int total = from.length();

        Postfix post = new Postfix(total);
        to = post.konversi(from);
        System.out.println("Postfix: " + to);
    }
}

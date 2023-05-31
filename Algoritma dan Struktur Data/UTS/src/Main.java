package src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Application app = new Application();
        app.initData();
        app.run(sc);
    }
}

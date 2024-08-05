package org.scoula.lib.cli.ui;

import java.util.Scanner;

public class Input {
    static Scanner scanner = new Scanner(System.in);

    public static int getInt(String title) {
        System.out.println(title);
        return Integer.parseInt(scanner.nextLine());
    }

    public static String getString(String title) {
        System.out.println(title);
        return scanner.nextLine();
    }
}

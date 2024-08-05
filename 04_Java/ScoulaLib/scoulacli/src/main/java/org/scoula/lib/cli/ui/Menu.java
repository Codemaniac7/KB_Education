package org.scoula.lib.cli.ui;

import java.awt.*;
import java.util.ArrayList;

public class Menu {
    ArrayList<MenuItem> menus;

    public Menu() {
        menus = new ArrayList<>();
    }

    public void add(MenuItem item) {
        menus.add(item);
    }

    public void printMenu() {
        System.out.println("------------------------------");
    }
}

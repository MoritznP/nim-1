package com.moritz;

/**
 * Hello world!
 *
 */
import java.util.Scanner;
import java.util.Random;

public class App {

    static public void main(String args[]) {
        Scanner keyboard = new Scanner(System.in);
        Random myrandom = new Random();
        int startZahl, wunsch, steabchenWegNehmen = 1;
        boolean s;

        System.out.println("Mit wie vielen Streichhölzer wollen sie maximal starten?");

        do {
            wunsch = keyboard.nextInt();
        } while (wunsch < 6);

        do {
            startZahl = myrandom.nextInt(wunsch) + 1;
        } while (startZahl < 10);

        System.out.println("Wir beginnen mit " + startZahl + " Stäbchen");

        int münze = myrandom.nextInt(2) + 1;

        if (münze == 1) {
            System.out.println("Du beginnst ");
            s = true;

        } else {
            System.out.println("Computer beginnt ");
            s = false;
        }

        do {
            if (!s) {
                nimCheat(startZahl);
                startZahl = startZahl - steabchenWegNehmen;
                System.out.println(startZahl + " übrigen Stäbchen.");
                s = false;
                System.out.println("Du bist dran.");
            } else {
                steabchenWegNehmen = leseAnzahl(keyboard);
                startZahl = startZahl - steabchenWegNehmen;
                System.out.println(startZahl + " übrige Stäbchen.");
                s = true;
            }
        } while (startZahl > 1);

        if (s) {
            System.out.println("!!Du Gewinnst!! Herzlichen Glückwunsch!!");
        } else {
            System.out.println("!!Computer gewinnt!!");
        }
    }

    static private void nimCheat(int startZahl) {
        System.out.println("Computer ist dran");
        int steabchenWegNehmen = 0, x;
        x = startZahl % 4;
        if (x == 0) {
            steabchenWegNehmen = 3;
        } else {
            steabchenWegNehmen = x;
        }
        System.out.print(x + "  " + steabchenWegNehmen);
    }

    static private int leseAnzahl(Scanner keyboard) {
        int steabchenWegNehmen;

        do {
            System.out.println(" Wähle 1,2 oder 3 Stäbchen aus das/die du wegnehmen willst! ");
            steabchenWegNehmen = keyboard.nextInt();
        } while (steabchenWegNehmen < 1 || steabchenWegNehmen > 3);

        return steabchenWegNehmen;
    }
}
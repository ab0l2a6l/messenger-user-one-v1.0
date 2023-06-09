package view;

import common.StaticScanner;

import java.util.Scanner;

public class Main {

    public static void main(String []args) {

        Scanner input = StaticScanner.getDate();
        System.out.println("1.sign up");
        System.out.println("2.log in");
        int signupOrLogin = input.nextInt();
        input.nextLine();

        if (signupOrLogin == 1)
        {
            // sabt nam

        }
        else if (signupOrLogin == 2)
        {
            //vorod
        }

        for (; ; ) {
            menu();
            int requestFromUser = input.nextInt();
            input.nextLine();
            switch (requestFromUser) {
                case 1 -> {
                    // save
                }

                case 2 -> {
                    //findByAll
                }

                case 3 -> {
                    return;
                }
                default -> System.out.println("wrong number !!! ");
            }
        }
    }

    private static void menu() {
        System.out.println("1.ersal payam");
        System.out.println("2.daryaft payam");
        System.out.println("3.exit");
    }

}

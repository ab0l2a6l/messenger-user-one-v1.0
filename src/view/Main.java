package view;

import common.StaticScanner;
import controler.UserOneControler;
import model.entity.UserOne;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        UserOneControler userOneControler = new UserOneControler();
        Scanner input = StaticScanner.getDate();

        System.out.println("1.log in ");
        System.out.println("2.sign up");
        int kodom = input.nextInt();
        input.nextLine();

        if (kodom == 1) {
            UserOne userOne = new UserOne();
            System.out.print("user name: ");
            userOne.setUsername(input.nextLine());

            System.out.print("password: ");
            userOne.setPassword(input.nextLine());

            boolean isResume = userOneControler.findByUsername(userOne);

            if (!isResume)
                return;

            for (; ; ) {
                menu();
                int requestFromUser = input.nextInt();
                input.nextLine();
                switch (requestFromUser) {
                    case 1 -> {
                        UserOne user = new UserOne();
                        System.out.println("b ki mikhay pm bedi? ");
                        user.setUsername(input.nextLine());

                        System.out.print("text ra vared konid: ");
                        user.setText(input.nextLine());

                        userOneControler.save(user);
                    }

                    case 2 -> {
                        List<UserOne> userOneList;
                        System.out.print("id ra vared konid ta pm ha namayesh dade shavad: ");
                        userOneList = userOneControler.findByAll(userOne.getUsername());

                        userOneList.forEach(System.out::println);
                    }

                    case 3 -> {
                        return;
                    }
                    default -> System.out.println("wrong number !!! ");
                }
            }
        } else if (kodom == 2) {

        }
    }

    private static void menu() {
        System.out.println("1.ersal payam");
        System.out.println("2.daryaft payam");
        System.out.println("3.exit");
    }

}

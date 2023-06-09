package view;

import common.StaticScanner;
import controler.UserOneControler;
import model.entity.UserOne;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String []args) {
        UserOneControler userOneControler = new UserOneControler();
        Scanner input = StaticScanner.getDate();


        for (; ; ) {
            menu();
            int requestFromUser = input.nextInt();
            input.nextLine();
            switch (requestFromUser) {
                case 1 -> {
                    UserOne userOne = new UserOne();
                    System.out.print ("id ra vared konid: ");
                    userOne.setId(input.nextLong());
                    input.nextLine();

                    System.out.print ("text ra vared konid: ");
                    userOne.setText(input.nextLine());

                    userOneControler.save(userOne);
                }

                case 2 -> {
                    List<UserOne> userOneList;
                    System.out.print ("id ra vared konid ta pm ha namayesh dade shavad: ");
                    userOneList = userOneControler.findByAll(input.nextLong());

                    userOneList.forEach(System.out::println);
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

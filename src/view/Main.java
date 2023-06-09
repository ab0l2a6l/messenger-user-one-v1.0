package view;

import common.StaticScanner;
import controler.UserOneControler;
import model.entity.UserOne;

import java.time.LocalTime;
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

                Thread inputData = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        UserOne user = new UserOne();
                        System.out.println("b ki mikhay pm bedi? ");
                        user.setUsername(input.nextLine());

                        System.out.print("text ra vared konid: ");
                        user.setText(input.nextLine());

                        userOneControler.save(user);
                    }
                });

                Thread outputData = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (true) {
                            LocalTime time = LocalTime.now();
                            System.err.println("time: " + time);

                            List<UserOne> userOneList;
                            userOneList = userOneControler.findByAll(userOne.getUsername());

                            userOneList.forEach(System.err::println);

                            try {
                                Thread.sleep(30000);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                });

                inputData.start(); // shroe kar nakh ha
                outputData.start();

                try {
                    inputData.join(); // aya nakh ha ejra shode and?
                    outputData.join();
                }catch (Exception e) {
                    e.printStackTrace();
                }

//                    case 5 -> {
//                        List<UserOne> userOneList;
//                        System.out.print("id ra vared konid ta pm ha namayesh dade shavad: ");
//                        userOneList = userOneControler.findByAll(userOne.getUsername());
//
//                        userOneList.forEach(System.out::println);
                //                  }

//                    default -> System.out.println("wrong number !!! ");
            }
        }
    }
}

//    private static void menu() {
//        System.out.println("1.ersal payam");
//        System.out.println("2.daryaft payam");
//        System.out.println("3.exit");
//    }



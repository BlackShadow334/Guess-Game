package com.blackshadow334.guess_game;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Guess_game {
    public static void main(String[] args) {
        System.out.println("\tWelcome to Guess Game.\n");
        System.out.print("Enter Your Name: ");

        Scanner scanner = new Scanner(System.in);
        String user = scanner.next();
        scanner.nextLine();
        System.out.println("\tHello " + user);
        scanner.nextLine();

        System.out.println("Do you want to play game (y/n)");

        Random random = new Random();

        while (true){
            char is_ready = scanner.next().toLowerCase().charAt(0);
            scanner.nextLine();

            if (is_ready == 'y'){

                System.out.println("\tYou have to guess a number from 0 - 100.\n\tAnd, you have only 8 chances.");
                scanner.nextLine();

                int random_num = random.nextInt(101);
                int user_ans;
                int remaining_guess = 8;

                while (true){
                            System.out.print("Enter your guess: ");

                            try {
                                user_ans = scanner.nextInt();
                                scanner.nextLine();

                                if (user_ans == random_num) {
                                    System.out.println("\tCongrutulations! YOU GUESSED CORRECT NUMBER.");
                                    break;
                                } else if (user_ans < random_num) {
                                    System.out.println("\tHint: Little bit higher.");
                                } else if (user_ans > random_num) {
                                    System.out.println("\tHint: Little bit lower.");
                                }

                            } catch (InputMismatchException e) {
                                System.out.println("\tPlease enter valid input.");
                                scanner.nextLine();
                            }

                    remaining_guess --;
                    if (remaining_guess <= 0){
                        System.out.println("\tYou have crossed your limit.");
                        scanner.nextLine();
                        System.out.println("\tYOU LOST GAME");
                        System.out.println("\tThe number was " + random_num);
                        scanner.nextLine();
                        break;
                    }else{
                        System.out.println("\tYou have only " + remaining_guess + " guess left." );
                    }
                }

                System.out.println("Do you want to play again (y/n).");
            }
            else if (is_ready == 'n'){
                System.out.println("exiting...");
                break;
            }
            else{
                System.out.println("Please enter valid input (y/n).");
            }
        }


    }
}

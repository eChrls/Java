/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConsoleUtils;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author alvaro
 */
public class GetNumber {

    public static int getIntNumber() {
        Scanner sc = new Scanner(System.in);
        int num = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.println("Introduce a number: ");
            try {
                num = sc.nextInt();
                validInput = false;
            } catch (InputMismatchException ime) {
                System.out.println("Invalid input. Please enter a valid number.");
                sc.nextLine();
            }
        }
        return num;
    }

    public static int getIntPositiveNumber() {
        Scanner sc = new Scanner(System.in);
        int num = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.println("Introduce a positive number: ");
            try {
                num = sc.nextInt();

                if (num > 0) {
                    validInput = false;
                } else {
                    System.out.println("Invalid input. Please enter a valid number.");
                }
            } catch (InputMismatchException ime) {
                System.out.println("Invalid input. Please enter a valid number.");
                sc.nextLine();
            }
        }
        return num;
    }

    public static double getDoubleNumber() {
        Scanner sc = new Scanner(System.in);
        double num = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.println("Introduce a number: ");
            try {
                num = sc.nextInt();
                validInput = false;
            } catch (InputMismatchException ime) {
                System.out.println("Invalid input. Please enter a valid number.");
                sc.nextLine();
            }
        }
        return num;
    }
}

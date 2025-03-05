/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JOptionUtils;

import javax.swing.JOptionPane;

/**
 *
 * @author alvaro
 */
public class GetNumber {

    public static int getIntNumber() {
        boolean validInput = false;
        int result = 0;

        while (!validInput) {
            String input = JOptionPane.showInputDialog(null,
                    "Please enter a number:",
                    "Number Input",
                    JOptionPane.QUESTION_MESSAGE);

            // User clicked Cancel or closed dialog
            if (input == null) {
                int choice = JOptionPane.showConfirmDialog(null,
                        "Do you want to cancel input?",
                        "Cancel Confirmation",
                        JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    result = Integer.MIN_VALUE;
                    validInput = true; // Exit loop with null result
                }
                // If NO, continue the loop (validInput remains false)
            } else {
                input = input.trim();

                if (input.isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                            "Input cannot be empty.",
                            "Invalid Input",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    try {
                        result = Integer.parseInt(input);
                        validInput = true;
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null,
                                "Please enter a valid integer number.",
                                "Invalid Input",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
        return result;
    }

    public static double getDoubleNumber() {
        boolean validInput = false;
        double result = 0.0;

        while (!validInput) {
            String input = JOptionPane.showInputDialog(null,
                    "Please enter a number:",
                    "Number Input",
                    JOptionPane.QUESTION_MESSAGE);

            // User clicked Cancel or closed dialog
            if (input == null) {
                int choice = JOptionPane.showConfirmDialog(null,
                        "Do you want to cancel input?",
                        "Cancel Confirmation",
                        JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    result = Double.NaN;
                    validInput = true; // Exit loop with null result
                }
                // If NO, continue the loop (validInput remains false)
            } else {
                input = input.trim();

                if (input.isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                            "Input cannot be empty.",
                            "Invalid Input",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    try {
                        result = Integer.parseInt(input);
                        validInput = true;
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null,
                                "Please enter a valid integer number.",
                                "Invalid Input",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
        return result;
    }
}

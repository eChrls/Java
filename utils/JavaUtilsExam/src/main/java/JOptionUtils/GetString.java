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
public class GetString {

    public static String getName() {
        String name = null;
        boolean validInput = false;

        while (!validInput) {
            name = JOptionPane.showInputDialog(null,
                    "Please enter your name:",
                    "Name Input",
                    JOptionPane.QUESTION_MESSAGE);
            if (name == null) {
                int choice = JOptionPane.showConfirmDialog(null,
                        "Do you want to cancel input?",
                        "Cancel Confirmation",
                        JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    return null; // Signal cancellation with null
                }
                // If NO, continue the loop
            } else if (name.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null,
                        "Name cannot be empty.",
                        "Invalid Input",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                return name.trim();
            }
        }
        return null;
    }
    
    public static String getNumericString() {
        boolean validInput = false;
        String input = null;

        while (!validInput) {
            input = JOptionPane.showInputDialog(null,
                    "Please enter a number (digits only):",
                    "Number Input",
                    JOptionPane.QUESTION_MESSAGE);

            if (input == null) { // User canceled
                int choice = JOptionPane.showConfirmDialog(null,
                        "Do you want to cancel input?",
                        "Cancel Confirmation",
                        JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    return null; // Signal cancellation
                }
            } else {
                input = input.trim();

                if (input.isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                            "Input cannot be empty.",
                            "Invalid Input",
                            JOptionPane.ERROR_MESSAGE);
                } else if (!input.matches("\\d+")) { // Ensure only numbers are entered
                    JOptionPane.showMessageDialog(null,
                            "Please enter only digits (0-9).",
                            "Invalid Input",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    validInput = true;
                }
            }
        }
        return input;
    }
    
    public static String getNumericStringWithLength(int length) {
        boolean validInput = false;
        String input = null;

        while (!validInput) {
            input = JOptionPane.showInputDialog(null,
                    "Please enter a number (digits only, " + length + " digits):",
                    "Number Input",
                    JOptionPane.QUESTION_MESSAGE);

            if (input == null) { // User canceled
                int choice = JOptionPane.showConfirmDialog(null,
                        "Do you want to cancel input?",
                        "Cancel Confirmation",
                        JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    return null; // Signal cancellation
                }
            } else {
                input = input.trim();

                if (input.isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                            "Input cannot be empty.",
                            "Invalid Input",
                            JOptionPane.ERROR_MESSAGE);
                } else if (!input.matches("\\d+")) { // Ensure only numbers are entered
                    JOptionPane.showMessageDialog(null,
                            "Please enter only digits (0-9).",
                            "Invalid Input",
                            JOptionPane.ERROR_MESSAGE);
                } else if (input.length() != length) { // Check if the length is correct
                    JOptionPane.showMessageDialog(null,
                            "Please enter exactly " + length + " digits.",
                            "Invalid Input",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    validInput = true;
                }
            }
        }
        return input;
    }
}

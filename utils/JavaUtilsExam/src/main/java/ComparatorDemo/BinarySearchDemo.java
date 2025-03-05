/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ComparatorDemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author alvaro
 */
public class BinarySearchDemo {
    
    public static void main(String[] args) {
        
        List<User> users = new ArrayList<>();
        
        users.add(new User(1, "Alice", "Smith", 25));
        users.add(new User(2, "Bob", "Johnson", 30));
        users.add(new User(3, "Charlie", "Williams", 22));
        users.add(new User(4, "David", "Jones", 35));
        users.add(new User(5, "Eva", "Brown", 28));
        users.add(new User(6, "Frank", "Davis", 40));
        users.add(new User(7, "Grace", "Miller", 27));
        users.add(new User(8, "Henry", "Wilson", 31));
        users.add(new User(9, "Ivy", "Moore", 26));
        users.add(new User(10, "Jack", "Taylor", 32));

        // Create a new user without values
        User userToSearch = new User();

        // Add the value we want to search for
        userToSearch.setAge(26);

        // Create the comparator
        Comparator compByAge = Comparator.comparing(User::getAge);

        // IMPORTANT -> Sort the list
        users.sort(compByAge);

        // User java method for binary search, returns the index
        int index = Collections.binarySearch(users, userToSearch, compByAge);
        if (index > 0) {
            System.out.println("User with 26 yo: " + users.get(index));
        } else {
            System.out.println("User not found.");
        }
    }
}

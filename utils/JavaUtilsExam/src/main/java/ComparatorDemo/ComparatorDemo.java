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
public class ComparatorDemo {

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
        users.add(new User(11, "Karen", "Anderson", 29));
        users.add(new User(12, "Leo", "Thomas", 33));
        users.add(new User(13, "Mona", "Jackson", 24));
        users.add(new User(14, "Nick", "White", 38));
        users.add(new User(15, "Olivia", "Harris", 21));
        users.add(new User(16, "Paul", "Martin", 29));
        users.add(new User(17, "Quinn", "Garcia", 36));
        users.add(new User(18, "Rachel", "Rodriguez", 27));
        users.add(new User(19, "Sam", "Lewis", 34));
        users.add(new User(20, "Tina", "Young", 23));

        // Comparator without lambda
        Comparator<User> byNameComparator = new Comparator<User>() {
            @Override
            public int compare(User u1, User u2) {
                return u1.getFirstName().compareTo(u2.getFirstName());
            }
        };

        // Comparator with lambda (annonymous method)
        Comparator<User> firstNameComparator = (User user1, User user2) -> user1.getFirstName().compareTo(user2.getFirstName());

        // Without type definitios
        Comparator<User> firstNameComparator2 = (user1, user2) -> user1.getFirstName().compareTo(user2.getFirstName());

        // Simplification
        Comparator<User> firstNameComparator3 = Comparator.comparing(User::getFirstName);

        // Reverse
        Comparator<User> reverseComparator = firstNameComparator3.reversed();

        // Chaining comparators
        Comparator<User> fullNameComparator = Comparator.comparing(User::getFirstName).thenComparing(User::getLastName);

        // Extra: parallel sort
        // Arrays.parallelSort(usersArray, firstNameComparator);
        
        // TESTING
        System.out.println("LIST: ");
        users.forEach(System.out::println);
        
        System.out.println("ORDERED LIST: ");
        Collections.sort(users, firstNameComparator3);
        users.forEach(System.out::println);
    }

}

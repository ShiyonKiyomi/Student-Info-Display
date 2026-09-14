import java.util.*;

public class Helper {
    public static int getValidChoice(Scanner scanner, String prompt, int min, int max ){
        int choice;
        while(true){
            System.out.print(prompt);

            if (scanner.hasNextInt()){
                choice = scanner.nextInt();
                if (choice >= min && choice <= max){
                    return choice;
                }
            } else {
                scanner.next();
            }
            System.out.println("Invalid choice input. Please try again");
        }

    }

    public static Student findById(List<Student> students, int targetId){
        for(Student student : students) {
            if(student.getId() == targetId){
                return student;
            }
        }
        return null;
    }

    public static Student findByName(List<Student> students, String targetName){
        for(Student student : students) {
            if(student.getName().equalsIgnoreCase(targetName)){
                return student;
            }
        }
        return null;
    }

    public static Student chooseSearchMethod(Scanner scanner, List<Student> students, String prompt){
        int search = getValidChoice(scanner, prompt, 1, 2);

        if (search == 1){
            System.out.print("Enter Student Id: ");
            int id = scanner.nextInt();

            return findById(students, id);
        } else {
            scanner.nextLine();

            System.out.print("Enter Student Name: ");
            String name = scanner.nextLine().trim();

            return findByName(students, name);
        }
    }

    public static String getUniqueName(Scanner scanner, List<Student> students, String prompt){
        while (true) {
            System.out.print(prompt);
            String name = scanner.nextLine().trim();

            if (name.isEmpty()){
                System.out.println("Name cannot be empty");
            } else if (findByName(students, name) != null) {
                System.out.println("Name already exist, please try again");
            } else {
                return name;
            }
        }
    }

    public static int getUniqueId(Scanner scanner, List<Student> students, String prompt){
        System.out.print(prompt);
        int id;

        while (true) {
            if (scanner.hasNextInt()) {
                id = scanner.nextInt();

                if (findById(students, id) != null) {
                    System.out.println("ID already exist. Please try again");
                } else if ( id <= 0 ) {
                    System.out.println("Error. Cannot contain a negative value. Please try again");
                } else {
                    return id;
                }

            } else {
                System.out.println("Invalid input. Please enter a number");
                    scanner.next();
            }
        }
    }

    public static int validateAge(Scanner scanner, String prompt){
        while(true){
            System.out.print(prompt);

            if (scanner.hasNextInt()){
                int age = scanner.nextInt();
                if (age <= 0 ) {
                    System.out.println("Error. Cannot contain a negative value. Please try again");
                } else {
                    return age;
                }
            } else {
                System.out.println("Invalid input. Please enter a number");
                    scanner.next();
            }
        }
    }

    public static float validateGpa(Scanner scanner, String prompt){
        while(true){
            System.out.print(prompt);

            if (scanner.hasNextFloat()){
                float gpa = scanner.nextFloat();
                if (gpa < 0 || gpa > 4) {
                    System.out.println("Error. Invalid value. Please try again");
                } else {
                    return gpa;
                }
            } else {
                System.out.println("Invalid Input. Please enter a number");
                    scanner.next();
            }
        }
    }
}

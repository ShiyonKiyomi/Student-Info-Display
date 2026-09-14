import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();
        //creating object
        Student student1 = new Student("Sean", 101, 19, 3);
        Student student2 = new Student("Alice", 102, 19, 4);

        students.add(student1);
        students.add(student2);

        boolean running = true;

        while(running){
            printMenu();
            int selection = Helper.getValidChoice(myScanner, "\nEnter: ", 0, 2);
            myScanner.nextLine(); // preventing crash :sob: its 11pm :sob:

            if (selection == 0){
                System.out.println("Exiting");
                running = false;
                continue;
            } else if (selection == 1) {
                String name = Helper.getUniqueName(myScanner, students, "Enter Name: ");
                int id = Helper.getUniqueId(myScanner, students, "Enter ID: ");
                int age = Helper.validateAge(myScanner, "Enter age");
                float gpa = Helper.validateGpa(myScanner, "Enter GPA");

                Student student = new Student(name, id, age, gpa);
                students.add(student);

            } else if (selection == 2) {
                int choice = Helper.getValidChoice(myScanner, "Enter id: ", 1, Integer.MAX_VALUE);

                Student foundStudent = Helper.findById(students, choice);

                if (foundStudent != null){
                    foundStudent.displayInfo();
                } else {
                    System.out.println("Student cannot be found");
                }
            }
        }
    }
    public static void printMenu(){
        System.out.print("\n---- TIP GPA CHECKER ----" +
                "\nChoose option: " +
                "\n[1]Create Student" +
                "\n[2]Show student" +
                "\n[0]Exit");
    }
}

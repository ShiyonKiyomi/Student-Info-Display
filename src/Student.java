public class Student {
    //fields
    private String name;
    private int id;
    private int age;
    private float gpa;
    private boolean status;

    //constructor
    public Student(String name, int id, int age, float gpa){
        this.name = name;
        this.id = id;
        this.age = age;
        this.gpa = gpa;
        this.status = gpa >= 2.0;
    }

    //setters and getters
    public String getName(){
        return name;
    } public void setName(String name){
        this.name = name;
    }

    public int getId(){
        return id;
    } public void setId(int id){
        this.id = id;
    }

    public int getAge(){
        return age;
    } public void setAge(int age){
        this.age = age;
    }

    public float getGpa(){
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
        this.status = gpa >= 2.0;
    }

    public boolean isStatus(){
       return status;
    }

    //method
    public void displayInfo(){
        System.out.println("\nName: " + name +
                "\nAge: " + age +
                "\nGPA: " + gpa +
                "\nPass: " + status);
    }

}
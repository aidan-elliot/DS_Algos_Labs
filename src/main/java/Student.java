import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

// Student class with basic information
public class Student {
    String name;
    String lab;
    int ssid;

    // Constructor to initialize a Student
    public Student(String name, String lab, int ssid){
        this.name = name;
        this.lab = lab;
        this.ssid = ssid;
    }

    // Override equals for comparing Students by ID
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Student student = (Student) obj;
        return ssid == student.ssid;
    }

    // Override toString for a formatted string representation of Student
    public String toString(){
        return new String(" Name : " + this.name +  ", " + " Lab  : " + this.lab  +  ", " + " SSID : " + this.ssid );
    }

    // Add a Student to an ArrayList with duplicate check
    public static void addStudent(ArrayList<Student> list, Student student) {
        if (list.contains(student)){
            throw new IllegalArgumentException("Duplicate student error");
        } else {
            list.add(student);
        }
    }

    // Reverse the order of Students in an ArrayList based on SSID
    public static void reverseOrder(ArrayList<Student> list) {
        int size = list.size();
        for (int i = 0; i < size / 2; i++) {
            Collections.swap(list, i, size - i - 1);
        }
    }

    // Add a Student to a LinkedList with duplicate check
    public static void addStudent(LinkedList<Student> list, Student student) {
        if (list.contains(student)){
            throw new IllegalArgumentException("Duplicate student error");
        } else {
            list.add(student);
        }
    }

    // Reverse the order of Students in a LinkedList
    public static void reverseOrder(LinkedList<Student> list) {
        Collections.reverse(list);
    }

    // Main method
    public static void main(String[] args) {
        // ArrayList
        ArrayList<Student> AL1 = new ArrayList<>();

        try {
            // Created Student objects
            Student St1 = new Student("Alex Johnson", "CST3108", 1);
            Student St2 = new Student("Emily Parker", "CST3108", 2);
            Student St3 = new Student("Chris Anderson", "CST3108", 3);
            Student St4 = new Student("Lauren Mitchell", "CST3108", 4);
            Student St5 = new Student("Jordan Taylor", "CST3108", 5);
            Student St6 = new Student("Morgan Davis", "CST3108", 6);

            // Add students to ArrayList
            addStudent(AL1, St1);
            addStudent(AL1, St2);
            addStudent(AL1, St3);
            addStudent(AL1, St4);
            addStudent(AL1, St5);
            addStudent(AL1, St6);

            System.out.println("ArrayList:");
            System.out.println(AL1);

            // Reverse the order of students in ArrayList
            reverseOrder(AL1);

            System.out.println("Reversed ArrayList:");
            System.out.println(AL1);

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        // LinkedList
        LinkedList<Student> LL1 = new LinkedList<>();

        try {
            // Created Student objects
            Student St1 = new Student("Alex Johnson", "CST3108", 1);
            Student St2 = new Student("Emily Parker", "CST3108", 2);
            Student St3 = new Student("Chris Anderson", "CST3108", 3);
            Student St4 = new Student("Lauren Mitchell", "CST3108", 4);
            Student St5 = new Student("Jordan Taylor", "CST3108", 5);
            Student St6 = new Student("Morgan Davis", "CST3108", 6);

            // Add students to LinkedList
            addStudent(LL1, St1);
            addStudent(LL1, St2);
            addStudent(LL1, St3);
            addStudent(LL1, St4);
            addStudent(LL1, St5);
            addStudent(LL1, St6);

            System.out.println("LinkedList:");
            System.out.println(LL1);

            // Reverse the order of students in LinkedList
            reverseOrder(LL1);

            System.out.println("Reversed LinkedList:");
            System.out.println(LL1);

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}


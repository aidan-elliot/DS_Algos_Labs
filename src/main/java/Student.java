import java.util.ArrayList;

public class Student {
    String name;
    String lab;
    int ssid;

    public Student(String name, String lab, int ssid){
        this.name = name;
        this.lab = lab;
        this.ssid = ssid;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Student student = (Student) obj;
        return ssid == student.ssid;
    }

    public String toString(){
        return new String(" Name : " + this.name +  ", " + " Lab  : " + this.lab  +  ", " + " SSID : " + this.ssid );
    }
    public static void addStudent(ArrayList<Student> list, Student student) {
        if (list.contains(student)){
            throw new IllegalArgumentException("Duplicate student error");
        } else {
            list.add(student);
        }
    }

    public static void main(String[] args) {
        Student St1 = new Student("Alex Johnson", "CST3108", 1);
        Student St2 = new Student("Emily Parker", "CST3108", 2);
        Student St3 = new Student("Chris Anderson", "CST3108", 3);
        Student St4 = new Student("Lauren Mitchell", "CST3108", 4);
        Student St5 = new Student("Jordan Taylor", "CST3108", 5);
        Student St6 = new Student("Morgan Davis", "CST3108", 6);

        ArrayList<Student> AL1 = new ArrayList<>();
        try{
            addStudent(AL1, St1);
            addStudent(AL1, St2);
            addStudent(AL1, St3);
            addStudent(AL1, St4);
            addStudent(AL1, St5);
            addStudent(AL1, St6);

            Student St7 = new Student("Morgan Dais", "CST3108", 3);
            addStudent(AL1, St7);
        } catch (IllegalArgumentException e){
            e.printStackTrace();
        }
        System.out.println(AL1);
    }
}
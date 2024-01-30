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
    public String toString(){
        return new String(" Name : " + this.name +  ", " + " Lab  : " + this.lab  +  ", " + " SSID : " + this.ssid );
    }
    ArrayList<String> students = new ArrayList<String>();

    Student St1 = new Student("Alex Johnson", "CST3108", 1);
    Student St2 = new Student("Emily Parker", "CST3108", 2);
    Student St3 = new Student("Chris Anderson", "CST3108", 3);
    Student St4 = new Student("Lauren Mitchell", "CST3108", 4);
    Student St5 = new Student("Jordan Taylor", "CST3108", 5);
    Student St6 = new Student("Morgan Davis", "CST3108", 6);

    public static void main(String[] args) {

    }
}
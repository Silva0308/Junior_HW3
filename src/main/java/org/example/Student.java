package org.example;
import java.io.*;

public class Student implements Serializable {
    private String name;
    private int age;
    private transient double GPA; //  Поле GPA объявлено как transient, что означает, что оно не будет сохраняться при сериализации.

    private Student() {
    }


    public Student(String name, int age, double GPA) {
        this.name = name;
        this.age = age;
        this.GPA = GPA;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", GPA=" + GPA +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    public void serializeToFile(String fileName) throws IOException {
        FileOutputStream fileOutput = new FileOutputStream(fileName);
        ObjectOutputStream output = new ObjectOutputStream(fileOutput);
        output.writeObject(this);
        output.close();
        fileOutput.close();
    }

    public static Student deserializeFromFile(String fileName) throws IOException, ClassNotFoundException {
        FileInputStream fileInput = new FileInputStream(fileName);
        ObjectInputStream input = new ObjectInputStream(fileInput);
        Student s = (Student) input.readObject();
        input.close();
        fileInput.close();
        return s;
    }

    public void printInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("GPA: " + GPA);
    }


}

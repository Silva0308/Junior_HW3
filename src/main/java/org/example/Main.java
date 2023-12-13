package org.example;
import java.io.*;
//Разработайте класс Student с полями String name, int age, transient double GPA (средний балл).
// Обеспечьте поддержку сериализации для этого класса. Создайте объект класса Student и инициализируйте его данными.
// Сериализуйте этот объект в файл. Десериализуйте объект обратно в программу из файла.
// Выведите все поля объекта, включая GPA, и обсудите, почему значение GPA не было сохранено/восстановлено.//
public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException  {
        Student s = new Student("John Smith", 20, 3.5); //Значение GPA не будет сохранено/восстановлено, потому что мы объявили это поле как transient. Это означает, что оно не будет сохраняться при сериализации объекта в файл.
        s.serializeToFile("student.ser");

        Student deserialized = Student.deserializeFromFile("student.ser");
        deserialized.printInfo();

}
}
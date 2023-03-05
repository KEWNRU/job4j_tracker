package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFio("Ivan Popov ");
        student.setGroup("Trainee ");
        student.setCreated("09.01.2023");
        System.out.println(student.getFio() + student.getGroup() + student.getCreated());
    }

}

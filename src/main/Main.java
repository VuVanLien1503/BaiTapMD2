package main;

import manager.ManagerStudent;
import model.ClassRoom;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ManagerStudent managerStudent = new ManagerStudent();
        ClassRoom classRoom = new ClassRoom();


        int choice;
        do {
            System.out.println("MENU:");
            System.out.println("1. Show StudentList");
            System.out.println("2. Add New Student");

            System.out.println("0. Exit");
            System.out.println("Enter Choice ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    managerStudent.displayAllStudent();
                    break;
                case 2:
                    managerStudent.addStudent(scanner);
                    break;
            }
        } while (choice != 0);
    }
}

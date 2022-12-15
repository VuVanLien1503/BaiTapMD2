package manager;

import model.ClassRoom;
import model.Student;

import java.util.Scanner;

public class ManagerStudent {
    ManagerClassRoom managerClassRoom = new ManagerClassRoom();
    private Student[] listStudent;

    public ManagerStudent() {
        listStudent = new Student[3];
        listStudent[0] = new Student(1, "Hoang", 20, "Male", "HaiPhong", 88, managerClassRoom.listClassRoom[0]);
        listStudent[1] = new Student(2, "Lien", 20, "Male", "NamDinh", 88, managerClassRoom.listClassRoom[1]);
        listStudent[2] = new Student(3, "Son", 20, "Male", "HaNoi", 88, managerClassRoom.listClassRoom[2]);
    }

    public void displayAllStudent() {
        System.out.printf("%-10s%-10s%-10s%-10s%-20s%s",
                "NAME", "AGE", "GENDER", "ADDRESS", "POINT", "CLASSROOM\n");
        for (Student s : listStudent) {
            s.display();
        }
    }

    public void addStudent(Scanner scanner) {
        System.out.println("1. Enter average point now");
        System.out.println("2. Enter average point then");
        System.out.println("Enter your choice: ");
        int choice = Integer.parseInt(scanner.nextLine());
        Student student = createStudent(scanner, choice);

        Student[] newListStudent = new Student[listStudent.length + 1];
        System.arraycopy(listStudent, 0, newListStudent, 0, listStudent.length);

        newListStudent[listStudent.length] = student;
        listStudent = newListStudent;
    }

    private Student createStudent(Scanner scanner, int choice) {
        System.out.println("Enter student Name:");
        String name = scanner.nextLine();
        System.out.println("Enter student Age:");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter student Gender:");
        String gender = choiceGender(scanner);
        System.out.println("Enter student address: ");
        String address = scanner.nextLine();

        System.out.println("Enter ClassRoom:");
        ClassRoom classRoom = choiceClass(scanner);
        if (choice == 1) {
            System.out.println("Enter student Point:");
            double point = Double.parseDouble(scanner.nextLine());
            return new Student(name, age, gender, address, point, classRoom);
        } else {
            return new Student(name, age, gender, address, classRoom);
        }
    }

    private String choiceGender(Scanner scanner) {
        System.out.println("1. Male");
        System.out.println("2. Female");
        System.out.println("3. Other");
        System.out.println("Enter your choice: ");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                return "Male";
            case 2:
                return "Female";
            default:
                return "Other";
        }
    }

    private ClassRoom choiceClass(Scanner scanner) {
        System.out.println("1. C09");
        System.out.println("2. C10");
        System.out.println("3. C11");
        System.out.println("4. Enter New ClassRoom");
        System.out.println("Enter  choice: ");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                return managerClassRoom.listClassRoom[0];
            case 2:
                return managerClassRoom.listClassRoom[1];
            case 3:
                return managerClassRoom.listClassRoom[2];
            case 4:
                managerClassRoom.addClassRoom(scanner);
                return managerClassRoom.listClassRoom[managerClassRoom.listClassRoom.length-1];
        }
        return null;
    }
}
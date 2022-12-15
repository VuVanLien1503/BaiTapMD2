package manager;

import model.ClassRoom;

import java.util.Scanner;

public class ManagerClassRoom {
    public ClassRoom[] listClassRoom;

    public ManagerClassRoom() {
        listClassRoom = new ClassRoom[3];
        listClassRoom[0]=new ClassRoom(1,"C09");
        listClassRoom[1]=new ClassRoom(2,"C10");
        listClassRoom[2]=new ClassRoom(3,"C11");
    }
    public void addClassRoom(Scanner scanner){
        ClassRoom classRoom=createClassRoom(scanner);

        ClassRoom[] newListClassRoom=new ClassRoom[listClassRoom.length+1];

        System.arraycopy(listClassRoom,0,newListClassRoom,0,listClassRoom.length);
        newListClassRoom[listClassRoom.length]=classRoom;

        listClassRoom=newListClassRoom;

    }
    private ClassRoom createClassRoom(Scanner scanner){
        int index=0;
        System.out.println("Enter ClassRoom Name:");
        String name=scanner.nextLine();
        for (int i = 0; i < listClassRoom.length; i++) {
            if (listClassRoom[i]!=null){
                index++;
            }
        }
        return new ClassRoom(index+1,name);

    }

}

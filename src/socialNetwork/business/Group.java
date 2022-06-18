package socialNetwork.business;

import java.util.ArrayList;
import java.util.Scanner;

public class Group {
    private String name;
    private ArrayList<Object> group;

    public Group(String name, ArrayList<Object> group){
        this.name=name;
        this.group=group;
    }

    public static Group createGroup(Scanner scan){
        String name = scan.nextLine();
        ArrayList<Object> initgroup = new ArrayList <>();
        Group group = new Group(name, initgroup);
        return group;
    }
}

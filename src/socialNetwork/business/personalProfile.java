package socialNetwork.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class personalProfile extends companyProfile {
    protected String firstname;
    protected List<Experiment> experiences;
    
    public personalProfile(int id, String name, String firstname, Language language, List<Experiment> experiences){
        super(id, name, language);
        this.firstname=firstname;
        this.experiences=experiences;
    }

    public void createPersonalProfile(Scanner scan){
        System.out.print("Name:  "); this.name = scan.nextLine();
        System.out.print("First name:  "); this.firstname = scan.nextLine();
        boolean idIsValid=false;
        while(!idIsValid){
            System.out.print("Id: ");
        if(scan.hasNextInt()){
            this.id = scan.nextInt();
            idIsValid=true;
            }
        else{scan.next();}    
        }
        System.out.print("Language (Eng/Fr) : "); String l = scan.next();
        if(l.equals("Fr")) this.language=companyProfile.Language.French;
        else this.language=companyProfile.Language.English;
        this.experiences = new ArrayList<Experiment>();
    }


    public void displayProfile(personalProfile myProfile){
        System.out.println(myProfile.firstname+" "+super.displayProfile());
    }
}

package socialNetwork.business;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class personalAccount extends personalProfile{
    private List<Post> writtenPost;
    private List<personalAccount> contacts;
    private List<Job> jobs;

    public personalAccount(int id,String name,String firstname,Language language, List<Post> writtenPost,List<Experiment> experiences,List<personalAccount> contacts, List<Job> jobs){
        super(id, name, firstname, language, experiences);
        this.setWrittenPost(writtenPost);
        this.contacts=contacts;
        this.jobs=jobs;
    }

    public List<Post> getWrittenPost() {
        return writtenPost;
    }

    public void setWrittenPost(List<Post> writtenPost) {
        this.writtenPost = writtenPost;
    }

    public static personalAccount createPersonalAccount(Scanner scan){
        String name = scan.nextLine();
        System.out.print("Name:  "); name = scan.nextLine();
        System.out.print("First name:  "); String firstname = scan.nextLine();
        boolean idIsValid=false;
        int id=0;
        while(!idIsValid){
            System.out.print("Id: ");
        if(scan.hasNextInt()){
            id = scan.nextInt();
            idIsValid=true;
            }
        else{scan.next();}    
        }
        System.out.print("Language (Eng/Fr) : "); String l = scan.next();
        Language language;
        if(l.equals("Fr")) language=Language.French;
        else language=Language.English;

        List<Post> writtenPost = new ArrayList<Post>();
        System.out.print("Written posts (y to continue/s to stop):  ");
        String data = scan.nextLine();
        while(!data.equals("s")){
            System.out.print("description:  ");
            data = scan.nextLine();
            String description=data;
            System.out.print("publiDate:  ");
            data = scan.nextLine();
            String publiDate=data;
            Post post= new Post(description, publiDate);
            if(!data.equals("s")) writtenPost.add(post);
            System.out.print("Another post (y/s) ?:  ");
            data = scan.nextLine();
        }
        data="";

        List<Experiment> experiences = new ArrayList<Experiment>();
        System.out.print("Experiences (y to continue/s to stop):  ");
        data = scan.nextLine();
        while(!data.equals("s")){
            data = scan.nextLine();
            Experiment exp= new Experiment(data);
            if(!data.equals("s")) experiences.add(exp);
            
        }
        data="";
        List<personalAccount> contacts = new ArrayList<personalAccount>();
        /*System.out.print("Contacts (s to stop):  ");
        while(!data.equals("s")){
            data = scan.nextLine();
            //personalAccount contact = new personalAccount(id, name, firstname, language, experiences, contacts, jobs);
            contact.name=data;
            if(!data.equals("s")) contacts.add(contact);
            
        }
        data="";*/
        List<Job> jobs = new ArrayList<Job>();
        System.out.print("Job ");
        jobs.add(Job.createJob(scan));
        System.out.println("\nGood Job, your account is created!\n");
        
        personalAccount pa = new personalAccount(id,name,firstname,language, writtenPost, experiences, contacts, jobs);

        return pa;
    }

    public void displayPersonalAccount(){
        System.out.println("Name: "+this.name+" Firstname: "+this.firstname+" Id: "+this.id+" Language: "+this.language);

        if(!this.getWrittenPost().isEmpty()){
            System.out.println("Posts: ");
            for(Post p:this.getWrittenPost()){
                System.out.println(p.getdescription());
                System.out.println(p.getPublicationDate());
            }
        }

        if(!this.experiences.isEmpty()){
            System.out.println("Experiences: ");
            for(Experiment e:this.experiences){
                System.out.println(e.description);
            }
        }

        if(!this.contacts.isEmpty()){
            System.out.println("Contacts: ");
            for(personalAccount c:this.contacts){
                System.out.println(c.name);
            }
        }

        System.out.println("Job: ");
        for(Job j:this.jobs){
            System.out.println(j.getdescription());
        }
    }

}

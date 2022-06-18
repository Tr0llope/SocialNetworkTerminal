package socialNetwork.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class companyAccount extends companyProfile {;
    public List<Post> writtenPost;
    List<String> employees;
    List<Job> publishedJobs;

    public companyAccount(int id, String name, Language language, List<Post> writtenPost, List<Job> publishedJobs, List<String> employees){
        super(id, name, language);
        this.employees=employees;
        this.publishedJobs=publishedJobs;
    }

    public static companyAccount createCompanyAccount(Scanner scan){
        int id=0;
        boolean idIsValid=false;
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

        String name = scan.nextLine();
        System.out.print("Name: ");
        name = scan.nextLine();

        List<Post> writtenPost = new ArrayList<Post>();
        System.out.print("Written posts (y to continue/s to stop):  ");
        String data = "";
        while(!data.equals("s")){
            data = scan.nextLine();
            String description=data;
            data = scan.nextLine();
            String publiDate=data;
            Post post= new Post(description, publiDate);
            if(!data.equals("s")) writtenPost.add(post);
            data = scan.nextLine();
            
        }
        data="";
        List<Job> publishedJobs= new ArrayList<Job>();
        System.out.print("Job ");
        publishedJobs.add(Job.createJob(scan));

        List<String> employees = new ArrayList<String>();
        System.out.print("Written posts (y to continue/s to stop):  ");
        data = scan.nextLine();
        while(!data.equals("s")){
            String e = data;
            if(!data.equals("s")) employees.add(e);
            
        }
        companyAccount ca= new companyAccount(id, name, language, writtenPost, publishedJobs, employees);
        return ca;
    }


    public void displayCompanyAccount(){

        System.out.println("Name: "+this.name+" Id: "+this.id+" Language: "+this.language);

        if(!this.writtenPost.isEmpty()){
            System.out.println("Posts: ");
            for(Post p:this.writtenPost){
                System.out.println(p.getdescription());
                System.out.println(p.getPublicationDate());
            }
        }
        
        if(!this.employees.isEmpty()){
            System.out.println("Contacts: ");
            for(String e:this.employees){
                System.out.println(e);
            }
        }

        if(!this.employees.isEmpty()){
            System.out.println("Published jobs: ");
            for(Job j:this.publishedJobs){
                System.out.println(j.getdescription());
            }
        }
    }

    public List<String> addEmployee(String employee, List<String> employees){
        employees.add(employee);
        return employees;
    }

    public List<String> removeEmployee(String employee, List<String> employees){
        employees.remove(employee);
        return employees;
    }

    public List<Job> addPublishedJob(Job job, List<Job> jobs){
        jobs.add(job);
        return jobs;
    }

    public List<Job> removePublishedJob(Job job, List<Job> jobs){
        jobs.remove(job);
        return jobs;
    }
}

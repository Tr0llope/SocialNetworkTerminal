package socialNetwork.business;

import java.util.Scanner;

public class Job {

    public enum JobType {
        fullTime, partTime, CDI, 
        CDD, workStudy, internship;
    }

    private String description;
    private String location;
    private String creationDate;
    private JobType jobType;

    public Job(String description, String location,String creationDate, JobType jobType){
        this.description=description;
        this. location=location;
        this.creationDate=creationDate;
        this.jobType=jobType;
    }

    public String getdescription() {
        return this.description;
    }

    public static Job createJob(Scanner scan){
        System.out.print("Description:  "); String description = scan.nextLine();
        System.out.print("Location:  "); String location = scan.nextLine();
        System.out.print("Date of creation:  "); String creationDate = scan.nextLine();
        System.out.print("Type of job (fullTime, partTime, CDI, CDD, workStudy, internship;) : ");
        String jType=scan.next();
        JobType jobType;
        switch(jType){
            case "fullTime":
                jobType=JobType.fullTime;
                break;
            case "partTime":
                jobType=JobType.partTime;
                break;
            case "CDD":
                jobType=JobType.CDD;
                break;
            case "CDI":
                jobType=JobType.CDI;
                break;
            case "workStudy":
                jobType=JobType.workStudy;
                break;
            case "internship":
                jobType=JobType.internship;
                break;
            default: 
                jobType=JobType.fullTime;
                break;
        }

        
        Job job = new Job(description, location,creationDate, jobType);
        return job;
    }

    public void displayJob(){
        System.out.println("Description: "+this.description+"\nType: "+this.jobType+"\nLocation: "+this.location+"\nDate of creation: "+this.creationDate);
    }

    public void modifyJob(){
        Scanner scan = new Scanner(System.in);
        System.out.print("New description: ");
        this.description=scan.next();
        System.out.print("New type: ");
        String jType=scan.next();
        switch(jType){
            case "fullTime":
                this.jobType=JobType.fullTime;
                break;
            case "partTime":
                this.jobType=JobType.partTime;
                break;
            case "CDD":
                this.jobType=JobType.CDD;
                break;
            case "CDI":
                this.jobType=JobType.CDI;
                break;
            case "workStudy":
                this.jobType=JobType.workStudy;
                break;
            case "internship":
                this.jobType=JobType.internship;
                break;
            default: break;
        }

        System.out.print("New location: ");
        this.location=scan.next();
        System.out.print("New date of creation (jj/mm/aaaa): ");
        this.creationDate=scan.next();
        scan.close();
    }
}

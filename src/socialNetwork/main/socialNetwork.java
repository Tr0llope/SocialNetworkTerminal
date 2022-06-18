package socialNetwork.main;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import socialNetwork.business.*;

public class socialNetwork {
    public static void main(String [] args){
        
        String quest = new String("What do you want to do? [h for help] ");
        Scanner scan = new Scanner(System.in);
        System.out.println("First of all, you have to create your account !");

        List<Post> writtenPost = new ArrayList<Post>();
        Post p = new Post("description", "publicationDate");
        writtenPost.add(p);
        
        List<personalAccount> personalAccounts = new ArrayList<personalAccount>();
        List<companyAccount> companyAccounts = new ArrayList<companyAccount>();
        ArrayList<Object> initDefaultGroup = new ArrayList <>();
        initDefaultGroup.add(personalAccounts);
        initDefaultGroup.add(companyAccounts);
        Group defaultGroup = new Group("defaultGroup", initDefaultGroup);

        personalAccount newPersonalAccount;

        System.out.print(quest);
        String choice = scan.next();
        while(!choice.equals("q")){
            if(choice.length()>0){
                switch(choice.charAt(0)){
                    case 'h':
                        System.out.println("h: list all the commands ");//ok
                        System.out.println("a: Create a personal account ");//ok
                        System.out.println("j: Display personal accounts");//ok
                        System.out.println("l: Create a company account");//ok
                        System.out.println("t: Display company accounts");//ok
                        System.out.println("g: create a group");//ok
                        System.out.println("p: Display all the posts");//ok
                        System.out.println("c: search a job");
                        System.out.println("q: quit the program"); //ok
                        //System.out.println("f: delete contact");
                    break;
                    case 'a':
                        initDefaultGroup.remove(personalAccounts);
                        newPersonalAccount = personalAccount.createPersonalAccount(scan);
                        personalAccounts.add(newPersonalAccount);
                        initDefaultGroup.add(personalAccounts);
                    break;
                    case 'j':
                        System.out.println("personal accounts");
                        for(personalAccount account:personalAccounts){
                            account.displayPersonalAccount();
                        }
                        break;
                    case 'l':
                        initDefaultGroup.remove(companyAccounts);
                        companyAccount newCompanyAccount = companyAccount.createCompanyAccount(scan);
                        companyAccounts.add(newCompanyAccount);
                        initDefaultGroup.add(companyAccounts);
                    break;
                    case 't':
                        System.out.println("company accounts");
                        for(companyAccount account:companyAccounts){
                            account.displayCompanyAccount();
                        }
                        break;
                    case 'g':
                        Group g = Group.createGroup(scan);
                        break;
                    
                    case 'p':
                        for(companyAccount c:companyAccounts){
                            for(Post post: c.writtenPost){
                                System.out.println(post.getPublicationDate());
                                System.out.println(post.getdescription());
                            }
                        }
                        break;

                    case 'c':
                        for(personalAccount pa: personalAccounts){
                            //for(Post p : pa.getWrittenPost()){

                            //}
                            //for(Post post: o.writtenPosts){

                            //}
                        }
                    break;
                    default:
                    System.out.println("Unknown command. Type h for help");
                    break;
                }
            }
            System.out.print(quest);
            choice = scan.next();
        }
        scan.close();
    }
    
}

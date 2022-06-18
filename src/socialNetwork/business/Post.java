package socialNetwork.business;

public class Post extends Experiment {
    private String publicationDate;

    public Post(String description, String publicationDate){
        super(description);
        this.publicationDate=publicationDate;
    }

    public String getdescription() {
        return this.description;
    }
    
    public void displayPost(){
        System.out.println(this.description);
    }

    public String getPublicationDate(){
        return this.publicationDate;
    }

    public Post[] addPost(Post newPost, Post[] postTab){
        return postTab;
    }

}

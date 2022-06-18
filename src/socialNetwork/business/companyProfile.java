package socialNetwork.business;


public class companyProfile implements ID{
    public enum Language {English, French}
    protected int id;
    protected String name;
    protected Language language;

    public companyProfile(int id,String name,Language language){
        this.id=id;
        this.name=name;
        this.language=language;
    }
    
    @Override
    public String getIdToString(){
        return String.valueOf(this.id);
    }

    @Override
    public String getNameToString(){
        return this.name;
    }

    @Override
    public String getLanguageToString(){
        return String.valueOf(this.language);
    }

    public String displayProfile(){
        String profile = this.name+" "+this.id+" "+this.language;
        System.out.println(profile);
        return profile;
    }

}
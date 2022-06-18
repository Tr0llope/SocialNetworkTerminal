package socialNetwork.business;


public interface ID {
    /**
     * Returns the id number of a company profile.
     * @return a String which contains the id number of a company profile.
     * @author Guillaume PARIS 
     */
    String getIdToString();

    /**
     * Returns the name of a company profile.
     * @return a String which contains the name of a company profile.
     * @author Guillaume PARIS 
     */
    String getNameToString();

    /**
     * Returns the language of a company profile.
     * @return a String which contains the language of a company profile.
     * @author Guillaume PARIS 
     */
    String getLanguageToString();
}
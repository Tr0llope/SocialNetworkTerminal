package socialNetwork.util;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.xml.sax.SAXException;
    
import org.w3c.dom.*;
import java.io.IOException;
import java.io.File;
import java.util.UUID;


    
    /** XMLDemo classe qui demontre comment lire et ecrire un fichier XML
     * La classe lit un XML qui contient plusieurs elements <pre>{@code<client>}</pre> (mais n'en n'ecrit qu'un seul):
     *	@author Guillaume PARIS
    */		
    public class xml {
        private TransformerFactory transformerFactory;
        private Transformer transformer;
        private DocumentBuilderFactory documentFactory;
        private DocumentBuilder documentBuilder;
        
    /**
    * Le nom du fichier XML qu'on lit
    */
        private static String XML_INPUT_FILE = "read.xml";
    /**
    * Le nom du fichier XML dans lequel on écrit
    */
        private static String XML_OUTPUT_FILE = "write.xml";
    
        public xml() {
            try {
                transformerFactory = TransformerFactory.newInstance();
                transformer = transformerFactory.newTransformer();
                documentFactory = DocumentBuilderFactory.newInstance();
                documentBuilder = documentFactory.newDocumentBuilder();
            } catch (TransformerException tfe) {
                tfe.printStackTrace();
            } catch (ParserConfigurationException pce) {
                pce.printStackTrace();
            }
        }
    
    /**
    * La methode qui transforme le document en memoire en fichier XML sur le disque dur
    * @param document le document à transformer
    * @param filePath le chemin (répértoire et nom) du fichier XML à créer 
    */	
        public void createXMLFile(Document document, String filePath)
        {
            try {
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(filePath));
    
            // If you use
            // StreamResult result = new StreamResult(System.out);
            // the output will be pushed to the standard output ...
            // You can use that for debugging 
    
            //transform the DOM Object to an XML File
            transformer.transform(domSource, streamResult);
            
            } catch (TransformerException tfe) {
                tfe.printStackTrace();
            }
            System.out.println("Done creating XML File");
        }
    
    /**
    * La methode qui crée le document en memoire
    * @return le document créé
    */	
        public Document createXMLDocument()
        {
            return documentBuilder.newDocument();
        }		
    
    /**
    * La methode qui lit un fichier XML et le transforme en liste de noeuds en mémoire
    * @param filePath le chemin (répértoire et nom) du fichier XML à lire 
    * @return la liste des noeuds lus
    */	
        public NodeList parseXMLFile (String filePath) {
            NodeList elementNodes = null;
            try {
                Document document= documentBuilder.parse(new File(filePath));
                Element root = document.getDocumentElement();
                
                elementNodes = root.getChildNodes();	
            }
            catch (SAXException e) 
            {
                e.printStackTrace();
            }
            catch (IOException e) 
            {
                e.printStackTrace();
            }
            return elementNodes;
        }
    
    /**
    * Methode pour démontrer la lecture d'un fichier XML qui contient plusieurs éléments
    */
        public void readXML() {
            NodeList nodes = this.parseXMLFile(XML_INPUT_FILE);
            if (nodes == null) return;
            
            for (int i = 0; i<nodes.getLength(); i++) {
                if (nodes.item(i).getNodeType() == Node.ELEMENT_NODE)   {
                    Element currentElement = (Element) nodes.item(i);
                    if (currentElement.getNodeName().equals("client")) 	{
                        try {
                            String firstName = currentElement.getElementsByTagName("firstName").item(0).getTextContent();
                            String lastName = currentElement.getElementsByTagName("lastName").item(0).getTextContent();
                            String address = currentElement.getElementsByTagName("address").item(0).getTextContent();
                            String uuid = null;
                            UUID uniqueID = null;
                            try {
                                uuid = currentElement.getElementsByTagName("UUID").item(0).getTextContent();
                            }
                            catch (Exception ex) {
                                System.out.println("Empty UUID, will create a new one");
                            }
                            if ((uuid == null)  || (uuid.isEmpty()))
                                uniqueID = UUID.randomUUID();
                            else uniqueID = UUID.fromString(uuid);
                            //verify that I read everything correctly:
                            System.out.println(firstName + " " + lastName + " " + address + " " + uniqueID.toString());
                        } catch (Exception ex) {
                            System.out.println("Something is wrong with the XML client element");
                        }
                    }
                }  
            }
        }
    
    /**
    * Methode pour démontrer l'écriture d'un fichier XML avec un seul élément
    */	
        public void writeXML() {
            Document document = this.createXMLDocument();
            if (document == null) return;
    
             // create root element
            Element root = document.createElement("clients");
            document.appendChild(root);
    
                //save one "client" element; create a loop to save more elements!!
                Element client = document.createElement("client");
                // clientUUID element
                UUID uniqueID = UUID.fromString("4f392743-c9ba-4230-9b93-a1c79c0a13c4");
                Element clientUUID = document.createElement("UUID");
                clientUUID.appendChild(document.createTextNode(uniqueID.toString()));
                client.appendChild(clientUUID);
                
                // firstName element
                String firstName = "Brad";
                Element firstNameElement = document.createElement("firstName");
                firstNameElement.appendChild(document.createTextNode(firstName));
                client.appendChild(firstNameElement);
                        
                //lastName element
                String lastName = "Pitt";
                Element lastNameElement = document.createElement("lastName");
                lastNameElement.appendChild(document.createTextNode(lastName));
                client.appendChild(lastNameElement);
                        
                //address element
                String address = "150 Broadway St., New York";
                Element addressElement = document.createElement("address");
                addressElement.appendChild(document.createTextNode(address));
                client.appendChild(addressElement);
                
                root.appendChild(client);
            
            this.createXMLFile(document, XML_OUTPUT_FILE);
        }
        
        /*public static void main (String[] args)
        {
            xml demo = new xml();
            demo.readXML();
            demo.writeXML();
        }*/
    
    }
    
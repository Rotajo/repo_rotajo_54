package lo54.projetlo54.core.service;

import java.util.List;
import lo54.projetlo54.core.entity.Client;
import lo54.projetlo54.core.repository.ClientDao;

/**
 * Display Client table
 * @author Jordan, Syntiche, Romina
 */
public class ClientService {
    
    //Blank constructor
    public ClientService() {
    }

    /**
     * Display the whole Client table
     * @return table
     */
    public String affichageTableEntiere(){
        
        ClientDao cd = new ClientDao();     
        List<Client> l = cd.recupererTout(); //Client list
        String s = ""; //Display in servlet
        
        for(Client cc : l){
            s+="<tr>"
             +"<td>"+cc.getIdClient()+"</td>"
             +"<td>"+cc.getLastname()+"</td>"
             +"<td>"+cc.getFirstname()+"</td>"
             +"<td>"+cc.getAddress()+"</td>"
             +"<td>"+cc.getPhone()+"</td>"
             +"<td>"+cc.getEmail()+"</td>"
             +"<td>"+cc.getCourseSession().getCourse().getCode()+"</td>"
             +"</tr>";
        }
        
        return s;
    } //End of "affichageTableEntiere"
    
} //End of Class

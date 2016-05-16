/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lo54.projetlo54.core.service;

import java.util.List;
import lo54.projetlo54.core.entity.Client;
import lo54.projetlo54.core.repository.ClientDao;

/**
 * Affichage de la table Client
 * @author Jordan
 */
public class ClientService {
    
    List<Client> l;

    public ClientService() {
    }

    /**
     * Affichage entière de la table Client
     * @author Jordan
     */
    public void affichageTableEntiere(){
        
        ClientDao cd = new ClientDao();
        
        l = cd.recupererTout();
           
        for(Client cc : l)
            System.out.println(cc.toString());   
    }
}

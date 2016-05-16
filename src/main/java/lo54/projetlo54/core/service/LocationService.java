/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lo54.projetlo54.core.service;

import java.util.List;
import lo54.projetlo54.core.entity.Location;
import lo54.projetlo54.core.repository.LocationDao;

/**
 * Affichage de la table Location
 * @author Jordan
 */
public class LocationService {
    
    List<Location> l;

    public LocationService() {
    }
    
    /*
     * Affichage entière de la table Location
     * @author Jordan
     */
    public void affichageTableEntiere(){
        
        LocationDao ld = new LocationDao();
        
        l = ld.recupererTout();
        
        for(Location ll : l)
            System.out.println(ll.toString());
    
    }
}

package lo54.projetlo54.core.service;

/**
 * Display of web pages
 * @author Jordan, Syntiche, Romina
 */
public class DisplayService {
    
    //Blank constructor
    public DisplayService() {
    }
    
    /**
     * Display header HTML
     * @return string of header
     */
    public String header() {
        String s = "";
        
        s+="<!DOCTYPE html>"
         +"<html> <head>"
         +"<title>Inscription aux UV - Catalogue</title>"
         +"<link rel='stylesheet' href='../ProjetLO54/CSS/style.css' type='text/css' media='screen' />"
         +"</head> <body>"
         +"<div class='title'>"
         +"<a href='../ProjetLO54/index.html'>"
         +"<img class='image' id='head_logo' src='UTBM_Logo.jpg' alt='UTBM Logo'/></a>"
         +"<h1>Inscription aux UV en ligne</h1>"
         +"<h3>PROJET LO54 </h3>"
         +"</div>";
        
        return s;
    } //End of "header"
    
    /**
     * Display navigation HTML
     * @return string of navigation
     */
    public String navigation() {
        String s = "";
        
        s+="<div class='navigation'>"
         +"<ul class='navigation'>"
         +"<li class='navigation'><a href='../ProjetLO54/home'>Accéder aux tables</a></li>"
         +"<li class='navigation'><a href='../ProjetLO54/form'>Inscription</a></li>"
         +"<li class='navigation'><a href='search.jsp'>Rechercher</a></li>"
         +"<li class='navigation'><a href='../ProjetLO54/print'>Enregistrer la liste des étudiants inscrits</a></li>"
         +"</ul></div>";
        
        return s;
    } //End of "navigation"
    
    /**
     * Display restPage HTML
     * @return string of restPage
     */
    public String restPage() {
        return "</body> </html>";
    } //End of "restPage"
    
} //End of class
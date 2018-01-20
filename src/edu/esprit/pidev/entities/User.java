/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.esprit.pidev.entities;

/**
 *
 * @author Rihab
 */
public class User {
    private int id;
    private String nom;
    private String prenom;
    private String dateNaiss;
    private String sexe;
    private String cvFormateur;
    private String docOrganisme;
    private String image;
    private  int etat;
    private  int nbrReclamation;
    private  CoursApprenant idCoursApprenant;
    private  Cours idCours;
    private  int telephone;
    private double Latitude;
    private double Longitude;
    private String Adresse;
    private int etat_connection ;
    private String salt;
    private String password;
    private String roles;
    private String username;
    private String username_canonical;
    private String  email;
    private String email_canonical;
    private int  enabled;
    
    Cours cours = new Cours ();

    public User(int id, String nom, String prenom, String dateNaiss, String sexe, String cvFormateur, String docOrganisme, String image, int etat, int nbrReclamation, CoursApprenant idCoursApprenant,
            Cours idCours, int telephone, double Latitude, double Longitude, String Adresse,int etat_connection, String password, String username,String username_canonical,
    String email,String email_canonical,int  enabled) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.username = username;
        this.username_canonical=username_canonical;
        this.password = password;
        this.email_canonical = email_canonical;
        this.email = email;
        this.salt=salt;
        this.dateNaiss = dateNaiss;
        this.sexe = sexe;
        this.roles = roles;
        this.cvFormateur = cvFormateur;
        this.docOrganisme = docOrganisme;
        this.image = image;
        this.etat = etat;
        this.nbrReclamation = nbrReclamation;
        this.idCoursApprenant = idCoursApprenant;
        this.idCours = idCours;
        this.telephone = telephone;
        this.Latitude = Latitude;
        this.Longitude = Longitude;
        this.Adresse = Adresse;
        this.etat_connection=etat_connection;
        this.enabled=enabled;
    }

    public User( String login, String nom, String prenom,  String email, String roles) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.roles = roles;
    }

    public User(String nom, String prenom, String username, String password, String email, String roles, String Adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.username = username;
        this.password= password;
        this.email = email;
        this.roles = roles;
        this.Adresse = Adresse;
    }


                 
      public User( String nom, String prenom, String dateNaiss, String sexe, String username,String username_canonical ,String email,String email_canonical,int enabled, String salt, String password, String roles)
      {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.username = username;
        this.username_canonical=username_canonical;
        this.password = password;
        this.email = email;
        this.email_canonical=email_canonical;
        this.dateNaiss = dateNaiss;
        this.sexe = sexe;
        this.roles = roles;
        this.enabled = enabled;
        this.salt=salt;
    }

       public User(String nom, String prenom, String username, String password, String email, String roles) {
        this.nom = nom;
        this.prenom = prenom;
        this.username = username;
        this.password = password;
        this.email = email;
        this.roles = roles;
    }

    

    public User(int id, String nom, String prenom, String username, String password, String email, String dateNaiss, String sexe, String roles, String cvFormateur, String docOrganisme, String image, int etat, int nbrReclamation, CoursApprenant idCoursApprenant, Cours idCours, int telephone) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.username = password;
        this.password= password;
        this.email = email;
        this.dateNaiss = dateNaiss;
        this.sexe = sexe;
        this.roles = roles;
        this.cvFormateur = cvFormateur;
        this.docOrganisme = docOrganisme;
        this.image = image;
        this.etat = etat;
        this.nbrReclamation = nbrReclamation;
        this.idCoursApprenant = idCoursApprenant;
        this.idCours = idCours;
        this.telephone = telephone;
    }
    
    
    public User( String nom, String prenom, String dateNaiss, String sexe, String username,String username_canonical ,String email,String email_canonical,int enabled, String salt, String password, String roles,String cvFormateur)
      {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.username = username;
        this.username_canonical=username_canonical;
        this.password = password;
        this.email = email;
        this.email_canonical=email_canonical;
        this.dateNaiss = dateNaiss;
        this.sexe = sexe;
        this.roles = roles;
        this.enabled=enabled;
        this.salt=salt;
        this.cvFormateur=cvFormateur;
    }
    
              

    public User(int id, String nom, String prenom, String password, String dateNaiss, int telephone) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.password = password;
        this.dateNaiss = dateNaiss;
        this.telephone = telephone;
    }
    public User(int id, String nom, String prenom, String dateNaiss, int telephone) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaiss = dateNaiss;
        this.telephone = telephone;
    }

    public User(int id, String nom, String prenom, String login, String pwd, String mail, String dateNaiss, String sexe, String role, int nbrReclamation, double Latitude, double Longitude) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.username = username;
        this.password = password;
        this.email = email;
        this.dateNaiss = dateNaiss;
        this.sexe = sexe;
        this.roles = roles;
        this.nbrReclamation = nbrReclamation;
        this.Latitude = Latitude;
        this.Longitude = Longitude;
        
    }
     public User(int id, String nom, String prenom, String username, String password, String email, String dateNaiss, String sexe, String roles, int nbrReclamation, String Adresse) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.username = username;
        this.password= password;
        this.email = email;
        this.dateNaiss = dateNaiss;
        this.sexe = sexe;
        this.roles = roles;
        this.nbrReclamation = nbrReclamation;
        this.Adresse= Adresse;
    }
    
      public User(int id, String nom, String prenom, String Username,String password,String dateNaiss ) 
    {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this. username = Username;
         this.password = password;
        this.dateNaiss = dateNaiss;
    }
    
    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername_canonical(String username) {
        this.username = username;
    }
    
     public String getUsername_canonical() {
        return username_canonical;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email_canonical ) {
        this.email_canonical = email_canonical;
    }
    public String getEmail_canonical() {
        return email_canonical;
    }

    public void setEmail_canonical(String email ) {
        this.email = email;
    }

    public String getDateNaiss() {
        return dateNaiss;
    }

    public void setDateNaiss(String dateNaiss) {
        this.dateNaiss = dateNaiss;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }


    public String getCvFormateur() {
        return cvFormateur;
    }

    public void setCvFormateur(String cvFormateur) {
        this.cvFormateur = cvFormateur;
    }

    public String getDocOrganisme() {
        return docOrganisme;
    }

    public void setDocOrganisme(String docOrganisme) {
        this.docOrganisme = docOrganisme;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public int getNbrReclamation() {
        return nbrReclamation;
    }

    public void setNbrReclamation(int nbrReclamation) {
        this.nbrReclamation = nbrReclamation;
    }

    public CoursApprenant getIdCoursApprenant() {
        return idCoursApprenant;
    }

    public void setIdCoursApprenant(CoursApprenant idCoursApprenant) {
        this.idCoursApprenant = idCoursApprenant;
    }

    public Cours getIdCours() {
        return idCours;
    }

    public void setIdCours(Cours idCours) {
        this.idCours = idCours;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public double getLatitude() {
        return Latitude;
    }

    public void setLatitude(double Latitude) {
        this.Latitude = Latitude;
    }

    public double getLongitude() {
        return Longitude;
    }

    public void setLongitude(double Longitude) {
        this.Longitude = Longitude;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }

    public int getEtat_connection() {
        return etat_connection;
    }

    public void setEtat_connection(int etat_connection) {
        this.etat_connection = etat_connection;
    }


    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

   
    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateNaiss=" + dateNaiss + ", sexe=" + sexe + ", cvFormateur=" 
                + cvFormateur + ", docOrganisme=" + docOrganisme + ", image=" + image + ", etat=" + etat + ", nbrReclamation=" + nbrReclamation 
                + ", idCoursApprenant=" + idCoursApprenant + ", idCours=" + idCours + ", telephone=" + telephone + ", Latitude=" + Latitude 
                + ", Longitude=" + Longitude + ", Adresse=" + Adresse + ", etat_connection=" + etat_connection + ", salt=" + salt + ", password=" 
                + password + ", roles=" + roles + ", username=" + username + ", username_canonical=" + username_canonical + ", email=" + email 
                + ", email_canonical=" + email_canonical + ", cours=" + cours + '}';
    }

  
   

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
    
}

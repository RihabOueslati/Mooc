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
public class Cours 
{
    private int idcours;
    private String titre;
    private String description;
    private String URL;
    private String categorie;
    private int MAJ;
    private int nbrChapitre;
    private String image;
    private String difficult;
    private String etat ;
    private int note ;

    //private int idCommentaire;
//    private Test idTest;
//    private CoursApprenant idCoursApprenant;
   private int idFormateur;

    public Cours() {}

    public Cours(String titre, String categorie, int nbrChapitre,String difficult, String image,String URL, String description,int note) {
        this.titre = titre;
        this.description = description;
        this.URL = URL;
        this.categorie = categorie;
        this.nbrChapitre = nbrChapitre;
        this.image = image;
        this.difficult=difficult;
        this.note = note ;
    }

    public Cours(int idCours, String titre, String description, String URL, String categorie, int MAJ, int nbrChapitre, String image, String difficult, int idFormateur) {
        this.idcours = idcours;
        this.titre = titre;
        this.description = description;
        this.URL = URL;
        this.categorie = categorie;
        this.MAJ = MAJ;
        this.nbrChapitre = nbrChapitre;
        this.image = image;
        this.difficult = difficult;
        this.idFormateur = idFormateur;
    }

    
    public int getIdCours() {
        return idcours;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getEtat() {
        return etat;
    }

    public void setIdCours(int idcours) {
        this.idcours = idcours;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public int getMAJ() {
        return MAJ;
    }

   

    public void setMAJ(int MAJ) {
        this.MAJ = MAJ;
    }

    public int getNbrChapitre() {
        return nbrChapitre;
    }

    public void setNbrChapitre(int nbrChapitre) {
        this.nbrChapitre = nbrChapitre;
    }

//    public int getIdCommentaire() {
//        return idCommentaire;
//    }
//
//    public void setIdCommentaire(int idCommentaire) {
//        this.idCommentaire = idCommentaire;
//    }
//
//    public Test getIdTest() {
//        return idTest;
//    }
//
//    public void setIdTest(Test idTest) {
//        this.idTest = idTest;
//    }
//
//    public CoursApprenant getIdCoursApprenant() {
//        return idCoursApprenant;
//    }
//
//    public void setIdCoursApprenant(CoursApprenant idCoursApprenant) {
//        this.idCoursApprenant = idCoursApprenant;
//    }
//

    public int getIdFormateur() {
        return idFormateur;
    }

    public void setIdFormateur(int idFormateur) {
        this.idFormateur = idFormateur;
    }
    
    

    public String getDifficult() {
        return difficult;
    }

    public void setDifficult(String difficult) {
        this.difficult = difficult;
    }

    public int getIdcours() {
        return idcours;
    }

    public void setIdcours(int idcours) {
        this.idcours = idcours;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    
    
    
    
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.idcours;
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
        final Cours other = (Cours) obj;
        if (this.idcours != other.idcours) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cours{" + "idCours=" + idcours + ", titre=" + titre + ", description=" + description + ", URL=" + URL + ", categorie=" + categorie + ", MAJ=" + MAJ + ", nbrChapitre=" + nbrChapitre + ", image=" + image + '}';
    }}

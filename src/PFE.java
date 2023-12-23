import  java.util.*;
public class PFE {
    private String sujet;
    private Encadrant encadrant;

    private Set<Etudiant> groupe;

    public PFE(String sujet, Encadrant encadrant) {
        this.sujet = sujet;
        this.encadrant = encadrant;
        this.groupe = new TreeSet<>();
    }

    public Encadrant getEncadrant() {
        return encadrant;
    }

    public void setEncadrant(Encadrant encadrant) {
        this.encadrant = encadrant;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public Set<Etudiant> getGroupe() {
        return groupe;
    }

    public void setGroupe(Set<Etudiant> groupe) {
        this.groupe = groupe;
    }

    public PFE(String sujet) {
        groupe = new TreeSet<>();
        this.sujet=sujet;
    }

    public void ajouterEtudiant(Etudiant etudiant) throws MaxEtudiantsDepassÈ{

        if(groupe.size()==3){
            throw new MaxEtudiantsDepassÈ("you reached maxed");
        }
        else{
            groupe.add(etudiant);
        }
    }


    public void supprimerEtudiant(Etudiant etudiant) {
        if(!groupe.isEmpty()){
            if(groupe.contains(etudiant)){
                groupe.remove(etudiant);
                System.out.println(etudiant +" is removed succesfully");
            }
        }
    }


    public void remplacerEtudiant(Etudiant etudiant1, Etudiant etudiant2) {
        if(groupe.contains(etudiant2)){
            groupe.add(etudiant2);
            groupe.remove(etudiant1);
            System.out.println("students replaced successfully");
        }
        else{
            System.out.println("student1 is not existed");
        }


    }
    public void remplacerGrouper(Set<Etudiant> groupe) throws MaxEtudiantsDepassÈ{
        if(groupe.size()>3){
            throw new MaxEtudiantsDepassÈ("bro u are giving me a groupe bigger than tree");
        }
        else{
            this.groupe=groupe;
            System.out.println("groupe replaced <3 ");
        }
    }

    public void viderGroupe(){
        groupe.removeAll(groupe);
        if(groupe.isEmpty()){
            System.out.println("groupe is empty yeeeey");
        }
        else{
            System.out.println("groupe is not empty hoooh ");
        }
    }

    public void ajouterGroupe(Set<Etudiant> groupe) throws MaxEtudiantsDepassÈ{
        if(groupe.size()+this.groupe.size()>3){
            throw new MaxEtudiantsDepassÈ("bro u are giving me big grou[");
        }
        else{
           this.groupe.addAll(groupe);
        }
    }






}

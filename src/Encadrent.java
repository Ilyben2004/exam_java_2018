import  java.util.*;


 class Encadrant {
    private String nom;
    private Set<PFE> projets;
    public Encadrant(String nom){
        projets = new HashSet<>();
        this.nom=nom;
    }
    public Encadrant(String nom, Set<PFE> projets) {

        this.nom=nom;
        this.projets=projets;


    }
    public Encadrant(Encadrant encadrant){
        this.projets=encadrant.getProjets();
        this.nom=encadrant.getNom();

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Set<PFE> getProjets() {
        return projets;
    }

    public void setProjets(Set<PFE> projets) {
        this.projets = projets;
    }

    //getters & setters fournis
    public void ajouterProjet(PFE projet){
        projets.add(projet);
    }

    public void supprimerProjet(PFE projet){
        projets.remove(projet);
    }
    public int NombreEtudiantsParEncadrant(){
        int nbrStudents  = 0 ;
        for(PFE p : projets ){
            nbrStudents+=p.getGroupe().size();
        }
        return nbrStudents;
    }
    public int NombrePFEParEncadrant(){
        return  projets.size();
    }
}
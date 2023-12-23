import  java.util.*;


public class Responsable extends Encadrant{
    private List<Encadrant> listEncadrants;

    public Responsable(String nom){
        super(nom);
    }
    public Responsable(String nom, Set<PFE> projets){
        super(nom,projets);
    }
    public Responsable(Encadrant encadrant) {
        super(encadrant);
    }
    public void echangerEtudiants(Etudiant etudiant1, Etudiant etudiant2)throws
            EtudiantSansPFEException{
        int Student_Founded = 0 ;


        for( PFE p1 : getProjets()  ) {
            if (p1.getGroupe().contains(etudiant1)) {
                Student_Founded++;
                for(PFE p2 : getProjets()){
                    if (p1.getGroupe().contains(etudiant2)) {
                        Student_Founded++;
                        p1.remplacerEtudiant(etudiant1,etudiant2);
                        p2.remplacerEtudiant(etudiant2,etudiant1);


                    }
                }

            }

        }
        if(Student_Founded!=2){
            throw  new EtudiantSansPFEException("i didnt find the 2 stdents ");
        }



    }
    public void transfererPFE(PFE pfe, Encadrant nouveauEncadrant) throws
            PFEsansEncadrantException{

        for(PFE P : getProjets()){
            if(P.equals(pfe)){
                P.setEncadrant(nouveauEncadrant)  ;
                System.out.println("we changed the enc of this project hahahahhaha");



            }
        }

    }
    public void transfererGroupe(PFE pfeSource, String NouveauSujet, Encadrant nouveauEncadrant){
        pfeSource.setEncadrant(nouveauEncadrant);
        pfeSource.setSujet(NouveauSujet);

    }


    public List<Encadrant> getListEncadrants() {
        return listEncadrants;
    }

    public void setListEncadrants(List<Encadrant> listEncadrants) {
        this.listEncadrants = listEncadrants;
    }
    public List<Etudiant> getListEtudiantsTriÈe(){

        ArrayList<Etudiant> tree =new ArrayList<>();
        for(Encadrant e : getListEncadrants() ){
            for(PFE p : e.getProjets())
              tree.addAll(p.getGroupe());

        }

        Collections.sort(tree);

        return tree;
    }

    public void echangerGroupe(PFE pfeSource, PFE pfeCible){
        for( PFE p1 : getListProjets() ){
            if(p1.equals(pfeSource)){
                for( PFE p2 : getListProjets() ){
                    if(p2.equals(p1)){
                        try {
                            p1.remplacerGrouper(p2.getGroupe());
                            p2.remplacerGrouper(p1.getGroupe());
                        } catch (MaxEtudiantsDepassÈ e) {
                            throw new RuntimeException(e);
                        }
                    }
                }

            }
        }
    }


    public List<PFE> getListProjets(){
        ArrayList<PFE> tree =new ArrayList<>();
        for(Encadrant e : getListEncadrants() )
            tree.addAll(e.getProjets());

        return tree;

    }

    public void repartirPFE(Set<PFE> projets,List<Etudiant> etudiants) throws MaxEtudiantsDepassÈ ,PFEsansEncadrantException{
        int index ;
        Random random = new Random();
        Etudiant e  = new Etudiant();
        for(PFE p : projets ){
            index = random.nextInt(etudiants.size());
            e = etudiants.get(index);
            p.ajouterEtudiant(e);
            etudiants.remove(e);
            index = random.nextInt(getListEncadrants().size());
            p.setEncadrant(getListEncadrants().get(index));

        }
    }

}
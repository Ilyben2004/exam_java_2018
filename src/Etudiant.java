public class Etudiant implements Comparable<Etudiant>{
    private String cne;
    private String nom;
    ;

    public Etudiant(String cne, String nom) {
        this.cne = cne;
        this.nom = nom;
    }
    public Etudiant(){

    }

    public String getCne() {
        return cne;
    }

    public void setCne(String cne) {
        this.cne = cne;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    //constructeurs, getters & setters sont considÈrÈs fournis
    @Override
    public int compareTo(Etudiant etudiant) {
int illBeReturned = -1;

for(int i = 0 ; i<Math.min(this.getNom().length(),etudiant.getNom().length());i++){

    if(this.getNom().toLowerCase().charAt(i)>etudiant.getNom().toLowerCase().charAt(i)) {
        return  -1;
    }
}
        return 1;
    }
}
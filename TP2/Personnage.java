import java.util.Random;

public abstract class Personnage implements Comparable<Personnage> {

  private String nom;
  private int pv;
  private int x;
  private int y;
  private String equipe;

  Random ran = new Random();

  public Personnage(String nom) {
    this.nom = nom;
    this.pv = 50 + ran.nextInt(100); // Nombre de PV allant de 50 à 150
    equipe = "Seul";
    deplacementAlea();
  }

  public Boolean getEstKO(){
    if (pv == 0){
      return true;
    }
    return false;
  }

  public void setPV(int pv) {
    this.pv = pv;
  }

  public void setEquipe(String str) {
    this.equipe = str;
  }

  public int getPV() {
    return pv;
  }

  public String getNom() {
    return nom;
  }


  public String allInfo() {
    return getClass().getSuperclass().getName() + " " + getClass().getName() ;
  }

  public String toString() {
    return allInfo() + " " + getNom() + " " + pv + " PV " + " X=" + x + " Y=" + y;
  }

  public double distance(Personnage p){
    return (Math.sqrt(Math.pow((this.x - p.x),2) + Math.pow((this.y - p.y),2)));
  }

  public void tropLoin (Personnage p) {
    System.out.println("\nDistance entre " + this.getNom() + " et " + p.getNom() + " trop importante ");
  }

  public void tropPres (Personnage p) {
    System.out.println("\nDistance entre " + this.getNom() + " et " + p.getNom() + " trop faible ");
  }

  public void koVerif (Personnage p) throws ExceptionEstKO{
    if(!(this.getEstKO() || p.getEstKO())){
    }
    if (this.getEstKO()){
      throw new ExceptionEstKO(this.nom);
    }

    if (p.getEstKO() && !p.equals(this)){
      throw new ExceptionEstKO(p.nom);
    }
  }


  public void testMemePerso (Personnage p) throws ExceptionMemePerso{
    if(p.equals(this)) {
      throw new ExceptionMemePerso(p.nom);
    }
  }

  public void testMemeEquipeC (Personnage p) throws ExceptionMemeEquipeC{
    if(p.equipe.equals(this.equipe)) {
      throw new ExceptionMemeEquipeC(this.nom, this.equipe);
    }
  }

  public void testMemeEquipeS (Personnage p) throws ExceptionMemeEquipeS{
    if(!(p.equipe.equals(this.equipe))) {
      throw new ExceptionMemeEquipeS(this.nom, p.equipe);
    }
  }


  public void koAffichage(Personnage p) {
    System.out.println("\n" + p.nom + " est KO");
  }

  public void deplacementAlea() {//Utilisé pour déplacer le personnage, afin de générer une distance aléatoire entre 2 Personnages
    this.x = 1 + ran.nextInt(10);
    this.y = 1 + ran.nextInt(10);
  }

  public void pvNonNegatifVerif (Personnage p) {// Si après une attaque, un Personnage a un nombre de PV négatifs, il est remis à 0

    if (p.getPV() < 0 && !p.equals(this)) {
      koAffichage(p);
      p.setPV(0);
    }

    if (this.getPV() < 0) {
      koAffichage(this);
      this.setPV(0);
    }
  }

  public int compareTo(Personnage p){
    return Integer.compare(this.pv, p.pv);
  }




}

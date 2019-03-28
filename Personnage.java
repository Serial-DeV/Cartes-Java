import java.util.Random;

public abstract class Personnage {

  private String nom;
  private int pv;
  private int x;
  private int y;
  private Boolean estKO;

  Random ran = new Random();

  public Personnage(String nom) {
    this.nom = nom;
    this.pv = 50 + ran.nextInt(100); // Nombre de PV allant de 50 à 150
    estKO = false;
    deplacementAlea();
  }

  public void setPV(int pv) {
    this.pv = pv;
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
    if(!(this.estKO || p.estKO)){
      //return false;
    }
    if (this.estKO){
      throw new ExceptionEstKO(this.nom);
      //koAffichage(this);
      //return true;
    }

    if (p.estKO && !p.equals(this)){
      throw new ExceptionEstKO(p.nom);
      //koAffichage(p);
      //return true;
    }

    //return true;
  }


  public void testMemePerso (Personnage p) throws ExceptionMemePerso{
    if(p.equals(this)) {
      throw new ExceptionMemePerso(p.nom);
    }
  }



  public void koAffichage(Personnage p) {
    System.out.println("\n" + p.nom + " est KO");
  }

  public void deplacementAlea() {
    this.x = 1 + ran.nextInt(29);
    this.y = 1 + ran.nextInt(29);
  }

  public void pvNonNegatifVerif (Personnage p) {

    if (p.getPV() < 0 && !p.equals(this)) {
      koAffichage(p);
      p.setPV(0);
      p.estKO = true;
    }

    if (this.getPV() < 0) {
      koAffichage(this);
      this.setPV(0);
      this.estKO = true;
    }
  }



}

import java.util.Random;

public abstract class Personnage implements Comparable<Personnage> {

  protected String nom;
  private int pv;
  private int x;
  private int y;
  protected String action = "";

  private Random ran = new Random();

  public Personnage(String nom) {
    this.nom = nom;
    this.pv = 50 + ran.nextInt(100); // Nombre de PV allant de 50 à 150
    deplacementAlea();
  }

  public Boolean getEstKO(){//Vérifie si un personnage est KO (PV == 0)
    if (pv == 0){
      return true;
    }
    return false;
  }

  public void setPV(int pv) {
    this.pv = pv;
  }

  public String getAction() {
    return action;
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

  public String toString() {// Comme allInfo mais en plus complet
    return allInfo() + " " + nom + " " + pv + "PV " + " X=" + x + " Y=" + y;
  }
  public String toStringV2(){ // Infos pour l'interface graphique
    if (getClass().getSuperclass().getName().equals("Guerrier"))
      return ("" + nom + "(" + getClass().getSuperclass().getName() + ")\nPV: " + pv + "\npoints d'attaque: " +  ((Guerrier)this).getPC());
    else if (getClass().getSuperclass().getName().equals("Soigneur"))
      return ("" + nom + "(" + getClass().getSuperclass().getName() + ")\nPV: " + pv + "\npoints de soin: " +  ((Soigneur)this).getPS());
    else if (getClass().getSuperclass().getName().equals("Paladin"))
      return ("" + nom + "(" + getClass().getSuperclass().getName() + ")\nPV: " + pv + "\npoints d'attaque: " +  ((Paladin)this).getPC() + "\npoints de soin: " +  ((Paladin)this).getPS());
    else
      return "ERREUR";
  }

  public double distance(Personnage p){ // Calcule la distance entre 2 personnages
    return (Math.sqrt(Math.pow((this.x - p.x),2) + Math.pow((this.y - p.y),2)));
  }

  public void tropLoin (Personnage p) {// Quand 2 personnages sont trop éloignés pour intéragir
    System.out.println("\nDistance entre " + this.nom + " et " + p.nom + " trop importante ");
    action = "Distance entre " + this.nom + " et " + p.nom + " trop importante ";
  }

  public void tropPres (Personnage p) {// Quand 2 personnages sont trop proches pour intéragir
    System.out.println("\nDistance entre " + this.nom + " et " + p.nom + " trop faible ");
    action = "Distance entre " + this.nom + " et " + p.nom + " trop faible ";
  }

  public void koVerif (Personnage p) throws ExceptionEstKO{ // Vérifie si les personnages concernés par une action sont KO ou pas
    if(!(this.getEstKO() || p.getEstKO())){
    }
    if (this.getEstKO()){
      throw new ExceptionEstKO(this.nom);
    }

    if (p.getEstKO() && !p.equals(this)){
      throw new ExceptionEstKO(p.nom);
    }
  }


  public void testMemePerso (Personnage p) throws ExceptionMemePerso{// Empêche une "auto-attaque"
    if(p.equals(this)) {
      throw new ExceptionMemePerso(p.nom);
    }
  }


  public void koAffichage(Personnage p) {// Affiche le nom d'un personnage lorsqu'il est mis KO
    System.out.println("\n" + p.nom + " est KO");
  }

  public String koAffichageStr(Personnage p) {// Utilisé pour générer un message d'info lorsqu'un personnage est mis KO
    return "\n" + p.nom + " est KO";
  }

  public void deplacementAlea() {//Utilisé pour déplacer le personnage, afin de générer une distance aléatoire entre 2 Personnages
    this.x = 1 + ran.nextInt(10);
    this.y = 1 + ran.nextInt(10);
  }

  public void pvNonNegatifVerif (Personnage p) {// Si après une attaque, un Personnage a un nombre de PV négatifs, il est remis à 0

    if (p.pv < 0 && !p.equals(this)) {
      koAffichage(p);
      p.setPV(0);
    }

    if (this.pv < 0) {
      koAffichage(this);
      this.setPV(0);
    }
  }

  public int compareTo(Personnage p){
    return Integer.compare(this.pv, p.pv);
  }




}

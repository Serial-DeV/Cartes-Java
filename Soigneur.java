public abstract class Soigneur extends Personnage implements ISoigne{

  private int ps;

  public Soigneur(String nom) {
    super(nom);
    this.ps = 50;
  }

  public int getPS() {
    return ps;
  }

  public String toString() {
    return super.toString() + " Soin " + ps;
  }

  public void infoSoin(Personnage allie) {
    System.out.println("\n" + this.getNom() + " soigne de " + this.getPS() + " a " + allie.getNom());
  }

}

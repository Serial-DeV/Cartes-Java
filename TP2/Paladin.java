public abstract class Paladin extends Personnage implements ICombat, ISoigne{

  private int pc;
  private int ps;

  public Paladin(String nom) {
    super(nom);
    this.pc = (int)(Math.random()*100);
    this.ps = (int)(Math.random()*50);
  }

  public int getPC() {
    return pc;
  }

  public int getPS() {
    return ps;
  }

  public String toString() {
    return super.toString() + " Attaque " + pc + " Soin " + ps;
  }

  public void infoCombat(Personnage ennemi) {
    System.out.println("\n" + this.getNom() + " inflige " + this.getPC() + " a " + ennemi.getNom());
  }

  public void infoSoin(Personnage allie) {
    System.out.println("\n" + this.getNom() + " soigne de " + this.getPS() + " a " + allie.getNom());
  }
}

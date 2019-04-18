public abstract class Paladin extends Personnage implements ICombat, ISoigne{

  private int pc;
  private int ps;

  public Paladin(String nom) {
    super(nom);
    this.pc = (int)(Math.random()*90)+10;
    this.ps = (int)(Math.random()*40)+10;
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
    action = this.getNom() + " inflige " + this.getPC() + " a " + ennemi.getNom();
  }

  public void infoSoin(Personnage allie) {
    System.out.println("\n" + this.getNom() + " soigne de " + this.getPS() + " " + allie.getNom());
    action = this.getNom() + " soigne de " + this.getPS() + " " + allie.getNom();
  }
}

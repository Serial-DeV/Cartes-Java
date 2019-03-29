public abstract class Guerrier extends Personnage implements ICombat{

  private int pc;

  public Guerrier(String nom) {
    super(nom);
    this.pc = (int)(Math.random()*100);
  }

  public int getPC() {
    return pc;
  }

  public String toString() {
    return super.toString() + " Attaque " + pc;
  }

  public void infoCombat(Personnage ennemi) {
    System.out.println("\n" + this.getNom() + " inflige " + this.getPC() + " a " + ennemi.getNom());
  }


}

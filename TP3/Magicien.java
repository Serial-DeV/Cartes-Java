public class Magicien extends Soigneur{

  public Magicien(String nom) {
    super(nom);
  }

  public void soigner(Personnage allie) {

    try{
      koVerif(this);//Vérifie que lui-même n'est pas KO
      deplacementAlea();//Utilisé pour définir des coordonnées aléatoires, elles-mêmes utilisées pour calculer la distance avec un autre Personnage
      allie.setPV(allie.getPV() + getPS());
      setPV((int)(getPV() - 0.1*getPS()));
      System.out.println("\n" + this.getNom() + " s'inflige " + 0.1*getPS() + " et soigne de " + this.getPS() + " " + allie.getNom());
      action = this.getNom() + " s'inflige " + 0.1*getPS() + " et soigne de " + this.getPS() + " " + allie.getNom();
      pvNonNegatifVerif (this);

    }

    catch(ExceptionEstKO e){//Si le personnage qui soigne est KO
      System.out.println("ExceptionEstKO: " + e.getMessage());
    }



  }

}

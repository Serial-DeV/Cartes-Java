public class Medecin extends Soigneur{

  public Medecin(String nom) {
    super(nom);
  }

  public void soigner(Personnage allie) {

    try{
      koVerif(this);//Vérifie que lui-même n'est pas KO
      deplacementAlea();//Utilisé pour définir des coordonnées aléatoires, elles-mêmes utilisées pour calculer la distance avec un autre Personnage
      if (distance(allie) < 5) {
        allie.setPV(allie.getPV() + getPS());
        infoSoin(allie);
      }

      else {
        tropLoin (allie);
      }

    }

    catch(ExceptionEstKO e){//Si le personnage qui soigne est KO
      System.out.println("ExceptionEstKO: " + e.getMessage());
    }



  }

}

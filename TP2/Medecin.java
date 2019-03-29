public class Medecin extends Soigneur{

  public Medecin(String nom) {
    super(nom);
  }

  public void soigner(Personnage allie) {

    try{
      testMemeEquipeS (allie);//Vérifie que l'allié est bien dans son équipe
      koVerif(this);//Vérifie que lui-même n'est pas KO
      deplacementAlea();
      if (distance(allie) < 5) {
        allie.setPV(allie.getPV() + getPS());
        infoSoin(allie);
      }

      else {
        tropLoin (allie);
      }

    }

    catch(ExceptionEstKO e){
      System.out.println("ExceptionEstKO: " + e.getMessage());
    }
    catch(ExceptionMemeEquipeS e){
      System.out.println("ExceptionMemeEquipeS: " + e.getMessage());
    }



  }

}

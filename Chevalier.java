public class Chevalier extends Paladin{

  public Chevalier(String nom) {
    super(nom);
  }


  public void combattre(Personnage ennemi) {

    try{
      testMemePerso (ennemi);
      koVerif(ennemi);
      deplacementAlea();
      if (distance(ennemi) < 5 ) {
        ennemi.setPV(ennemi.getPV() - getPC());
        infoCombat(ennemi);
      }


      else {
        tropLoin (ennemi);
      }

      pvNonNegatifVerif (ennemi);
    }

    catch(ExceptionEstKO e){
      System.out.println("ExceptionEstKO: " + e.getMessage());
    }
    catch(ExceptionMemePerso e){
      System.out.println("ExceptionMemePerso: " + e.getMessage());
    }


  }

  public void soigner(Personnage allie) {

    try{

      koVerif(this);
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


  }

}

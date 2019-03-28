public class Sorcier extends Paladin{

  public Sorcier(String nom) {
    super(nom);
  }


  public void combattre(Personnage ennemi) {

    try{
      testMemePerso (ennemi);
      koVerif(ennemi);
      deplacementAlea();
      if (Math.random() < 0.5) {
        ennemi.setPV(ennemi.getPV() - getPC());
        infoCombat(ennemi);
        pvNonNegatifVerif (ennemi);
      }

      else {
        System.out.println("\nEchec de l'attaque");
      }
    }

    catch(ExceptionEstKO e){
      System.out.println("ExceptionEstKO: " + e.getMessage());
    }
    catch(ExceptionMemePerso e){
      System.out.println("ExceptionMemePerso: " + e.getMessage());
    }

    /*else
    System.out.println("attaque impossible ");*/


  }

  public void soigner(Personnage allie) {

    try{

      koVerif(this);
      deplacementAlea();
      if (Math.random() < 0.7) {
        allie.setPV(allie.getPV() + getPS());
        infoSoin(allie);
      }

      else {
        System.out.println("\nEchec du soin");
      }
    }

    catch(ExceptionEstKO e){
      System.out.println("ExceptionEstKO: " + e.getMessage());
    }


  }

}

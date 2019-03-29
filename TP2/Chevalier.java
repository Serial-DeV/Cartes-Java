public class Chevalier extends Paladin{

  public Chevalier(String nom) {
    super(nom);
  }


  public void combattre(Personnage ennemi) {

    try{
      testMemePerso (ennemi);//Vérifie que l'ennemi n'est pas lui-même
      testMemeEquipeC (ennemi);//Vérifie que l'ennemi n'est pas dans son équipe
      koVerif(ennemi);//Vérifie que lui-même ou l'ennemi n'est pas KO
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
    catch(ExceptionMemeEquipeC e){
      System.out.println("ExceptionMemeEquipeC: " + e.getMessage());
    }


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

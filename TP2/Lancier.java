public class Lancier extends Guerrier{

  public Lancier(String nom) {
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
        setPV((int)(getPV() - 0.1*getPC()));
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

}

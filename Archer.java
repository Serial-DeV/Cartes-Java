public class Archer extends Guerrier{

  public Archer(String nom) {
    super(nom);
  }


  public void combattre(Personnage ennemi) {

    try{
      testMemePerso (ennemi);
      koVerif(ennemi);
      deplacementAlea();
      if (distance(ennemi) < 15 && distance(ennemi) >= 5 &&  Math.random() < 0.7) {
        ennemi.setPV(ennemi.getPV() - getPC());
        System.out.println("\n" + this.getNom() + " inflige " + this.getPC() + " a " + ennemi.getNom());
      }

      else if (distance(ennemi) < 5 && distance(ennemi) >= 2) {
        ennemi.setPV(ennemi.getPV() - getPC());
        infoCombat(ennemi);
      }

      else if (distance(ennemi) < 2) {
        tropPres (ennemi);
      }

      else if (distance(ennemi) >= 15) {
        tropLoin (ennemi);
      }

      else
        System.out.println("\nEchec de l'attaque");

      pvNonNegatifVerif (ennemi);

    }

    catch(ExceptionEstKO e){
      System.out.println("ExceptionEstKO: " + e.getMessage());
    }
    catch(ExceptionMemePerso e){
      System.out.println("ExceptionMemePerso: " + e.getMessage());
    }


  }

}

public class Sorcier extends Paladin{

  public Sorcier(String nom) {
    super(nom);
  }


  public void combattre(Personnage ennemi) {

    try{
      testMemePerso (ennemi);//Vérifie que l'ennemi n'est pas lui-même
      koVerif(ennemi);//Vérifie que lui-même ou l'ennemi n'est pas KO
      deplacementAlea();
      if (Math.random() < 0.5) {
        ennemi.setPV(ennemi.getPV() - getPC());
        infoCombat(ennemi);
        pvNonNegatifVerif (ennemi);
      }

      else {
        System.out.println("\nL'attaque de " + this.nom + " contre " + ennemi.nom + " a échoué ");
        action = "L'attaque de " + this.nom + " contre " + ennemi.nom + " a échoué ";
      }
    }

    catch(ExceptionEstKO e){//Si l'un des deux personnages concernés est KO
      System.out.println("ExceptionEstKO: " + e.getMessage());
    }
    catch(ExceptionMemePerso e){//Ne peut pas combattre lui-même
      System.out.println("ExceptionMemePerso: " + e.getMessage());
    }

  }

  public void soigner(Personnage allie) {

    try{
      koVerif(this);//Vérifie que lui-même n'est pas KO
      deplacementAlea();//Utilisé pour définir des coordonnées aléatoires, elles-mêmes utilisées pour calculer la distance avec un autre Personnage
      if (Math.random() < 0.7) {
        allie.setPV(allie.getPV() + getPS());
        infoSoin(allie);
      }

      else {
        System.out.println("\nLe soin de " + this.nom + " sur " + allie.nom + " a échoué ");
        action = "Le soin de " + this.nom + " sur " + allie.nom + " a échoué ";
      }
    }

    catch(ExceptionEstKO e){//Si le personnage qui soigne est KO
      System.out.println("ExceptionEstKO: " + e.getMessage());
    }


  }

}

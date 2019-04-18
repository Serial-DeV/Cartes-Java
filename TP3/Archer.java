public class Archer extends Guerrier{

  public Archer(String nom) {
    super(nom);
  }


  public void combattre(Personnage ennemi) {

    try{
      testMemePerso (ennemi);//Vérifie que l'ennemi n'est pas lui-même
      koVerif(ennemi);//Vérifie que lui-même ou l'ennemi n'est pas KO
      deplacementAlea();//Utilisé pour définir des coordonnées aléatoires, elles-mêmes utilisées pour calculer la distance avec un autre Personnage
      if (distance(ennemi) < 15 && distance(ennemi) >= 5 &&  Math.random() < 0.7) {
        ennemi.setPV(ennemi.getPV() - getPC());
        infoCombat(ennemi);
      }

      else if (distance(ennemi) < 5 && distance(ennemi) >= 2) {
        ennemi.setPV(ennemi.getPV() - getPC());
        infoCombat(ennemi);
      }

      else if (distance(ennemi) < 2) {//Ne peut pas combattre de trop près
        tropPres (ennemi);
      }

      else if (distance(ennemi) >= 15) {//Ne peut pas combattre de trop loin
        tropLoin (ennemi);
      }

      else {
        System.out.println("\nL'attaque de " + this.nom + " contre " + ennemi.nom + " a échoué ");
        action = "L'attaque de " + this.nom + " contre " + ennemi.nom + " a échoué ";
      }

      pvNonNegatifVerif (ennemi);

    }

    catch(ExceptionEstKO e){//Si l'un des deux personnages concernés est KO
      System.out.println("ExceptionEstKO: " + e.getMessage());
    }
    catch(ExceptionMemePerso e){//Ne peut pas combattre lui-même
      System.out.println("ExceptionMemePerso: " + e.getMessage());
    }


  }

}

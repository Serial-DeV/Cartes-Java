public class Lancier extends Guerrier{

  public Lancier(String nom) {
    super(nom);
  }


  public void combattre(Personnage ennemi) {

    try{
      testMemePerso (ennemi);//Vérifie que l'ennemi n'est pas lui-même
      koVerif(ennemi);//Vérifie que lui-même ou l'ennemi n'est pas KO
      deplacementAlea();//Utilisé pour définir des coordonnées aléatoires, elles-mêmes utilisées pour calculer la distance avec un autre Personnage
      if (distance(ennemi) < 5 ) {//Ne peut pas combattre de trop loin
        ennemi.setPV(ennemi.getPV() - getPC());
        setPV((int)(getPV() - 0.1*getPC()));
        System.out.println("\n" + this.getNom() + " s'inflige " + 0.1*getPC() + " et inflige " + this.getPC() + " à " + ennemi.getNom());
        action = this.getNom() + " s'inflige " + 0.1*getPC() + " et inflige " + this.getPC() + " à " + ennemi.getNom();
      }

      else {
        tropLoin (ennemi);
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

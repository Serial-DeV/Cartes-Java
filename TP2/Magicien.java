public class Magicien extends Soigneur{

  public Magicien(String nom) {
    super(nom);
  }

  public void soigner(Personnage allie) {

    try{

      testMemeEquipeS (allie);//Vérifie que l'allié est bien dans son équipe
      koVerif(this);//Vérifie que lui-même n'est pas KO
      deplacementAlea();
      allie.setPV(allie.getPV() + getPS());
      setPV((int)(getPV() - 0.1*getPS()));
      infoSoin(allie);
      pvNonNegatifVerif (this);

    }

    catch(ExceptionEstKO e){
      System.out.println("ExceptionEstKO: " + e.getMessage());
    }
    catch(ExceptionMemeEquipeS e){
      System.out.println("ExceptionMemeEquipeS: " + e.getMessage());
    }



  }

}

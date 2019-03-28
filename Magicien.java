public class Magicien extends Soigneur{

  public Magicien(String nom) {
    super(nom);
  }

  public void soigner(Personnage allie) {

    try{

      koVerif(this);
      deplacementAlea();
      allie.setPV(allie.getPV() + getPS());
      setPV((int)(getPV() - 0.1*getPS()));
      infoSoin(allie);
      pvNonNegatifVerif (this);

    }

    catch(ExceptionEstKO e){
      System.out.println("ExceptionEstKO: " + e.getMessage());
    }



  }

}

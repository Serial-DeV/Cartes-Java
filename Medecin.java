public class Medecin extends Soigneur{

  public Medecin(String nom) {
    super(nom);
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

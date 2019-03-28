import java.util.ArrayList;
public class Collection {

  private ArrayList<Personnage> cartes;
  private String nom;
  private static int cptVol = 0;

  public Collection(String nom) {
    cartes = new ArrayList<Personnage>();
    this.nom = nom;
  }

  public void ajout(Personnage p) {
    cartes.add(p);
  }

  public void ajoutVolee() {

    if (Math.random() < 0.17){
      ajout(new Archer("Archer_"+(++cptVol)));
    }

    else if (Math.random() < 0.33){
      ajout(new Lancier("Lancier_"+(++cptVol)));
    }

    else if (Math.random() < 0.5){
      ajout(new Medecin("Medecin_"+(++cptVol)));
    }

    else if (Math.random() < 0.67){
      ajout(new Magicien("Magicien_"+(++cptVol)));
    }

    else if (Math.random() < 0.83){
      ajout(new Chevalier("Chevalier_"+(++cptVol)));
    }

    else {
      ajout(new Sorcier("Sorcier_"+(++cptVol)));
    }

  }

  public Personnage getPersonnage(int n) {
    return cartes.get(n);
  }


  public String toString() {
    String s = nom + ":\n";
    for(int i = 0; i < cartes.size(); i++) {
      s += "-> Carte " + (i+1) + ": " + cartes.get(i).toString() + "\n";
    }

    return s;
  }

  public String[] listePerso(int n) {
    String[] s = new String[n];
    for(int i = 0; i < n; i++) {
      s[i] = cartes.get(i).getNom();
    }

    return s;
  }

  public int getCartesSize() {
    return cartes.size();
  }

}

import java.util.ArrayList;
public class Equipe extends ArrayList<Personnage>{

  //private ArrayList<Personnage> cartes;
  private String nom;
  private static int cptVol = 0;// utilisé dans le nom d'un personnage créé à la volée
  private static final long serialVersionUID = 1L;// Permet d'eviter un warning

  public Equipe(String nom) {
    this.nom = nom;
  }

  public Boolean verifAPerdu(){
    for (Personnage p : this){
      if (!(p.getEstKO())){
        return false;
      }
    }
    return true;
  }

  public void ajout(Personnage p) {
    add(p);
    p.setEquipe(nom);
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
    return get(n);
  }


  public String toString() {
    String s = nom + ":\n";
    for(int i = 0; i < size(); i++) {
      s += "-> Carte " + (i+1) + ": " + get(i).toString() + "\n";
    }

    return s;
  }

  public String[] listePerso(int n) {
    String[] s = new String[n];
    for(int i = 0; i < n; i++) {
      s[i] = get(i).getNom();
    }

    return s;
  }

  public int getEquipeSize() {// Retourne la taille de l'équipe, utilisé pour choisir un personnage aléatoirement
    return size();
  }


  public String getNom(){
    return nom;
  }


}

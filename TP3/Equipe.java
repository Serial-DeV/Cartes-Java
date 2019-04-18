import java.util.ArrayList;
public class Equipe extends ArrayList<Personnage>{

  private String nom;
  private static int cptVol = 0;// utilisé dans le nom d'un personnage créé à la volée
  private static final long serialVersionUID = 1L;// Permet d'eviter un warning
  private static final String[] listeNoms= {"Superman","Oracle","Plastic Man","Vibe","Wildcat","Kid Flash","Blue Devil","Nightrunner","Atom","Bane","Vertigo","Brainiac","Salvatore Maroni","Ra's al Ghul","Reverse-Flash","Killer Croc","Killer Frost","Killer Moth","Lex Luthor","Firefly","Steppenwolf","Red Hood","Ocean Master","Cheetah","Gorilla Grodd","Supergirl","Batman","Batgirl","Spider-Man","Thor","Captain America","Thing","Mr.Fantastic","Wally West","Silver Surfer","Wolverine","Iron Man","Dardevil","Wonder Woman","Hulk","Black Panther","Leonardo","Raphael","Donatello","Michelangelo","Robin","Mr.Freeze","Poison Ivy","Nightwing","Parallax","Man-Bat","Deadshot","Deathstroke","Katana","Superboy","Wonder Girl"};

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
  }

  public void ajoutVolee() {
    int rang = (int)(Math.random()*listeNoms.length);
    double nbAlea = Math.random();

    if (nbAlea < 0.17){
      ajout(new Archer(listeNoms[rang]));
    }

    else if (nbAlea < 0.33){
      ajout(new Lancier(listeNoms[rang]));
    }

    else if (nbAlea < 0.5){
      ajout(new Medecin(listeNoms[rang]));
    }

    else if (nbAlea < 0.67){
      ajout(new Magicien(listeNoms[rang]));
    }

    else if (nbAlea < 0.83){
      ajout(new Chevalier(listeNoms[rang]));
    }

    else {
      ajout(new Sorcier(listeNoms[rang]));
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

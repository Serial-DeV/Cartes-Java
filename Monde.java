public class Monde {
  public static void main (String[] args) {

    Archer a1 = new Archer("Batman");
    Medecin a2 = new Medecin("Catwoman");
    Sorcier a3 = new Sorcier("Superman");

    Lancier b1 = new Lancier("Captain America");
    Magicien b2 = new Magicien("Iron Man");
    Chevalier b3 = new Chevalier("Hulk");

    System.out.println("\n");
    System.out.println(a1.toString());
    System.out.println(a2.toString());
    System.out.println(a3.toString());
    System.out.println(b1.toString());
    System.out.println(b2.toString());
    System.out.println(b3.toString());

    System.out.println("\nDistance entre " + a1.getNom() + " et " + b3.getNom() + ": " + a1.distance(b3));
    b3.combattre(a1);

    a1.setPV(150);
    System.out.println("\n" + a1.toString());


    System.out.println("\n");
    System.out.println(a1.toString());
    System.out.println(a2.toString());
    System.out.println(a3.toString());
    System.out.println(b1.toString());
    System.out.println(b2.toString());
    System.out.println(b3.toString());

//Fin partie 1

    Collection c1 = new Collection("Ma collection");
    c1.ajout(a3);
    c1.ajout(a2);
    c1.ajout(b1);
    System.out.println("\n" + c1.toString() + "\n");

    c1.ajoutVolee();
    c1.ajoutVolee();
    c1.ajoutVolee();
    c1.ajoutVolee();
    System.out.println("\n" + c1.toString() + "\n");

    ((Paladin)c1.getPersonnage(0)).combattre(c1.getPersonnage(0));
    ((Paladin)c1.getPersonnage(0)).combattre(c1.getPersonnage(0));
    ((Paladin)c1.getPersonnage(0)).combattre(c1.getPersonnage(0));
    System.out.println("\n" + c1.toString() + "\n");



    int sC1 = c1.getCartesSize();
    String[] s = c1.listePerso(sC1);
    for (int i = 0; i < s.length ; i++ ) {
      System.out.println("\n" + s[i]);

    }

    Fenetre f = new Fenetre(s);
    f.setVisible(true);





  }
}

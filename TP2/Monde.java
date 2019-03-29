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

////////////////Fin partie 1//////////////////////////////////////

    Equipe c1 = new Equipe("Elite Team Fighting");
    Equipe e1 = new Equipe("Warriors Team");

    c1.ajout(a3);
    c1.ajout(a2);
    c1.ajout(a1);
    System.out.println("\n" + c1.toString() + "\n");

    e1.ajout(b3);
    e1.ajout(b2);
    e1.ajout(b1);
    System.out.println("\n" + e1.toString() + "\n");

    /*c1.ajoutVolee();
    c1.ajoutVolee();
    c1.ajoutVolee();
    c1.ajoutVolee();
    System.out.println("\n" + c1.toString() + "\n");*/

    /*((Paladin)c1.getPersonnage(0)).combattre(c1.getPersonnage(0));
    ((Paladin)c1.getPersonnage(0)).combattre(c1.getPersonnage(0));
    ((Paladin)c1.getPersonnage(0)).combattre(c1.getPersonnage(0));
    System.out.println("\n" + c1.toString() + "\n");*/

    //((Paladin)c1.getPersonnage(0)).soigner(e1.getPersonnage(0));




    // Combat en 1000 rounds maximum
    int nbRounds = 1000;
    int round = 1;
    Boolean pasFini = true;
    while(round <= nbRounds && pasFini){

      //Demi round 1: Action effectuee par un personnage de l'equipe 1
      int persoEquipe1;
      do {
        persoEquipe1 = (int)(Math.random()*c1.getEquipeSize());
      } while (c1.getPersonnage(persoEquipe1).getEstKO());

      int persoEquipe2;
      do {
        persoEquipe2 = (int)(Math.random()*e1.getEquipeSize());
      } while (e1.getPersonnage(persoEquipe2).getEstKO());


      int persoEquipe1Bis = (int)(Math.random()*c1.getEquipeSize());
      int persoEquipe2Bis = (int)(Math.random()*e1.getEquipeSize());

      if ((c1.getPersonnage(persoEquipe1).getClass().getSuperclass().getName()+"").equals("Guerrier")) {
        ((Guerrier)c1.getPersonnage(persoEquipe1)).combattre(e1.getPersonnage(persoEquipe2));
      }

      else if ((c1.getPersonnage(persoEquipe1).getClass().getSuperclass().getName()+"").equals("Soigneur")) {
        ((Soigneur)c1.getPersonnage(persoEquipe1)).soigner(c1.getPersonnage(persoEquipe1Bis));
      }

      else if ((c1.getPersonnage(persoEquipe1).getClass().getSuperclass().getName()+"").equals("Paladin")) {
        if (Math.random() < 0.5) {
          ((Paladin)c1.getPersonnage(persoEquipe1)).combattre(e1.getPersonnage(persoEquipe2));
        }
        else{
          ((Paladin)c1.getPersonnage(persoEquipe1)).soigner(c1.getPersonnage(persoEquipe1Bis));
        }
      }


      if (c1.verifAPerdu() && e1.verifAPerdu()){
        pasFini = false;
        System.out.println("\nEgalite\n");
        break;
      }

      else if (c1.verifAPerdu()){
        pasFini = false;
        System.out.println("\n"+e1.getNom()+" gagne\n");
        break;
      }

      else if (e1.verifAPerdu()){
        pasFini = false;
        System.out.println("\n"+c1.getNom()+" gagne\n");
        break;
      }

      System.out.println("\nFin Demi Round " + round + "\n");

      //Demi round 2: Action effectuee par un personnage de l'equipe 2

      do {
        persoEquipe1 = (int)(Math.random()*c1.getEquipeSize());
      } while (c1.getPersonnage(persoEquipe1).getEstKO());

      do {
        persoEquipe2 = (int)(Math.random()*e1.getEquipeSize());
      } while (e1.getPersonnage(persoEquipe2).getEstKO());


      if ((e1.getPersonnage(persoEquipe2).getClass().getSuperclass().getName()+"").equals("Guerrier")) {
        ((Guerrier)e1.getPersonnage(persoEquipe2)).combattre(c1.getPersonnage(persoEquipe1));
      }

      else if ((e1.getPersonnage(persoEquipe2).getClass().getSuperclass().getName()+"").equals("Soigneur")) {
        ((Soigneur)e1.getPersonnage(persoEquipe2)).soigner(e1.getPersonnage(persoEquipe2Bis));
      }

      else if ((e1.getPersonnage(persoEquipe2).getClass().getSuperclass().getName()+"").equals("Paladin")) {
        if (Math.random() < 0.5) {
          ((Paladin)e1.getPersonnage(persoEquipe2)).combattre(c1.getPersonnage(persoEquipe1));
        }
        else{
          ((Paladin)e1.getPersonnage(persoEquipe2)).soigner(e1.getPersonnage(persoEquipe2Bis));
        }
      }


      if (c1.verifAPerdu() && e1.verifAPerdu()){
        pasFini = false;
        System.out.println("\nEgalite\n");
        break;
      }

      else if (c1.verifAPerdu()){
        pasFini = false;
        System.out.println("\n"+e1.getNom()+" gagne\n");
        break;
      }

      else if (e1.verifAPerdu()){
        pasFini = false;
        System.out.println("\n"+c1.getNom()+" gagne\n");
        break;
      }
      System.out.println("\nFin Round " + round +"\n");


      round++;
    }

    if (round > nbRounds ) {
      System.out.println("\nEgalite\n");
    }


    System.out.println("\nFin du duel\n");

    System.out.println("\n" + c1.toString() + "\n");
    System.out.println("\n" + e1.toString() + "\n");








////////////////////Fin Partie 2/////////////////////////////////////

    /*int sC1 = c1.getEquipeSize();
    String[] s = c1.listePerso(sC1);
    for (int i = 0; i < s.length ; i++ ) {
      System.out.println("\n" + s[i]);

    }


    int sC2 = e1.getEquipeSize();
    String[] s2 = e1.listePerso(sC2);
    for (int i = 0; i < s2.length ; i++ ) {
      System.out.println("\n" + s2[i]);

    }

    Fenetre f = new Fenetre(s,s2,c1.getNom() + " VS " + e1.getNom());
    f.setVisible(true);*/





  }
}

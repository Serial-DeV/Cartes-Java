public class Main {
  public static void main (String[] args) {


    Equipe eq = new Equipe("Elite Team Fighting");

    eq.ajoutVolee();
    eq.ajoutVolee();
    eq.ajoutVolee();
    eq.ajoutVolee();
    eq.ajoutVolee();

    System.out.println("\n" + eq.toString() + "\n");

    Fenetre f = new Fenetre(eq);
  }
}

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.text.*;

public class Fenetre extends JFrame{
  private static final long serialVersionUID = 1L; // Evite un warning à la compilation

  // Divisions de la fenêtre
  private JPanel jpNomJeu = new JPanel();//Contient le nom du jeu
  private JPanel haut = new JPanel();//Contient les listes de personnage
  private JPanel milieuHaut = new JPanel();//Contient les infos sur le combat et les actions réalisées
  private JPanel milieu = new JPanel();//Contient les statistiques des personnages sélectionnés
  private JPanel bas = new JPanel();//Contient le bouton générer

  private JLabel jlNomJeu = new JLabel ("JEU DE CARTES");//Nom du jeu

  //Utilisés pour afficher les listes de personnages
  private DefaultListModel<String> listModel;
  private DefaultListModel<String> listModel2;
  private JList<String> liste1;
  private JList<String> liste2;
  private JScrollPane sp1;
  private JScrollPane sp2;

  //Liste de personnages
  private Equipe eq1;

  //Utilisés pour la génération de panneaux d'informations sur le combat et statistiques des personnages sélectionnés
  private JTextArea listStat1;
  private JTextArea listStat2;
  private JTextArea listInfosCombat;
  private JPanel stats1;
  private JPanel stats2;
  private JPanel infosCombat;

  //Boutons soigner combattre et générer
  private JButton boutonSoigner;
  private JButton boutonCombattre;
  private JButton gen;

  //Conteneurs des boutons combattre et soigner
  private JPanel conteneurBoutonC;
  private JPanel conteneurBoutonS;




  public Fenetre(Equipe equipe){
    //Caractéristiques du titre
    Font font = new Font("Arial",Font.BOLD,42);
    jlNomJeu.setFont(font);
    jlNomJeu.setForeground(new Color(120,20,20));
    jpNomJeu.add(jlNomJeu);

    //Caractéristiques de la fenêtre
    this.setTitle("JEU DE CARTES");
    this.setSize(900, 550);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.setLayout(new GridLayout(5, 1)); // La fenêtre est subdivisée en 5 parties, étant sur 5 lignes et sur 1 colonne
    this.setResizable(false);

    //Initialisation des listes de personnages
    this.eq1 = equipe;
    listInit();

    // ajout des boutons et des écouteurs
    boutonCombattre = new JButton("Combattre");
    boutonCombattre.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
          try{
            int index1 = liste1.getSelectedIndex();
            int index2 = liste2.getSelectedIndex();
            eq1.get(index2);
            if(!eq1.get(index1).getClass().getSuperclass().getName().equals("Soigneur") && index1 != index2){ // Le test d'égalité sur les index doit être effectué après. Un personnage ne peut pas s'attaquer lui-même
              if(eq1.get(index1).getClass().getSuperclass().getName().equals("Guerrier")){
                ((Guerrier)eq1.get(index1)).combattre(eq1.get(index2));
              }
              else if(eq1.get(index1).getClass().getSuperclass().getName().equals("Paladin")){
                ((Paladin)eq1.get(index1)).combattre(eq1.get(index2));
              }
              listInfosCombat.setText(eq1.get(index1).getAction());
              messageInfosActualiser(); //Actualise le panneau d'informations
              verifClasse(index1);
              if(eq1.get(index1).getEstKO()) {
                JOptionPane.showMessageDialog(null,eq1.get(index1).koAffichageStr(eq1.get(index1)), "Attention", JOptionPane.WARNING_MESSAGE);
                eq1.remove(index1);
                majListe();
              }
              if(eq1.get(index2).getEstKO()) {
                JOptionPane.showMessageDialog(null,eq1.get(index2).koAffichageStr(eq1.get(index2)), "Attention", JOptionPane.WARNING_MESSAGE);
                eq1.remove(index2);
                majListe();
              }
              affichage(index1,1);
              affichage(index2,2);
            }
          } catch(IndexOutOfBoundsException err){
            JOptionPane.showMessageDialog(null, "Selectionnez un personnage ou générez-en un nouveau s'il n'y en a pas", "Attention", JOptionPane.WARNING_MESSAGE);
          }

        }

    });

    boutonSoigner = new JButton("  Soigner  ");// Les espaces permettent d'avoir un bouton Soigner d'une largeur équivalente à celle du bouton combattre
    boutonSoigner.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
          try {
            int index1 = liste1.getSelectedIndex();
            int index2 = liste2.getSelectedIndex();
            eq1.get(index2);
            if (!eq1.get(index1).getClass().getSuperclass().getName().equals("Guerrier")){
              if(eq1.get(index1).getClass().getSuperclass().getName().equals("Soigneur")){
                ((Soigneur)eq1.get(index1)).soigner(eq1.get(index2));
              }
              else if(eq1.get(index1).getClass().getSuperclass().getName().equals("Paladin")){
                ((Paladin)eq1.get(index1)).soigner(eq1.get(index2));
              }
              listInfosCombat.setText(eq1.get(index1).getAction());
              messageInfosActualiser();
              verifClasse(index1);
              if(eq1.get(index1).getEstKO()) {
                JOptionPane.showMessageDialog(null,eq1.get(index1).koAffichageStr(eq1.get(index1)), "Attention", JOptionPane.WARNING_MESSAGE);
                eq1.remove(index1);
                majListe();
              }
              if(eq1.get(index2).getEstKO()) {
                JOptionPane.showMessageDialog(null,eq1.get(index2).koAffichageStr(eq1.get(index2)), "Attention", JOptionPane.WARNING_MESSAGE);
                eq1.remove(index2);
                majListe();
              }
              affichage(index1,1);
              affichage(index2,2);
            }

          } catch(IndexOutOfBoundsException err){
              JOptionPane.showMessageDialog(null, "Selectionnez un personnage ou générez-en un nouveau s'il n'y en a pas", "Attention", JOptionPane.WARNING_MESSAGE);
          }
        }
    });

    gen = new JButton("Générer");
    gen.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        genererPersonnage();
      }
    });

    jlNomJeu.addMouseListener(new MouseAdapter() { //Change la couleur du titre lorsque l'on clique dessus
      public void mouseReleased(MouseEvent e) {
      jlNomJeu.setForeground(new Color((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256)));
      }
    });

    //Initialisation par désactivation des boutons combattre et soigner
    offBoutonsAction();

    //Ajout des boutons aux conteneurs
    conteneurBoutonC = new JPanel();
    conteneurBoutonC.setLayout(new FlowLayout(5, 25, 40));
    conteneurBoutonC.add(boutonCombattre);
    conteneurBoutonS = new JPanel();
    conteneurBoutonS.setLayout(new FlowLayout(5, 20, 40));
    conteneurBoutonS.add(boutonSoigner);

    //Initialisation des panneaux d'information
    listStat1 = new JTextArea(5,15);
    listStat2 = new JTextArea(5,15);
    listInfosCombat = new JTextArea(5,5);
    listInfosCombat.setText("Retrouvez ici les détails des interactions entre vos personnages");// Affichage par défaut
    listStat1.setEditable(false);
    listStat2.setEditable(false);
    listInfosCombat.setEditable(false);

    pasDePersoSelect();// Affichage par défaut
    mouseListenerInit();// Initialisation des écouteurs des listes de personnages

    //Initialisation des panneaux d'information
    stats1 = new JPanel();
    stats2 = new JPanel();
    infosCombat = new JPanel();
    stats1.add(listStat1);
    stats2.add(listStat2);
    infosCombat.add(listInfosCombat);

    //On assemble le tout
    haut.setLayout(new GridLayout(1, 6));
    haut.add(new JPanel());
    haut.add(sp1);
    haut.add(conteneurBoutonC);
    haut.add(conteneurBoutonS);
    haut.add(sp2);
    haut.add(new JPanel());
    milieuHaut.add(infosCombat);
    milieu.setLayout(new GridLayout(1, 2));
    milieu.add(stats1);
    milieu.add(stats2);
    bas.add(gen);
    this.add(jpNomJeu);
    this.add(haut);
    this.add(milieuHaut);
    this.add(milieu);
    this.add(bas);
    this.setVisible(true);
  }
/////////////Fin du constructeur/////////////

  public void affichage(int index, int ls){//Affiche les stats du personnage sélectionné
    String s = eq1.get(index).toStringV2();
    if (ls == 1)
      listStat1.setText(s);
    else
      listStat2.setText(s);
  }
  //Ces 4 méthodes activent ou désactivent les boutons, en fonctions de personnages sélectionnés
  public void offSoigner() {
    boutonSoigner.setEnabled(false);
  }

  public void offCombattre() {
    boutonCombattre.setEnabled(false);
  }

  public void onSoigner() {
    boutonSoigner.setEnabled(true);
  }

  public void onCombattre() {
    boutonCombattre.setEnabled(true);
  }

  //Vérifie la classe du personnage réalisant l'action et modifie l'état des boutons combattre et soigner
  public void verifClasse(int i){
    if(eq1.get(i).getClass().getSuperclass().getName().equals("Guerrier")){
      offSoigner();
      onCombattre();
    }
    else if(eq1.get(i).getClass().getSuperclass().getName().equals("Soigneur")){
      onSoigner();
      offCombattre();
    }
    else{
      onSoigner();
      onCombattre();
    }

  }

  public void listInit()  {//Initialisation des listes
    listModel = new DefaultListModel<String>();
    for(int i = 0; i < eq1.size(); i++) {
      listModel.addElement(""+eq1.get(i).getNom());
    }

    listModel2 = new DefaultListModel<String>();
    for(int i = 0; i < eq1.size(); i++) {
      listModel2.addElement(""+eq1.get(i).getNom());
    }

    liste1 = new JList<String>(listModel);
    liste2 = new JList<String>(listModel2);
    sp1 = new JScrollPane();
    sp2 = new JScrollPane();
    sp1.setViewportView(liste1);
    sp2.setViewportView(liste2);
  }

  public void genererPersonnage() { //Génère un personnage à la volée, dont la manière d'attaquer et/ou soigner est aléatoire
    eq1.ajoutVolee();
    majListe();
  }

  public void majListe()  { //Met à jour les listes
    listInit();
    listReInit();
    affichageReInit();
    mouseListenerInit();
  }

  public void listReInit() {//Réinitialisation de l'affichage (après qu'une génération de personnage ou un KO) des listes
    haut.remove(1);
    haut.add(sp1, 1);
    haut.remove(4);
    haut.add(sp2, 4);
    haut.revalidate();
    haut.repaint();
  }

  public void messageInfosActualiser() {//Actualise le message d'information après une action
    infosCombat.remove(0);
    infosCombat.add(listInfosCombat);
    infosCombat.revalidate();
    infosCombat.repaint();
  }
  public void affichageReInit() {//Réinitialisation de l'affichage (après qu'une génération de personnage ou un KO) des statistiques
    stats1.remove(0);
    stats2.remove(0);
    stats1.add(listStat1);
    stats2.add(listStat2);
    stats1.revalidate();
    stats1.repaint();
    stats2.revalidate();
    stats2.repaint();
    offBoutonsAction();
  }


  public void mouseListenerInit(){//Initialisation des écouteurs pour les listes
    liste1.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e) {
       int index1 = liste1.getSelectedIndex();
       int index2 = liste2.getSelectedIndex();
       affichage(index1,1);
       if(index2 != -1) //Vérifie que le personnage qui subit a été sélectionné en comparant index2 à -1
        verifClasse(index1);
       if(index1 == index2)
        offCombattre();
         }
    });

    liste2.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e) {
        int index1 = liste1.getSelectedIndex();
        int index2 = liste2.getSelectedIndex();
        affichage(index2,2);
        if(index1 != -1) //Vérifie que le personnage qui agit a été sélectionné en comparant index1 à -1
          verifClasse(index1);
        if(index1 == index2)
         offCombattre();
      }
    });
    pasDePersoSelect();
  }

  public void pasDePersoSelect(){ //Initialisation lorsque aucun personnage n'est sélectionné
    listStat1.setText("Selectionnez un personnage\nOu générez-en un nouveau");
    listStat2.setText("Selectionnez un personnage\nOu générez-en un nouveau");
  }

  public void offBoutonsAction(){ //Désactive les boutons combattre et soigner
    offSoigner();
    offCombattre();
  }

}

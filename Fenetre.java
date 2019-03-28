import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


public class Fenetre extends JFrame implements ActionListener, ItemListener, ListSelectionListener{

  public Fenetre(String[] s){
    setTitle("TITRE");
    setSize(1024,768);

    JList liste = new JList(s);
    JList liste2 = new JList(s);


    Container c = getContentPane();
    c.setLayout(new FlowLayout());
    c.add(liste);
    c.add(liste2);

    /*Container c2 = getContentPane();
    c2.setLayout(new FlowLayout());
    c2.add(liste);*/

    GridLayout gl = new GridLayout(2,2);
    c.setLayout(gl);

    /*GridLayout gl2 = new GridLayout(100,100);
    c2.setLayout(gl2);*/

    System.out.println("NB ELEm: "+c.getComponentCount());

  /*  Container c2 = getContentPane();
    c2.setLayout(new FlowLayout());
    c2.add(liste);*/
  }

  public void actionPerformed(ActionEvent ev){}
  public void itemStateChanged(ItemEvent ev){}
  public void valueChanged(ListSelectionEvent ev){}

}

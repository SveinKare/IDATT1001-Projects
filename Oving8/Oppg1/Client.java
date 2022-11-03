package Oppg1;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

/**
 * Klassen Client er en subclass av JFrame
 */
public class Client extends JFrame implements ActionListener{
    //Lager objekter
    Person Per = new Person("Per", "Jensen", 1998);
    ArbTaker Arbeider1 = new ArbTaker(Per, 238748, 2016, 40000, 23.3);
    JTextField månedslønn = new JTextField();
    JTextField skatteprosent = new JTextField();

    /**
     * Konstruktør for Client-klassen
     */
    Client(){
        //Lager standard font
        Font standard = new Font("Times New Roman", Font.PLAIN, 16);

        //Setter tittel, størrelse og plassering for vinduet
        setTitle("Haker Bughes AS");
        setLayout(new GridBagLayout());
        setLocation(500, 100);

        //Bruker GridBagLayout som layoutmanager
        GridBagConstraints layoutCon = null;

        //Lager labels og tekstfelt for alle attributtene som skal vises fra ArbTaker-klassen

        JLabel fullname = new JLabel("Navn: " + Arbeider1.navn());
        fullname.setFont(standard);
        layoutCon = new GridBagConstraints();
        layoutCon.gridx = 0;
        layoutCon.gridy = 0;
        layoutCon.insets = new Insets(10, 10, 10, 10);
        add(fullname, layoutCon);

        JLabel nr = new JLabel("Ansattnummer: " + Arbeider1.getArbtakernr());
        nr.setFont(standard);
        layoutCon = new GridBagConstraints();
        layoutCon.gridx = 0;
        layoutCon.gridy = 1;
        layoutCon.insets = new Insets(10, 10, 10, 10);
        add(nr, layoutCon);


        JLabel ansÅr = new JLabel("Ansettelsesår: " + Arbeider1.getAnsettelsesår());
        ansÅr.setFont(standard);
        layoutCon = new GridBagConstraints();
        layoutCon.gridx = 0;
        layoutCon.gridy = 2;
        layoutCon.insets = new Insets(10, 10, 10, 10);
        add(ansÅr, layoutCon);

        JLabel mndLønn = new JLabel("Månedslønn: ");
        mndLønn.setFont(standard);
        layoutCon = new GridBagConstraints();
        layoutCon.gridx = 0;
        layoutCon.gridy = 3;
        add(mndLønn, layoutCon);

        månedslønn.setText(Double.toString(Arbeider1.getMånedslønn()));
        månedslønn.setColumns(10);
        layoutCon = new GridBagConstraints();
        layoutCon.gridx = 0;
        layoutCon.gridy = 4;
        add(månedslønn, layoutCon);

        JLabel skattLabel = new JLabel("Skatteprosent: ");
        skattLabel.setFont(standard);
        layoutCon = new GridBagConstraints();
        layoutCon.gridx = 0;
        layoutCon.gridy = 5;
        layoutCon.insets = new Insets(10, 10, 0, 10);
        add(skattLabel, layoutCon);

        skatteprosent.setText(Double.toString(Arbeider1.getSkatteprosent()));;
        skatteprosent.setColumns(10);
        layoutCon = new GridBagConstraints();
        layoutCon.gridx = 0;
        layoutCon.gridy = 6;
        add(skatteprosent, layoutCon);

        JButton lagre = new JButton("Lagre");
        lagre.addActionListener(this);
        layoutCon = new GridBagConstraints();
        layoutCon.gridx = 0;
        layoutCon.gridy = 7;
        layoutCon.insets = new Insets(20, 0, 0, 0);
        add(lagre, layoutCon);
    }
    public static void main(String[] args) {
        Person Per = new Person("Per", "Jensen", 1998);
        ArbTaker Arbeider1 = new ArbTaker(Per, 238748, 2016, 40000, 23.3);

        System.out.println("Arbtakernr: " + Arbeider1.getArbtakernr());
        System.out.println("Ansettelsesår: " + Arbeider1.getAnsettelsesår());
        Arbeider1.setMånedslønn(50340.0);
        Arbeider1.setSkatteprosent(43.2);
        System.out.println("Månedslønn: " + Arbeider1.getMånedslønn());
        System.out.println("Skatteprosent: " + Arbeider1.getSkatteprosent());
        System.out.println("Skatt per måned: " + Arbeider1.skattPrMnd());
        System.out.println("Årslønn: " + Arbeider1.årslønn());
        System.out.println("Skatt per år: " + Arbeider1.skattPrÅr());
        System.out.println("Navn: " + Arbeider1.navn());
        System.out.println("Alder: " + Arbeider1.alder());
        System.out.println("Ansiennitet: " + Arbeider1.ansiennitet());
        System.out.println("Ansatt lenger enn 5 år : " + Arbeider1.lengerEnn(5));

        Client window = new Client();

        //Setter verdier for vinduet og gjør det synlig
        System.out.println();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setPreferredSize(new Dimension(600, 600));
        window.pack();
        window.setVisible(true);
        
 
    }


    /**
     * Metode som kalles når "Lagre" knappen blir trykket. Setter månedslønn og skatteprosent ved å hente verdier fra textfeltene til GUI'en. 
     */
    public void actionPerformed(ActionEvent event){
        try{
            Arbeider1.setMånedslønn(Double.parseDouble(månedslønn.getText()));
            Arbeider1.setSkatteprosent(Double.parseDouble(skatteprosent.getText()));
            JOptionPane.showMessageDialog(this, "Verdiene har blitt oppdatert", "Info", JOptionPane.PLAIN_MESSAGE);
            System.out.println("Månedslønn: " + Arbeider1.getMånedslønn());
            System.out.println("Skatteprosent: " + Arbeider1.getSkatteprosent());
        } catch(Exception e){
            JOptionPane.showMessageDialog(this, "Vennligst tast inn et heltall eller desimaltall", "Feilmelding", JOptionPane.PLAIN_MESSAGE);
            månedslønn.setText(Double.toString(Arbeider1.getMånedslønn()));
            skatteprosent.setText(Double.toString(Arbeider1.getSkatteprosent()));

        }
    }
}

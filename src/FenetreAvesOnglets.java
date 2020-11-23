import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import sun.java2d.SunGraphicsEnvironment.TTFilter;

public class FenetreAvesOnglets extends JFrame implements ActionListener {
	private JTabbedPane tab;
	private JPanel po1, po2, po3, pn, pc, ps;
	private JLabel ltext, lp, lt;
	private JTextField tf;
	private JButton br, bb, bv, bcop, bcol, bcoup, ba, bA, bsl, bf;
	private JComboBox comp, comt;
	private JToggleButton togG, togI;
	private JTextArea ta;// ecrire sue les lignes et sur les colonnes ,,preciser
	// le nombre de lignes et colonnes// il est à
	// l'interieur de Jscrolpan
	private JScrollPane sp;// scroler

	public FenetreAvesOnglets() {
		setTitle("Fenetre avec onglets");
		setSize(600, 450);
		setLocationRelativeTo(this);
		tab = new JTabbedPane();
		add(tab);
		po1 = new JPanel();
		tab.add(po1, "Onglet1");
		po1.setBackground(Color.lightGray);
		po1.setLayout(new BorderLayout());// creer 3 zones dans la paneau angle1
		pn = new JPanel();
		po1.add(pn, BorderLayout.NORTH);
		ltext = new JLabel("Texte :");
		pn.add(ltext);
		tf = new JTextField(8);
		pn.add(tf);
		br = new JButton();
		br.setBackground(Color.red);
		br.addActionListener(this);
		pn.add(br);

		bb = new JButton();
		bb.setBackground(Color.blue);
		bb.addActionListener(this);
		pn.add(bb);
		bv = new JButton();
		bv.setBackground(Color.green);
		bv.addActionListener(this);
		pn.add(bv);
		lp = new JLabel("police :");
		pn.add(lp);
		comp = new JComboBox();
		comp.addItem("Cambria");// il faut respecter l'orthographe
		comp.addItem("Times New Roman");
		comp.addItem("Monotype Corsiva");
		pn.add(comp);
		comp.addActionListener(this);
		lt = new JLabel("taille");
		pn.add(lt);
		comt = new JComboBox();
		comt.addItem("12");
		comt.addItem("20");
		comt.addItem("30");
		pn.add(comt);
		comt.addActionListener(this);

		pc = new JPanel();
		po1.add(pc, BorderLayout.CENTER);
		ta = new JTextArea(18, 50);
		sp = new JScrollPane(ta);
		pc.add(sp);
		ps = new JPanel();

		po1.add(ps, BorderLayout.SOUTH);
		bcop = new JButton("copier");
		bcop.addActionListener(this);
		ps.add(bcop);
		bcol = new JButton("coller");
		bcol.addActionListener(this);
		ps.add(bcol);
		bcoup = new JButton("couper");
		bcoup.addActionListener(this);
		ps.add(bcoup);
		togG = new JToggleButton("G");
		togG.addActionListener(this);
		ps.add(togG);
		togI = new JToggleButton("I");
		togI.addActionListener(this);
		ps.add(togI);
		ba = new JButton("a");ba.addActionListener(this);
		ps.add(ba);
		bA = new JButton("A");bA.addActionListener(this);
		ps.add(bA);
		bsl = new JButton("Saut de ligne");bsl.addActionListener(this);
		ps.add(bsl);
		bf = new JButton("fermer");
		ps.add(bf);

		po2 = new JPanel();
		tab.add(po2, "Onglet2");
		po2.setBackground(Color.gray);
		po3 = new JPanel();
		tab.add(po3, "Onglet3");
		po3.setBackground(Color.DARK_GRAY);
		
	}

	public static void main(String[] args) {
		FenetreAvesOnglets fe = new FenetreAvesOnglets();
		fe.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == bcop) {
			tf.copy();// copier le contenu de jtextfeald

		}
		if (e.getSource() == bcol) {
			ta.paste();// coller le contenu de jtextfield dans jtextarea

		}
		if (e.getSource() == bcoup) {
			tf.cut();// couper le contenu de jtextfeald

		}
		if (e.getSource() == bb) {
			ta.setForeground(Color.blue);

		}
		if (e.getSource() == bv) {
			ta.setForeground(Color.GREEN);

		}
		if (e.getSource() == br) {
			ta.setForeground(Color.red);

		}
		if (e.getSource() == togG) {
			if (togG.isSelected()) {
				ta.setFont(new Font("Cambria", Font.BOLD, 12));// tjr si on a
				// une classe
				// comme
				// argument il
				// faut
				// l'instancier
				// avc
				// new::font(
				// police
				// ;style,taille
				// transformer le text en gras
			} else {
				ta.setFont(new Font("Cambria", Font.PLAIN, 12));// on fait rien
			}

		}
		if (e.getSource() == togI) {
			if (togI.isSelected()) {
				ta.setFont(new Font("cambria", Font.ITALIC, 12));

			} else {
				ta.setFont(new Font("cambria", Font.PLAIN, 12));
			}

		}
		if (togG.isSelected() && togI.isSelected()) {
			ta.setFont(new Font("cambria", Font.BOLD | Font.ITALIC, 12));

		}
		if (!togG.isSelected() && togI.isSelected()) {
			ta.setFont(new Font("cambria", Font.ITALIC, 12));

		}

		if (togG.isSelected() && !togI.isSelected()) {
			ta.setFont(new Font("cambria", Font.BOLD, 12));

		}
		if (e.getSource() == bA) {
			ta.setText(ta.getText().toUpperCase());

		}
		if (e.getSource() == ba) {
			ta.setText(ta.getText().toLowerCase());

		}
		if (e.getSource() == bsl) {
			ta.setLineWrap(true);

		}
		if (e.getSource() == comp) {
			if (comp.getSelectedItem() == "Cambria") {
				ta.setFont(new Font("Cambria", Font.PLAIN, Integer.parseInt(comt.getSelectedItem()+"")));

			}
			if (comp.getSelectedItem() == "Times New Roman") {
				ta.setFont(new Font("Times New Roman", Font.PLAIN, Integer.parseInt(comt.getSelectedItem()+"")));
			}
			if (comp.getSelectedItem() == "Monotype Corsiva") {
				ta.setFont(new Font("Monotype Corsiva", Font.PLAIN, Integer.parseInt(comt.getSelectedItem()+"")));

			}

		}
		if (e.getSource() == comt) {
			if (comt.getSelectedItem() == "12") {
				ta.setFont(new Font(comp.getSelectedItem()+"", Font.PLAIN,12));

			}
			if (comt.getSelectedItem() == "20") {
				ta.setFont(new Font(comp.getSelectedItem()+"", Font.PLAIN, 20));

			}
			if (comt.getSelectedItem() == "30") {
				ta.setFont(new Font(comp.getSelectedItem()+"", Font.PLAIN, 30));

			}
		}
		

	}
}

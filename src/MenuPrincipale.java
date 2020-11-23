import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MenuPrincipale extends JFrame implements ActionListener {
	private JPanel pn, pc, ps;
	private JButton bq, bo, bcop, bcol, bcoup;
	private JLabel limg;
	private JMenuBar mb;
	private JMenu mf, me, ma;
	private JMenuItem io, ic, iq, icop, icol, icoup, ipro;
	private JToolBar tb;

	public MenuPrincipale() {
		setTitle("menu principal");
		setSize(700, 550);
		setLocationRelativeTo(this);
		mb = new JMenuBar();
		setJMenuBar(mb);
		mf = new JMenu("fichier");
		mb.add(mf);
		io = new JMenuItem("ouvrir");
		mf.add(io);
		io.addActionListener(this);
		ic = new JMenuItem("consulter");
		mf.add(ic);
		iq = new JMenuItem("quitter");
		mf.add(iq);
		iq.addActionListener(this);
		me = new JMenu("edition");
		mb.add(me);
		icop = new JMenuItem("copier");
		me.add(icop);
		icol = new JMenuItem("coller");
		me.add(icol);
		icoup = new JMenuItem("couper");
		me.add(icoup);

		ma = new JMenu("aide");
		mb.add(ma);
		ipro = new JMenuItem("à propos");
		ma.add(ipro);
		pn = new JPanel();
		add(pn, "North");
		pn.setBackground(Color.gray);
		pn.setLayout(new FlowLayout(FlowLayout.LEFT));
		tb = new JToolBar();
		pn.add(tb);
		bo = new JButton(new ImageIcon(getClass().getResource("ouvrir.png")));
		tb.add(bo);
		bo.addActionListener(this);
		bo.setCursor(new Cursor(Cursor.HAND_CURSOR));
		bo.setToolTipText("ouvrir la fenetre avec onglet");
		bcop = new JButton(new ImageIcon(getClass().getResource("copier.png")));
		tb.add(bcop);
		bcol = new JButton(new ImageIcon(getClass().getResource("coller.png")));
		tb.add(bcol);
		bcoup = new JButton(new ImageIcon(getClass().getResource("couper.png")));
		tb.add(bcoup);

		pc = new JPanel();
		add(pc, "Center");
		limg = new JLabel(new ImageIcon(getClass().getResource(
				"FondDev.final.png")));
		pc.add(limg);
		ps = new JPanel();
		add(ps, "South");
		ps.setBackground(Color.gray);
		ps.setLayout(new FlowLayout(FlowLayout.RIGHT));
		bq = new JButton("quitter l'application", new ImageIcon((getClass()
				.getResource("Exit.png"))));
		ps.add(bq);
		bq.addActionListener(this);

	}

	public static void main(String[] args) {
		MenuPrincipale mp = new MenuPrincipale();
		mp.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bo || e.getSource() == io) {
			FenetreAvesOnglets fa = new FenetreAvesOnglets();
			fa.setVisible(true);

		}
		if (e.getSource() == bq || e.getSource() == iq) {
			int opt = JOptionPane.showConfirmDialog(this,
					"voulez-vous vraiment quitter?", "Confirmation",
					JOptionPane.YES_NO_OPTION);
			if (opt==0) {
			
			System.exit(0);}

		}

	}

}

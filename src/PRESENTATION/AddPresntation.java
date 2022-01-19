package PRESENTATION;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import DAO.IScolarite;
import DAO.ScolariteImpl;
import METIER.ENTITY.Etudiant;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class AddPresntation extends JFrame{
	JPanel pajout = new JPanel(new GridLayout(3,2,5,5));
	
	JLabel nom = new JLabel("Nom");
	JTextField tnom = new JTextField();
	
	JLabel prenom = new JLabel("Prenom",JLabel.RIGHT);
	JTextField tprenom = new JTextField();
	
	JButton ajouter = new JButton("Ajouter");
	
	JPanel bas = new JPanel();
	
	JButton quitter = new JButton("Quitter");
	IScolarite action = new ScolariteImpl();
	JPanel prs = new JPanel(new GridLayout(1,1));
	TableModele tm = new TableModele();
	JTable table = new JTable(tm);
	JScrollPane jsp = new JScrollPane(table);
	
	public AddPresntation() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		nom.setHorizontalAlignment(JLabel.RIGHT);
		pajout.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE,2), "Ajouter Etudiant "));
		pajout.add(nom);
		pajout.add(tnom);
		pajout.add(prenom);
		pajout.add(tprenom);
		pajout.add(ajouter);
		this.add(pajout,BorderLayout.NORTH);
		prs.add(jsp);
		this.add(prs,BorderLayout.CENTER);
		bas.add(quitter);
		this.add(bas,BorderLayout.SOUTH);
		pack();
		setVisible(true);
		tm.charger(action.getAllEtudiant());
		ajouter.addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(tnom.getText().equals("") || tprenom.getText().equals(""))
					JOptionPane.showMessageDialog(AddPresntation.this, "Erreur de saisie");
				
				
				else {
					action.addEtudiant(new Etudiant(tnom.getText(), tprenom.getText()));
					tm.charger(action.getAllEtudiant());
				}
		
			
		}
	});

	quitter.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			dispose();
		}
		
	});
	}
	}

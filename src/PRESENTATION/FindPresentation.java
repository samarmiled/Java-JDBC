package PRESENTATION;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.util.*;
import java.util.List;

import DAO.IScolarite;
import DAO.ScolariteImpl;
import METIER.ENTITY.Etudiant;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class FindPresentation extends JFrame{
	JTextField texte = new JTextField(20);
	JButton rechercher = new JButton("Rechercher");
	IScolarite gestion = new ScolariteImpl();
	JPanel haut = new JPanel();
	JPanel bas = new JPanel();
	JButton quitter = new JButton("Quitter");
	TableModele tm = new TableModele();
	JTable table = new JTable(tm);
	JScrollPane jsp = new JScrollPane(table);
	public FindPresentation() {
		this.setTitle("Rechercher");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
		haut.add(texte);
		haut.add(rechercher);
		this.add(haut,BorderLayout.NORTH);
		tm.charger(gestion.getAllEtudiant());
		this.add(jsp,BorderLayout.CENTER);
		bas.add(quitter);
		this.add(bas,BorderLayout.SOUTH);
		this.pack();
		
		rechercher.addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			  List<Etudiant>  liste = gestion.getEtudiantsPMC(texte.getText());
				tm.charger(liste);
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

package PRESENTATION;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ScolaritePresentation extends JFrame{
	JButton ajouter = new JButton(new ImageIcon("C://images/add.png"));
	JButton rechercher = new JButton(new ImageIcon("C://images/search.png"));
	JButton fermer = new JButton(new ImageIcon("C://images/close.jpg"));
	public ScolaritePresentation() {
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("Gestion Etudiants");
		this.setLayout(new GridLayout(1,3,10,10));
		this.add(ajouter);
		this.add(rechercher);
		this.add(fermer);
		this.pack();
		ajouter.addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new AddPresntation();
			}
			
		});
		rechercher.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new FindPresentation();
			}
			
		});
		fermer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
		});
	}
	public static void main(String[] args) {
		new ScolaritePresentation();
		
	}


}

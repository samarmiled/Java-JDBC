package PRESENTATION;

import java.util.*;

import javax.swing.table.AbstractTableModel;

import METIER.ENTITY.Etudiant;


public class TableModele extends AbstractTableModel{
	private List<Etudiant> etudiants;
	private String colonnes[]=  {"Id","Nom","Prenom"};
	
	public TableModele () {
		etudiants = new ArrayList<>();
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return etudiants.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return colonnes.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		switch(columnIndex) {
		case 0:
			return etudiants.get(rowIndex).getId();
		case 1:
			return etudiants.get(rowIndex).getNom();
		case 2:
			return etudiants.get(rowIndex).getPrenom();
		
		}
		
		return null;
	}
	@Override
public String getColumnName(int column) {
	return colonnes[column];
}
	public void charger(List<Etudiant> l) {
		
			this.etudiants=l;
			fireTableDataChanged();
		
		
	}
	
}

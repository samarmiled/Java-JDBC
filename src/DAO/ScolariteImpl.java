package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import METIER.ENTITY.Etudiant;

public class ScolariteImpl implements IScolarite {

	@Override
	public void addEtudiant(Etudiant e) {
		// TODO Auto-generated method stub
		Connection cnx = SingletonConnection.getInstance();
		try {
			PreparedStatement stmt = cnx.prepareStatement("insert into etudiant (nom,prenom) values(?,?)");
			stmt.setString(1, e.getNom());
			stmt.setString(2, e.getPrenom());
			stmt.executeUpdate();
		}catch(SQLException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public List<Etudiant> getAllEtudiant() {
		// TODO Auto-generated method stub
		Connection cnx = SingletonConnection.getInstance();
		List<Etudiant> liste = new ArrayList<>();
		try {
			PreparedStatement ps = cnx.prepareStatement("select * from etudiant");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Etudiant e = new Etudiant();
				e.setId(rs.getInt(1));
				e.setNom(rs.getString(2));
				e.setPrenom(rs.getString(3));
				liste.add(e);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return liste;
	}

	@Override
	public List<Etudiant> getEtudiantsPMC(String mc) {
		// TODO Auto-generated method stub
		Connection cnx = SingletonConnection.getInstance();
		List<Etudiant> liste = new ArrayList<>();
		try {
			PreparedStatement ps = cnx.prepareStatement("select * from etudiant where nom like ?");
			ps.setString(1, "%" + mc + "%");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Etudiant e = new Etudiant();
				e.setId(rs.getInt(1));
				e.setNom(rs.getString(2));
				e.setPrenom(rs.getString(3));
				liste.add(e);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		return liste;
	}

	@Override
	public Etudiant getEtudiant(int id) {
		// TODO Auto-generated method stub
		Connection cnx = SingletonConnection.getInstance();
		Etudiant e = null;
		try {
			PreparedStatement ps = cnx.prepareStatement("select * from etudiant where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				e = new Etudiant();
				e.setId(rs.getInt(1));
				e.setNom(rs.getString(2));
				e.setPrenom(rs.getString(3));
			}
		} catch (SQLException e3) {
			// TODO: handle exception
			e3.printStackTrace();
		}

		return e;
	}

	@Override
	public void modifierEtudiant(Etudiant e) {
		// TODO Auto-generated method stub
		Connection cnx = SingletonConnection.getInstance();
		try {
			PreparedStatement ps = cnx.prepareStatement("update etudiant set nom=?,prenom=? where id=?");
			ps.setString(1, e.getNom());
			ps.setString(2, e.getPrenom());
			ps.setInt(3, e.getId());
			ps.executeUpdate();
		} catch (SQLException e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
	}

	@Override
	public void supprimerEtudiant(int id) {
		// TODO Auto-generated method stub
		Connection cnx = SingletonConnection.getInstance();
		try {
			PreparedStatement ps = cnx.prepareStatement("delete from etudiant where id=?");
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}

package DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import Connection.DBConnection;
import DAO.IEvaluatedDao;
import Models.EvaluateModel;

public class EvaluateDaoImpl extends DBConnection implements IEvaluatedDao{

	@Override
	public void insert(EvaluateModel evaluate) {
		String sql = "INSERT INTO Evaluated(name, email, subject, content)"
				+ "VALUES(?, ?, ?, ?)";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, evaluate.getName());
			ps.setString(2, evaluate.getEmail());
			ps.setString(3, evaluate.getSubject());
			ps.setString(4, evaluate.getContent());
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<EvaluateModel> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}

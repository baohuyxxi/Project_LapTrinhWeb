package DAO;

import java.util.List;

import Models.EvaluateModel;

public interface IEvaluatedDao {
	void insert(EvaluateModel evaluate);
	void delete(int id);
	List<EvaluateModel> getAll();
}

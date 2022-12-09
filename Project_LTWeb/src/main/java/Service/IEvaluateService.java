package Service;

import java.util.List;

import Models.EvaluateModel;

public interface IEvaluateService {
	void insert(EvaluateModel evaluate);
	void delete(int id);
	List<EvaluateModel> getAll();
}

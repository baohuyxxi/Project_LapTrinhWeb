package Service.Impl;

import java.util.List;

import DAO.IEvaluatedDao;
import DAO.Impl.EvaluateDaoImpl;
import Models.EvaluateModel;
import Service.IEvaluateService;

public class EvaluateServiceImpl implements IEvaluateService{
	IEvaluatedDao evaluatedDao = new EvaluateDaoImpl();

	@Override
	public void insert(EvaluateModel evaluate) {
		evaluatedDao.insert(evaluate);
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<EvaluateModel> getAll() {
		// TODO Auto-generated method stub
		return evaluatedDao.getAll();
	}

	@Override
	public int CountEvaluated() {
		// TODO Auto-generated method stub
		return evaluatedDao.CountEvaluated();
	}
	
}

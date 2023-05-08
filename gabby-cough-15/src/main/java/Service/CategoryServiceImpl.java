package Service;

import java.util.List;

import Dao.CategoryDao;
import Dao.CategoryDaoImpl;
import Entity.Category;
import Exception.SomeThingWentWrongException;

public class CategoryServiceImpl implements CategoryService {
	
	public CategoryServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addcategory(Category category) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		  CategoryDao categoryDao=new CategoryDaoImpl();
		if(category == null) {
	        throw new IllegalArgumentException("Category cannot be null");
	    }
		categoryDao.addcategory(category);
	}

	@Override
	public void deleteCategory(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Category> getAllCategories() throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		  CategoryDao categoryDao=new CategoryDaoImpl();
		 List<Category> list= categoryDao.getAllCategories();
		return list;
	}

	@Override
	public void updateCategory(Category category) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double calculateTotalCost(int categoryId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Category findCategoryById(Long categoryId) throws SomeThingWentWrongException {
		 CategoryDao categoryDao=new CategoryDaoImpl();
			Category category=categoryDao.findCategoryById(categoryId);
		return category;
	}

}

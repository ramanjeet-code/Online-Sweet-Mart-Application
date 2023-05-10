package Dao;

import java.util.List;

import Entity.Category;
import Exception.SomeThingWentWrongException;

public interface CategoryDao {
	void addcategory(Category category) throws SomeThingWentWrongException;
	 public void deleteCategory(int id) throws SomeThingWentWrongException;
	 List<Category> getAllCategories() throws SomeThingWentWrongException;
	 void updateCategory(Category category);
	 double calculateTotalCost(int categoryId);
	 Category findCategoryById(Long categoryId) throws SomeThingWentWrongException;
}

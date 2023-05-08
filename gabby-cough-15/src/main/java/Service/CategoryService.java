package Service;

import java.util.List;

import Entity.Category;
import Exception.SomeThingWentWrongException;

public interface CategoryService {
 void addcategory(Category category) throws SomeThingWentWrongException;
 public void deleteCategory(int id);
 List<Category> getAllCategories() throws SomeThingWentWrongException;
 void updateCategory(Category category);
 double calculateTotalCost(int categoryId);
Category findCategoryById(Long categoryId) throws SomeThingWentWrongException;
}

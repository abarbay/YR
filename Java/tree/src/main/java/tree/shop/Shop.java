package tree.shop;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private Category root= new Category(0,"Shop");

    public void addCategory(long id, String name, long parentId){
        if(id==parentId){throw new IllegalArgumentException();}
        Category parent=findCategoryById(this.getRoot(), parentId);
        new Category(id,name,parent);
      }

    public List<String> subCategoriesNames(long categoryId){
        List<String> result= new ArrayList<>();
                    Category parentCategory=findCategoryById(this.getRoot(), categoryId);
            for(Category category:parentCategory.getChildren()){
                result.add(category.getName());
            }
        return result;
        }

    public void addProduct(long id, String name, long categoryId){
        Category category=findCategoryById(this.getRoot(), categoryId);
        if(category== null){throw new IllegalArgumentException();}
        category.getProducts().add(new Product(id,name,category));

    }

    public List<Product> productsOfCategory(long categoryId){
        List<Product> result= new ArrayList<>();
        Category category=findCategoryById(this.getRoot(), categoryId);
        for(Product product:category.getProducts()){
            result.add(product);
        }
        return result;
    }

    public List<String> itemsInSameCategory(long productId){
        List<String> result= new ArrayList<>();
        Product productInCategory=findProductById(this.getRoot(),productId);
        for(Product product:productsOfCategory(productInCategory.getCategory().getId())){
            if(product.getId()!=productId){
                result.add(product.getName());
            }
        }
        return result;
    }

    public Product findProductById(Category searchIn,long productId){
        long categoryId=0;
        Product productToFind=null;
        while(productToFind==null){
            Category category=findCategoryById(searchIn,categoryId);
            for(Product product:category.getProducts()){
                if(product.getId()==productId){
                    productToFind=product;
                    break;
                }
            }
            categoryId++;
        }
        return productToFind;
    }

    public List<String>pathToCategory(long categoryId){
        List<String> result= new ArrayList<>();
        Category category=findCategoryById(this.getRoot(),categoryId);
        result.add(this.getRoot().getName());
        if(category.getParent().getName()!=this.getRoot().getName()){
            result.add(category.getParent().getName());
        }
        return result;
    }


    public List<String>pathToProduct(long productId){
        List<String> result= new ArrayList<>();
        Product productToFind=findProductById(this.getRoot(), productId);
        result.addAll(pathToCategory(productToFind.getCategory().getId())); // Category add
        result.add(productToFind.getCategory().getName()); // last category add based on product
        return result;
    }



    public Category getRoot() {
        return root;
    }

    private Category findCategoryById(Category searchIn,long categoryId){
        return searchIn.findCategoryById(categoryId);
    }
}

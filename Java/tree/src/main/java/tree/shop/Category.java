package tree.shop;


import java.util.ArrayList;
import java.util.List;


public class Category {
    private long id;
    private String name;
    private Category parent;
    private List<Category> children= new ArrayList<>();
    private List<Product> products= new ArrayList<>();

    public Category(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category(long id, String name, Category parent) {
        this.id = id;
        this.name = name;
        this.parent = parent;
        parent.children.add(this);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Category getParent() {
        return parent;
    }

    public List<Category> getChildren() {
        return children;
    }

    public List<Product> getProducts() {
        return products;
    }



    /*
    A rekurzió az utolsó levélig megy lefelé ha nem talál egyezést az ID-vel akkor
    feljebb jön egy szintet és megy a mellete lévő levélre addifg folytatja amíg nincs találat.
    A null érték az ami jelzi hogy nincs több gyerek ezért jöhet feljebb egy szintet
     */

    public Category findCategoryById(long id){
        if(this.getId()==id){return this;}
        for(Category cat:children){
            // If feltétel megy lefelé a fán
            if(cat.findCategoryById(id)!=null){return cat.findCategoryById(id);}
        }
        // ezzel megyek felfele
        return null;
    }
}

package genericinterface.search;

import genericinterface.Item;
import genericinterface.SearchCriteria;

import java.util.List;

public class SearchService<T extends Item>{

    public T findFirst(List<T> items, SearchCriteria criteria){
       if(items==null || items.size()==0){throw new IllegalArgumentException();}
       T found=null;
       for(T item:items){
           if(criteria.pass(item)){
               found=item;
               break;
           }
       }

       if (found==null){throw new IllegalArgumentException();}
        return found;
    }


}

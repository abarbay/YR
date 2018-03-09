package objectclass;


import java.util.ArrayList;
import java.util.List;

public class SimpleBag {
    private List<Object> items ;
    private int cursor;

    public SimpleBag(){
        items= new ArrayList<>();
        cursor=-1;
    }

    public void putItem(Object item){
        items.add(item);
    }

    public boolean isEmpty(){
        return (items.size()==0);
    }

    public int size(){
        return items.size();
    }

    public void beforeFirst(){
        cursor=-1;
    }

    public boolean hasNext(){
        return (items.size()-1>cursor);

    }

    public Object next(){
        cursor++;
        return items.get(cursor);
    }

    public boolean contains(Object item){
      boolean result=false;
        for(Object i:items){
          if(i.equals(item)){
              result=true;
              break;
          }
      }
      return result;
    }
    public int getCursor(){
        return cursor;
    }


}

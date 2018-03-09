package methodstructure.pendrives;

import java.util.List;

public class Pendrives {
   private  List<Pendrive> pendrives;

   public Pendrive best(List<Pendrive> pendrives){
       Pendrive result=null;
       for (int i = 0; i <pendrives.size() ; i++) {
           for (int j = i+1; j <pendrives.size(); j++) {
               if(result==null|| pendrives.get(i).comparePricePerCapacity(pendrives.get(j))==-1){
                   result=pendrives.get(i);
               }
           }
       }
    return result;
   }

   public Pendrive cheapest(List<Pendrive> pendrives){
       Pendrive result=null;
       for (int i = 0; i <pendrives.size() ; i++) {
           for (int j =i+1; j <pendrives.size() ; j++) {
               if(result==null || pendrives.get(i).cheaperThan(pendrives.get(j))){
                   result=pendrives.get(i);
               }
           }

       }
       return result;
   }

   public void risePriceWhereCapacity(List<Pendrive> pendrives , int percent, int capacity){
       for(Pendrive pendrive:pendrives){
           if(pendrive.getCapacity()==capacity){
               pendrive.risePrice(percent);
           }
       }
   }

}



package immutable.satellite;

import java.util.ArrayList;
import java.util.List;

public class SpaceAgency {

    List<Satellite> satellites= new ArrayList<>();

    public void registerSatellite(Satellite satellite){
        if(satellite==null){throw new NullPointerException("Parameter must not be null!");}
        else{satellites.add(satellite);}
    }


    public Satellite findSatelliteByRegisterIdent(String registerIdent){
        Satellite result=null;

        for(Satellite satellite:satellites) {
            if (satellite.getRegisterIdent().equals(registerIdent)) {
                result = satellite;
            }
        }
            if(result==null){
                throw new IllegalArgumentException("Satellite with the given registration cannot be found!"); }
            else{return result;}
    }


    private boolean isEmpty(String str){
        boolean result=false;
        if(str==""){
            result=true;
        }
        return result;
    }

    @Override
    public String toString() {
        return satellites.toString();
    }
}

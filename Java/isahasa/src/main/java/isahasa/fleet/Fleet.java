package isahasa.fleet;

import java.util.ArrayList;
import java.util.List;

public class Fleet {
    List<Ship> ships= new ArrayList<>();
    private int waitingPersons;
    private int waitingCargo;


    public void addShip(Ship ship){
        ships.add(ship);
    }

    public void lift(int passengers, int cargoWeight){
        int tempCargo=cargoWeight;
        int tempPersons=passengers;


        for(Ship ship:ships){
            if(ship instanceof CanCarryGoods){
                tempCargo=((CanCarryGoods) ship).loadCargo(tempCargo);
                waitingCargo=tempCargo;
            }
            if(ship instanceof  CanCarryPassengers){
                tempPersons=((CanCarryPassengers) ship).loadPassenger(tempPersons);
                waitingPersons=tempPersons;
            }
        }
    }

    public int getWaitingPersons() {
        return waitingPersons;
    }

    public int getWaitingCargo() {
        return waitingCargo;
    }
}

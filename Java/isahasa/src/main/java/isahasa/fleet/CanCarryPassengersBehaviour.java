package isahasa.fleet;

public class CanCarryPassengersBehaviour implements CanCarryPassengers {
    private  int passengers;
    private  int maxPassengers;

    public CanCarryPassengersBehaviour(int maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    @Override
    public int loadPassenger(int passengers) {
        int result=passengers;

        if(maxPassengers<passengers){
            this.passengers=maxPassengers;
            result=passengers-maxPassengers;
        }else{
            this.passengers=passengers;
            result=0;
        }
        return result;
    }



    @Override
    public int getPassengers() {
        return passengers;
    }
}

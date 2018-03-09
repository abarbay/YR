package isahasa.fleet;

public class CanCarryGoodsBehaviour implements CanCarryGoods {
    private int cargoWeight;
    private int maxCargoWeight;


    public CanCarryGoodsBehaviour(int maxCargoWeight) {
        this.maxCargoWeight = maxCargoWeight;
    }

    @Override
    public int getCargoWeight() {
        return this.cargoWeight;
    }

    @Override
    public int loadCargo(int cargoWeight) {
        int result=cargoWeight;

        if(maxCargoWeight<cargoWeight){
            this.cargoWeight=maxCargoWeight;
            result=cargoWeight-maxCargoWeight;
        }else{
            this.cargoWeight=cargoWeight;
            result=0;
        }
        return result;
    }

}

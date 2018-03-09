package inheritancemethods.products;

import java.math.BigDecimal;

public class PackedProduct extends Product {
    private int packingUnit;
    private BigDecimal weightOfBox;

    public PackedProduct(String name, BigDecimal unitWeight, int numberOfDecimals, int packingUnit, BigDecimal weightOfBox) {
        super(name, unitWeight, numberOfDecimals);
        this.packingUnit = packingUnit;
        this.weightOfBox = weightOfBox;
    }


    public int getPackingUnit() {
        return packingUnit;
    }

    public BigDecimal getWeightOfBox() {
        return weightOfBox;
    }
    @Override
    public BigDecimal totalWeight(int pieces){
        int boxNeeded=0;
        if(pieces%packingUnit!=0){
            boxNeeded++;
        }
        boxNeeded=boxNeeded+ pieces/packingUnit;

        BigDecimal boxWeightsum= weightOfBox.multiply(new BigDecimal(boxNeeded)).setScale(super.getNumberOfDecimals());

        return boxWeightsum.add(super.getUnitWeight().multiply(new BigDecimal(pieces)).setScale(super.getNumberOfDecimals()));
    }

}

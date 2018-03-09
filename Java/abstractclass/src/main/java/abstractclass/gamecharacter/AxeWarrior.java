package abstractclass.gamecharacter;

import java.util.Random;

public class AxeWarrior extends Character {


    public AxeWarrior(Point position, Random rnd) {
        super(position, rnd);

    }

    private int getActualSecondaryDamage(){
        return Math.round(super.getRnd().nextInt(super.getActualPrimaryDamage()*2));
    }

    @Override
    public void secondaryAttack(Character enemy) {
        if(super.getPosition().distance(enemy.getPosition())<2){
            super.hit(enemy,this.getActualSecondaryDamage());
        }

    }
}

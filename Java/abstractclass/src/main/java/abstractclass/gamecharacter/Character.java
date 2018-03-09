package abstractclass.gamecharacter;

import java.util.Random;

public abstract class Character {
    private Point position;
    private int hitPoint;
    private Random rnd;

    public Character(Point position,Random rnd) {
        this.position = position;
        this.hitPoint = 100;
        this.rnd = rnd;
    }

    public Point getPosition() {
        return this.position;
    }

    public Random getRnd() {
        return rnd;
    }

    public int getHitPoint() {
        return hitPoint;
    }

    public boolean isAlive(){
        Boolean result=false;
        if(hitPoint>0){
            result=true;
        }
        return result;
    }
    protected int getActualPrimaryDamage(){
        return Math.round(rnd.nextInt(9)+1);
    }

    private int getActualDefence(){
        return Math.round(rnd.nextInt(5));
    }

    protected void hit(Character enemy, int damage){
        if(enemy.getActualDefence()<damage){
           enemy.decreaseHitpoint(damage);
        }
    }

    public void primaryAttack(Character enemy){
        this.hit(enemy,this.getActualPrimaryDamage());
    }

    private void decreaseHitpoint(int diff){
        hitPoint-=diff;
    }

    public abstract void secondaryAttack(Character enemy);



}

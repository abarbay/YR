package collectionsarraylist;

import java.util.*;

public class Lottery {

    public List<Integer> selectWinningNumbers(int lotteryType, int ballCount)throws IllegalArgumentException{
        if(lotteryType>=ballCount){throw new IllegalArgumentException("Balls must be more then the winning numbers!");}
        List<Integer>shufflingMachine= new ArrayList<>();
        for(int i=1;i<=ballCount;i++){
            shufflingMachine.add(i);
        }
        List<Integer>winningNumbers=new ArrayList<>();
        Collections.shuffle(shufflingMachine);
        while(winningNumbers.size()!=lotteryType){
            int ballNumber=new Random().nextInt(shufflingMachine.size()-1)+1;
            winningNumbers.add(ballNumber);
            shufflingMachine.remove(ballNumber);
            Collections.shuffle(shufflingMachine);
        }
        Collections.sort(winningNumbers);
        return winningNumbers;

    }


}

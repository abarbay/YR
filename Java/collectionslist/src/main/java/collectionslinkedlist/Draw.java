package collectionslinkedlist;

import java.util.*;

public class Draw {
    public Set<Integer> drawNumbers(int drawCount, int maxNumber) throws IllegalArgumentException {
        List<Integer> winningNumbers = new LinkedList<>();
        List<Integer> shufflingMachine = new LinkedList<>();

        if (drawCount>=maxNumber ) {
            throw new IllegalArgumentException("drawCount must be less");
        }


        for (int i = 1; i <= maxNumber; i++) {
            shufflingMachine.add(i);
        }
        Collections.shuffle(shufflingMachine);
        while (winningNumbers.size() != drawCount) {
            int ballNumber = new Random().nextInt(shufflingMachine.size() - 1) + 1;
            winningNumbers.add(ballNumber);
            shufflingMachine.remove(ballNumber);
            Collections.shuffle(shufflingMachine);
        }
        Queue<Integer> winningQueue = new PriorityQueue<>(winningNumbers);
        TreeSet<Integer> result= new TreeSet<>();

        while(winningQueue.peek()!=null){
            result.add(winningQueue.poll());
        }
        return result;
    }


}

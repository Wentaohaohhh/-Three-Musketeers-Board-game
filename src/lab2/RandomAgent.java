package lab2;

import java.util.List;
import java.util.Random;

public class RandomAgent extends Agent {

    public RandomAgent(Board board) {
        super(board);
    }

    /**
     * Gets a valid random move the RandomAgent can do.
     * @return a valid Move that the RandomAgent can perform on the Board
     */
    @Override
    public Move getMove() { // TODO
    	List<Cell> list1 = board.getPossibleCells();
    	Cell fromCell = list1.get(new Random().nextInt(list1.size()));
    	List<Cell> list2 = board.getPossibleDestinations(fromCell);
    	Cell toCell = list2.get(new Random().nextInt(list2.size()));
    	Move move = new Move(fromCell, toCell);
    	System.out.printf("[%s (Random Agent)] Moving piece %s to %s.", board.getTurn().getType(), fromCell.getCoordinate().toString(), toCell.getCoordinate().toString());
        return move;
    }
}

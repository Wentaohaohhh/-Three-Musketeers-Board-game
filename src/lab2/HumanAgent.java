package lab2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HumanAgent extends Agent {
	private final Scanner scanner = new Scanner(System.in);
    public HumanAgent(Board board) {
        super(board);
    }

    /**
     * Asks the human for a move with from and to coordinates and makes sure its valid.
     * Create a Move object with the chosen fromCell and toCell
     * @return the valid human inputted Move
     */
    @Override
    public Move getMove() { // TODO
    	List<Coordinate> fromList = new ArrayList<>();
    	for(int i = 0; i < board.getPossibleCells().size(); i++) {
    		fromList.add(board.getPossibleCells().get(i).getCoordinate());
    	}
    	Cell fromCell = getFromCell(fromList);
    	List<Coordinate> toList = new ArrayList<>();
    	for(int i = 0; i < board.getPossibleDestinations(fromCell).size(); i++) {
    		toList.add(board.getPossibleDestinations(fromCell).get(i).getCoordinate());
    		
    	}
    	
    	Cell toCell = getToCell(toList);
    	
    	Move move = new Move(fromCell, toCell);
        return move;
    }
    private Cell getFromCell(List<Coordinate> fromList) {
    	System.out.printf("[%s] Possible pieces are %s. Enter the piece you want to move:", board.getTurn().getType(), fromList);
    	String coor = scanner.next().toUpperCase();
    	for(int i = 0; i < fromList.size(); i++) {
			if( coor.equals(fromList.get(i).toString())) {
				Cell fromCell = board.getCell(fromList.get(i));
				return fromCell;
			}
		}
		System.out.printf("%s is invalid", coor);
    	return getFromCell(fromList);
    }
    private Cell getToCell(List<Coordinate> tolist) {
    	System.out.printf("[%s] Possible destinations are %s. Enter where you want to move:", board.getTurn().getType(), tolist);
    	String coor = scanner.next().toUpperCase();
    	for(int i = 0; i < tolist.size(); i++) {
			if( coor.equals(tolist.get(i).toString())) {
				Cell toCell = board.getCell(tolist.get(i));
				return toCell;
			}
		}
		System.out.printf("%s is an invalid destination.\n", coor);
    	return getToCell(tolist);
    }
}

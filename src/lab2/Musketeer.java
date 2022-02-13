package lab2;

public class Musketeer extends Piece {

    public Musketeer() {
        super("X", Type.MUSKETEER);
    }

    /**
     * Returns true if the Musketeer can move onto the given cell.
     * @param cell Cell to check if the Musketeer can move onto
     * @return True, if Musketeer can move onto given cell, false otherwise
     */
    @Override
    public boolean canMoveOnto(Cell cell) { // TODO
    	if(cell.hasPiece() && cell.getPiece().getType() == Type.GUARD) {
    		return true;
    	}
    	return false;
        
    }
}

package es.seatcode.mower.service;

import es.seatcode.mower.domain.Board;
import es.seatcode.mower.domain.Cell;
import es.seatcode.mower.domain.Position;

public interface BoardService {
	
	Board createBoard(Position upperRightCoordinates, Cell mower1, Cell mower2);
	
	void resolveMovement(Board board,Cell cellmower1 ,String movementMower1,Cell cellMower2 ,String movementMower2);

}

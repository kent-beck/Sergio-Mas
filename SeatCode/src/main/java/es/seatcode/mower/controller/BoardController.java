package es.seatcode.mower.controller;

import es.seatcode.mower.domain.Board;
import es.seatcode.mower.domain.Cell;
import es.seatcode.mower.domain.Position;

public interface BoardController {
	
	Board createBoard(Position upperRightCoordinates, Cell mower1, Cell mower2);
	
	void resolveMovement(Board board,Cell cellMower1 ,String movementMower1,Cell cellMower2 ,String movementMower2);
	
}

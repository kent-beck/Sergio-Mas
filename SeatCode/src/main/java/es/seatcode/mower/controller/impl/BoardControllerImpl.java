package es.seatcode.mower.controller.impl;

import es.seatcode.mower.controller.BoardController;
import es.seatcode.mower.domain.Board;
import es.seatcode.mower.domain.Cell;
import es.seatcode.mower.domain.Position;
import es.seatcode.mower.service.impl.BoardServiceImpl;


public class BoardControllerImpl implements BoardController {
	
	private BoardServiceImpl boardServiceImpl = new BoardServiceImpl();

	@Override
	public Board createBoard(Position upperRightCoordinates, Cell mower1, Cell mower2) {
		return boardServiceImpl.createBoard(upperRightCoordinates,mower1,mower2);
	}

	@Override
	public void resolveMovement(Board board,Cell cellmower1 ,String movementMower1,Cell cellMower2 ,String movementMower2) {
		boardServiceImpl.resolveMovement(board,cellmower1,movementMower1,cellMower2,movementMower2);
	}

	

}

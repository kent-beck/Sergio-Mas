
package es.seatcode.mower;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import es.seatcode.mower.controller.impl.BoardControllerImpl;
import es.seatcode.mower.domain.Board;
import es.seatcode.mower.domain.Cell;
import es.seatcode.mower.domain.Position;


public class Main {
		
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		System.out.println("***Welcome to the mower programme***");
		
		System.out.println("Enter the board coordinates: ");

		Position position;
		while (Objects.isNull(position=isValidCoordinates(scanner.nextLine())));
		
		boolean allDataOk = false;
		int count = 1;
		
		String movement;
		ArrayList<Cell> cells = new ArrayList<>();
		ArrayList<String> movements = new ArrayList<>();

		while (!allDataOk) {

			System.out.println("Starting position mower "+count);

			while (Objects.isNull(isValidCell(scanner.nextLine(),cells,position)));
			
			System.out.println("Mower movement "+count);

			while (Objects.isNull(movement=isValidMovement(scanner.nextLine())));
			movements.add(movement);

			allDataOk = count==2;		
			
			count++;

		}

		scanner.close();
		
		BoardControllerImpl boardControllerImpl = new BoardControllerImpl();
		Board board = boardControllerImpl.createBoard(position, cells.get(0), cells.get(1));
		boardControllerImpl.resolveMovement(board, cells.get(0), movements.get(0), cells.get(1), movements.get(1));

	}
	
	private static Position isValidCoordinates(String cadena) {
		if (!cadena.matches("[1-9]+[1-9]+")) {
			System.out.println("The coordinates are invalid. Example of use: [1-9] [1-9]");
			return null;
		}
		return Position.builder().coordinateX(Integer.parseInt(cadena.substring(0, 1))).coordinateY(Integer.parseInt(cadena.substring(1, 2))).build();
	}

	private static Cell isValidCell(String cadena,ArrayList<Cell> cells,Position position) {
		if (!cadena.matches("[0-9]+[0-9]+[N|E|S|W]")) {
			System.out.println("Mower position is invalid. Example of use: [0-9] [0-9] [N|E|S|W]");
			return null;
		}
		Cell cell = Cell.builder().busy(Boolean.TRUE).cardinalPoint(cadena.substring(2, 3)).position(Position.builder().coordinateX(Integer.parseInt(cadena.substring(0, 1))).coordinateY(Integer.parseInt(cadena.substring(1, 2))).build()).build();
		if (cells.contains(cell)) {
			System.out.println("Mower position entered, already exists. You must enter another position.");
			return null;
		}else {
			if ((Integer.parseInt(cadena.substring(0, 1))>position.getCoordinateX())){
				System.out.println("X-coordinate, out of range, must be less than or equal to "+position.getCoordinateX());
				return null;
			}
			if ((Integer.parseInt(cadena.substring(1, 2))>position.getCoordinateY())){
				System.out.println("Y-coordinate, out of range, must be less than or equal to "+position.getCoordinateY());
				return null;
			}
			cells.add(cell);
		}
		return cell;
	}

	private static String isValidMovement(String cadena) {
		if (!cadena.matches("[L|R|M]+")) {
			System.out.println("Mower movement is invalid. Example of use: [L|R|M]+");
			return null;
		}
		return cadena;
	}	

}


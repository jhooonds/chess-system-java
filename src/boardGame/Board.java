package boardGame;

public class Board {
	
	private int rows;
	private int collumns;
	private Piece[][] pieces;
	
	public Board(int rows, int collumns) {
		if(rows <1 || collumns < 1) {
				throw new BoardException("Error creating board: There must be  at least  1 row and 1 Collumn");
		}
		this.rows = rows;
		this.collumns = collumns;
		pieces = new Piece[rows][collumns];
	}

	public int getRows() {
		return rows;
	}

	public int getCollumns() {
		return collumns;
	}
	
	public Piece piece(int row, int collumn) {
		if(!positionExists(row, collumn)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[row][collumn];		
	}
	
	public Piece piece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[position.getRow()][position.getCollumn()];
	}
	
	
	public void PlacePiece(Piece piece, Position position) {
		if(thereIsAPiece(position)) {
			throw new BoardException("There is already a piece on position," + position);
		}
		pieces[position.getRow()][position.getCollumn()] = piece;		
		piece.position =  position;
	}
	
	private boolean positionExists(int row, int collumn) {
		return row >= 0 && row < rows && collumn >= 0 && collumn < collumns;
	}
	
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getCollumn());		
	}
	
	public boolean thereIsAPiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return piece(position) != null;
	}
	
	public  Piece removePiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board!");
		}
		if(piece(position) == null) {
			return null;
		}		
		Piece aux = piece(position);
		
		aux.position = null;
		pieces[position.getRow()][position.getCollumn()] = null;	
		return aux;
	}
	

}

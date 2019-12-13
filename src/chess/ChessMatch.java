package chess;

import boardGame.Board;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {
	private Board board;

	public ChessMatch() {
		board = new Board(8, 8);
		initialSetup();
	}
	
	public ChessPiece[][] getPieces() {
	 ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getCollumns()];
	 for(int i = 0; i<board.getRows(); i++) {
		 for(int j=0; j<board.getCollumns(); j++) {
			 mat[i][j] = (ChessPiece) board.piece(i,j);
		 }
	 }
	 return mat;
		
	}
	
	private void PlaceNewPiece(char collumn, int row, ChessPiece piece) {
		board.PlacePiece(piece, new ChessPosition(collumn, row).toPosition());
	}
	
	private void initialSetup() {
		PlaceNewPiece('b', 6, new Rook(board, Color.WHITE));
		PlaceNewPiece('e', 8, new King(board, Color.BLACK));
		PlaceNewPiece('e', 1, new King(board, Color.WHITE));
	}

}

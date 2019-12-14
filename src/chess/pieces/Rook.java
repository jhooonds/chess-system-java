package chess.pieces;

import boardGame.Board;
import boardGame.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece {

	public Rook(Board board, Color color) {
		super(board, color);		
	}
	
	
	@Override
	public String toString() {
		return "R";
	}


	@Override
	public boolean[][] possibleMoves() {
		boolean [][] mat = new boolean[getBoard().getRows()][getBoard().getCollumns()];
		
		Position p = new Position(0, 0);
		
		//Above  Piece
		p.setValues(position.getRow() -1, position.getCollumn());
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getCollumn()] = true;
			p.setRow(p.getRow() -1);			
		}
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getCollumn()] = true;
		}
		
		//left Piece
		p.setValues(position.getRow(), position.getCollumn() -1);
			while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getCollumn()] = true;
				p.setCollumn(p.getCollumn() - 1);
			}
			
			if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getCollumn()] = true;
			}
			
			//Right Piece
			p.setValues(position.getRow(), position.getCollumn() + 1);
				while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
					mat[p.getRow()][p.getCollumn()] = true;
					p.setCollumn(p.getCollumn() + 1);
				}
				if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
					mat[p.getRow()][p.getCollumn()] = true;
				}
				
				//Below Piece
				p.setValues(position.getRow() + 1, position.getCollumn());
					while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
						mat[p.getRow()][p.getCollumn()] = true;
						p.setRow(p.getRow() + 1);
					}
					if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
						mat[p.getRow()][p.getCollumn()] = true;
					}   	
		
		
		return mat;
	}
	
	
	

}

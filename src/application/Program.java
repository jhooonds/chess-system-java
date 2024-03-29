package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {

		ChessMatch ch = new ChessMatch();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			try {
				UI.clearScreen();
				UI.printBoard(ch.getPieces());
				System.out.println();
				System.out.print("Print Source");
				ChessPosition source = UI.readChessPosition(sc);
				
				boolean[][] possibleMoves = ch.possibleMoves(source);
				UI.clearScreen();
				UI.printBoard(ch.getPieces(), possibleMoves);
				
				System.out.println();
				System.out.print("Target: ");
				ChessPosition target = UI.readChessPosition(sc);
				
				ChessPiece capturedPiece = ch.performChessMove(source, target);
			}
			catch (ChessException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}
		

	}

}

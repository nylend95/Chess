package no.nylend.api.chess;

import no.nylend.api.chess.pieces.PieceColor;

import java.util.ArrayList;
import java.util.List;

public class Game {
	private Board board;
	private PieceColor turn = PieceColor.WHITE;
	private boolean whiteCastle = false;
	private boolean blackCastle = false;

	public Game() {
		this(new Board());
	}

	public Game(Board board){
		this.board = board;
		this.reset();
	}

	public void reset(){
		this.board = new Board();
		whiteCastle = false;
		blackCastle = false;
	}



	public List<String> getAvailableActions(){
		// TODO should probably not be String
		return new ArrayList<>();
	}

	public List<String> getAvailableBlackActions(){
		// TODO should probably not be String
		return new ArrayList<>();
	}

	public List<String> getAvailableWhiteActions(){
		// TODO should probably not be String
		return new ArrayList<>();
	}

	private void switchTurn(){
		turn = (turn == PieceColor.WHITE) ? PieceColor.BLACK : PieceColor.WHITE;
	}


}

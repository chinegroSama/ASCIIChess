package neumont;

public class Board
{
	private Piece boardSetup[][];

	public Board()
	{
		this.boardSetup = new Piece[8][8];
		boardSetup[0][0] = new Piece(PieceType.WROOK);
		boardSetup[0][1] = new Piece(PieceType.WKNIGHT);
		boardSetup[0][2] = new Piece(PieceType.WBISHOP);
		boardSetup[0][3] = new Piece(PieceType.WQUEEN);
		boardSetup[0][4] = new Piece(PieceType.WKING);
		boardSetup[0][5] = new Piece(PieceType.WBISHOP);
		boardSetup[0][6] = new Piece(PieceType.WKNIGHT);
		boardSetup[0][7] = new Piece(PieceType.WROOK);
		boardSetup[1][0] = new Piece(PieceType.WPAWN);
		boardSetup[1][1] = new Piece(PieceType.WPAWN);
		boardSetup[1][2] = new Piece(PieceType.WPAWN);
		boardSetup[1][3] = new Piece(PieceType.WPAWN);
		boardSetup[1][4] = new Piece(PieceType.WPAWN);
		boardSetup[1][5] = new Piece(PieceType.WPAWN);
		boardSetup[1][6] = new Piece(PieceType.WPAWN);
		boardSetup[1][7] = new Piece(PieceType.WPAWN);

		for (int y = 2; y <= 5; y++)
			for (int x = 0; x < 8; x++)
				boardSetup[y][x] = new Piece(PieceType.NOPIECE);

		boardSetup[7][0] = new Piece(PieceType.BROOK);
		boardSetup[7][1] = new Piece(PieceType.BKNIGHT);
		boardSetup[7][2] = new Piece(PieceType.BBISHOP);
		boardSetup[7][3] = new Piece(PieceType.BQUEEN);
		boardSetup[7][4] = new Piece(PieceType.BKING);
		boardSetup[7][5] = new Piece(PieceType.BBISHOP);
		boardSetup[7][6] = new Piece(PieceType.BKNIGHT);
		boardSetup[7][7] = new Piece(PieceType.BROOK);
		boardSetup[6][0] = new Piece(PieceType.BPAWN);
		boardSetup[6][1] = new Piece(PieceType.BPAWN);
		boardSetup[6][2] = new Piece(PieceType.BPAWN);
		boardSetup[6][3] = new Piece(PieceType.BPAWN);
		boardSetup[6][4] = new Piece(PieceType.BPAWN);
		boardSetup[6][5] = new Piece(PieceType.BPAWN);
		boardSetup[6][6] = new Piece(PieceType.BPAWN);
		boardSetup[6][7] = new Piece(PieceType.BPAWN);

		for (int y = 0; y < 8; y++)
			for (int x = 0; x < 8; x++)
			{
				if (boardSetup[y][x].getType() == PieceType.WPAWN)
					boardSetup[y][x].setPicture("WPN");
				else if (boardSetup[y][x].getType() == PieceType.WROOK)
					boardSetup[y][x].setPicture("WRK");
				else if (boardSetup[y][x].getType() == PieceType.WBISHOP)
					boardSetup[y][x].setPicture("WBP");
				else if (boardSetup[y][x].getType() == PieceType.WKNIGHT)
					boardSetup[y][x].setPicture("WKT");
				else if (boardSetup[y][x].getType() == PieceType.WQUEEN)
					boardSetup[y][x].setPicture("WQN");
				else if (boardSetup[y][x].getType() == PieceType.WKING)
					boardSetup[y][x].setPicture("WKG");
				else if (boardSetup[y][x].getType() == PieceType.BPAWN)
					boardSetup[y][x].setPicture("BPN");
				else if (boardSetup[y][x].getType() == PieceType.BROOK)
					boardSetup[y][x].setPicture("BRK");
				else if (boardSetup[y][x].getType() == PieceType.BBISHOP)
					boardSetup[y][x].setPicture("BBP");
				else if (boardSetup[y][x].getType() == PieceType.BKNIGHT)
					boardSetup[y][x].setPicture("BKT");
				else if (boardSetup[y][x].getType() == PieceType.BQUEEN)
					boardSetup[y][x].setPicture("BQN");
				else if (boardSetup[y][x].getType() == PieceType.BKING)
					boardSetup[y][x].setPicture("BKG");
				else
					boardSetup[y][x].setPicture(" ");
			}
	}

	// allows piece to move on the board
	public void movePiece(String boardPosition, String newPosition)
	{
		
		// with letterSideInitial and letterSideNew the input should be something like (a7) 
		// so splitting it into the letter and into the number, then converting them all to
		// int to be able to manipulate the position on the 2d array
		
		String letterSideInitial = boardPosition.substring(0, 1).trim();
		String letterSideNew = newPosition.substring(0, 1).trim();
		int initialX = 0;
		int initialY = Integer.parseInt(boardPosition.substring(1).trim());
		int newX = 0;
		int newY = Integer.parseInt(newPosition.substring(1).trim());
		
		switch(letterSideInitial)
		{
			case "a":
				initialX = 0;
				break;
			case "b":
				initialX = 1;
				break;
			case "c":
				initialX = 2;
				break;
			case "d":
				initialX = 3;
				break;
			case "e":
				initialX = 4;
				break;
			case "f":
				initialX = 5;
				break;
			case "g":
				initialX = 6;
				break;
			case "h":
				initialX = 7;
				break;
		}
		
		switch(letterSideNew)
		{
			case "a":
				newX = 0;
				break;
			case "b":
				newX = 1;
				break;
			case "c":
				newX = 2;
				break;
			case "d":
				newX = 3;
				break;
			case "e":
				newX = 4;
				break;
			case "f":
				newX = 5;
				break;
			case "g":
				newX = 6;
				break;
			case "h":
				newX = 7;
				break;
		}
		
		// these 2 lines actually change the position to move to to the old piece
		// and the original position with a NOPIECE
		
				this.boardSetup[newY][newX].setPiece(this.boardSetup[initialY][initialX]);
				this.boardSetup[initialY][initialX].setType(PieceType.NOPIECE);
				
		
		//test and modulate the castling and isolation
		//of the checkmate and check application between methods
	}

	// this method draws the chess board with all the pieces.
	public boolean hasPiece(PieceType pieceType)
	{
		if (pieceType.equals(PieceType.NOPIECE))
			return false;
		else
			return true;
	}

	public void draw()
	{
		System.out.println("  +---+---+---+---+---+---+---+---+");
		for (int y = 0; y < 8; y++)
		{
			System.out.print(y + " |");
			for (int x = 0; x < 8; x++)
			{
				System.out.printf("%3s|", boardSetup[y][x].getPicture());
			}
			System.out.println();
			System.out.println("  +---+---+---+---+---+---+---+---+");
		}
		System.out.println("  + A + B + C + D + E + F + G + H +");
	}

	// this method is to draw the board with the pieces alloted moves.
	public void draw(Piece piece)
	{
		//boardSetup[x][y+1].setType = boardSetup[x][y].getType();
	}

}

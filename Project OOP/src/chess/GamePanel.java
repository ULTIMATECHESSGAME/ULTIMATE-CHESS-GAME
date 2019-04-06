package chess;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GamePanel extends JPanel {

	private Vector<Player> playerList = new Vector<Player>();
	private final int BLOCK = 8;
	private final int SIZE = 500 / 8;
	private Point click = null;
	private final Rectangle BOUND = new Rectangle(0, 0, 500, 500);
	private Color colorTurn;
	private MouseListener mouseListener = new MouseListener() {

		@Override
		public void mouseReleased(MouseEvent arg0) {
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			Point current = e.getPoint();
			// memeriksa apakah kotak yang dipilih berada didalam papan catur
			if (BOUND.contains(current)) {
				Point select = new Point(current.x / SIZE, current.y / SIZE);
				// validasi giliran jalan pemain
				for (Player player : playerList) {
					if (click != null)
						break;
					for (Bidak bidak : player.getBidakList()) {
						if (bidak.getPoint().equals(select) && !bidak.getColor().equals(colorTurn)) {
							System.out.println(false);
							return;
						}
					}
				}

				if (click == null) {// memilih bidak
					click = select;
				} else {
					if (click.equals(select)) {
						click = null;
					} else {

						// menempatkan bidak di posisi yang baru
						for (Player player : playerList) {
							for (Bidak bidak : player.getBidakList()) {
								if (bidak.getPoint().equals(click) && bidak.legalMove(select)) {
									
										ValidasiMap.map[select.y][select.x] = ValidasiMap.map[click.y][click.x];
										ValidasiMap.map[click.y][click.x] = null;

									bidak.setPoint(select);
									// mengganti giliran jalan
									if (colorTurn == Color.WHITE)
										colorTurn = Color.BLACK;
									else
										colorTurn = Color.WHITE;
									break;
								}
							}
						}
						for (int i = 0; i < 8; i++) {
							for (int j = 0; j < 8; j++) {
								try {
									System.out.printf("%d-%d|",ValidasiMap.map[i][j].getPoint().x,
											ValidasiMap.map[i][j].getPoint().y);
								} catch (Exception e2) {
									
								}

							}
							System.out.println("");
						}
						click = null;
					}
				}
			}
			repaint();

		}
	};

	public GamePanel() {
		// TODO Auto-generated constructor stub
		initial();
		addMouseListener(mouseListener);
		colorTurn = Color.WHITE;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				try {
					if (ValidasiMap.map[i][j].equals(null))
						System.out.println(" ");
				} catch (Exception e) {
					System.out.println(" ");
					break;
				}
				System.out.printf("%s", ValidasiMap.map[i][j].getName());
			}
			System.out.println("");
		}

	}

	public void initial() {
		Player a = new Player();
		Player b = new Player();
		Bidak kingWhite = new King(new Point(4, 7), "KingW", Color.WHITE, true, new ImageIcon("whiteKing.png"));
		Bidak queenWhite = new Queen(new Point(3, 7), "QuenW", Color.WHITE, true, new ImageIcon("WhiteQueen.png"));
		Bidak KnightWhite = new Knight(new Point(1, 7), "KnightW", Color.WHITE, true, new ImageIcon("WhiteKnight.png"));
		Bidak KnightWhite2 = new Knight(new Point(6, 7), "KnightW", Color.WHITE, true,
				new ImageIcon("WhiteKnight.png"));
		Bidak rookWhite = new Rook(new Point(0, 7), "RookW", Color.WHITE, true, new ImageIcon("WhiteRook.png"));
		Bidak rookWhite2 = new Rook(new Point(7, 7), "RookW", Color.WHITE, true, new ImageIcon("WhiteRook.png"));
		Bidak bishopWhite = new Bishop(new Point(2, 7), "BishopW", Color.WHITE, true, new ImageIcon("WhiteBishop.png"));
		Bidak bishopWhite2 = new Bishop(new Point(5, 7), "BishopW", Color.WHITE, true,
				new ImageIcon("WhiteBishop.png"));
		Bidak pawnWhite = new Pawn(new Point(0, 6), "PawnW", Color.WHITE, true, new ImageIcon("WhitePawn.png"));
		Bidak pawnWhite2 = new Pawn(new Point(1, 6), "PawnW", Color.WHITE, true, new ImageIcon("WhitePawn.png"));
		Bidak pawnWhite3 = new Pawn(new Point(2, 6), "PawnW", Color.WHITE, true, new ImageIcon("WhitePawn.png"));
		Bidak pawnWhite4 = new Pawn(new Point(3, 6), "PawnW", Color.WHITE, true, new ImageIcon("WhitePawn.png"));
		Bidak pawnWhite5 = new Pawn(new Point(4, 6), "PawnW", Color.WHITE, true, new ImageIcon("WhitePawn.png"));
		Bidak pawnWhite6 = new Pawn(new Point(5, 6), "PawnW", Color.WHITE, true, new ImageIcon("WhitePawn.png"));
		Bidak pawnWhite7 = new Pawn(new Point(6, 6), "PawnW", Color.WHITE, true, new ImageIcon("WhitePawn.png"));
		Bidak pawnWhite8 = new Pawn(new Point(7, 6), "PawnW", Color.WHITE, true, new ImageIcon("WhitePawn.png"));
		Bidak kingBlack = new King(new Point(4, 0), "KingB", Color.BLACK, true, new ImageIcon("blackKing.png"));
		Bidak queenBlack = new Queen(new Point(3, 0), "QuenB", Color.BLACK, true, new ImageIcon("blackQueen.png"));
		Bidak KnightBlack = new Knight(new Point(1, 0), "KnightB", Color.BLACK, true, new ImageIcon("blackKnight.png"));
		Bidak KnightBlack2 = new Knight(new Point(6, 0), "KnightB", Color.BLACK, true,
				new ImageIcon("blackKnight.png"));
		Bidak rookBlack = new Rook(new Point(0, 0), "RookB", Color.BLACK, true, new ImageIcon("blackRook.png"));
		Bidak rookBlack2 = new Rook(new Point(7, 0), "RookB", Color.BLACK, true, new ImageIcon("blackRook.png"));
		Bidak bishopBlack = new Bishop(new Point(2, 0), "BishopB", Color.BLACK, true, new ImageIcon("blackBishop.png"));
		Bidak bishopBlack2 = new Bishop(new Point(5, 0), "BishopB", Color.BLACK, true,
				new ImageIcon("blackBishop.png"));
		Bidak pawnBlack = new Pawn(new Point(0, 1), "PawnB", Color.BLACK, true, new ImageIcon("blackPawn.png"));
		Bidak pawnBlack2 = new Pawn(new Point(1, 1), "PawnB", Color.BLACK, true, new ImageIcon("blackPawn.png"));
		Bidak pawnBlack3 = new Pawn(new Point(2, 1), "PawnB", Color.BLACK, true, new ImageIcon("blackPawn.png"));
		Bidak pawnBlack4 = new Pawn(new Point(3, 1), "PawnB", Color.BLACK, true, new ImageIcon("blackPawn.png"));
		Bidak pawnBlack5 = new Pawn(new Point(4, 1), "PawnB", Color.BLACK, true, new ImageIcon("blackPawn.png"));
		Bidak pawnBlack6 = new Pawn(new Point(5, 1), "PawnB", Color.BLACK, true, new ImageIcon("blackPawn.png"));
		Bidak pawnBlack7 = new Pawn(new Point(6, 1), "PawnB", Color.BLACK, true, new ImageIcon("blackPawn.png"));
		Bidak pawnBlack8 = new Pawn(new Point(7, 1), "PawnB", Color.black, true, new ImageIcon("blackPawn.png"));
		a.getBidakList().add(kingWhite);
		a.getBidakList().add(queenWhite);
		a.getBidakList().add(KnightWhite);
		a.getBidakList().add(KnightWhite2);
		a.getBidakList().add(rookWhite);
		a.getBidakList().add(rookWhite2);
		a.getBidakList().add(bishopWhite);
		a.getBidakList().add(bishopWhite2);
		a.getBidakList().add(pawnWhite);
		a.getBidakList().add(pawnWhite2);
		a.getBidakList().add(pawnWhite3);
		a.getBidakList().add(pawnWhite4);
		a.getBidakList().add(pawnWhite5);
		a.getBidakList().add(pawnWhite6);
		a.getBidakList().add(pawnWhite7);
		a.getBidakList().add(pawnWhite8);

		playerList.add(a);
		b.getBidakList().add(kingBlack);
		b.getBidakList().add(queenBlack);
		b.getBidakList().add(KnightBlack);
		b.getBidakList().add(KnightBlack2);
		b.getBidakList().add(rookBlack);
		b.getBidakList().add(rookBlack2);
		b.getBidakList().add(bishopBlack);
		b.getBidakList().add(bishopBlack2);
		b.getBidakList().add(pawnBlack);
		b.getBidakList().add(pawnBlack2);
		b.getBidakList().add(pawnBlack3);
		b.getBidakList().add(pawnBlack4);
		b.getBidakList().add(pawnBlack5);
		b.getBidakList().add(pawnBlack6);
		b.getBidakList().add(pawnBlack7);
		b.getBidakList().add(pawnBlack8);

		playerList.add(b);
		ValidasiMap.map[0][0] = rookBlack;
		ValidasiMap.map[0][1] = KnightBlack;
		ValidasiMap.map[0][2] = bishopBlack;
		ValidasiMap.map[0][3] = queenBlack;
		ValidasiMap.map[0][4] = kingBlack;
		ValidasiMap.map[0][5] = bishopBlack2;
		ValidasiMap.map[0][6] = KnightBlack2;
		ValidasiMap.map[0][7] = rookBlack2;
		ValidasiMap.map[1][0] = pawnBlack;
		ValidasiMap.map[1][1] = pawnBlack2;
		ValidasiMap.map[1][2] = pawnBlack3;
		ValidasiMap.map[1][3] = pawnBlack4;
		ValidasiMap.map[1][4] = pawnBlack5;
		ValidasiMap.map[1][5] = pawnBlack6;
		ValidasiMap.map[1][6] = pawnBlack7;
		ValidasiMap.map[1][7] = pawnBlack8;
		ValidasiMap.map[7][0] = rookWhite;
		ValidasiMap.map[7][1] = KnightWhite;
		ValidasiMap.map[7][2] = bishopWhite;
		ValidasiMap.map[7][3] = queenWhite;
		ValidasiMap.map[7][4] = kingWhite;
		ValidasiMap.map[7][5] = bishopWhite2;
		ValidasiMap.map[7][6] = KnightWhite2;
		ValidasiMap.map[7][7] = rookWhite2;
		ValidasiMap.map[6][0] = pawnWhite;
		ValidasiMap.map[6][1] = pawnWhite2;
		ValidasiMap.map[6][2] = pawnWhite3;
		ValidasiMap.map[6][3] = pawnWhite4;
		ValidasiMap.map[6][4] = pawnWhite5;
		ValidasiMap.map[6][5] = pawnWhite6;
		ValidasiMap.map[6][6] = pawnWhite7;
		ValidasiMap.map[6][7] = pawnWhite8;

	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		for (int i = 0; i < BLOCK; i++) {
			for (int j = 0; j < BLOCK; j++) {
				if ((i + j) % 2 == 0) {
					g.setColor(Color.white);
				} else {
					g.setColor(Color.DARK_GRAY);
				}
				if (click != null && click.equals(new Point(i, j))) {
					g.setColor(Color.RED);
				}
				g.fillRect(i * SIZE, j * SIZE, SIZE, SIZE);

			}
		}
		for (int i = 0; i < BLOCK; i++) {
			for (int j = 0; j < BLOCK; j++) {
				try {
					if (ValidasiMap.map[i][j].isActive()) {
						g.drawImage(ValidasiMap.map[i][j].getImg().getImage(),
								ValidasiMap.map[i][j].getPoint().x * SIZE, ValidasiMap.map[i][j].getPoint().y * SIZE,
								SIZE, SIZE, null);
					}
				} catch (Exception e) {

				}
			}
		}
	}
}

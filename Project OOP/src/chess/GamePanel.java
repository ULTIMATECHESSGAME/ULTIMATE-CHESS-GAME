package chess;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import org.omg.CORBA.PRIVATE_MEMBER;

import resource.Picture;
import resource.StopWatch;

public class GamePanel extends JPanel {

	private final int resize = 720 / 8;
	private Vector<Player> playerList = new Vector<Player>();
	private final int BLOCK = 8;
	private final int SIZE = 500 / 8;
	private Point click = null;
	private final Rectangle BOUND = new Rectangle(resize, resize, 500, 500);
	private Color colorTurn;
	private Double player1Time = 0.0;
	private Double player2Time = 0.0;
	private Double time = 0.0;
	private Long timeDisplayMinute = (long) 0;
	private Long timeDisplaySecond = (long) 0;
	private Long timeDisplay2Minute = (long) 0;
	private Long timeDisplay2Second = (long) 0;
	private long start = 0;
	private long stop = 0;
	private boolean flag = false;

	public double elapsedTime() {
		stop = System.currentTimeMillis();
		setTime();
		return (stop - start) / 1000.0;
	}

	private void setTime() {
		time += (stop - start) / 1000.0;
		flag = false;
	}

	public void startTime() {
		start = System.currentTimeMillis();
		flag = true;
	}

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
				Point select = new Point((current.x - resize) / SIZE, (current.y - resize) / SIZE);
				// validasi giliran jalan pemain
				try {
					if (!ValidasiMap.map[select.y][select.x].getColor().equals(colorTurn) && click == null) {
						System.out.println(false);
						return;

					}
				} catch (Exception e1) {

				}

				if (click == null) {// memilih bidak
					click = select;
				} else {
					if (click.equals(select)) {
						click = null;
					} else {

						try {
							if (ValidasiMap.map[click.y][click.x].legalMove(select, click)) {// validasi legal move

								for (Player player : playerList) {
									if (!player.getPlayerColor().equals(colorTurn)
											&& ValidasiMap.map[select.y][select.x] != null)// memindahkan pion yang
																							// dimakan
										player.getBidakList().add(ValidasiMap.map[select.y][select.x]);
								}
								elapsedTime();
								ValidasiMap.map[select.y][select.x] = ValidasiMap.map[click.y][click.x];
								ValidasiMap.map[select.y][select.x].setPoint(select);
								ValidasiMap.map[select.y][select.x].setStep(+1);
								
								ValidasiMap.map[click.y][click.x] = null;// menghapus pion yang dimakan dari array 2d
								// mengganti giliran jalan
								if (colorTurn == Color.WHITE) {
									colorTurn = Color.BLACK;
									player1Time += elapsedTime();
									startTime();
								} else {
									colorTurn = Color.WHITE;
									player2Time += elapsedTime();
									startTime();
								}
							}
						} catch (Exception r) {

						}
						// untuk debug di console
						consoleDebug();
						click = null;
					}
				}
			}
			repaint();

		}
	};

	public void consoleDebug() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				try {
					if (ValidasiMap.map[i][j] != null)
						System.out.printf("%5s|", ValidasiMap.map[i][j].getName());
					else
						System.out.printf("  null");
				} catch (Exception e2) {

				}

			}
			System.out.println("");
		}
		for (Player player : playerList) {
			for (Bidak bidak : player.getBidakList()) {
				if (bidak == null)
					break;
				System.out.println(bidak.getName());
			}
		}
	}

	public GamePanel() {
		// TODO Auto-generated constructor stub
		initial();
		addMouseListener(mouseListener);
		colorTurn = Color.WHITE;
		consoleDebug();
		startTime();
		th.start();
	}

	public void initial() {
		Player a = new Player(Color.WHITE);
		Player b = new Player(Color.BLACK);
		Bidak kingWhite = new King(new Point(4, 7), "KingW", Color.WHITE, true, new ImageIcon("rajaPutih.png"));
		Bidak queenWhite = new Queen(new Point(3, 7), "QuenW", Color.WHITE, true, new ImageIcon("menteriPutih.png"));
		Bidak KnightWhite = new Knight(new Point(1, 7), "KnightW", Color.WHITE, true, new ImageIcon("kudaPutih.png"));
		Bidak KnightWhite2 = new Knight(new Point(6, 7), "KnightW", Color.WHITE, true,
				new ImageIcon("kudaPutih.png"));
		Bidak rookWhite = new Rook(new Point(0, 7), "RookW", Color.WHITE, true, new ImageIcon("bentengPutih.png"));
		Bidak rookWhite2 = new Rook(new Point(7, 7), "RookW", Color.WHITE, true, new ImageIcon("bentengPutih.png"));
		Bidak bishopWhite = new Bishop(new Point(2, 7), "BishopW", Color.WHITE, true, new ImageIcon("seluncur.png"));
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
		Bidak rookBlack = new Rook(new Point(0, 0), "RookB", Color.BLACK, true, new ImageIcon("benteng.png"));
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
		playerList.add(a);
		playerList.add(b);
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				ValidasiMap.map[i][j] = null;
			}
		}
		
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

//		g.drawImage(Picture.getBg().getImage(), 0, 0, 1360, 720, null);
//		g.drawImage(Picture.getTable().getImage(), resize -40 , resize-40 , 580, 580, null);
		for (int i = 0; i < BLOCK; i++) {
			for (int j = 0; j < BLOCK; j++) {

				if (click != null && click.equals(new Point(j, i))) {
					ValidasiMap.map[i][j].predictedMove(g, ValidasiMap.map[i][j].getPoint());
				}

				if (ValidasiMap.map[i][j] != null) {
					g.drawImage(ValidasiMap.map[i][j].getImg().getImage(),
							ValidasiMap.map[i][j].getPoint().x * SIZE + resize,
							ValidasiMap.map[i][j].getPoint().y * SIZE + resize, SIZE, SIZE, null);
				}
			}
		}
	
		if (flag && colorTurn.equals(Color.WHITE)) {
			timeDisplayMinute = TimeUnit.SECONDS.toMinutes((long) (player1Time + ((System.currentTimeMillis() - start) / 1000.0)));
			timeDisplaySecond = (long) (player1Time + ((System.currentTimeMillis() - start) / 1000.0)) % 60;

		} else {
			timeDisplay2Minute = TimeUnit.SECONDS.toMinutes((long) (player2Time + ((System.currentTimeMillis() - start) / 1000.0)));
			timeDisplay2Second = (long) (player2Time + ((System.currentTimeMillis() - start) / 1000.0)) % 60;
		}
		g.setFont(Font.getFont(TOOL_TIP_TEXT_KEY));
		g.setColor(Color.BLACK);
		g.drawString(timeDisplayMinute.toString() + " : " + timeDisplaySecond.toString(), 700, 600);
		g.drawString(timeDisplay2Minute.toString() + " : " + timeDisplay2Second.toString(), 700, 100);
		g.drawImage(Picture.getNumber().getImage(), 700, 400, 100, 100, null);
		int count = 40, count2 = 40;
		for (Player player : playerList) {
			for (Bidak bidak : player.getBidakList()) {
				if (bidak == null)
					break;
				if (player.getPlayerColor().equals(Color.BLACK)) {
//					g.drawImage(new ImageIcon("Shadow.png").getImage(), count + 10, 30, SIZE - 20, SIZE -20, null);
					g.drawImage(bidak.getImg().getImage(), count, 620, SIZE, SIZE, null);
					count += 40;
				} else {
//					g.drawImage(new ImageIcon("Shadow.png").getImage(), count + 10, 650, SIZE, SIZE, null);
					g.drawImage(bidak.getImg().getImage(), count2, 0, SIZE, SIZE, null);
					count2 += 40;
				}
			}

		}

	}

	Thread th = new Thread(() -> {
		while (true) {

			try {
				if (flag) {
					repaint();
				}
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	});

}

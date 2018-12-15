package FourInArowPCK;
import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private int BOARD_WIDTH = 1024;
    private int BOARD_HEIGHT = 768;
    private final int ROWS = 7;
    private final int COLS = 6;
    private int[][] cells;
    private int grid[];
    private int width;
    private int height;
    private int turn;
    private int draw;

    public GamePanel(){
        this.cells = new int[ROWS][COLS];
        this.grid = new int[ROWS];
        this.width = BOARD_WIDTH / (ROWS + 1);
        this.height = BOARD_HEIGHT / (COLS + 1);
        this.turn = 0;
        this.draw = 0;
        for (int i = 0; i < ROWS; i++) {
            grid[i] = COLS - 1;
        }
    }

    public int getBOARD_WIDTH() {
        return BOARD_WIDTH;
    }

    public int getBOARD_HEIGHT() {
        return BOARD_HEIGHT;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setBOARD_WIDTH(int BOARD_WIDTH) {
        this.BOARD_WIDTH = BOARD_WIDTH;
    }

    public void setBOARD_HEIGHT(int BOARD_HEIGHT) {
        this.BOARD_HEIGHT = BOARD_HEIGHT;
    }

    public int getROWS() {
        return ROWS;
    }

    public int getCOLS() {
        return COLS;
    }

    // Creating a method to make the color and shape of each token.
    public void paintComponent(Graphics g2) {
        // Made object Graphics2D to create GUI.
        Graphics2D g = (Graphics2D) g2;
        // Setting the "Stroke" changes the thickness of each line on the board
        // Double for-loop to check if each slot of the board is filled and
        // creates the board with ovals and rectangles.
        // 0 = dark gray = empty slot
        // 1 = pink = Player 1
        // 2 = green = Player 2
        g.clearRect(0, 0, BOARD_WIDTH, BOARD_HEIGHT);
        g.setStroke(new BasicStroke(4));
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (cells[i][j] != 0) {
                    if (cells[i][j] == 1)
                        g.setColor(Color.PINK);
                    else if (cells[i][j] == 2)
                        g.setColor(Color.GREEN);
                    g.fillOval(width * i, height * j, width, height);
                }
                g.setColor(Color.DARK_GRAY);
                g.drawOval(width * i, height * j, width, height);
                g.drawRect(width * i, height * j, width, height);
            }
        }
    }

    /**
     * @param player
     * @param X
     * @param Y
     * Created getWinner method to check if there are four tokens in a row,
     * Vertically, horizontally, or diagonally
     */

    public void getWinner(int player, int X, int Y) {
        // If any of these methods return true then it will display the winner
        if (getAcross(X, Y, player) || getUp(X, Y, player) || getTopL(X, Y, player) || getTopR(X, Y, player)) {
            // This pops up a message window saying who the winner is
            JOptionPane.showMessageDialog(null, "Player " + player + " Wins!");
        }

    }


    /**
     * @param x
     * @param y
     * @param pl
     * @return Method to check if there are four tokens in a row horizontally
     */
    
    public boolean getAcross(int x, int y, int pl) {
        while (x - 1 >= 0) {
            if (cells[x - 1][y] == pl)
                x--;
            else
                break;
        }
        int counter = 0;
        while (true) {
            if (cells[x][y] == pl) {
                counter++;
                x++;
            } else
                break;
            if (counter == 4)
                return true;
            if (x >= ROWS)
                return false;
        }
        return false;
    }

    /**
     * @param x
     * @param y
     * @param pl
     * @return Method to check if there are four tokens in a row vertically
     */
    
    public boolean getUp(int x, int y, int pl) {
        while (y + 1 < COLS) {
            if (cells[x][y + 1] == pl)
                y++;
            else
                break;
        }
        int counter = 0;
        while (true) {
            if (cells[x][y] == pl) {
                counter++;
                y--;
            } else
                break;
            if (counter == 4)
                return true;
            if (y < 0)
                return false;
        }
        return false;
    }

    // Method to check if there are four tokens in a row diagonally to the
    // top-left
    public boolean getTopL(int x, int y, int pl) {
        while (x + 1 < ROWS && y + 1 < COLS) {
            if (cells[x + 1][y + 1] == pl) {
                x++;
                y++;
            } else
                break;
        }
        int counter = 0;
        while (true) {
            if (cells[x][y] == pl) {
                counter++;
                y--;
                x--;
            } else
                break;
            if (counter == 4) {
                return true;
            }
            if (y > COLS || y < 0) {
                return false;
            } else if (x > ROWS || x < 0) {
                return false;
            }
        }
        return false;
    }

    // Method to check if there are four tokens in a row diagonally to the
    // top-right
    public boolean getTopR(int x, int y, int pl) {
        while (x - 1 >= 0 && y + 1 < COLS) {
            if (cells[x - 1][y + 1] == pl) {
                x--;
                y++;
            } else
                break;
        }
        int counter = 0;
        while (true) {
            if (cells[x][y] == pl) {
                counter++;
                y--;
                x++;
            } else
                break;
            if (counter == 4) {
                return true;
            }
            if (y < 0) {
                return false;
            } else if (x >= ROWS) {
                return false;
            }
        }
        return false;
    }

    int mgY = -1;
    int mgX = -1;

    public void calcCell() {
        if (mgX != -1 && mgY != -1) {
            if (grid[mgX] >= 0) {
                if (turn == 0) {
                    cells[mgX][grid[mgX]] = 1;
                    getWinner(1, mgX, grid[mgX]);
                    grid[mgX]--;

                } else {
                    cells[mgX][grid[mgX]] = 2;
                    getWinner(2, mgX, grid[mgX]);
                    grid[mgX]--;
                }
                // This for loop checks if the game ends with a Draw
                // If there all of the spaces in the top row are filled then the
                // game ends in a draw
                for (int i = 0; i < ROWS - 1; i++) {
                    if (cells[i][0] != 0) {
                        draw++;
                    } else {
                        draw = 0;
                        break;
                    }
                    if (draw == 7) {
                        // If the top row is full then a message window will pop
                        // up saying the game ends in a draw
                        JOptionPane.showMessageDialog(null, "DRAW");
                        break;
                    }

                }
                // After placing the token it will switch to the second player's
                // turn.
                if (turn == 0)
                    turn = 1;
                else
                    turn = 0;
            }
        }

        repaint();
    }

    public void clearBoard()
    {
        this.cells = new int[ROWS][COLS];
        this.grid = new int[ROWS];
        this.width = BOARD_WIDTH / (ROWS + 1);
        this.height = BOARD_HEIGHT / (COLS + 1);
        this.turn = 0;
        this.draw = 0;
        for (int i = 0; i < ROWS; i++) {
            grid[i] = COLS - 1;
        }

        repaint();
    }
}

package Gato;

import java.util.Scanner;

public class JuegoGato {
    public static void main(String[] args) {
        char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
        };
        printBoard(board);
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("¿Quién jugará primero? (H para humano, C para computadora): ");
        char firstPlayer = scanner.nextLine().toUpperCase().charAt(0);
        
        while (true) {
            if (firstPlayer == 'H') {
                playerMove(board);
                printBoard(board);
                if (isGameOver(board)) {
                    break;
                }
                
                computerMove(board);
                printBoard(board);
                if (isGameOver(board)) {
                    break;
                }
            } else if (firstPlayer == 'C') {
                computerMove(board);
                printBoard(board);
                if (isGameOver(board)) {
                    break;
                }
                
                playerMove(board);
                printBoard(board);
                if (isGameOver(board)) {
                    break;
                }
            } else {
                System.out.println("Selección no válida. Ingresa 'H' o 'C'.");
            }
        }
    }
    
    public static void printBoard(char[][] board) {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }
    
    public static void playerMove(char[][] board) {
        Scanner scanner = new Scanner(System.in);
        int row, col;
        while (true) {
            System.out.print("Ingresa la fila (0-2): ");
            row = scanner.nextInt();
            System.out.print("Ingresa la columna (0-2): ");
            col = scanner.nextInt();
            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
                board[row][col] = 'X';
                break;
            } else {
                System.out.println("Movimiento inválido. Inténtalo de nuevo.");
            }
        }
    }
    
    public static void computerMove(char[][] board) {
        int[] bestMove = minimax(board, 'O');
        board[bestMove[0]][bestMove[1]] = 'O';
        System.out.println("La computadora ha realizado su movimiento en fila " + bestMove[0] + " y columna " + bestMove[1]);
    }
    
    public static int[] minimax(char[][] board, char player) {
        int[] bestMove = new int[]{-1, -1};
        int bestScore = (player == 'O') ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    board[i][j] = player;
                    int score = minimaxHelper(board, 0, false, Integer.MIN_VALUE, Integer.MAX_VALUE);
                    board[i][j] = ' ';
                    if ((player == 'O' && score > bestScore) || (player == 'X' && score < bestScore)) {
                        bestScore = score;
                        bestMove[0] = i;
                        bestMove[1] = j;
                    }
                }
            }
        }
        return bestMove;
    }
    
    public static int minimaxHelper(char[][] board, int depth, boolean isMaximizing, int alpha, int beta) {
        if (isGameOver(board)) {
            return evaluate(board);
        }
        
        if (isMaximizing) {
            int maxEval = Integer.MIN_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == ' ') {
                        board[i][j] = 'O';
                        int eval = minimaxHelper(board, depth + 1, false, alpha, beta);
                        board[i][j] = ' ';
                        maxEval = Math.max(maxEval, eval);
                        alpha = Math.max(alpha, eval);
                        if (beta <= alpha) {
                            break;
                        }
                    }
                }
            }
            return maxEval;
        } else {
            int minEval = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == ' ') {
                        board[i][j] = 'X';
                        int eval = minimaxHelper(board, depth + 1, true, alpha, beta);
                        board[i][j] = ' ';
                        minEval = Math.min(minEval, eval);
                        beta = Math.min(beta, eval);
                        if (beta <= alpha) {
                            break;
                        }
                    }
                }
            }
            return minEval;
        }
    }
    
    public static boolean isGameOver(char[][] board) {
        return evaluate(board) != 0 || isBoardFull(board);
    }
    
    public static boolean isBoardFull(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static int evaluate(char[][] board) {
        // Comprobar filas
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                if (board[i][0] == 'O') return 1;
                else if (board[i][0] == 'X') return -1;
            }
        }
        
        // Comprobar columnas
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == board[1][j] && board[1][j] == board[2][j]) {
                if (board[0][j] == 'O') return 1;
                else if (board[0][j] == 'X') return -1;
            }
        }
        
        // Comprobar diagonales
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            if (board[0][0] == 'O') return 1;
            else if (board[0][0] == 'X') return -1;
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            if (board[0][2] == 'O') return 1;
            else if (board[0][2] == 'X') return -1;
        }
        
        return 0;  // Empate
    }
}

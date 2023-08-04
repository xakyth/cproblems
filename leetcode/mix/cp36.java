package leetcode.mix;

import java.util.HashSet;

public class cp36 {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> hs = new HashSet<>(9);
        HashSet<Character> hs2 = new HashSet<>(9);
        for (int i = 0; i < 9; i++) {
            hs.clear();
            hs2.clear();
            for (int j = 0; j < 9; j++) {
                if (Character.isDigit(board[i][j])) {
                    if (hs.contains(board[i][j]))
                        return false;
                    hs.add(board[i][j]);
                }
                if (Character.isDigit(board[j][i])) {
                    if (hs2.contains(board[j][i]))
                        return false;
                    hs2.add(board[j][i]);
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                hs.clear();
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        if (Character.isDigit(board[i*3+l][j*3+k])) {
                            if (hs.contains(board[i*3+l][j*3+k]))
                                return false;
                            hs.add(board[i*3+l][j*3+k]);
                        }
                    }
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        
    }
}

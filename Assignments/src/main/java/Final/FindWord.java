package Final;

public class FindWord {
    /*Q4
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
*/

    static int ptr = 0;

    public static boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        //find the first alphabet in the matrix
        //check neighbours after that
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]==word.charAt(0)){
                    //check neighbours for next char
                    return checkNeighbour(i,j,board,visited,word, ptr);
                }
            }
        }
        return false;
    }

    private static boolean checkNeighbour(int i, int j, char[][] board, boolean[][] visited, String word, int ptr){
        if(i>=0 && j>=0 && i<board.length && j<board[i].length
                && !visited[i][j] && board[i][j]==word.charAt(ptr)) {

            if(ptr==word.length()-1){
                return true;
            }
            visited[i][j]= true;
            ptr++;

            return checkNeighbour(i, j + 1, board, visited, word, ptr) ||
            checkNeighbour(i + 1, j, board, visited, word, ptr) ||
            checkNeighbour(i, j - 1, board, visited, word, ptr) ||
            checkNeighbour(i - 1, j, board, visited, word, ptr);

        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board ={
                        {'A','B','C','E'},
                        {'S','F','C','S'},
                        {'A','D','E','E'}
                        };
        System.out.println(exist(board,"ABCCED"));

    }
}

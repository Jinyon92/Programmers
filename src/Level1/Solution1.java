package Level1;
import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int ySize = board.length;
        int xSize = board[0].length;
        LinkedList <Integer> list = new LinkedList<Integer>();

        int len = moves.length;
        for(int i=0; i<len; i++){
            int targetX = moves[i]-1;

            for(int y=0; y<ySize; y++){
                if(board[y][targetX] != 0){
                    list.add(board[y][targetX]);
                    board[y][targetX] = 0;
                    break;
                }
            }

            int idx = list.size();
            if(idx >= 2){
                if(list.get(idx-1) == list.get(idx-2)){
                    list.removeLast();
                    list.removeLast();
                    answer += 2;
                }
            }
        }
        return answer;
    }
}
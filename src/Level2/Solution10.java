package Level2;

class Solution10 {
    static char[][] map;
    static boolean[][] visited;
    static int ret;

    public int[] solution(String[][] places) {
        int[] answer = {0,0,0,0,0};
        map = new char[5][5];

        for(int i=0; i<5; i++){
            ret = 1;
            for(int y=0; y<5; y++){
                String temp = places[i][y];
                map[y] = temp.toCharArray();
            }

            for(int y=0; y<5; y++){
                for(int x=0; x<5; x++){
                    if(map[y][x] == '0') map[y][x] = 'O';
                }
            }

            for(int y=0; y<5; y++){
                for(int x=0; x<5; x++){
                    if(map[y][x] == 'P' && ret == 1){
                        visited = new boolean[5][5];
                        visited[y][x] = true;
                        dfs(y,x,0);
                    }
                }
            }

            answer[i] = ret;
        }
        return answer;
    }

    static int[] dy = {1,0,-1,0};
    static int[] dx = {0,1,0,-1};
    public static void dfs(int y, int x, int count){
        if(count >= 2 || ret == 0) return;

        for(int dir=0; dir<4; dir++){
            int ny = y + dy[dir];
            int nx = x + dx[dir];

            if(ny < 0 || ny >= 5 || nx < 0 || nx >= 5) continue;

            if(!visited[ny][nx]){
                if(map[ny][nx] == 'P'){
                    ret = 0;
                    return;
                }

                if(map[ny][nx] == 'O'){
                    visited[ny][nx] = true;
                    dfs(ny,nx,count+1);
                    visited[ny][nx] = false;
                }
            }

        }
    }
}

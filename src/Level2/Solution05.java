package Level2;

class Solution05 {
    static boolean visited[][];
    static int[][] map;
    static int M,N;
    static int cnt;
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        M = m;
        N = n;
        map = picture;
        visited = new boolean[m][n];

        for(int y=0; y<m; y++){
            for(int x=0; x<n; x++){
                if(map[y][x] != 0 && visited[y][x] == false){
                    cnt = 0;
                    visited[y][x] = true;
                    dfs(y,x,map[y][x]);
                    numberOfArea += 1;
                    if(maxSizeOfOneArea < cnt) maxSizeOfOneArea = cnt;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    static int[] dy = {1,0,-1,0};
    static int[] dx = {0,1,0,-1};
    public void dfs(int y, int x, int key){
        cnt += 1;
        for(int dir = 0; dir<4; dir++){
            int ny = y + dy[dir];
            int nx = x + dx[dir];
            if(ny < 0 || ny >= M || nx < 0 || nx >= N) continue;

            if(visited[ny][nx] == false && key == map[ny][nx]){
                visited[ny][nx] = true;
                dfs(ny,nx,key);
            }
        }
    }
}

package ctci.chapter8;

public class RobotInGrid {

    public static void run(int[][] map) {
        for (int r = 1; r < map.length; r++) {
            if(map[r-1][0] >= 0 && map[r][0] >= 0){
                map[r][0] = 1;
            }else{
                map[r][0] = -1;
            }
        }
        for (int c = 1; c < map[0].length; c++) {
            if(map[0][c-1] >= 0 && map[0][c] >= 0){
                map[0][c] = 1;
            }else{
                map[0][c] = -1;
            }
        }
        for (int r = 1; r < map.length; r++) {
            for (int c = 1; c < map[0].length; c++) {
                if(map[r][c] < 0){
                   continue;
                }
                if(map[r-1][c] >= 0 || map[r][c-1] >= 0){
                   map[r][c] = 1;
                 }else{
                    map[r][c] = -1;
                }

            }
        }
    }

    public static void main(String[] args) {
        int[][] map = new int[][]{
                {0,0,0,0,-1,0},
                {0,-1,0,-1,0,0},
                {0,0,0,0,0,0},
                {0,-1,0,0,-1,0},
                {0,0,0,-1,0,0}
        };
        RobotInGrid.run(map);

        for(int[] row : map){
            for(int rol : row){
                System.out.printf("%d ",rol);
            }
            System.out.printf("\n");
        }

    }

}

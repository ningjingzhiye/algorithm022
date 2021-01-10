import javafx.util.Pair;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    /**
     * dirX[]、dirY[] 的下标 i 代表了当前机器人的方向
     * 
     * i=0，向北，即向上
     * i=1，向东，即向右
     * i=2，向南，即向下
     * i=3，向西，即向左
     * 
     * 当读取指令为-1时，向右转90度，即当前方向(curDir + 1) % 4就可以得到右转方向
     * 当读取指令为-2时，向左转90度，即当前方向(curDir + 3) % 4就可以得到左转方向
     */
    public int robotSim(int[] commands, int[][] obstacles) {
        int[] dirX = {0, 1, 0, -1};
        int[] dirY = {1, 0, -1, 0};
        int curX = 0, curY = 0;
        int curDir = 0;
        int res = 0;
        Set<Pair<Integer, Integer>> obstacleSet = new HashSet<>();
        for (int i = 0; i < obstacles.length; i++) {
            obstacleSet.add(new Pair<>(obstacles[i][0], obstacles[i][1]));
        }
        for (int i = 0; i < commands.length; i++) {
            if (commands[i] == -1) {
                curDir = (curDir + 1) % 4;
            } else if (commands[i] == -2) {
                curDir = (curDir + 3) % 4;
            } else {
                for (int j = 0; j < commands[i]; j++) {
                    int newX = curX + dirX[curDir];
                    int newY = curY + dirY[curDir];
                    if (!obstacleSet.contains(new Pair<>(newX, newY))) {
                        curX = newX;
                        curY = newY;
                        res = Math.max(res, curX * curX + curY * curY);
                    } else {
                        break;
                    }
                }
            }
        }
        return res;
    }

}

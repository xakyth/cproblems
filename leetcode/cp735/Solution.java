package leetcode.cp735;

import java.util.ArrayList;
import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> positiveAsteroids = new Stack<>();
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] > 0) {
                positiveAsteroids.add(asteroids[i]);
            } else {
                if (positiveAsteroids.size() == 0) {
                    temp.add(asteroids[i]);
                } else {
                    int asteroid = positiveAsteroids.pop();
                    if (asteroid == -asteroids[i]) {
                        continue;
                    } else if (asteroid > -asteroids[i]) {
                        positiveAsteroids.push(asteroid);
                    } else {
                        boolean flag = true;
                        while (positiveAsteroids.size() > 0) {
                            asteroid = positiveAsteroids.pop();
                            if (asteroid == -asteroids[i]) {
                                flag = false;
                                break;
                            } else if (asteroid > -asteroids[i]) {
                                positiveAsteroids.push(asteroid);
                                flag = false;
                                break;
                            } else {
                                continue;
                            }
                        }
                        if (flag)
                            temp.add(asteroids[i]);
                    }
                }
            }
        }
        int[] result = new int[temp.size() + positiveAsteroids.size()];
        for (int i = 0; i < temp.size(); i++) {
            result[i] = temp.get(i);
        }
        for (int i = result.length - 1; i >= temp.size(); i--) {
            result[i] = positiveAsteroids.pop();
        }

        return result;
    }
}
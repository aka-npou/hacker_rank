package RookieRank4.ServerRoomSafety;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static String checkAll(int n, int[] height, int[] position) {
        // Complete this function

        // ---->
        boolean left = false;
        int j = 0;
        int max_i = -1;
        while(j < position.length-1) {
            System.out.println("j = " + j);
            for (int i = 0; i < n; i++) {
                if (position[j] < position [i]) {
                    if (position[j] + height[j] >= position[i]) {
                        System.out.println(j+" -> "+i);
                        if (max_i == -1 || position[max_i]+height[max_i] < position[i]+height[i]){
                            max_i = i;
                            System.out.println(max_i+" < "+i);
                        }
                    }
                }
            }
            if (max_i == -1) {
                left = false;
                break;
            } else {
                left = true;
                j = max_i;
                max_i = -1;
            }
        }
        System.out.println(left);
        System.out.println("--------------");
        // <----
        boolean right = false;
        j = position.length-1;
        max_i = -1;
        while(j != 0) {
            System.out.println("j = " + j);
            for (int i = 0; i < n; i++) {
                if (position[j] > position [i]) {
                    System.out.println(i+" <- "+j);
                    if (position[j] - height[j] <= position[i]) {
                        if (max_i == -1 || position[max_i]-height[max_i] > position[i]-height[i])
                            max_i = i;
                        System.out.println(max_i+" > "+i);
                    }
                }
            }
            if (max_i == -1) {
                right = false;
                break;
            } else {
                right = true;
                j = max_i;
                max_i = -1;
            }
        }

        System.out.println(right);
        System.out.println("--------------");

        if (left && right)
            return "BOTH";
        if (left)
            return "LEFT";
        if (right)
            return "RIGHT";
        return "NONE";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] position = new int[n];
        for(int position_i = 0; position_i < n; position_i++){
            position[position_i] = in.nextInt();
        }
        int[] height = new int[n];
        for(int height_i = 0; height_i < n; height_i++){
            height[height_i] = in.nextInt();
        }
        String ret = checkAll(n, height, position);
        System.out.println(ret);
        in.close();
    }
}


//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] matrix = new int[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution ob = new Solution();
            int ans = ob.findCoverage(matrix);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int helperFindCoverage(int[][] matrix, int i, int j){
        int result = 0;
        if(i-1 >= 0 && j >= 0 && j < matrix[0].length){
            int upper = matrix[i-1][j];
            result += (upper == 1) ? 1 : 0;
        }
        if(i+1 < matrix.length && j >= 0 && j < matrix[0].length){
            int lower = matrix[i+1][j];
            result += (lower == 1) ? 1 : 0;
        }
        if(j-1 >= 0 && i >= 0 && i < matrix.length){
            int left = matrix[i][j-1];
            result += (left == 1) ? 1 : 0;
        }
        if(j+1 < matrix[0].length && i >= 0 && i < matrix.length){
            int right = matrix[i][j+1];
            result += (right == 1) ? 1 : 0;
        }
        return result;
        
    }
    public int findCoverage(int[][] matrix) {
        // code here
        int ans = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                int ele = matrix[i][j];
                if(ele == 0){
                    ans += helperFindCoverage(matrix, i, j);
                }
            }
        }
        return ans;
    }
}
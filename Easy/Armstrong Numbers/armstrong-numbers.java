//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.armstrongNumber(n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    static String armstrongNumber(int n) {
        // code here
        int num = 0;
        int count = 0;
        int ans = n;
        
        while(n > 0) {
            num = n % 10;
            count = count + num * num * num;
            n = n / 10;
        }
        
        if(count == ans) {

            return "true";
        }
        return "false";
    }
}

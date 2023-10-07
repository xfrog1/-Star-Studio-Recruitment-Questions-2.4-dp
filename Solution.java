import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N,V,x;
        N=sc.nextInt();
        V=sc.nextInt();
        int []v=new int [N];
        int []w=new int [N];
        int []s=new int [N];
        int []dp=new int [V+1];
        for(int i=0;i<N;i++)
        {
            v[i]=sc.nextInt();
            w[i]=sc.nextInt();
            s[i]=sc.nextInt();
        }
        for(int i=0;i<N;i++)
        {
            x=1;
            while(2*x<=s[i]+1) {
                for (int j = V-x*v[i];j>=0;j--)
                    dp[j+x*v[i]]=Math.max(dp[j]+x*w[i],dp[j+x*v[i]]);
                x=x*2;
            }
            x=s[i]-x+1;
            for (int j = V-x*v[i];j>=0;j--)
                dp[j+x*v[i]]=Math.max(dp[j]+x*w[i],dp[j+x*v[i]]);
        }
        System.out.println(dp[V]);
    }
}
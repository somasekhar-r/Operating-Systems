// multi-level queue scheduling algorithm (fixed priority scheduling)
import java.util.*;
public class QueueScheduling
{
    static void burstTime(int n,int bt[],int su[],int p[])
    {
        System.out.println("Enter Burst time for each process"); 
        Scanner sc = new Scanner(System.in);
		for(int i=0;i<n;i++) 
		{ 
			System.out.print("Enter BT for process"+(i+1)+":"); 
			bt[i]= sc.nextInt();
			p[i]=i+1;
			System.out.print("Enter System/User Process (0/1) ? :");
			su[i]=sc.nextInt();
		} 
	}
	static void sorting(int n,int su[],int bt[],int p[])
    {
        for(int i=0 ; i<n; i++)
		{
			for(int  j=0;  j < n-i-1 ; j++){
				if( su[j] > su[j+1] ){
					int temp = p[j]; p[j] = p[j+1]; p[j+1] = temp;
					temp=bt[j]; bt[j]=bt[j+1]; bt[j+1]=temp;
					temp = su[j]; su[j] = su[j+1]; su[j+1] = temp; }
			}
		}
	}
	static void waitingTime(int wt[],int n,int bt[])
    {
        wt[0]=0;
        for(int i=1; i<n; i++)
            wt[i]=bt[i-1]+wt[i-1];
    }
    static void turnAroundTime(int n,int tat[],int wt[],int bt[])
    {
		tat[0] = bt[0];
		for(int i=1; i<n; i++)
            tat[i]=tat[i-1]+bt[i];
	}
	static void averageWtTat(float avgWt,float avgTat,int wt[],int tat[],int n)
    {
        for(int i=0; i<n; i++)
        {
            avgWt=avgWt+wt[i];
            avgTat=avgTat+tat[i];
        }
        System.out.println("Avg waiting time:"+avgWt/n+"\nAvg turn around time:"+avgTat/n);
    }
	public static void main(String args[])
 	{
		Scanner sc=new Scanner(System.in);
		float avgWt=0,avgTat=0;
		System.out.print("Enter the number of processes: ");
		int n=sc.nextInt();
		int p[]=new int[n],bt[]=new int[n],su[]=new int[n],wt[]=new int[n],tat[]=new int[n];
		burstTime(n, bt, su,p);
		sorting(n, su, bt, p);
		waitingTime(wt, n, bt);
		turnAroundTime(n, tat, wt, bt);
		System.out.println("--------------------------------------------------------------------------------"); 
		System.out.println("\nPROCESS\tSYSTEM/USER PROCESS \tBURST TIME\tWAITING TIME\tTURNAROUND TIME");
		for(int i=0;i<n;i++)
			System.out.println(p[i]+"\t"+su[i]+"\t\t\t"+bt[i]+"\t\t\t"+wt[i]+"\t\t"+tat[i]);
		System.out.println("--------------------------------------------------------------------------------"); 
		averageWtTat(avgWt, avgTat, wt, tat, n);
	}
}

/**
Output:
Enter the number of processes: 4
Enter Burst time for each process
Enter BT for process1:6
Enter System/User Process (0/1) ? :0
Enter BT for process2:3
Enter System/User Process (0/1) ? :1
Enter BT for process3:8
Enter System/User Process (0/1) ? :0
Enter BT for process4:4
Enter System/User Process (0/1) ? :1
--------------------------------------------------------------------------------

PROCESS SYSTEM/USER PROCESS     BURST TIME      WAITING TIME    TURNAROUND TIME
1       0                       6                       0               6
3       0                       8                       6               14
2       1                       3                       14              17
4       1                       4                       17              21
--------------------------------------------------------------------------------
Avg waiting time:9.25
Avg turn around time:14.5
 **/
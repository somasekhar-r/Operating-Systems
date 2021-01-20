//CPU Scheduling Algorithm:FCFS Program
import java.util.*;
public class FCFS
{
    static void burstTime(int n,int bt[],int process[])
    {
        System.out.println("Enter Burst time for each process"); 
        Scanner sc = new Scanner(System.in);
		for(int i=0;i<n;i++) 
		{ 
			System.out.print("Enter BT for process"+(i+1)+":"); 
			bt[i]= sc.nextInt();
			process[i]=i+1;
		} 
    }
    static void waitingTime(int wt[],int n,int bt[])
    {
        wt[0]=0;
        for(int i=1; i<n; i++)
        {
            wt[i]=bt[i-1]+wt[i-1];
        }
    }
    static void turnAroundTime(int n,int tat[],int wt[],int bt[])
    {
        for(int i=0; i<n; i++)
        {
            tat[i]=bt[i]+wt[i];
        }
    }
    static void averageWtTat(float awt,float atat,int wt[],int tat[],int n)
    {
        for(int i=0; i<n; i++)
        {
            awt=awt+wt[i];
            atat=atat+tat[i];
        }
        System.out.println("Avg waiting time:"+awt/n+"\nAvg turn around time:"+atat/n);
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("enter no of process:");
        int n=sc.nextInt();
        float atat=0,awt=0;
        int bt[]= new int[n], wt[]=new int[n], tat[]=new int[n],process[]=new int[n];
        burstTime(n, bt,process);
        waitingTime(wt, n, bt);
        turnAroundTime(n, tat, wt, bt);
        System.out.println("------------------------------------------"); 
        System.out.println("PROCESS\tBT\tWT\tTAT"); 
		for(int i=0;i<n;i++) 
		{
			System.out.println(process[i]+"\t"+bt[i]+"\t"+wt[i]+"\t"+tat[i]);
		} 
        System.out.println("------------------------------------------"); 
        averageWtTat(awt, atat, wt, tat, n);
    } 
}

/**
Output:
enter no of process:5
Enter Burst time for each process
Enter BT for process1:4
Enter BT for process2:7
Enter BT for process3:8
Enter BT for process4:4
Enter BT for process5:6
-------------------------------------------------------------
PROCESS BT      WT      TAT
1       4       0       4
2       7       4       11
3       8       11      19
4       4       19      23
5       6       23      29
-------------------------------------------------------------
Avg waiting time:11.4
Avg turn around time:17.2
**/
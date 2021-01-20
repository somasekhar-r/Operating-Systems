//CPU Scheduling Algorithm:SJF Program
import java.util.*;
public class SJF
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
    static void sorting(int n,int bt[],int process[])
    {
        for(int i = 0 ; i<n; i++)
		{
			for(int  j=0;  j < n-i-1 ; j++){
				if( bt[j] > bt[j+1] ){
					int temp = bt[j]; bt[j] = bt[j+1]; bt[j+1] = temp;
					temp = process[j]; process[j] = process[j+1]; process[j+1] = temp; }
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
        for(int i=0; i<n; i++)
            tat[i]=bt[i]+wt[i];
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
        System.out.println("Before sorting:");
        System.out.println("------------------------------------------"); 
        System.out.println("PROCESS\tBT\tWT\tTAT"); 
		for(int i=0;i<n;i++) 
			System.out.println(process[i]+"\t"+bt[i]+"\t"+wt[i]+"\t"+tat[i]);
        System.out.println("------------------------------------------"); 
        averageWtTat(awt, atat, wt, tat, n);
        sorting(n, bt, process);
        waitingTime(wt, n, bt);
        turnAroundTime(n, tat, wt, bt);
        System.out.println("After sorting:");
        System.out.println("------------------------------------------"); 
        System.out.println("PROCESS\tBT\tWT\tTAT"); 
		for(int i=0;i<n;i++) 
			System.out.println(process[i]+"\t"+bt[i]+"\t"+wt[i]+"\t"+tat[i]);
        System.out.println("------------------------------------------"); 
        averageWtTat(awt, atat, wt, tat, n);
    } 
}
/**
Output:
enter no of process:5
Enter Burst time for each process
Enter BT for process1:6
Enter BT for process2:7
Enter BT for process3:2
Enter BT for process4:4
Enter BT for process5:3
Before sorting:
------------------------------------------
PROCESS BT      WT      TAT
1       6       0       6
2       7       6       13
3       2       13      15
4       4       15      19
5       3       19      22
------------------------------------------
Avg waiting time:10.6
Avg turn around time:15.0
After sorting:
------------------------------------------
PROCESS BT      WT      TAT
3       2       0       2
5       3       2       5
4       4       5       9
1       6       9       15
2       7       15      22
------------------------------------------
Avg waiting time:6.2
Avg turn around time:10.6
**/

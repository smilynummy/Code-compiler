import java.net.*;
import java.util.*;
import java.lang.Thread.*;
import java.io.*;
public class Serverpub implements Runnable
{
	Socket s[]=new Socket[10];
	PrintWriter pw;
	Thread t[]=new Thread[10];
	Scanner scan=new Scanner(System.in);
	BufferedReader br;
	int i,n;
	String str,msg;
	Serverpub{
		try{
			ServerSocket ss=new ServerSocket(9876);
			System.out.println("Enter the number of clients:");
			n=scan.nextInt();

			for(i=0;i<n;i++){
				t[i]=new Thread[this];
				s[i]=ss.accept();

			}
			for(i=0;i<n;i++)
			{
				t[i].start();
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public void run()
	{
		try{
			int k=0;
			while(true)
			{
				for (i=0;i<n;i++) {
					if(Thread.currentThread()==t[i]){
						br=new BufferedReader(new InputStreamReader(s[i].getInputStream()));
						msg=br.readLine();
						k=i;
					}
					
				}
				for (i=0;i<n ;i++ ) {
					if(j!=k){
						pw=new PrintWriter(s[].getOutputStream(),true);
						pw.println(msg);
					}
					
				}
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public static void main(String[] args) {
		Serverpub sp=new Serverpub();
	}
} 
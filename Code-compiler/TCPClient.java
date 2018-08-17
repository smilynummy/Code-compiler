import java.io.*;
import java.util.*;
import java.awt.*;
import java.net.*;
import java.awt.event.*;

class TCPClient extends Frame implements ActionListener
{
	 
	 	String buff;
	 	BufferedReader br;
	 	PrintWriter pw;
	 	Button bt;
	 	TextField tf;
	 	TextArea ta;
	 	Socket in;
	 	TCPClient()
	 	{
	 		super("TCPClient");
	 		try{
	 		in=new Socket("localhost",9876);
	 		

	 		br=new BufferedReader(new InputStreamReader(in.getInputStream()));
	 		pw=new PrintWriter(in.getOutputStream(),true);

	 		bt=new Button("Send");
	 		tf=new TextField(30);
	 		ta=new TextArea("");

	 		setLayout(new FlowLayout());
	 		
	 		add(ta);
	 		add(tf);
	 		add(bt);

	 		bt.addActionListener(this);
	 		ta.setEditable(false);

	 		setSize(650,300);
	 		setVisible(true);
	 	    }
	 		catch(Exception e) {
	 			System.out.println(e);
	 			
	 		}


	 	}
	 	public void actionPerformed(ActionEvent ae){
	 		try{
	 			buff=tf.getText();
	 			ta.append("\nClient:"+buff);
	 			pw.println(buff);
	 			tf.setText("");
	 			System.out.println("Client:"+buff);
	 		}
	 		catch(Exception e)
	 		{
	 			System.out.println(e);
	 		}
	 	}
		
		void receive()
		{
			try{
				while(true)
				{
					buff="\nServer:"+br.readLine();
					ta.append(buff);
					System.out.println(buff);
				}
			}
			catch(Exception e)
			{
					System.out.println(e);
			}
			
		}

	
public static void main(String[] args) throws Exception {
	TCPClient tc=new TCPClient();
	tc.receive();
}
}
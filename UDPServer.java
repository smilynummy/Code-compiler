import java.io.*;
import java.util.*;
import java.net.*;

class UDPClient{
	 public static void main(String[] args) throws Exception {
	 	try{
	 		DatagramSocket ss=new DatagramSocket(9876);
	 		byte b[]=new byte[1024];
	 		DatagramPacket rpack=new DatagramPacket(b,b.length);

	 		ss.receive(rpack);
	 		String msg=new String(rpack.getData());
	 		System.out.println(msg);

	 		InetAddress ip=rpack.getAddress();
	 		int port=rpack.getPort();
	 		DatagramPacket spack=new DatagramPacket(b,b.length,ip,port);

	 		ss.send(spack);
	 		


	 	}
	 	catch(Exception e)
	 	{
	 		System.out.println(e);
	 	}

		
	}
}
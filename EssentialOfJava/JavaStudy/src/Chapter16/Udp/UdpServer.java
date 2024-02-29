package Chapter16.Udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.SimpleDateFormat;

public class UdpServer {

	public static void start() throws IOException {
		DatagramSocket socket = new DatagramSocket(7777);
		DatagramSocket inPacket, outPacket;
		
		byte[] inMsg = new byte[10];
		byte[] outMsg;
		
		while(true) {
			inPacket = new DatagramPacket(inMsg, inMsg.length);
			
			socket.receive(inPacket);
			
			InetAddress address = inPacket.getInetAddress();
			int port = inPacket.getPort();
			
			SimpleDateFormat sdf = new SimpleDateFormat("[hh:mm:ss]");
			String time = sdf.format(new Date());
			outMsg = time.getBytes();
			
			outPacket = new DatagramPacket(outMsg, outMsg.length, address, port);
			socket.send(outPacket);
		}
	}
	
	public static void main(String args[]) {
		try {
			new UdpServer().start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

package Chapter16.TcpIpServer;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TcpIpServer {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket(7777);
			System.out.println(getTime() + "������ �غ�Ǿ����ϴ�.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		while(true) {
			try {
				System.out.println(getTime() + "���� ��û�� ��ٸ��ϴ�.");
				// ���������� Ŭ���̾�Ʈ�� �����û�� �� ������ ������ ���߰� ��� ��ٸ���.
				// Ŭ���̾�Ʈ�� �����û�� ���� Ŭ���̾�Ʈ ���ϰ� ����� ���ο� ������ �����Ѵ�.
				Socket socket = serverSocket.accept();
				System.out.println(getTime() + socket.getInetAddress() 
				                + "�κ��� �����û�� ���Խ��ϴ�.");
				
				//������ ��½�Ʈ���� ��´�.
				OutputStream out = socket.getOutputStream();
				DataOutputStream dos = new DataOutputStream(out);
				
				// ���� ���Ͽ� �����͸� ������.
				dos.writeUTF("[Notice] Test Message1 from Server.");
				System.out.println(getTime() + "�����͸� �����߽��ϴ�.");
				
				// ��Ʈ���� ������ �ݾ��ش�.
				dos.close();
				socket.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	static String getTime() {
		SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
		return f.format(new Date());
	}
}

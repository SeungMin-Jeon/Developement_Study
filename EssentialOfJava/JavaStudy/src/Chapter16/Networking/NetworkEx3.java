package Chapter16.Networking;

import java.net.URL;
import java.net.URLConnection;

public class NetworkEx3 {
	public static void main(String[] args) {
		URL url = null;
		String address = "http://www.codechobo.com/sample/hello.html";
		
		try {
			url = new URL(address);
			URLConnection conn = url.openConnection();
			
			System.out.println("conn.toString():" + conn);
			System.out.println("getAllowUserInteraction():"
								+conn.getAllowUserInteraction());
			System.out.println("getConnectTimeout():"
					 + conn.getConnectTimeout());
			System.out.println("getContent():" + conn.getContent());
			System.out.println("getContentEncoding():" + conn.getContentEncoding());
			System.out.println();
		} catch (Exception e) {
			
		}
	}

}

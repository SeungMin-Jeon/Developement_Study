package Chapter16.Networking;

import java.io.IOException;
import java.net.URL;

public class NetworkEx2 {

	public static void main(String[] args) throws IOException {
		URL url = new URL("http://www.codechobo.com:80/sample/" 
							+ "hello.html?referer=codechobo#index1");
		
		System.out.println("url.getAuthority():" + url.getAuthority());
		System.out.println("url.getDefaultPort():" + url.getDefaultPort());
		System.out.println("url.getPort():" + url.getPort());
		System.out.println("url.getHost():" + url.getHost());
		System.out.println("url.getFile():" + url.getFile());
		System.out.println("url.getPath():" + url.getPath());
		System.out.println("url.getProtocol():" + url.getProtocol());
		System.out.println("url.getQuery():" + url.getQuery());
		System.out.println("url.getRef():" + url.getRef());
		System.out.println("url.getUserInfo:" + url.getUserInfo());
		
		
	}

}

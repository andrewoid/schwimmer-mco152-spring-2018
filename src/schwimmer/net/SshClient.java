package schwimmer.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.UnknownHostException;

public class SshClient {

	public static void main(String args[]) {

		try {
//			https://docs.oracle.com/javase/8/docs/technotes/guides/security/jsse/samples/sockets/client/SSLSocketClient.java
//			SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
//			SSLSocket socket = (SSLSocket) factory.createSocket("12.42.205.38", 22);
//			
//			socket.startHandshake();
			
			HttpURLConnection connection;
			
			Socket socket = new Socket("earthquake.usgs.gov", 80);
			
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			
			out.print("GET / HTTP/1.0\n\n");
			out.flush();
			
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			
			String inputLine;
            while ((inputLine = reader.readLine()) != null) {
                System.out.println(inputLine);
            }
			
			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

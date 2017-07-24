package jef;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SocketServer {

	private static final Logger LOG = LoggerFactory.getLogger(SocketServer.class);

	public static final int PORT_NUMBER = 1777;

	public static void main(String[] args) throws IOException {

		// Create server (never close because of the loop)
		@SuppressWarnings("resource")
		ServerSocket servSocket = new ServerSocket(PORT_NUMBER);
		LOG.info("Server waiting for connection on {}", PORT_NUMBER);

		// Loop
		while (true) {
			LOG.info("Waiting for a new connection");

			// Accept a connection
			try (Socket client = servSocket.accept();
					ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
					ObjectInputStream ois = new ObjectInputStream(client.getInputStream());) {

				LOG.info("Connection accepted from ({})", client.getInetAddress());

				// Receiev data
				Object o = ois.readObject();
				LOG.info("Server has receive data : {}", o.toString());

				// Send ACK
				oos.writeObject("Data received");
				LOG.info("ACK sent");

			} catch (Exception e) {
				LOG.error("Exception", e);
			}
		}
	}
}

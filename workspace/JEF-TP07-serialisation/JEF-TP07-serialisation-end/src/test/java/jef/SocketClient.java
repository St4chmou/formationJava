package jef;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SocketClient {

	private static final Logger LOG = LoggerFactory.getLogger(SocketClient.class);

	public static void main(String[] args) throws UnknownHostException {

		final String serverIP = "127.0.0.1";

		// Starting
		LOG.info("Connecting to {}", serverIP);

		// Create a socket and connect to localhost on PORT_NUMBER
		try (Socket socket1 = new Socket(serverIP, SocketServer.PORT_NUMBER);
				ObjectInputStream ois = new ObjectInputStream(socket1.getInputStream());
				ObjectOutputStream oos = new ObjectOutputStream(socket1.getOutputStream());) {

			// Connected
			LOG.info("Connected !");

			// Create data to send
			AppareilElectrique data = new AppareilElectrique("BOSH", "MODELE_A", 300);

			// Send an object to the serveur
			oos.writeObject(data);
			LOG.info("Message sent \"{}\"", data);

			// Receive ACK
			Object o = ois.readObject();
			LOG.info("ACK is \"{}\"", o.toString());

		} catch (Exception e) {
			LOG.error("Exception", e);
		}

	}
}

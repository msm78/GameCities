package by.htp.gameCities;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	private static final int SERVER_PORT = 8081;
	private static final String SERVER_HOST = "localhost";
	private static InetAddress ip;

	private String inpMessage;
	Socket clientSocket;
	InputStream is;
	OutputStream os;
	DataInputStream dis;
	DataOutputStream dos;

	GameClient game = new GameClient("Client");

	public Client() {
		super();
	}

	private void connection() throws IOException {
		ip = InetAddress.getByName(SERVER_HOST);
		clientSocket = new Socket(ip, SERVER_PORT);
		
		os = clientSocket.getOutputStream();
		dos = new DataOutputStream(os);

		is = clientSocket.getInputStream();
		dis = new DataInputStream(is);
	}
	
	public void clientServer() {

		try {
			//Thread.sleep(5000);
			this.connection();
			System.out.println("Successfully connected");
			
			game.randomCity();
			while (game.isGame()) {
				dos.writeUTF(game.getOutMessage());
				System.out.println("Клиент: " + game.getOutMessage());
				dos.flush();
				Thread.sleep(500);

				inpMessage = dis.readUTF();
				System.out.println("Сервер: " + inpMessage + "\n");
				game.setInpMessage(inpMessage);
				game.citiesExchange();
			}
			Thread.sleep(500);

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (ConnectException e) {
			// подключение к серверу не удалось
			System.out.println("No one to play with");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
package main.send;

import main.Main;
import main.Position;

public class Client extends Thread{
	byte[] b;
	public Client(byte[] b) {
		this.b=b;
	}
	public void run() {
		try {
			Main.send.send(new Position(b).getDatagramPacket(new byte[] {-2}));
		} catch (Exception e) {
			
		}
	}
}

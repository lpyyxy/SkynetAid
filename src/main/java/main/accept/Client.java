package main.accept;

import java.io.IOException;
import java.net.DatagramPacket;

import main.Main;
import main.MainData;
import main.ServerStatusEnum;
import main.send.Server;

public class Client extends Thread{
	public void run() {
		byte[] b;
		DatagramPacket packet;
		while(MainData.getServerStatus().equals(ServerStatusEnum.RUNING)) {
			b=new byte[6];
			packet=new DatagramPacket(b,6);
			try {
				Main.accept.receive(packet);
			} catch (IOException e) {
				
			}
			new Server(b,packet).start();
		}
	}
}

package main.send;

import java.net.DatagramPacket;

import main.Main;
import main.Tools;

public class Server extends Thread{
	byte[] b;
	DatagramPacket packet;
	public Server(byte[] b,DatagramPacket packet) {
		this.b=b;
		this.packet=packet;
	}
	public void run() {
		try {
			Main.mainOutputStream.write(Tools.byteArrayMerge(Tools.byteArrayCut(1,4,b),Tools.shortToByteArray(Tools.intToShort(packet.getPort()))));
		} catch (Exception e) {
			
		}
	}
}

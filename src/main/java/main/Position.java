package main;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.UnknownHostException;



public final class Position {
	private InetAddress address;
	private int port;
	public Position(byte[] data) throws UnknownHostException {
		Start(InetAddress.getByAddress(Tools.byteArrayCut(0, 4, data)),Tools.shortToInt(Tools.byteArrayToShort(Tools.byteArrayCut(4,2, data))));
	}
	private void Start(InetAddress address,int port) {
		this.address=address;
		this.port=port;
	}
	public DatagramPacket getDatagramPacket(byte[] data) {
		return new DatagramPacket(data,data.length,address,port);
	}
}

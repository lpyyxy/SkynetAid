package main.accept;

import java.io.IOException;

import main.Main;
import main.MainData;
import main.ServerStatusEnum;
import main.send.Client;

public class Server extends Thread{
	public void run() {
		byte[] b;
		while(MainData.getServerStatus().equals(ServerStatusEnum.RUNING)) {
			b=new byte[6];
			try {
				Main.mainInputStream.read(b);
			} catch (IOException e) {
				
			}
			new Client(b).start();
		}
	}
}

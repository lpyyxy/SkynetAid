package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;

import main.accept.Client;
import main.accept.Server;

public class Main {
	public static OutputStream mainOutputStream=null;
	
	public static InputStream mainInputStream =null;
	
	public static DatagramSocket accept=null;
	
	public static DatagramSocket send =null;
	public static void main(String[] args) throws NumberFormatException, IOException {
		MainData.setServerStatusEnum(ServerStatusEnum.RUNING);
		ServerSocket Mainserver = new ServerSocket(Integer.valueOf(args[0]).intValue());
		Socket MainSocket =Mainserver.accept();
		mainOutputStream=MainSocket.getOutputStream();
		mainInputStream=MainSocket.getInputStream();
		send=new DatagramSocket(Integer.valueOf(args[1]).intValue());
		accept=new DatagramSocket(Integer.valueOf(args[2]).intValue());
		new Server().start();
		new Client().start();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        do {
			str = br.readLine();
        } while (!str.equals("end"));
        MainData.setServerStatusEnum(ServerStatusEnum.CLOSEING);
        accept.close();
        send.close();
        mainInputStream.close();
        mainOutputStream.close();
        MainSocket.close();
        Mainserver.close();
	}
}

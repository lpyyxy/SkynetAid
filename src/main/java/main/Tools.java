package main;

public final class Tools {

	public static short byteArrayToShort(byte[] data) {
		return byteArrayToShort(0,data);
	}
	public static short byteArrayToShort(int subscript,byte[] data) {
		return (short) ((data[subscript]&0xff)|((data[subscript+1]&0xff)<<8));
	}

	public static byte[] shortToByteArray(short data) {
		byte[] bytes=new byte[2];
		bytes[1]=(byte)(data>>8);
		bytes[0]=(byte)data;
		return bytes;
	}
	public static short intToShort(int data) {
		return (short)data;
	}
	public static int shortToInt(short data) {
		return ((int)data)&0x0000ffff;
	}

	public static byte[] byteArrayMerge(byte[] head,byte[] tail) {
		byte[] Command=new byte[head.length+tail.length];
		System.arraycopy(head,0, Command, 0,head.length);
		System.arraycopy(tail,0, Command,head.length,tail.length);
		return Command;
	}

	public static byte[] byteArrayCut(int subscript,int length,byte[] data) {
		byte[] dataCopy=data;
		byte[] dataNew=new byte[length];
		System.arraycopy(dataCopy,subscript, dataNew,0,length);
		dataCopy=null;
		return dataNew;
	}
}

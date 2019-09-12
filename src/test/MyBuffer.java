package test;

import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;

public class MyBuffer {
	
	public void read() throws Exception {
		
		//Files.newBufferedReader(Paths.get("aaa.txt"));
		FileChannel inChannel = FileChannel.open(Paths.get("aaa.txt"));
		ByteBuffer buff = ByteBuffer.allocate(1024);
		
		while(inChannel.read(buff)!=-1) {
			buff.flip();
			
		}
	}
	
	public static void main(String[] args) {
		
	}

}

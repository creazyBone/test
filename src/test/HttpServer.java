package test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class HttpServer {

	public static void main(String[] args) throws Exception{
		//启动服务器监听8888端口
		ServerSocket server = new ServerSocket(8888);
		System.out.println("服务器启动...正在监听8888端口");
		
		while(!Thread.interrupted()) {
			//不停接受客户请求
			Socket client = server.accept();
			
			//获取输入输出流
			InputStream in = client.getInputStream();
			OutputStream out = client.getOutputStream();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String line = br.readLine();
			System.out.println("request:"+line);
			
			PrintWriter pw = new PrintWriter(out);
			
			InputStream is = new FileInputStream("E:\\学习\\并发编程\\index.html");
			BufferedReader bfr = new BufferedReader(new InputStreamReader(is));
			pw.println("HTTP/1.1 200 OK");
			pw.println("Content-Type text/html;charset=utf-8");
			pw.println("Content-Length: "+is.available());
			pw.println("Server:hello");
			pw.println("Date:"+ new Date());
			pw.println("");
			pw.flush();
			String c = null;
			while((c = bfr.readLine()) != null) {
				pw.print(c);
			}
			pw.flush();
			
			pw.close();
			bfr.close();
			br.close();
			
			client.close();
		}
		
		server.close();
	}
}

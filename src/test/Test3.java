package test;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

public class Test3 {
	
public static void main(String[] args) throws CharacterCodingException {
		Charset cs1 = Charset.forName("GBK");
		// ��ȡ������
		CharsetEncoder ce = cs1.newEncoder();
		// ��ȡ������
		CharsetDecoder cd = cs1.newDecoder();
		CharBuffer cbuf = CharBuffer.allocate(1024);// ����1024�ֽڵĿռ��ַ
		cbuf.put("�����");
	//	System.out.println("before-cbuf.position:"+cbuf.position());
		cbuf.flip();// ת��Ϊ��ģʽ
		System.out.println("after-cbuf.position:"+cbuf.position());
		//for(int k = 0; k < 3; k++) {
		//	System.out.println(cbuf.get());
		//	System.out.println("after-get-cbuf.position:"+cbuf.position());
	//	}
		// ����
		ByteBuffer bBuf = ce.encode(cbuf);
		System.out.println("after-encode-cbuf.position:"+cbuf.position());
		System.out.println("bBuf.position:"+bBuf.position());
		for (int i = 0; i < 6; i++) {
			System.out.println(bBuf.get());
			System.out.println("after-get-bBuf.position:"+bBuf.position());
		}
		System.out.println("before-bBuf.position:"+bBuf.position());
		bBuf.flip();// ת��Ϊ��ģʽ

		System.out.println(cd.decode(bBuf));

	}
}


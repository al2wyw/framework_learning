package mytest;

import java.io.*;

public class test_mark_reset {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fin = new FileInputStream("123.txt");
//		BufferedInputStream bfin=new BufferedInputStream(fin,4);
//		int i = 0;
//		if(fin.markSupported())
//			System.out.println("yes");
//		if(bfin.markSupported())
//			System.out.println("yes");
//		bfin.mark(4);
//		i = bfin.read();
//		System.out.println((char) i);
//		i = bfin.read();
//		System.out.println((char) i);
//		bfin.reset();
//		i = bfin.read();
//		System.out.println((char) i);
//		bfin.close();
		System.out.println(System.getProperty("file.encoding"));
		InputStreamReader fr=new InputStreamReader(fin,"UTF-8");
		if(fr.markSupported()){
			System.out.println("yes");
		}
		int i=0;
		i=fr.read();
		System.out.println((char)i);
		i=fr.read();
		System.out.println((char)i);
		i=fr.read();
		System.out.println((char)i);
		fr.skip(1);
		i=fr.read();
		System.out.println((char)i);
		i=fr.read();
		System.out.println((char)i);
		fr.close();
		FileOutputStream fout=new FileOutputStream("out.txt");
		int g=56;
		char c='1';
		int u=0xE4;
		int u1=0xB8;
		int u2=0x80;
		fout.write(g);
		fout.write(c);
		fout.write(u);
		fout.write(u1);
		fout.write(u2);
		fout.close();
		FileOutputStream fou=new FileOutputStream("out1.txt");
		Writer wr=new OutputStreamWriter(fou,"UTF-8");
		wr.write(56);
		wr.write('1');
		wr.write('一');
		wr.close();
		FileOutputStream fo=new FileOutputStream("out2.txt");
		DataOutputStream dout=new DataOutputStream(fo);
		dout.writeInt(0xE4B880);
		dout.close();
		StringWriter sw =new StringWriter(100);
		ByteArrayOutputStream bos=new ByteArrayOutputStream(100);
		bos.size(); 
	}

}

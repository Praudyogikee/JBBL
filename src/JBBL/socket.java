package JBBL;

import java.io.*;
import java.net.*;
public class socket {
	public static String Host = "";
	public static int Port = 0;
	public static Socket ss = null;
	public static DataInputStream DIS = null;
	public static DataOutputStream DOS = null;
	public socket(String H, int P) {
		Host = H;
		Port = P;
	}
	public static void init() {
		try {
		ss = new Socket(Host,Port);
		DIS = new DataInputStream(ss.getInputStream());
		DOS = new DataOutputStream(ss.getOutputStream());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void write(String in) {
		try {
			DOS.write(in.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static String read() {
		try {
			String s =  new String(DIS.readAllBytes());
			return s;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "0";
	}
}

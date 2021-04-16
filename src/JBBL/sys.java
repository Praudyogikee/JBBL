package JBBL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sys {
    public String cmd(String s) {
    	String out = "";
    	try {
        	Process pr = new ProcessBuilder().command("bash", "-c", s).start();
        	BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
        	String line = "";
        	while ((line=buf.readLine())!=null) {
        	out+=line+"\n";
        	}
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return out;
    }
}


package JBBL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sys {
    public String cmd(String s) {
    	String out = "";
    	try {
    		Runtime run = Runtime.getRuntime();
        	Process pr = run.exec(s);
        	pr.waitFor();
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

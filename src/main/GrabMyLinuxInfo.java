package main;

import java.util.ArrayList;

public class GrabMyLinuxInfo {
	public static void main(String[] args) {
		JBBL.sys x = new JBBL.sys();
		String out = "";
		ArrayList<String> CommandsToExecute = new ArrayList<String>() {
			{
			add("uname -r"); // Linux Kernel Version
			add("cat /etc/issue"); // Distro info
			add("cat /proc/version"); // Kernel Version
			add("ps aux"); // Running services
			add("route"); // Network Routes
			add("/sbin/ifconfig -a"); // ifconfig
			add("lscpu"); // CPU info
			}
		};
		for(int i = 0;i<CommandsToExecute.size();i++) {
			out += x.cmd(CommandsToExecute.get(i));
			out += "\n--------------------------------------\n";
		}
		System.out.println(out);
	}
}

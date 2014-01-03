package org.rz.demo.store.web;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.webapp.WebAppContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application {

	private static final int DEFAULT_PORT = 8080;

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	private final Server server;

	public static void main(String[] args) throws Exception {
		new Application(args).start();
	}

	public Application(String[] args) {
		server = new Server(getPort(args));
	}

	public void start() {
		try {
			WebAppContext webapp = new WebAppContext();
			webapp.setContextPath("/");
			webapp.setWar("src/main/webapp");
			server.setHandler(webapp);
			server.start();
			// server.join();
		} catch (Exception e) {
			log.error("Error while starting up jetty; Caused by: " + e.getMessage(), e);
		}
	}

	public int getLocalPort() {
		return ((ServerConnector) server.getConnectors()[0]).getLocalPort();
	}

	public void stop() {
		try {
			server.stop();
		} catch (Exception e) {
			log.error("Error while stopping jetty; Caused by: " + e.getMessage(), e);
		}
	}

	private int getPort(String[] args) {
		if (args.length > 0) {
			try {
				return Integer.parseInt(args[0]);
			} catch (Exception e) {
				log.error("Can't parse port; Caused by: " + e.getMessage(), e);
			}
		}
		return DEFAULT_PORT;
	}
}

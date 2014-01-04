package org.rz.demo.store.web;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ ProductControllerSC.class })
public class SuiteIT {

	private static volatile Application app;

	public static int getLocalPort() {
		return app.getLocalPort();
	}

	@BeforeClass
	public static void startupJetty() {
		app = new Application(new String[] { "0" });
		app.start();
	}

	@AfterClass
	public static void shutdownJetty() {
		app.stop();
	}

}

package com.shumz.aatg.myfirstproject1.test;

import android.os.Debug;
import android.test.suitebuilder.annotation.SmallTest;
import junit.framework.TestCase;

public class MyFirstProjectTests1 extends TestCase {

	private static final boolean DEBUG = true;

	public MyFirstProjectTests1(String name) {
		super(name);
		
		if (DEBUG) {
			Debug.waitForDebugger();
		}

	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@SmallTest
	public void testSomething() {
		fail("Not implemented yet...");
	}

	@VeryImportantTest
	public void testOtherStuff() {
		fail("Not implemented yet");
	}

//	public void testShouldThrowException() {
//		try {
//		MyFirstProjectActivity.methodThatShouldThrowException();
//		fail("Exception was not thrown");
//		} catch ( Exception ex ) {
//
//		// do nothing
//		}
//		}

	
}

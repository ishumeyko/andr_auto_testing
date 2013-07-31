/**
 * 
 */
package com.shumz.tconverter.test;

import java.util.HashMap;

import junit.framework.TestCase;

import com.shumz.tconverter.TConverter;

/**
 * @author shum
 * 
 */
public class TConverterTest extends TestCase {

	/**
	 * @param name
	 */
	public TConverterTest(String name) {
		super(name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	private static final HashMap<Double, Double> conversionTableDouble = new HashMap<Double, Double>();
	static {
		// initialize (c, f) pairs
		conversionTableDouble.put(0.0, 32.0);
		conversionTableDouble.put(100.0, 212.0);
		conversionTableDouble.put(-1.0, 30.20);
		conversionTableDouble.put(-100.0, -148.0);
		conversionTableDouble.put(32.0, 89.60);
		conversionTableDouble.put(-40.0, -40.0);
		conversionTableDouble.put(-273.0, -459.40);
	}

	/**
	 * Test method for
	 * {@link com.shumz.tconverter.TConverter#fahrenheitToCelsius(double)}.
	 */
	public final void testFahrenheitToCelsius() {

		for (double c : conversionTableDouble.keySet()) {
			final double f = conversionTableDouble.get(c);
			final double ca = TConverter.fahrenheitToCelsius(f);
			final double delta = Math.abs(ca - c);
			final String msg = "" + f + "F -> " + c + "C but is " + ca
					+ " (delta " + delta + ")";
			assertTrue(msg, delta < 0.0001);
		}

		// fail("Not yet implemented"); // TODO
	}

	public final void testCelsiusToFahrenheit() {
		for (double c : conversionTableDouble.keySet()) {
			final double f = conversionTableDouble.get(c);
			final double fa = TConverter.celsiusToFahrenheit(c);
			final double delta = Math.abs(fa - f);
			final String msg = "" + c + "C -> " + f + "F but is " + fa
					+ " (delta " + delta + ")";
			assertTrue(msg, delta < 0.0001);
		}
	}



}

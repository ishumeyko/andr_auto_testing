/**
 * 
 */
package com.shumz.tconverter.test;

import android.test.AndroidTestCase;
import com.shumz.tconverter.EditNumber;
import com.shumz.tconverter.InvalidTemperatureException;
import com.shumz.tconverter.TConverter;

/**
 * @author shum
 * 
 */
public class EditNumberTest extends AndroidTestCase {

	private EditNumber mEditNumber;

	// private Context mContext;

	/**
	 * @param name
	 */

	public EditNumberTest() {
		this("EditNumberTest");
	}

	public EditNumberTest(String name) {
		setName(name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();

		mEditNumber = new EditNumber(mContext);
		mEditNumber.setFocusable(true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for
	 * {@link com.shumz.tconverter.EditNumber#EditNumber(android.content.Context)}
	 * .
	 */
	public final void testEditNumberContext() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.shumz.tconverter.EditNumber#clear()}.
	 */
	public final void testClear() {

		final String value = "123.45";

		mEditNumber.setText(value);
		mEditNumber.clear();

		String expectedString = "";
		String actualString = mEditNumber.getText().toString();
		assertEquals(expectedString, actualString);
	}

	/**
	 * Test method for {@link com.shumz.tconverter.EditNumber#setNumber(double)}
	 * .
	 */
	public final void testSetNumber() {
		mEditNumber.setNumber(123.45);
		final String expected = "123.45";
		final String actual = mEditNumber.getText().toString();
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link com.shumz.tconverter.EditNumber#getNumber()}.
	 */
	public final void testGetNumber() {
		mEditNumber.setNumber(123.45);
		final double expected = 123.45;
		final double actual = mEditNumber.getNumber();

		assertEquals(expected, actual);
	}

	public final void testExceptionForLessThanAbsoluteZeroF() {
		try {
			TConverter.fahrenheitToCelsius(TConverter.ABSOLUTE_ZERO_F - 1);
			fail();
		} catch (InvalidTemperatureException ex) {
			// do nothing
		}
	}

	public final void testExceptionForLessThanAbsoluteZeroC() {
		try {
			TConverter.celsiusToFahrenheit(TConverter.ABSOLUTE_ZERO_C - 1);
			fail();
		} catch (InvalidTemperatureException ex) {
			// do nothing
		}
	}
}

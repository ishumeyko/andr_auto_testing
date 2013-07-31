package com.shumz.tconverter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;

import com.shumz.tconverter.TConverter.OP;

@SuppressLint("DefaultLocale")
public class TConverterActivity extends Activity {

	private EditNumber mCelsius;
	private EditNumber mFahrenheit;

	public class TChangedWatcher implements TextWatcher {
		private final EditNumber mSource;
		private final EditNumber mDest;

		private OP mOp;

		/**
		 * @param mDest
		 * @param convert
		 * @throws NoSuchMethodException
		 * @throws SecurityException
		 */
		public TChangedWatcher(TConverter.OP op) {
			if (op == OP.C2F) {
				this.mSource = mCelsius;
				this.mDest = mFahrenheit;
			} else {
				this.mSource = mFahrenheit;
				this.mDest = mCelsius;
			}
			this.mOp = op;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see android.text.TextWatcher#afterTextChanged(
		 * android.text.Editable)
		 */
		public void afterTextChanged(Editable s) {
			// TODO Auto-generated method stub
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see android.text.TextWatcher#beforeTextChanged(
		 * java.lang.CharSequence, int, int, int)
		 */
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			// TODO Auto-generated method stub
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see android.text.TextWatcher#onTextChanged( java.lang.CharSequence,
		 * int, int, int)
		 */

		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
			if (!mDest.hasWindowFocus() || mDest.hasFocus() || s == null) {
				return;
			}
			final String str = s.toString();

			if ("".equals(str)) {
				mDest.setText("");
				return;
			}
			try {
				final double temp = Double.parseDouble(str);
				final double result = (mOp == OP.C2F) ? TConverter
						.celsiusToFahrenheit(temp) : TConverter
						.fahrenheitToCelsius(temp);
						final String resultString = String.format("%.2f", result);
				mDest.setNumber(result);
				mDest.setSelection(resultString.length());
			} catch (NumberFormatException e) {
				// WARNING
				// this is generated while a number is entered,
				// for example just a '-'
				// so we don't want to show the error
			} catch (Exception e) {
				mSource.setError("ERROR: " + e.getLocalizedMessage());
			}
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tconverter);

		mCelsius = (EditNumber) findViewById(R.id.celsius);
		mFahrenheit = (EditNumber) findViewById(R.id.fahrenheit);
		
		mCelsius.addTextChangedListener(new TChangedWatcher(OP.C2F));
		mFahrenheit.addTextChangedListener(new TChangedWatcher(OP.F2C));

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tconverter, menu);
		return true;
	}

}

package com.shumz.aatg.myfirstproject1;

import com.shumz.aatg.myfirstproject1.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MyFirstProjectActivity1 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_first_project);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my_first_project, menu);
        return true;
    }
    
}

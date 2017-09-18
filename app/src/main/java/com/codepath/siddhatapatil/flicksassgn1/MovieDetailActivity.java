package com.codepath.siddhatapatil.flicksassgn1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * Created by siddhatapatil on 9/17/17.
 */

public class MovieDetailActivity extends Activity{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_detail);
    }
    public void onSubmit(View v) {
        // closes the activity and returns to first screen
        this.finish();
    }
}

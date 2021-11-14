package havefuneveryday.co.uk.squashrules3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class DetailActivity extends AppCompatActivity implements DetailFragment.OnFragmentInteractionListener {
    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        Log.i("squashQuizProject DetailActivity", "just done super onCreate ");
        getIntent();
//        Intent i = getIntent();
        Log.i("squashQuizProject DetailActivity", "done getIntent ");
        setContentView(R.layout.activity_detail);
        Log.i("squashQuizProject DetailActivity", "done set content view");
        if (paramBundle == null)
            getSupportFragmentManager().beginTransaction().add(R.id.container, new DetailFragment()).commit();
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.i("squashQuizProject DetailActivity", "in onDestroy");
    }

    public void onFragmentInteraction(String paramString) {}

    public static interface OnFragmentInteractionListener {}
}
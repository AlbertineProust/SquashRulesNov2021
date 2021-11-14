package havefuneveryday.co.uk.squashrules3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.support.v7.app.AppCompatActivity;


public class AnswersActivity  extends Activity implements AnswerDetailFragment.OnFragmentInteractionListener {


    protected void onCreate(Bundle paramBundle) {

        super.onCreate(paramBundle);
        Log.i("sqQuProj AnsActivity", "just done super onCreate ");
       // getIntent();

        Intent i;


        if (paramBundle == null) {
            assert getSupportFragmentManager() != null;
            getSupportFragmentManager().beginTransaction().add(R.id.container, new AnswerDetailFragment()).commit();
        }
    }

    private FragmentManager getSupportFragmentManager() {
        return null;
    }

//    protected void onDestroy() { getSupportFragmentManager().super.onDestroy(); }

    public void onFragmentInteraction(String paramString) {}

    public static interface OnFragmentInteractionListener {}
}

package havefuneveryday.co.uk.squashrules3;


import android.app.Activity;
import android.app.Application;
import android.os.Bundle;



import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;


public class MainActivity extends AppCompatActivity {
    protected static Application app;

    private final String LOG_TAG = MainActivity.class.getSimpleName();

    protected int myCounter = 0;

    protected void onCreate(Bundle paramBundle) {
        Log.i("squashQuizProject", "in onCreate ");
        this.myCounter++;
        Log.i(" counter equals ", "Counter " + this.myCounter);
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_main);
        Log.i("squashQuizProject", "before getsupportfragmant ");
       // getFragmentManager().beginTransaction(R.id.container, new QuizFragment()).commit();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        QuizFragment fragment = new QuizFragment();
        fragmentTransaction.add(R.id.container, fragment);
        fragmentTransaction.commit();
    }

    protected void onDestroy(Bundle paramBundle) {
        Log.i("squashQuizProject", "in onDestroy");
        this.myCounter++;
        Log.i(" counter equals ", "Counter " + this.myCounter);
        onDestroy();
    }

    protected void onPause() {
        Log.i("squashQuizProject", "in onPause");
        this.myCounter++;
        Log.i(" couter equals ", "Counter " + this.myCounter);
        super.onPause();
    }

    protected void onResume() {
        Log.i("squashQuizProject", "in onResume");
        this.myCounter++;
        Log.i(" couter equals ", "Counter " + this.myCounter);
        super.onResume();
    }

    protected void onStart() {
        Log.i("squashQuizProject", "in onStart");
        this.myCounter++;
        Log.i(" couter equals ", "Counter " + this.myCounter);
        super.onStart();
    }

    protected void onStop() {
        Log.i("squashQuizProject", "in onStop");
        this.myCounter++;
        Log.i(" couter equals ", "Counter " + this.myCounter);
        super.onStop();
    }
}

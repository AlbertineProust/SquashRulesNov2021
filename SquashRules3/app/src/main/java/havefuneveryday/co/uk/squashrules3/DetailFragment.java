package havefuneveryday.co.uk.squashrules3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DetailFragment extends Fragment implements View.OnClickListener {
    private int answerIsFalse = 1123;

    private int answerIsTrue = 1122;

    private int intentRequestCode = 9112;

    private DetailActivity.OnFragmentInteractionListener mListener;

    private boolean questionAnswer;

    private boolean questionWasAnswered = false;

    protected int totalIndex;

    public static DetailFragment newInstance(String paramString1, String paramString2) {
        DetailFragment detailFragment = new DetailFragment();
        detailFragment.setArguments(new Bundle());
        return detailFragment;
    }

    protected void doFalseGobackToast() { Toast.makeText(getActivity(),R.string.GoBackFalse, Toast.LENGTH_SHORT).show(); }

    protected void doTrueGobackToast() { Toast.makeText(getActivity(), R.string.GoBackTrue, Toast.LENGTH_SHORT).show(); }

    public void onClick(View paramView) {}

    public void onCreate(Bundle paramBundle) { super.onCreate(paramBundle); }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) { return paramLayoutInflater.inflate(2130903072, paramViewGroup, false); }

    public void onDetach() {
        super.onDetach();
        new Intent();
        this.mListener = null;
    }

    public void onStart() {
        super.onStart();
        Intent intent = getActivity().getIntent();
        final Button trueButton = (Button) getView().findViewById(R.id.Question_is_true);
        final Button falseButton = (Button) getView().findViewById(R.id.Question_is_false);
        trueButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View param1View) {
                Log.i("squashQuizProject DetailFragment", "in true button ");
                questionAnswer = true;
                questionWasAnswered = true;
                getActivity().setResult(answerIsTrue);

                DetailFragment.this.doTrueGobackToast();
            }
        });
        falseButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View param1View) {
                getActivity().setResult(answerIsFalse);
                questionAnswer = false;
                questionWasAnswered = true;
                doFalseGobackToast();
                DetailFragment.this.doFalseGobackToast();
            }
        });
        TextView textView = (TextView)getView().findViewById(R.id.TheCurrentQuestion);
        intent.getSerializableExtra("ReferenceObject");
        intent.getIntExtra("QuizListPosition", 1);
        textView.setText(intent.getStringExtra("latestQuestion"));
    }

    public static interface OnFragmentInteractionListener {
        void onFragmentInteraction(String param1String);
    }
}


package havefuneveryday.co.uk.squashrules3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.zip.Inflater;

import static havefuneveryday.co.uk.squashrules3.R.layout.fragment_answer_detail;

public class AnswerDetailFragment extends Fragment implements View.OnClickListener {
    private int answerIsFalse = 1123;

    private int answerIsTrue = 1122;

    private int intentRequestCode = 9112;

    private DetailActivity.OnFragmentInteractionListener mListener;

    private boolean questionAnswer;

    private boolean questionWasAnswered = false;

    private String selectedAnswerSave = "selectedAnswerSave";

    private String selectedAnswerShouldvbinSave = "selectedAnswerShouldvbinSave";

    private String selectedPuntersAnswerRightSave = "selectedPuntersAnswerRightSave";

    private String selectedPuntersAnswerSave = "selectedPuntersAnswerSave";

    private String selectedQuestionSave = "selectedQuestionSave";

    protected int totalIndex;

    public static DetailFragment newInstance(String paramString1, String paramString2) {
        DetailFragment detailFragment = new DetailFragment();
        detailFragment.setArguments(new Bundle());
        return detailFragment;
    }

    public void onClick(View paramView) {}

    public void onCreate(Bundle paramBundle) { super.onCreate(paramBundle); }

    public View onCreateView(LayoutInflater Inflater, ViewGroup container1, Bundle paramBundle) {
        View view = (View) Inflater.inflate(R.layout.fragment_answer_detail, container1,false);
        Intent intent = getActivity().getIntent();
        ((TextView)view.findViewById(R.id.TheQuestionThatWasAnswered)).setText(intent.getStringExtra(this.selectedQuestionSave));
        ((TextView)view.findViewById(R.id.YourAnswerWas)).setText((new Boolean(intent.getBooleanExtra(this.selectedPuntersAnswerSave, true))).toString());
        ((TextView)view.findViewById(R.id.YourAnswerShouldHaveBeen)).setText(intent.getStringExtra(this.selectedAnswerShouldvbinSave));
        TextView textView = (TextView)view.findViewById(R.id.YourAnswerWasTherefore);
        Boolean bool = Boolean.valueOf(intent.getBooleanExtra(this.selectedPuntersAnswerRightSave, true));
        (new Boolean(bool.booleanValue())).toString();
        if (bool.booleanValue()) {
            String str1 = "right";
            textView.setText(str1);
            ((TextView)view.findViewById(R.id.TheExplanation)).setText(intent.getStringExtra(this.selectedAnswerSave));
            return view;
        }
        String str = "wrong";
        textView.setText(str);
        final TextView viewById = (TextView) view.findViewById(Integer.parseInt(intent.getStringExtra(selectedAnswerSave)));
        return view;
    }

    public void onDetach() { super.onDetach(); }

    public void onStart() { super.onStart(); }

    public static interface OnFragmentInteractionListener {
        void onFragmentInteraction(String param1String);
    }
}

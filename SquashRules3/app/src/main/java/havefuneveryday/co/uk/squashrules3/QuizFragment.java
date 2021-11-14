package havefuneveryday.co.uk.squashrules3;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Arrays;

import static android.content.Intent.getIntent;

public class QuizFragment extends Fragment {
    static int QuestionWasAnswered = 12656;

    protected int CurrentTotalIndexClickedOn = 0;

    private String CurrentTotalIndexClickedOnSave = "CurrentsTotalIndexClickedOnSave";

    private boolean allBatchAnswered = false;

    private String allBatchAnsweredSave = "allBatchAnsweredSave";

    private int answerIsFalse = 1123;

    private int answerIsTrue = 1122;

    boolean[] answeredArray;

    private String answeredArraySave = "answeredArraySave";

    protected int batchesSoFar = 0;

    private String batchesSoFarSave = "batchesSoFarSave";

    protected int batchsize = 4;

    private String batchsizeSave = "batchsizeSave";

    private String bigBundle = "bigBundle";

    private boolean haveShownAnswersInvitation = false;

    private String haveShownAnswersInvitationSave = "haveShownAnswersInvitationSave";

    private int intentRequestCode = 9112;

    Context myContext = getActivity();

    protected boolean nowShowingAnswers = false;

    private String nowShowingAnswersSave = "nowShowingAnswers";

    boolean[] puntersAnswerArray;

    private String puntersAnswerArraySave = "puntersAnswerArraySave";

    boolean[] puntersAnswerIsRightArray;

    private String puntersAnswerIsRightArraySave = "puntersAnswerIsRightArraySave";

    private boolean puntersCurrentAnswer;

    String[][] questionBank;

    protected int questionBankSize = 0;

    protected int questionIndex = 0;

    private String questionIndexSave = "questionIndexSave";

    ArrayAdapter<String> quizAdapter;

    ArrayList<String> quizArrayList = new ArrayList(100);

    private int score;

    private String selectedAnswerSave = "selectedAnswerSave";

    private String selectedAnswerShouldvbinSave = "selectedAnswerShouldvbinSave";

    private String selectedPuntersAnswerRightSave = "selectedPuntersAnswerRightSave";

    private String selectedPuntersAnswerSave = "selectedPuntersAnswerSave";

    private String selectedQuestionSave = "selectedQuestionSave";

    public QuizFragment() {
        String[] arrayOfString1 = { "4. If the ball is down, the Referee calls �down�", "If the ball is down, the Marker calls �down.", "false", "false", null, null };
        String[] arrayOfString2 = { "5. A referee can award a let or stroke even if no let request was made", "The Referee may allow a let or award a stroke without a request having been made, especially for reasons of safety", "false", "false", null, null };
        String[] arrayOfString3 = { "11. The Marker must announce the result of the match", "The Market must announce the result of the match", "true", "false", null, null };
        String[] arrayOfString4 = { "17.  The Marker must repeat the Referee�s decision after a player�s request for a let, and then call the score;", "The Marker must repeat the Referee�s decision after a player�s request for a let, and then call the score", "true", "false", null, null };
        String[] arrayOfString5 = { "21. The warm up at the start of a match is 5 minutes", "The warm up at the start of a match is 5 minutes", "true", "false", null, null };
        String[] arrayOfString6 = { "31. If the swing was affected by slight contact with the opponent who was making every effort to avoid the interference a let is allowed, unless the striker would have made a winning return, in which case a stroke is awarded to the striker", "if the swing was affected by slight contact with the opponent who was\nmaking every effort to avoid the interference a let is allowed, unless the striker would have made a winning return, in which case a stroke is awarded to the striker", "true", "false", null, null };
        String[] arrayOfString7 = { "35.", "A4", "true", "false", null, null };
        this.questionBank = new String[][] {
                { "1. The rules of squash have been in force since 1992", "The current rules are dated 2014.", "false", "false", null, null }, { "2. The rules of squash in England are owned and published by England Squash.", "The rules are global and set by The World Squash Federation.", "false", "false", null, null }, { "3. The Marker�s decision is final", "Players can appeal to the Referee if both Marker and Referee are present.", "false", "false", null, null }, arrayOfString1, arrayOfString2, { "6. If the striker strikes the ball and the opponent then requests a let, but then the ball goes down or out, the opponent wins the rally", "If the striker strikes the ball and the opponent then requests a let, but then the ball goes down or out, the opponent wins the rally", "true", "false", null, null }, { "7. A match should normally be officiated by a Marker and a Judge, both of whom must keep a record of the score, which player is serving, and the correct box for service", "A match should normally be officiated by a Marker and a Referee, both of whom must keep a record of the score, which player is serving, and the correct box for service", "false", "false", null, null }, { "8. The Marker keeps the score and the Referee records which player is serving and the correct box for service.", "Marker and a Referee, both keep a record of the score, which player is serving, and the correct box for service.", "false", "false", null, null }, { "9. If there is only one Official, a player cannot appeal any call.", "If there is only one Official, that Official is both the Marker and the Referee. A player may appeal any call or lack of call made by that Official as Marker to that same Official as the Referee.", "false", "false", null, null }, { "10. If the ball is out of cour the correct call is Out Of Court", "If the ball is out of cour the correct call is Out", "false", "false", null, null },
                arrayOfString3, { "12. The Referee must call 'fault,' 'down,' 'out,' 'not up' or 'stop', as appropriate", "The Marker must call 'fault,' 'down,' 'out,' 'not up' or 'stop', as appropriate", "false", "false", null, null }, { "13. A player can appeal the Referee's decision", "The Referee's decision is final", "false", "false", null, null }, { "14. A player can appeal the Marker's decision", "A player can appeal the Marker's decision", "true", "false", null, null }, { "15. The Referee may award the match to a player whose opponent is not on court ready to play within the time stated", "The Referee may award the match to a player whose opponent is not on court ready to play within the time stated", "true", "false", null, null }, { "16. The only alternative to the two official system is to have one official", "The rules describe an alternative three referee system", "false", "false", null, null }, arrayOfString4, { "18. The Marker must call  Game And Match Ball  when a player needs 1 point to win the match", "The call is Match Ball only, not Game and Match Ball", "false", "false", null, null }, { "19. When the score reaches 10 10 the Referee calls 10-all: a player must win by 2 points", "The Marker makes the call", "false", "false", null, null }, { "20. The Referee must give an explanation if asked", "The explanation is optional The Referee may give an explanation if asked", "false", "false", null, null },
                arrayOfString5, { "22. If one player as to leave the court, the other player cannot strike the ball while the first player is not present", "A4", "false", "false", null, null }, { "23. If the Server throws the ball to serve but the ball hits the ground, it is not a serve and server can start again ", "Only of there was no attempt to hit the ball is it not a serve.", "false", "false", null, null }, { "24. If the server serves from the wrong service-box, and the server wins the rally, the rally stands", "If the server serves from the wrong service-box, and the server wins the rally, the rally stands", "true", "false", null, null }, { "25. Interference occurs only if one the following 3 conditions is not met - fair view of the ball, freedom for a reasonable swing and unobstructed direct access to the ball", "The 4th condition is freedom to strike the ball to any part of the front wall", "false", "false", null, null }, { "26. If there is no interference there must be no let", "There can be a let if there is no interference but there is reasonable fear of injury", "false", "false", null, null }, { "27. The request for a let is Let Please. The request for a stroke is Stroke Please", "A request for a let includes a request for a stroke", "false", "false", null, null }, { "28 If there is interference a let must be granted.", "The striker but also be able to make a good return", "false", "false", null, null }, { "29 If there was interference but the striker was not in a position to play a winner the let decision is Yes Let .", "If the opponent was not making every effort to avoid the interference, a Stroke is awarded", "false", "false", null, null }, { "30. If there was interference, but it did not prevent the striker from seeing and getting to the ball to make a good return, this is minimal interference and no let is allowed;", "if there was interference, but it did not prevent the striker from seeing and getting to the ball to make a good return, this is minimal interference and no let is allowed;", "true", "false", null, null },
                arrayOfString6, { "32. If a swing was prevented by contact with the opponent, a let is awarded to the striker.", "if the swing was prevented by contact with the opponent, a stroke is awarded to the striker, even if the opponent was making every effort to avoid the interference.", "true", "false", null, null }, { "33.", "A4", "true", "false", null, null }, { "34.", "A4", "true", "false", null, null }, arrayOfString7, { "If there is interference and the incoming striker is attempting to get to the ball, a let is allowable", "if there was interference, but it did not prevent the striker from seeing and getting to the ball to make a good return, this is minimal interference and no let is allowed", "true", "false", null, null } };
        this.answeredArray = new boolean[100];
        this.puntersAnswerArray = new boolean[100];
        this.puntersAnswerIsRightArray = new boolean[100];
    }

    public int calculateScore() {
        Log.i(" quizfragement ", "in calculate score ");
        int j = 0;
        int i = getbatchesSoFar();
        int k = getBatchsize();
        int m = getbatchesSoFar();
        int n = getBatchsize();
        int i1 = getBatchsize();
        i *= k;
        while (i < m * n + i1) {
            Log.i(" i is ", new String((new Integer(i)).toString()));
            k = j;
            if (this.puntersAnswerIsRightArray[i] == true)
                k = j + 1;
            i++;
            j = k;
        }
        return j;
    }

    boolean checkIfAllBatchAnswered() {
        Log.i(" quizfragement ", "in check if all batch answered");
        int j = 0;
        int i = getbatchesSoFar();
        int k = getBatchsize();
        int m = getbatchesSoFar();
        int n = getBatchsize();
        int i1 = getBatchsize();
        i *= k;
        while (i < m * n + i1) {
            Log.i(" i is ", new String((new Integer(i)).toString()));
            k = j;
            if (this.answeredArray[i])
                k = j + 1;
            i++;
            j = k;
        }
        Log.i(" num qs ansd in batch", Integer.toString(j));
        return (j == getBatchsize());
    }

    protected String getAnswer(int paramInt) { return this.questionBank[paramInt][1]; }

    int getBatchsize() { return this.batchsize; }

    int getCurrentTotalIndexClickedOn() { return this.CurrentTotalIndexClickedOn; }

    protected String getQuestion(int paramInt) { return this.questionBank[paramInt][0]; }

    protected int getQuestionBankSize() { return this.questionBankSize; }

    protected int getbatchesSoFar() { return this.batchesSoFar; }

    void markAsAnswered(int paramInt, String paramString) {
        this.questionBank[paramInt][4] = paramString;
        this.questionBank[paramInt][3] = "true";
        if (this.questionBank[paramInt][2] == "true" && paramString == "true") {
            this.questionBank[paramInt][5] = "right";
            return;
        }
        this.questionBank[paramInt][5] = "wrong";
    }

    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        Log.i("squQizProj qizfrag", "in onActivity Result");
        Integer integer = new Integer(paramInt2);
        if (paramInt2 == this.answerIsTrue) {
            this.puntersCurrentAnswer = true;
        } else {
            this.puntersCurrentAnswer = false;
        }
        Log.i("qzfrag resu code is ", integer.toString());
        if (paramIntent == null)
            Log.i("sqQuProj quizfragement", "Intent data is null");
        updateArray();
        if (checkIfAllBatchAnswered())
            this.allBatchAnswered = true;
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        Log.i("sqQuProj qizfrag", "in OnCreate ");
        setHasOptionsMenu(true);
        restoreFromBundle(getActivity().getIntent().getBundleExtra(this.bigBundle));
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        Log.i("sqQuProj quizfrag", "in onCreateView ");
        updateList();
        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), R.layout.list_item_question, this.quizArrayList);
        View view = paramLayoutInflater.inflate(R.layout.fragment_quiz, paramViewGroup, false);
        ListView listView = (ListView)view.findViewById(R.id.QuizListView);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {

                String latestq = (String)param1AdapterView.getItemAtPosition(param1Int);
                QuizFragment.this.setCurrentTotalIndexClickedOn(QuizFragment.this.getbatchesSoFar() * QuizFragment.this.getBatchsize() + param1Int);
                if (QuizFragment.this.checkIfAllBatchAnswered()) {
                    if (!QuizFragment.this.haveShownAnswersInvitation) {

                        Integer integer1 = new Integer(QuizFragment.this.score);
                        Integer integer2 = new Integer(QuizFragment.this.batchsize);
                        String str = new String("You scored " + integer1.toString() + " / " + integer2.toString() + " Tap for answers or swipe right to continue");
                        Toast.makeText(QuizFragment.this.getActivity(), str, Toast.LENGTH_LONG).show();
                        return;
                    }
                    Intent intent1 = new Intent(QuizFragment.this.getActivity(), AnswersActivity.class);
                    Log.i("squQizProj quizfrag", "about to start putExtras)");
                    intent1.putExtra(QuizFragment.this.selectedQuestionSave, QuizFragment.this.questionBank[QuizFragment.this.getCurrentTotalIndexClickedOn()][0]);
                    intent1.putExtra(QuizFragment.this.selectedAnswerSave, QuizFragment.this.questionBank[QuizFragment.this.getCurrentTotalIndexClickedOn()][1]);
                    intent1.putExtra(QuizFragment.this.selectedPuntersAnswerSave, QuizFragment.this.puntersAnswerArray[QuizFragment.this.getCurrentTotalIndexClickedOn()]);
                    intent1.putExtra(QuizFragment.this.selectedPuntersAnswerRightSave, QuizFragment.this.puntersAnswerIsRightArray[QuizFragment.this.getCurrentTotalIndexClickedOn()]);
                    intent1.putExtra(QuizFragment.this.selectedAnswerShouldvbinSave, QuizFragment.this.questionBank[QuizFragment.this.getCurrentTotalIndexClickedOn()][2]);
                    Log.i("squashQuizProj quizfrag", "about to start answer activity(intent)");
                    QuizFragment.this.startActivity(intent1);
                    return;
                }
                Intent intent2 = new Intent(QuizFragment.this.getActivity(), DetailActivity.class);
                intent2.putExtra("latestQuestion", latestq);
                Log.i("sqQzProj quzfragement", "about to startactivity(intent)");
                QuizFragment.this.startActivityForResult(intent2, QuizFragment.this.intentRequestCode);
            }
        });
        listView.setOnTouchListener(new OnSwipeTouchListener(this.myContext) {
            public void onSwipeRight() {
                Log.i(" quizfragement ", "in OnSwipeRight");
                if (QuizFragment.this.allBatchAnswered) {
                    Log.i(" quizfragement ", "allBatchAnswered is true now being set to false");
                    allBatchAnswered = false;
                    nowShowingAnswers = false;
                    Log.i(" in swipe right ", "Before showNextBatch");
                    QuizFragment.this.showNextBatch();
                    Log.i(" in swipe right ", "After showNextBatch");
                    QuizFragment.this.getActivity().finish();
                    Log.i(" in swipe right ", "After get activity.finish");
                    return;
                }
                Log.i(" in quiz fragment ", "before please try to answer all qs");
                Toast.makeText(QuizFragment.this.getActivity(), "Please try to answer all questions", 0).show();
            }
        });
        return view;
    }

    public void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
        Log.i(" quizfrag onSavInstStat", "just done super");
        paramBundle.putBoolean(this.allBatchAnsweredSave, this.allBatchAnswered);
        paramBundle.putInt(this.batchesSoFarSave, this.batchesSoFar);
        paramBundle.putInt(this.CurrentTotalIndexClickedOnSave, this.CurrentTotalIndexClickedOn);
        paramBundle.putBoolean(this.nowShowingAnswersSave, this.nowShowingAnswers);
        paramBundle.putInt(this.batchsizeSave, this.batchsize);
        paramBundle.putInt(this.questionIndexSave, this.questionIndex);
        paramBundle.putBooleanArray(this.answeredArraySave, this.answeredArray);
        paramBundle.putBooleanArray(this.puntersAnswerArraySave, this.puntersAnswerArray);
        paramBundle.putBooleanArray(this.puntersAnswerIsRightArraySave, this.puntersAnswerIsRightArray);
        paramBundle.putBoolean(this.haveShownAnswersInvitationSave, this.haveShownAnswersInvitation);
        paramBundle.putBoolean(this.nowShowingAnswersSave, this.nowShowingAnswers);
        Log.i(" qizfrag onSaveInstStat", "done all puts");
    }

    public void onStart() { super.onStart(); }

    protected String questionTrue(int paramInt) { return this.questionBank[paramInt][2]; }

    void restoreFromBundle(Bundle paramBundle) {
        if (paramBundle != null) {
            Log.i("Restorg CTIndx b4 restr", (new Integer(this.CurrentTotalIndexClickedOn)).toString());
            this.allBatchAnswered = paramBundle.getBoolean(this.allBatchAnsweredSave);
            this.batchesSoFar = paramBundle.getInt(this.batchesSoFarSave);
            this.CurrentTotalIndexClickedOn = paramBundle.getInt(this.CurrentTotalIndexClickedOnSave);
            Log.i("Restrin CTIx AFT restr", (new Integer(this.CurrentTotalIndexClickedOn)).toString());
            this.questionBankSize = this.questionBank.length;
            this.nowShowingAnswers = paramBundle.getBoolean(this.nowShowingAnswersSave);
            this.batchsize = paramBundle.getInt(this.batchsizeSave);
            this.questionIndex = paramBundle.getInt(this.questionIndexSave);
            this.answeredArray = paramBundle.getBooleanArray(this.answeredArraySave);
            this.puntersAnswerArray = paramBundle.getBooleanArray(this.puntersAnswerArraySave);
            this.puntersAnswerIsRightArray = paramBundle.getBooleanArray(this.puntersAnswerIsRightArraySave);
            this.haveShownAnswersInvitation = paramBundle.getBoolean(this.haveShownAnswersInvitationSave);
            this.nowShowingAnswers = paramBundle.getBoolean(this.nowShowingAnswersSave);
        }
    }

    void saveInstanceState() { onSaveInstanceState(new Bundle()); }

    protected void setAnsweringNowIndictor() { this.nowShowingAnswers = true; }

    protected void setBatchsize(int paramInt) { this.batchsize = paramInt; }

    void setCurrentTotalIndexClickedOn(int paramInt) { this.CurrentTotalIndexClickedOn = paramInt; }

    protected void setQuestionIndex(int paramInt) { this.questionIndex = paramInt; }

    protected void setbatchesSoFar(int paramInt) { this.batchesSoFar = paramInt; }

    protected void showNextBatch() {
        Log.i(" quizfragement ", "in ShowNextBatch");
        unsetAnsweringNowIndicator();
        this.batchesSoFar++;
        updateList();
        Log.i(" quizfragement ", "about to start new fragment");
        Intent intent = new Intent(getActivity(), MainActivity.class);
        saveInstanceState();
        Bundle bundle = new Bundle();
        bundle.putBoolean(this.allBatchAnsweredSave, this.allBatchAnswered);
        bundle.putInt(this.batchesSoFarSave, this.batchesSoFar);
        bundle.putInt(this.CurrentTotalIndexClickedOnSave, this.CurrentTotalIndexClickedOn);
        bundle.putBoolean(this.nowShowingAnswersSave, this.nowShowingAnswers);
        bundle.putInt(this.batchsizeSave, this.batchsize);
        bundle.putInt(this.questionIndexSave, this.questionIndex);
        bundle.putBooleanArray(this.answeredArraySave, this.answeredArray);
        bundle.putBooleanArray(this.puntersAnswerArraySave, this.puntersAnswerArray);
        bundle.putBooleanArray(this.puntersAnswerIsRightArraySave, this.puntersAnswerIsRightArray);
        intent.putExtra(this.bigBundle, bundle);
        Log.i("quiz fragment", "transporter engaged");
        startActivity(intent);
        Log.i("quiz fragment", "after startActivity - IntentToRefresh");
    }

    protected void unsetAnsweringNowIndicator() { this.nowShowingAnswers = false; }

    void updateArray() {
        Log.i(" quizfragement ", "in update array");
        updatePunterAnswered();
        updateRightWrongAnswer();
        updateWithTheGivenAnswer();
        checkIfAllBatchAnswered();
    }

    protected void updateList() {
        int counter = getbatchesSoFar() * getBatchsize();
        int endCounter = getBatchsize() + counter;
        Log.i("off end? endCounter:", (new Integer(endCounter)).toString());
        Log.i("off end? counter is  ", (new Integer(counter)).toString());
        Log.i("off end? qtnBankLength:", (new Integer(this.questionBank.length)).toString());

        if (counter > 0) {

            if (endCounter + getBatchsize() > this.questionBank.length) {
                Log.i("End cnter > questn bank", "yes ");
                setbatchesSoFar(0);
                counter = 0;
                endCounter = getBatchsize() + counter;
                Log.i("endcounter is now ", (new Integer(endCounter)).toString());
                Arrays.fill(this.answeredArray, false);
            }
        }
        Log.i("Afor quzAry updt lpctr:", (new Integer(counter)).toString());
        Log.i("Afore same, End ctr:", (new Integer(endCounter)).toString());
        this.quizArrayList.clear();
        for (int j = counter; j < endCounter; j++) {
            Log.i("qzfrag upd'g qzAry j:", (new Integer(j)).toString());
            this.quizArrayList.add(getQuestion(j));
            counter = j;
            if (this.questionBank[j + 1][0] == null)

            j = endCounter;
        }
    }

    void updatePunterAnswered() { this.answeredArray[getCurrentTotalIndexClickedOn()] = true; }

    void updateRightWrongAnswer() {
        if ((this.puntersCurrentAnswer && this.questionBank[getCurrentTotalIndexClickedOn()][2] == "true") || (!this.puntersCurrentAnswer && this.questionBank[getCurrentTotalIndexClickedOn()][2] == "false")) {
            this.puntersAnswerIsRightArray[getCurrentTotalIndexClickedOn()] = true;
        } else {
            this.puntersAnswerIsRightArray[getCurrentTotalIndexClickedOn()] = false;
        }
        Log.i(" quizfragement ", "updated puntersAnswerIsRight");
    }

    void updateWithTheGivenAnswer() {
        String str = (new Integer(getCurrentTotalIndexClickedOn())).toString();
        this.puntersAnswerArray[getCurrentTotalIndexClickedOn()] = this.puntersCurrentAnswer;
        Log.i(" quizfragement ", "updatg puntrs answ ary");
        Log.i("gtCrntTotIdxCikedOn():", str);
    }
}

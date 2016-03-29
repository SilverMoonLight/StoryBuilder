package jonathan.storybuilder;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by Joe on 2/25/2016.
 */
public class StoryFragment extends Fragment {

    public static final String STORY = "story";
    public static final String ANSWER = "answer";
    public static final String COMPLETE = "complete";
    public static final String SHOW = "show";
    RecyclerView mRecyclerView;
    ArrayList<String> mStoryLines;
    ArrayList<String> mChoice1;
    ArrayList<String> mChoice2;
    ArrayList<String> mChoice3;
    ArrayList<String> mCorrect;
    ArrayList<String> mInteraction;
    ArrayList<String> mCompleteLines;
    TextView mStoryTitle;
    Answer mAnswer;
    Story mStory;
    StoryAdapter mAdapter;
    CompleteStory mComplete;
    protected static boolean canMove = true;
    int num = 0;

    public static StoryFragment newInstance(Story story, Answer answer, CompleteStory completeStory) {
        Bundle args = new Bundle();
        args.putParcelable(STORY, story);
        args.putParcelable(ANSWER, answer);
        args.putParcelable(COMPLETE, completeStory);
        StoryFragment fragment = new StoryFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.story_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);




    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.next_button:

                if(canMove) {
                    num++;
                    mAdapter.setVisiblity(num);
                    mAdapter.onBindViewHolder(mAdapter.mStoryLines, 1);
                    updateUI();
                }
                int x = num -1;
                if (x < (mInteraction.size() -1)) {
                    if (mInteraction.get(x).equals("multi")) {
                        canMove = false;
                    }
                }

                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        mStory = getArguments().getParcelable(STORY);
        mAnswer =  getArguments().getParcelable(ANSWER);
        mComplete = getArguments().getParcelable(COMPLETE);
        setChoices();
        setStoryLines();
        setComplete();

        if (mComplete.getComplete().equals("no")) {
            AlertDialog alertDialog = new AlertDialog.Builder(getContext()).setTitle("start").
                    setMessage("click on the next button on the top right").
                    setPositiveButton(android.R.string.ok, null).create();
            alertDialog.show();
        }



    }

    public static void get() {

        canMove = true;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.story_view, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.storyRecyclerView);
        mRecyclerView.hasFixedSize();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mStoryTitle = (TextView) view.findViewById(R.id.titleName);
        String text = mStory.getTitle();
        mStoryTitle.setText(text);
        updateUI();
        return view;
    }

    public void updateUI() {

        if (mAdapter == null) {
            mAdapter = new StoryAdapter(mStoryLines, mChoice1, mChoice2, mChoice3, mCorrect, mInteraction, mComplete, mCompleteLines);
            mRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.notifyDataSetChanged();
        }
    }

    public void setChoices() {

        mChoice1 = new ArrayList<>();
        mChoice2 = new ArrayList<>();
        mChoice3 = new ArrayList<>();
        mCorrect = new ArrayList<>();
        mInteraction = new ArrayList<>();

        mChoice1.add(mAnswer.getAnswer1Choice1());
        mChoice1.add(mAnswer.getAnswer2Choice1());
        mChoice1.add(mAnswer.getAnswer3Choice1());
        mChoice1.add(mAnswer.getAnswer4Choice1());
        mChoice1.add(mAnswer.getAnswer5Choice1());

        mChoice2.add(mAnswer.getAnswer1Choice2());
        mChoice2.add(mAnswer.getAnswer2Choice2());
        mChoice2.add(mAnswer.getAnswer3Choice2());
        mChoice2.add(mAnswer.getAnswer4Choice2());
        mChoice2.add(mAnswer.getAnswer5Choice2());

        mChoice3.add(mAnswer.getAnswer1Choice3());
        mChoice3.add(mAnswer.getAnswer2Choice3());
        mChoice3.add(mAnswer.getAnswer3Choice3());
        mChoice3.add(mAnswer.getAnswer4Choice3());
        mChoice3.add(mAnswer.getAnswer5Choice3());

        mCorrect.add(mAnswer.getAnswer1Correct());
        mCorrect.add(mAnswer.getAnswer2Correct());
        mCorrect.add(mAnswer.getAnswer3Correct());
        mCorrect.add(mAnswer.getAnswer4Correct());
        mCorrect.add(mAnswer.getAnswer5Correct());

        mInteraction.add(mAnswer.getAnswer1Interaction());
        mInteraction.add(mAnswer.getAnswer2Interaction());
        mInteraction.add(mAnswer.getAnswer3Interaction());
        mInteraction.add(mAnswer.getAnswer4Interaction());
        mInteraction.add(mAnswer.getAnswer5Interaction());


    }

    public void setComplete() {
        mCompleteLines = new ArrayList<>();

        mCompleteLines.add(mComplete.getLine1());
        mCompleteLines.add(mComplete.getLine2());
        mCompleteLines.add(mComplete.getLine3());
        mCompleteLines.add(mComplete.getLine4());
        if (mComplete.getLine5() != null) {
            mCompleteLines.add(mComplete.getLine5());
        }
        mCompleteLines.add(mComplete.getFinalLine());
    }

    public void setStoryLines() {
        mStoryLines = new ArrayList<>();

        mStoryLines.add(mStory.getLine1());
        mStoryLines.add(mStory.getLine2());
        mStoryLines.add(mStory.getLine3());
        mStoryLines.add(mStory.getLine4());
        if(mStory.getLine5() != null) {
            mStoryLines.add(mStory.getLine5());
        }
        mStoryLines.add(mStory.getFinalLine());
    }

    class StoryAdapter extends RecyclerView.Adapter<StoryLines> {

        ArrayList<String> mStoryPart;
        ArrayList<String> mCho1;
        ArrayList<String> mCho2;
        ArrayList<String> mCho3;
        ArrayList<String> mCorr;
        ArrayList<String> mInterList;
        StoryLines mStoryLines;
        CompleteStory mCompleteStory;
        ArrayList<String> mCompleteList;
        int number = 0;
        public StoryAdapter(ArrayList<String> lines, ArrayList<String> choice1, ArrayList<String> choice2,
                            ArrayList<String> choice3, ArrayList<String> correct, ArrayList<String> interaction, CompleteStory completeStory, ArrayList<String> comepeltelines) {
            mStoryPart = lines;
            mCho1 = choice1;
            mCho2 = choice2;
            mCho3 = choice3;
            mCorr = correct;
            mInterList = interaction;
            mCompleteStory = completeStory;
            mCompleteList = comepeltelines;
        }

        public void setVisiblity(int num) {
            number = num;
        }

        @Override
        public StoryLines onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
            mStoryLines  = new StoryLines(view);
            mStoryLines.setCompleteStory(mCompleteStory);
            return mStoryLines;
        }

        @Override
        public void onBindViewHolder(StoryLines holder, int position) {
            if(mCompleteStory.getComplete().equals("no")) {
                holder.startStory(mStoryPart.get(position));


                if (holder.getAdapterPosition() < (mStoryPart.size() - 1)) {
                    holder.setLineType(mInterList.get(position));
                    if (holder.mType.equals("multi")) {
                        holder.setChoices(mCho1.get(position), mCho2.get(position),
                                mCho3.get(position), mCorr.get(position), mStoryPart.get(position));
                    } else if (holder.mType.equals("none")) {

                    }
                }

                if (number > 0) {

                    if (holder.getAdapterPosition() < number) {
                        holder.mRow.setVisibility(View.VISIBLE);


                    }
                }
            } else {
                holder.showStory(mCompleteList.get(position));
            }
        }

        @Override
        public int getItemCount() {
            return mStoryPart.size();
        }
    }

    class StoryLines extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView mRow;
        String mType;
        MultiChoiceDialog choices;
        FillInDialog mFillInDialog;
        FinalDialog mFinalDialog;
        CompleteStory mCompleteStory;

        public StoryLines(View itemView) {
            super(itemView);
            mRow = (TextView) itemView.findViewById(R.id.rowtextView);
            itemView.setOnClickListener(this);
        }

        public void setCompleteStory(CompleteStory completeStory) {
            mCompleteStory =completeStory;
        }

        public void setLineType(String type) {
            mType = type;
        }

        public void setChoices(String choices1, String choice2, String choice3, String correct, String row) {

            choices = MultiChoiceDialog.newInstance(choices1, choice2, choice3 ,correct, row);
        }

        public void startStory(String question) {

            mRow.setText(question);
            mRow.setVisibility(View.INVISIBLE);

        }

        public void showStory(String show) {
            mRow.setText(show);
        }


        @Override
        public void onClick(View v) {
            FragmentManager fragmentManager = getFragmentManager();
            if(getAdapterPosition() < num) {
                if(getAdapterPosition() == (mStoryLines.size() - 1)) {
                    mFinalDialog = new FinalDialog();
                    mFinalDialog.newInstance(mRow.getText().toString(), mCompleteStory);
                    mFinalDialog.show(fragmentManager, SHOW);
                } else if (mType.equals("multi")) {
                    choices.show(fragmentManager, SHOW);
                } else  {

                }
            }
        }
    }
}

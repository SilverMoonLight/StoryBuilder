package jonathan.storybuilder;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Joe on 2/26/2016.
 */
public class FinalDialog extends DialogFragment {

    protected static String mFinalQuestion;
    EditText mAnswer;
    TextView mQuestionLabel;
    static CompleteStory mCompleteStory;

    public static void newInstance(String finalQuestion, CompleteStory completeStory) {
        mFinalQuestion = finalQuestion;
        mCompleteStory = completeStory;
    }
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        View view = LayoutInflater.from(getActivity()).inflate(R.layout.final_dialog, null);

        mQuestionLabel = (TextView) view.findViewById(R.id.finalQuestionLabel);
        mQuestionLabel.setText(mFinalQuestion);
        mAnswer = (EditText) view.findViewById(R.id.userFinalAnswer);


        return new AlertDialog.Builder(getActivity()).setView(view).setPositiveButton("Submit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String reponse = mAnswer.getText().toString().trim().toLowerCase();
                if(reponse.equals("no") || reponse.equals("yes")) {

                    mCompleteStory.setResponse(reponse);
                    mCompleteStory.setComplete("yes");
                    CompleteStories stories = CompleteStories.get(getContext());
                    stories.updateStory(mCompleteStory);
                    Intent intent = new Intent();
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.setClass(getActivity(), MainActivity.class);
                    startActivity(intent);
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setTitle("Error").setMessage("Please enter yes or no").setPositiveButton("Ok", null);
                    builder.show();
                }
            }
        }).create();
    }
}

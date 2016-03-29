package jonathan.storybuilder;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Joe on 2/25/2016.
 */
public class Answer implements Parcelable {

    private String mAnswer1Choice1;
    private String mAnswer1Choice2;
    private String mAnswer1Choice3;
    private String mAnswer1Correct;
    private String mAnswer1Interaction;
    private String mAnswer2Choice1;
    private String mAnswer2Choice2;
    private String mAnswer2Choice3;
    private String mAnswer2Correct;
    private String mAnswer2Interaction;
    private String mAnswer3Choice1;
    private String mAnswer3Choice2;
    private String mAnswer3Choice3;
    private String mAnswer3Correct;
    private String mAnswer3Interaction;
    private String mAnswer4Choice1;
    private String mAnswer4Choice2;
    private String mAnswer4Choice3;
    private String mAnswer4Correct;
    private String mAnswer4Interaction;
    private String mAnswer5Choice1;
    private String mAnswer5Choice2;
    private String mAnswer5Choice3;
    private String mAnswer5Correct;
    private String mAnswer5Interaction;

    public Answer() {

    }

    public String getAnswer1Choice1() {
        return mAnswer1Choice1;
    }

    public void setAnswer1Choice1(String answer1Choice1) {
        mAnswer1Choice1 = answer1Choice1;
    }

    public String getAnswer1Choice2() {
        return mAnswer1Choice2;
    }

    public void setAnswer1Choice2(String answer1Choice2) {
        mAnswer1Choice2 = answer1Choice2;
    }

    public String getAnswer1Choice3() {
        return mAnswer1Choice3;
    }

    public void setAnswer1Choice3(String answer1Choice3) {
        mAnswer1Choice3 = answer1Choice3;
    }

    public String getAnswer1Correct() {
        return mAnswer1Correct;
    }

    public void setAnswer1Correct(String answer1Correct) {
        mAnswer1Correct = answer1Correct;
    }

    public String getAnswer1Interaction() {
        return mAnswer1Interaction;
    }

    public void setAnswer1Interaction(String answer1Interaction) {
        mAnswer1Interaction = answer1Interaction;
    }

    public String getAnswer2Choice1() {
        return mAnswer2Choice1;
    }

    public void setAnswer2Choice1(String answer2Choice1) {
        mAnswer2Choice1 = answer2Choice1;
    }

    public String getAnswer2Choice2() {
        return mAnswer2Choice2;
    }

    public void setAnswer2Choice2(String answer2Choice2) {
        mAnswer2Choice2 = answer2Choice2;
    }

    public String getAnswer2Choice3() {
        return mAnswer2Choice3;
    }

    public void setAnswer2Choice3(String answer2Choice3) {
        mAnswer2Choice3 = answer2Choice3;
    }

    public String getAnswer2Correct() {
        return mAnswer2Correct;
    }

    public void setAnswer2Correct(String answer2Correct) {
        mAnswer2Correct = answer2Correct;
    }

    public String getAnswer2Interaction() {
        return mAnswer2Interaction;
    }

    public void setAnswer2Interaction(String answer2Interaction) {
        mAnswer2Interaction = answer2Interaction;
    }

    public String getAnswer3Choice1() {
        return mAnswer3Choice1;
    }

    public void setAnswer3Choice1(String answer3Choice1) {
        mAnswer3Choice1 = answer3Choice1;
    }

    public String getAnswer3Choice2() {
        return mAnswer3Choice2;
    }

    public void setAnswer3Choice2(String answer3Choice2) {
        mAnswer3Choice2 = answer3Choice2;
    }

    public String getAnswer3Choice3() {
        return mAnswer3Choice3;
    }

    public void setAnswer3Choice3(String answer3Choice3) {
        mAnswer3Choice3 = answer3Choice3;
    }

    public String getAnswer3Correct() {
        return mAnswer3Correct;
    }

    public void setAnswer3Correct(String answer3Correct) {
        mAnswer3Correct = answer3Correct;
    }

    public String getAnswer3Interaction() {
        return mAnswer3Interaction;
    }

    public void setAnswer3Interaction(String answer3Interaction) {
        mAnswer3Interaction = answer3Interaction;
    }

    public String getAnswer4Choice1() {
        return mAnswer4Choice1;
    }

    public void setAnswer4Choice1(String answer4Choice1) {
        mAnswer4Choice1 = answer4Choice1;
    }

    public String getAnswer4Choice2() {
        return mAnswer4Choice2;
    }

    public void setAnswer4Choice2(String answer4Choice2) {
        mAnswer4Choice2 = answer4Choice2;
    }

    public String getAnswer4Choice3() {
        return mAnswer4Choice3;
    }

    public void setAnswer4Choice3(String answer4Choice3) {
        mAnswer4Choice3 = answer4Choice3;
    }

    public String getAnswer4Correct() {
        return mAnswer4Correct;
    }

    public void setAnswer4Correct(String answer4Correct) {
        mAnswer4Correct = answer4Correct;
    }

    public String getAnswer4Interaction() {
        return mAnswer4Interaction;
    }

    public void setAnswer4Interaction(String answer4Interaction) {
        mAnswer4Interaction = answer4Interaction;
    }

    public String getAnswer5Choice1() {
        return mAnswer5Choice1;
    }

    public void setAnswer5Choice1(String answer5Choice1) {
        mAnswer5Choice1 = answer5Choice1;
    }

    public String getAnswer5Choice2() {
        return mAnswer5Choice2;
    }

    public void setAnswer5Choice2(String answer5Choice2) {
        mAnswer5Choice2 = answer5Choice2;
    }

    public String getAnswer5Choice3() {
        return mAnswer5Choice3;
    }

    public void setAnswer5Choice3(String answer5Choice3) {
        mAnswer5Choice3 = answer5Choice3;
    }

    public String getAnswer5Correct() {
        return mAnswer5Correct;
    }

    public void setAnswer5Correct(String answer5Correct) {
        mAnswer5Correct = answer5Correct;
    }

    public String getAnswer5Interaction() {
        return mAnswer5Interaction;
    }

    public void setAnswer5Interaction(String answer5Interaction) {
        mAnswer5Interaction = answer5Interaction;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(mAnswer1Choice1);
        dest.writeString(mAnswer1Choice2);
        dest.writeString(mAnswer1Choice3);
        dest.writeString(mAnswer1Correct);
        dest.writeString(mAnswer1Interaction);
        dest.writeString(mAnswer2Choice1);
        dest.writeString(mAnswer2Choice2);
        dest.writeString(mAnswer2Choice3);
        dest.writeString(mAnswer2Correct);
        dest.writeString(mAnswer2Interaction);
        dest.writeString(mAnswer3Choice1);
        dest.writeString(mAnswer3Choice2);
        dest.writeString(mAnswer3Choice3);
        dest.writeString(mAnswer3Correct);
        dest.writeString(mAnswer3Interaction);
        dest.writeString(mAnswer4Choice1);
        dest.writeString(mAnswer4Choice2);
        dest.writeString(mAnswer4Choice3);
        dest.writeString(mAnswer4Correct);
        dest.writeString(mAnswer4Interaction);
        dest.writeString(mAnswer5Choice1);
        dest.writeString(mAnswer5Choice2);
        dest.writeString(mAnswer5Choice3);
        dest.writeString(mAnswer5Correct);
        dest.writeString(mAnswer5Interaction);

    }

    private Answer(Parcel in) {
        mAnswer1Choice1 = in.readString();
        mAnswer1Choice2 = in.readString();
        mAnswer1Choice3 = in.readString();
        mAnswer1Correct = in.readString();
        mAnswer1Interaction = in.readString();
        mAnswer2Choice1 = in.readString();
        mAnswer2Choice2 = in.readString();
        mAnswer2Choice3 = in.readString();
        mAnswer2Correct = in.readString();
        mAnswer2Interaction = in.readString();
        mAnswer3Choice1 = in.readString();
        mAnswer3Choice2 = in.readString();
        mAnswer3Choice3 = in.readString();
        mAnswer3Correct = in.readString();
        mAnswer3Interaction = in.readString();
        mAnswer4Choice1 = in.readString();
        mAnswer4Choice2 = in.readString();
        mAnswer4Choice3 = in.readString();
        mAnswer4Correct = in.readString();
        mAnswer4Interaction = in.readString();
        mAnswer5Choice1 = in.readString();
        mAnswer5Choice2 = in.readString();
        mAnswer5Choice3 = in.readString();
        mAnswer5Correct = in.readString();
        mAnswer5Interaction = in.readString();

    }

    public static final Creator<Answer> CREATOR = new Creator<Answer>() {
        @Override
        public Answer createFromParcel(Parcel source) {
            return new Answer(source);
        }

        @Override
        public Answer[] newArray(int size) {
            return new Answer[0];
        }
    };
}

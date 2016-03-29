package jonathan.storybuilder;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Joe on 2/29/2016.
 */
public class CompleteStory implements Parcelable {
    private String mTitle;
    private String mLine1;
    private String mLine2;
    private String mLine3;
    private String mLine4;
    private String mLine5;
    private String mFinalLine;
    private String mResponse;
    private String mComplete;

    public CompleteStory() {

    }

    public CompleteStory(String title) {
        mTitle = title;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getLine1() {
        return mLine1;
    }

    public void setLine1(String line1) {
        mLine1 = line1;
    }

    public String getLine2() {
        return mLine2;
    }

    public void setLine2(String line2) {
        mLine2 = line2;
    }

    public String getLine3() {
        return mLine3;
    }

    public void setLine3(String line3) {
        mLine3 = line3;
    }

    public String getLine4() {
        return mLine4;
    }

    public void setLine4(String line4) {
        mLine4 = line4;
    }

    public String getLine5() {
        return mLine5;
    }

    public void setLine5(String line5) {
        mLine5 = line5;
    }

    public String getFinalLine() {
        return mFinalLine;
    }

    public void setFinalLine(String finalLine) {
        mFinalLine = finalLine;
    }

    public String getResponse() {
        return mResponse;
    }

    public void setResponse(String response) {
        mResponse = response;
    }

    public String getComplete() {
        return mComplete;
    }

    public void setComplete(String complete) {
        mComplete = complete;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mTitle);
        dest.writeString(mLine1);
        dest.writeString(mLine2);
        dest.writeString(mLine3);
        dest.writeString(mLine4);
        dest.writeString(mLine5);
        dest.writeString(mFinalLine);
        dest.writeString(mResponse);
        dest.writeString(mComplete);
    }

    public CompleteStory(Parcel in) {
        mTitle = in.readString();
        mLine1 = in.readString();
        mLine2 = in.readString();
        mLine3 = in.readString();
        mLine4 = in.readString();
        mLine5 = in.readString();
        mFinalLine = in.readString();
        mResponse = in.readString();
        mComplete = in.readString();
    }

    public static final Creator<CompleteStory> CREATOR = new Creator<CompleteStory>() {
        @Override
        public CompleteStory createFromParcel(Parcel source) {
            return new CompleteStory(source);
        }

        @Override
        public CompleteStory[] newArray(int size) {
            return new CompleteStory[0];
        }
    };
}

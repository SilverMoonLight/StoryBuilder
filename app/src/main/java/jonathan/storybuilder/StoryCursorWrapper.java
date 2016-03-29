package jonathan.storybuilder;

import android.database.Cursor;
import android.database.CursorWrapper;

import jonathan.storybuilder.StoryDbSchema.StoryTable;

/**
 * Created by Joe on 2/29/2016.
 */
public class StoryCursorWrapper extends CursorWrapper{

    public StoryCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public CompleteStory getResponse() {
        String title = getString(getColumnIndex(StoryTable.Cols.TITLE));
        String response = getString(getColumnIndex(StoryTable.Cols.RESPONSE));
        String line1 = getString(getColumnIndex(StoryTable.Cols.LINE1));
        String line2 = getString(getColumnIndex(StoryTable.Cols.LINE2));
        String line3 = getString(getColumnIndex(StoryTable.Cols.LINE3));
        String line4 = getString(getColumnIndex(StoryTable.Cols.LINE4));
        String line5 = getString(getColumnIndex(StoryTable.Cols.LINE5));
        String finalLine = getString(getColumnIndex(StoryTable.Cols.FINAL_LINE));
        String complete = getString(getColumnIndex(StoryTable.Cols.COMPLETE));

        CompleteStory story = new CompleteStory(title);
        story.setResponse(response);
        story.setTitle(title);
        story.setLine1(line1);
        story.setLine2(line2);
        story.setLine3(line3);
        story.setLine4(line4);
        story.setLine5(line5);
        story.setFinalLine(finalLine);
        story.setComplete(complete);
        return story;
    }

}

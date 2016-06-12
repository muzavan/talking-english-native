package kaitor.id.talkingenglish.util;

import android.content.Context;
import android.content.SharedPreferences;

import kaitor.id.talkingenglish.level.fragment.LevelFragment;

/**
 * Created by user pc on 5/30/2016.
 */
public class ProgressUtil {
    public final static String PREF_NAME = "talking_english";
    public final static String KEY_BEGINNER = "beginner";
    public final static String KEY_INTERMEDIATE = "intermediate";
    public final static String KEY_ADVANCED = "advanced";
    private SharedPreferences mSharedPreferences;

    public ProgressUtil(Context ctx){
        mSharedPreferences = ctx.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
    }

    public void setTopic(String topic){
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putBoolean(topic.toLowerCase(),true);
        editor.commit();
    }


    public boolean getTopicStatus(String topic){
        return (mSharedPreferences.contains(topic.toLowerCase()) && mSharedPreferences.getBoolean(topic.toLowerCase(),false));
    }

    public int getBeginner(){
        int count = 0;
        for (String t : LevelUtil.BEGINNER_LEVELS){
            if(mSharedPreferences.contains(t) && mSharedPreferences.getBoolean(t,false)){
                count++;
            }
        }
        return count;
    }

    public int getIntermediate(){
        int count = 0;
        for (String t : LevelUtil.INTERMEDIATE_LEVELS){
            if(mSharedPreferences.contains(t) && mSharedPreferences.getBoolean(t,false)){
                count++;
            }
        }
        return count;
    }

    public int getAdvanced(){
        int count = 0;
        for (String t : LevelUtil.ADVANCED_LEVELS){
            if(mSharedPreferences.contains(t) && mSharedPreferences.getBoolean(t,false)){
                count++;
            }
        }
        return count;
    }
}

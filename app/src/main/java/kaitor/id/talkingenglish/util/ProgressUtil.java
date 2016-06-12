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
        return (mSharedPreferences.contains(topic) && mSharedPreferences.getBoolean(topic,false));
    }

    public float getBeginner(){
        int count = 0;
        for (String t : LevelUtil.BEGINNER_LEVELS){
            if(mSharedPreferences.contains(t) && mSharedPreferences.getBoolean(t,false)){
                count++;
            }
        }
        return (float)count/(float) LevelUtil.BEGINNER_LEVELS.length;
    }

    public float getIntermediate(){
        int count = 0;
        for (String t : LevelUtil.INTERMEDIATE_LEVELS){
            if(mSharedPreferences.contains(t) && mSharedPreferences.getBoolean(t,false)){
                count++;
            }
        }
        return (float)count/(float) LevelUtil.INTERMEDIATE_LEVELS.length;
    }

    public float getAdvanced(){
        int count = 0;
        for (String t : LevelUtil.ADVANCED_LEVELS){
            if(mSharedPreferences.contains(t) && mSharedPreferences.getBoolean(t,false)){
                count++;
            }
        }
        return (float)count/(float) LevelUtil.ADVANCED_LEVELS.length;
    }
}

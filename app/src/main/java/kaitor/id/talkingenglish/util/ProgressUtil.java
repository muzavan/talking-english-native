package kaitor.id.talkingenglish.util;

import android.content.Context;
import android.content.SharedPreferences;

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

    public void setBeginner(int progress){
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putInt(KEY_BEGINNER,progress);
        editor.commit();
    }

    public void setIntermediate(int progress){
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putInt(KEY_INTERMEDIATE,progress);
        editor.commit();
    }

    public void setAdvanced(int progress){
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putInt(KEY_ADVANCED,progress);
        editor.commit();
    }

    public int getBeginner(){
        return mSharedPreferences.getInt(KEY_BEGINNER,0);
    }

    public int getIntermediate(){
        return mSharedPreferences.getInt(KEY_INTERMEDIATE,0);
    }

    public int getAdvanced(){
        return mSharedPreferences.getInt(KEY_ADVANCED,0);
    }
}

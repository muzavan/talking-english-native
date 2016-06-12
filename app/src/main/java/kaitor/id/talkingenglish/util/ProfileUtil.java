package kaitor.id.talkingenglish.util;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by user pc on 5/27/2016.
 */
public class ProfileUtil {
    public final static String PREF_NAME = "talking_english";
    public final static String KEY_NAME = "talking_name";
    public final static String KEY_SCORE = "talking_score";
    private SharedPreferences mSharedPreferences;

    public ProfileUtil(Context ctx){
        mSharedPreferences = ctx.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
    }


    public void setName(String name){
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(KEY_NAME,name);
        editor.commit();
    }

    public String getName(){
        return mSharedPreferences.getString(KEY_NAME,"Anonim");
    }

    public boolean isLogin(){
        return mSharedPreferences.contains(KEY_NAME);
    }

    public int getScore() {return mSharedPreferences.getInt(KEY_SCORE,0);}

    public void setScore(int score){
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putInt(KEY_SCORE,score);
        editor.commit();
    }


}

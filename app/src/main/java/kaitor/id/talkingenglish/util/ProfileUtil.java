package kaitor.id.talkingenglish.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by user pc on 5/27/2016.
 */
public class ProfileUtil {
    public final static String PREF_NAME = "talking_english";
    public final static String KEY_NAME = "talking_name";
    Context ctx;

    public ProfileUtil(Context ctx){
        this.ctx = ctx;
    }

    public void setName(String name){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_NAME,name);
        editor.commit();
    }

    public String getName(){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_NAME,"Anonim");
    }

    public boolean isLogin(){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.contains(KEY_NAME);
    }
}

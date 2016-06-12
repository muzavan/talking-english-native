package kaitor.id.talkingenglish.level.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import kaitor.id.talkingenglish.DictionaryActivity;
import kaitor.id.talkingenglish.R;
import kaitor.id.talkingenglish.level.model.DialogueLevel;
import kaitor.id.talkingenglish.main.Dictionary;

/**
 * Created by user pc on 6/12/2016.
 */
public class DialogueAdapter extends ArrayAdapter<String> {
    public DialogueAdapter(Context context, int resource, String[] objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        // assign the view we are converting to a local variable
        View v = convertView;

        // first check to see if the view is null. if so, we have to inflate it.
        // to inflate it basically means to render, or show, the view.
        if (v == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.item_dialogue, null);
        }

        String d = getItem(position);

        if (d != null) {
            TextView tvWord = (TextView) v.findViewById(R.id.tv_dialogue);
            tvWord.setText(d);
            if(position%2 == 0){
                tvWord.setTextColor(getContext().getResources().getColor(R.color.green_beginner));
            }
        }

        return v;
    }
}

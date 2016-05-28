package kaitor.id.talkingenglish.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import kaitor.id.talkingenglish.R;

/**
 * Created by user pc on 5/28/2016.
 */
public class DictionaryAdapter extends ArrayAdapter<Dictionary> {

    public DictionaryAdapter(Context context, int resource, List<Dictionary> objects) {
        super(context, resource, objects);
    }

    public View getView(int position, View convertView, ViewGroup parent){

        // assign the view we are converting to a local variable
        View v = convertView;

        // first check to see if the view is null. if so, we have to inflate it.
        // to inflate it basically means to render, or show, the view.
        if (v == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.item_dictionary, null);
        }

        Dictionary dict = getItem(position);

        if(dict != null){
            TextView tvWord = (TextView)v.findViewById(R.id.tv_word);
            tvWord.setText(dict.getWord());
        }

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TO-DO : Next Fragment to Show Word Detail
            }
        });

        return v;
    }
}

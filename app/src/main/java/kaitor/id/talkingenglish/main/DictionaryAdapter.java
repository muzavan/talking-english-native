package kaitor.id.talkingenglish.main;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import kaitor.id.talkingenglish.DictionaryActivity;
import kaitor.id.talkingenglish.MainActivity;
import kaitor.id.talkingenglish.R;

/**
 * Created by user pc on 5/28/2016.
 */
public class DictionaryAdapter extends ArrayAdapter<Dictionary> {

    private ArrayList<Dictionary> allWords = new ArrayList<>();

    public DictionaryAdapter(Context context, int resource, List<Dictionary> objects) {
        super(context, resource, objects);
        initData();
    }


    public void initData() {
        // TODO : Get All Words from JSON
        allWords.add(new Dictionary("Sing","Bernyanyi","(v) Kata kerja","",""));
        allWords.add(new Dictionary("Mother","Ibu","(n) Kata benda","",""));
        allWords.add(new Dictionary("Father","Ayah","(n) Kata benda","",""));
        allWords.add(new Dictionary("You","Kamu/Engkau/Dirimu","(p) Kata ganti orang","",""));
        allWords.add(new Dictionary("Close","Tutup","(v) Kata kerja","",""));
        addAll(allWords);
    }

    public View getView(final int position, View convertView, ViewGroup parent) {

        // assign the view we are converting to a local variable
        View v = convertView;

        // first check to see if the view is null. if so, we have to inflate it.
        // to inflate it basically means to render, or show, the view.
        if (v == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.item_dictionary, null);
        }

        Dictionary dict = getItem(position);

        if (dict != null) {
            TextView tvWord = (TextView) v.findViewById(R.id.tv_word);
            tvWord.setText(dict.getWord());
            tvWord.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getContext(), DictionaryActivity.class);
                    intent.putExtra("Dictionary",getItem(position));
                    getContext().startActivity(intent);

                }
            });
        }

        return v;
    }

    public void filterByWord(String word) {
        clear();
        for (Dictionary d : allWords) {
            if (d.getWord().toLowerCase().contains(word.toLowerCase())) {
                add(d);
            }
        }
    }
}

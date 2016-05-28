package kaitor.id.talkingenglish.main;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import kaitor.id.talkingenglish.R;

/**
 * Created by user pc on 5/28/2016.
 */
public class DictionaryFragment extends Fragment {
    public DictionaryAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dictionary,container,false);

        //Prepare List Adapter
        ListView listDictionary = (ListView) view.findViewById(R.id.list_dictionary);
        adapter = new DictionaryAdapter(getContext(),R.layout.item_dictionary, new ArrayList<Dictionary>());
        listDictionary.setAdapter(adapter);

        //Prepare Query
        final EditText editSearchWord = (EditText) view.findViewById(R.id.edit_search_word);
        editSearchWord.setEnabled(true);
        editSearchWord.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                editSearchWord.requestFocusFromTouch(); // to get focus from tab host
                return false;
            }
        });
        editSearchWord.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String word = s.toString();
                if(!word.equals("")){
                    adapter.filterByWord(word);
                }
            }
        });
        return view;
    }
}

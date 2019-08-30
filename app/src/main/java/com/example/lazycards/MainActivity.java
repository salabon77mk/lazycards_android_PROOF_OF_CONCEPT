package com.example.lazycards;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final String web_server = "";

    protected static final String FAST_SUB = "FAST_SUB";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /* Fast submit that creates an array of
    *   word : word to add to anki
    *   tags : tags to add to card
    *   deck : which deck to add to // fig this out, make an anki req to create a spinner
    *   populated with current decks
    *
    *   Meant to be fast and dumb (just add a new card and forget)
     */
    public void submit(View view){
  //      Intent intent = new Intent(this, Submit.class);
        EditText word_et = (EditText) findViewById(R.id.editText_word);
        EditText deck_et = (EditText) findViewById(R.id.editText_deck);
        EditText tags_et = (EditText) findViewById(R.id.editText_tags);

        String word = word_et.getText().toString();
        String deck = deck_et.getText().toString();
        List<String> tags = splitTags(tags_et);

        JSONObject payload = new JSONObject();

        try {
            payload.put("word", word);
            payload.put("deck", deck);

            JSONArray tags_j = new JSONArray();
            for(String s : tags){ tags_j.put(s); }

            payload.put("tags", tags_j);
        } catch (JSONException e) {
            e.printStackTrace(); // wil this ever even happen??
        }

        fast_post(payload);
    }

    private List<String> splitTags(EditText tags_et){
        String tags = tags_et.getText().toString();
        if(tags.length() == 0){
            return new ArrayList<>();
        }
        String[] items = tags.split(" ");
        return Arrays.asList(items);
    }

    private void fast_post(JSONObject data){

    }
}

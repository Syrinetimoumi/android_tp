package com.example.tp5;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class MainActivity extends AppCompatActivity {
    FirebaseFirestore db;



// Dans votre activité principale (MainActivity.java)
        private AutoCompleteTextView autoCompleteTextView;
        private ListView listView;
        private ArrayAdapter<String> adapter;

        // Exemple de données d'étudiants (à remplacer par vos propres données)
        private List<String> studentNames = new ArrayList<>() ;
      //  private int[] studentNotes = {10, "B", "C", "D"};

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            db = FirebaseFirestore.getInstance();
            db.collection("glsi")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            for (QueryDocumentSnapshot doc:task.getResult()
                                 ) {
                                Log.v("Names",doc.getId());
                                studentNames.add(doc.getId());
                            }
                        }
                    });

            autoCompleteTextView = findViewById(R.id.autoCompleteTextView);
            listView = findViewById(R.id.listView);

            // Créez un adaptateur pour l'AutoCompleteTextView
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, studentNames);
            autoCompleteTextView.setAdapter(adapter);

            // Lorsqu'un nom est sélectionné dans l'AutoCompleteTextView
                autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String selectedname = (String) parent.getItemAtPosition(position);
                        Log.v("Data",selectedname);
                    }
                });
        }

    private Map<String, List<Integer>> studentGradesMap = new HashMap<>();



    public class Note {
        private int value;

        public Note(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public String getEmoji() {
            return value > 10 ? "😊" : "😢";
        }
    }

    public class NoteAdapter extends ArrayAdapter<Note> {
        public NoteAdapter(MainActivity context, List<Note> notes) {
            super(context, 0, notes);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Note note = getItem(position);
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
            }
            TextView textView = (TextView) convertView;
            textView.setText( note.getEmoji()+ "    " +note.getValue() );
            return convertView;
        }
    }


}
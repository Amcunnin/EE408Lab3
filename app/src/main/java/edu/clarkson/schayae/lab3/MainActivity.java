package edu.clarkson.schayae.lab3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Button;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //declarations
    private Button saveButton;
    private Button searchButton;
    private EditText message;
    private ListView entryList;
    private ArrayList<String> entryArray = new ArrayList<String>();
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //assign variables to widgets
        saveButton = (Button) findViewById(R.id.saveButton);
        searchButton = (Button) findViewById(R.id.searchButton);
        entryList = (ListView) findViewById(R.id.entryList);

        //creating data object associations behind list view
        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, entryArray);
        entryList.setAdapter(adapter);

        saveButton.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View view) {
                                              entryArray.add(message.getText().toString());
                                              adapter.notifyDataSetChanged();
                                          }
                                      }
        );

        searchButton.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View view) {
                                                String data = message.getText().toString();
                                                int position = adapter.getPosition(data);
                                                if (position >= 0) {
                                                    Toast.makeText(getBaseContext(), data + " is in the list", Toast.LENGTH_LONG).show();
                                                }
                                                else {
                                                    Toast.makeText(getBaseContext(), data + " is not in the list", Toast.LENGTH_LONG).show();
                                                }
                                            }
                                        }
        );
    }
}
package sg.edu.rp.c346.id20019652.demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etElement;
    EditText etIndexElement;
    Button btnAdd;
    Button btnRemove;
    Button btnUpdate;
    ListView lvColour;
    ArrayList<String> alColours;
    ArrayAdapter<String> aaColour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etElement = findViewById(R.id.editTextColour);
        etIndexElement = findViewById(R.id.editTextIndex);
        btnAdd = findViewById(R.id.buttonAddition);
        btnRemove = findViewById(R.id.buttonRemove);
        btnUpdate = findViewById(R.id.buttonUpdate);
        lvColour = findViewById(R.id.listViewColour);

        alColours = new ArrayList<>();
        alColours.add("Red");
        alColours.add("Orange");

        aaColour = new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_list_item_1, alColours);
        lvColour.setAdapter(aaColour);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newColour = etElement.getText().toString();
                int pos = Integer.parseInt(etIndexElement.getText().toString());

                //check if index is avail in arraylist
                if(pos <= alColours.size()) {
                    //add to arraylist
                    alColours.add(pos, newColour);
                    //call adapter to update, notify there's a data change
                    aaColour.notifyDataSetChanged();
                }
                else {
                    String strMssg = "Please enter a correct position number";
                    Toast.makeText(MainActivity.this, strMssg, Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int posRemove= Integer.parseInt(etIndexElement.getText().toString());

                //check if position index is avail in arraylist
                if(posRemove <= alColours.size()){
                    //remove from arraylist
                    alColours.remove(posRemove);
                    //call adapter to update, notify there's a data change
                    aaColour.notifyDataSetChanged();
                }
                else {
                    String strMssg = "Please enter a correct position number";
                    Toast.makeText(MainActivity.this, strMssg, Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String updateColour = etElement.getText().toString();
                int posUpdate = Integer.parseInt(etIndexElement.getText().toString());

                //check if position index is avail in arraylist
                if(posUpdate <= alColours.size()){
                    //update to arraylist
                    alColours.set(posUpdate, updateColour);
                    //call adapter to update, notify there's a data change
                    aaColour.notifyDataSetChanged();
                }
                else {
                    String strMssg = "Please enter a correct position number";
                    Toast.makeText(MainActivity.this, strMssg, Toast.LENGTH_SHORT).show();
                }
            }
        });
        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String colour = alColours.get(position);
                Toast.makeText(MainActivity.this, colour, Toast.LENGTH_SHORT).show();
                etElement.setText(alColours.get(position));
                etIndexElement.setText(String.valueOf(position));
            }
        });
    }
}
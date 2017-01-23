package ch01.example09_section_headers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import com.darwindeveloper.dispositivosmoviles.R;

public class SectionsActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListView list = new ListView(this);

        SimpleSectionsAdapter<String> adapter = new SimpleSectionsAdapter<String>(
                list, /* Context for resource inflation */
                R.layout.ch01_9_list_header, /* Layout for header views */
                android.R.layout.simple_list_item_1 /* Layout for item views */
        ) {
            //Click handler for item taps
            @Override
            public void onSectionItemClick(String item) {
                Toast.makeText(SectionsActivity.this, item, Toast.LENGTH_SHORT).show();
            }
        };

        adapter.addSection("Fruits", new String[]{"Apples", "Oranges", "Bananas", "Mangos"});
        adapter.addSection("Vegetables", new String[]{"Carrots", "Peas", "Broccoli"});
        adapter.addSection("Meats", new String[]{"Pork", "Chicken", "Beef", "Lamb"});

        list.setAdapter(adapter);
        setContentView(list);
    }
}
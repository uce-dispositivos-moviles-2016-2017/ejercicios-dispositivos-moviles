package ch01.example07_adapterviewempty;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import com.darwindeveloper.dispositivosmoviles.R;


public class EmptyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ch01_7_empty);
        
        ListView list = (ListView)findViewById(R.id.mylist);
        TextView empty = (TextView)findViewById(R.id.myempty);
        
        /*
         * Attach the ch01_7_empty view.  The framework will show this
         * view when the ListView's adapter has no elements.
         */
        list.setEmptyView(empty);

        //Continue adding adapters and data to the list
    }

}

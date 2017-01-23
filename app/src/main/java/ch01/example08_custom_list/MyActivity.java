package ch01.example08_custom_list;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.darwindeveloper.dispositivosmoviles.R;

public class MyActivity extends AppCompatActivity {
    
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListView list = new ListView(this);
        setContentView(list);
        
        CustomAdapter adapter = new CustomAdapter(this,
                    R.layout.ch01_8_custom_row,
                    R.id.line1,
                    new String[] {"Bill","Tom","Sally","Jenny"});
        list.setAdapter(adapter);

    }

    private static class CustomAdapter extends ArrayAdapter<String> {
        
        public CustomAdapter(Context context, int layout, int resId, String[] items) {
            //Call through to ArrayAdapter implementation
            super(context, layout, resId, items);
        }
        
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row = convertView;
            //Inflate a new row if one isn't recycled
            if(row == null) {
                row = LayoutInflater.from(getContext()).inflate(R.layout.ch01_8_custom_row, parent, false);
            }

            String item = getItem(position);
            ImageView left = (ImageView)row.findViewById(R.id.leftimage);
            ImageView right = (ImageView)row.findViewById(R.id.rightimage);
            TextView text = (TextView)row.findViewById(R.id.line1);

            left.setImageResource(R.mipmap.ic_launcher);
            right.setImageResource(R.mipmap.ic_launcher);
            text.setText(item);

            return row;
        }
    }
}
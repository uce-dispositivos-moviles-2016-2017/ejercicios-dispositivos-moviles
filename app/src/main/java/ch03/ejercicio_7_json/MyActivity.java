package ch03.ejercicio_7_json;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.darwindeveloper.dispositivosmoviles.R;

import org.json.JSONException;
import org.json.JSONObject;

public class MyActivity extends Activity {
    private static final String JSON_STRING =
            "{\"person\":{\"name\":\"John\",\"age\":30,\"children\":["
            + "{\"name\":\"Billy\",\"age\":5},"
            + "{\"name\":\"Sarah\",\"age\":7},"
            + "{\"name\":\"Tommy\",\"age\":9}"
            + "] } }";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ch03_7_main);

        TextView line1 = (TextView)findViewById(R.id.line1);
        TextView line2 = (TextView)findViewById(R.id.line2);
        TextView line3 = (TextView)findViewById(R.id.line3);
        try {
            JSONObject person = (new JSONObject(JSON_STRING)).getJSONObject("person");
            String name = person.getString("name");
            line1.setText("This person's name is " + name);
            line2.setText(name + " is " + person.getInt("age") + " years old.");
            line3.setText(name + " has " + person.getJSONArray("children").length()
                + " children.");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}

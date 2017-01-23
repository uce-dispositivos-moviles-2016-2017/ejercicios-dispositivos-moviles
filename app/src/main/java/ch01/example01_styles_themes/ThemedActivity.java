package ch01.example01_styles_themes;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.darwindeveloper.dispositivosmoviles.R;

/**
 * @author Darwin Morocho
 */
public class ThemedActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ch01_1_activity_themed);
    }
}

package ch01.example11_transition_animations;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Button b = new Button(this);
        b.setText("Click");
        b.setOnClickListener(this);
        setContentView(b);
    }
    
    @Override
    public void onClick(View v) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
//        overridePendingTransition(R.anim.activity_open_enter, R.anim.activity_open_exit);
    }
    
    @Override
    public void onBackPressed() {
        super.onBackPressed();
//        overridePendingTransition(R.anim.activity_close_enter, R.anim.activity_close_exit);
    }
}

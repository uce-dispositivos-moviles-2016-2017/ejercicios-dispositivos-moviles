package ch01.example11_transition_animations;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import com.darwindeveloper.dispositivosmoviles.R;

public class SupportActivity extends ActionBarActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ch01_11_main);
    }
    
    public void onAddClick(View v) {
        SupportFragment fragment = new SupportFragment();
        
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        //Must be called first!
//        ft.setCustomAnimations(R.anim.activity_open_enter, R.anim.activity_open_exit, R.anim.activity_close_enter, R.anim.activity_close_exit);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.replace(R.id.container_fragment, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }
}

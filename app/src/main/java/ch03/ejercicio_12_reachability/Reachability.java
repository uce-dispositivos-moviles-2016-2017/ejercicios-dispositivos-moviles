package ch03.ejercicio_12_reachability;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.darwindeveloper.dispositivosmoviles.R;

public class Reachability extends Activity {
    
    ReachabilityManager mReach;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ch03_12_main);
     
        mReach = ReachabilityManager.getInstance(this);
        //mReach.isHostReachable("209.85.227.104")
        Toast.makeText(this, "Network "+mReach.isNetworkReachable()+"\nGoogle "+mReach.isHostReachable(0xD155E368), Toast.LENGTH_SHORT).show();
    }
}
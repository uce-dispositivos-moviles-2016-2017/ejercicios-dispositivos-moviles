package ch01.example02_systemui;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.Window;

import com.darwindeveloper.dispositivosmoviles.R;

public class ImmersiveActivity extends ActionBarActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Request this feature so the ActionBar will hide
        supportRequestWindowFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
        setContentView(R.layout.ch01_2_main);

    }
    
    public void onToggleClick(View v) {
        //Here we only need to hide the UI on a tap because
        // the system will make the controls re-appear for us
        // whe the user does an edge swipe from the top or bottom.
        v.setSystemUiVisibility(
                /* This flag tells Android not to shift 
                 * our layout when resizing the window to
                 * hide/show the system elements
                 */
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                /* This flag hides the system status bar.  If
                 * ACTION_BAR_OVERLAY is requested, it will hide
                 * the ActionBar as well.
                 */
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                /* This flag hides the on-screen controls
                 */
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                /* This flag tells the controls to stay hidden until
                 * the user brings them back explicitly with a gesture
                 */
                | View.SYSTEM_UI_FLAG_IMMERSIVE);
    }
}

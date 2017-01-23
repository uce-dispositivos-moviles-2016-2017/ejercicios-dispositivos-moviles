package ch01.example12_static_transforms;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;

import com.darwindeveloper.dispositivosmoviles.R;

@SuppressLint("NewApi")
public class ScrollActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        HorizontalScrollView parentView = new HorizontalScrollView(this);
        PerspectiveScrollContentView contentView = new PerspectiveScrollContentView(this);
        
        // Disable hardware acceleration for this view because dynamic adjustment of
        // child transformations does not currently work in hardware.  You can also
        // disable for the entire Activity or Application with android:hardwareAccelerated="false"
        // in the manifest, but it is often best to disable acceleration in as few places as
        // possible to get the best performance.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            contentView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }
        
        //Add a handful of images to scroll through
        for (int i = 0; i < 20; i++) {
            ImageView iv = new ImageView(this);
            iv.setImageResource(R.mipmap.ic_launcher);
            contentView.addView(iv);
        }
        //Add the views to the display
        parentView.addView(contentView);
        setContentView(parentView);
    }
}

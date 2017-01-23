package ch02.ejercicio_13_14;

import android.app.Activity;
import android.os.Bundle;

import com.darwindeveloper.dispositivosmoviles.R;

public class ImageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RotateZoomImageView imageView = new RotateZoomImageView(this);
        imageView.setImageResource(R.drawable.ic_launcher);
        
        setContentView(imageView);
    }
}

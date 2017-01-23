package com.darwindeveloper.dispositivosmoviles;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.Types.BoomType;
import com.nightonke.boommenu.Types.ButtonType;
import com.nightonke.boommenu.Types.PlaceType;
import com.nightonke.boommenu.Util;

import java.util.ArrayList;
import java.util.List;

import myrecyclerview.FeedItem;
import myrecyclerview.MyRecyclerViewAdapter;
import myrecyclerview.OnItemClickListener;
import uk.co.samuelwall.materialtaptargetprompt.MaterialTapTargetPrompt;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private List<FeedItem> feedsList_cap1=new ArrayList<>();
    private List<FeedItem> feedsList_cap2=new ArrayList<>();
    private List<FeedItem> feedsList_cap3=new ArrayList<>();
    private List<FeedItem> feedsList_cap4=new ArrayList<>();



    private RecyclerView mRecyclerView;
    private MyRecyclerViewAdapter adapter;
    private ProgressBar progressBar;

    //boom menu
    private boolean init = false;
    private BoomMenuButton boomMenuButton;

    MaterialTapTargetPrompt mFabPrompt;

   // private ActionMode mActionMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        boomMenuButton = (BoomMenuButton)findViewById(R.id.boom);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        initCapitulos();//inicializamos los arraylists

        adapter = new MyRecyclerViewAdapter(MainActivity.this, feedsList_cap1);

        mySetADapter();






        new MaterialTapTargetPrompt.Builder(MainActivity.this)
                .setTarget(findViewById(R.id.boom))
                .setPrimaryText("Información y Dependencias")
                .setSecondaryText("Quienes somos, autores, version de la app, librerias, etc.")
                .setOnHidePromptListener(new MaterialTapTargetPrompt.OnHidePromptListener()
                {
                    @Override
                    public void onHidePrompt(MotionEvent event, boolean tappedTarget)
                    {
                        //Do something such as storing a value so that this prompt is never shown again
                    }

                    @Override
                    public void onHidePromptComplete()
                    {

                    }
                })
                .show();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_cap1) {
            adapter = new MyRecyclerViewAdapter(MainActivity.this, feedsList_cap1);
            mySetADapter();
        }
        if (id == R.id.nav_cap2) {
            adapter = new MyRecyclerViewAdapter(MainActivity.this, feedsList_cap2);
            mySetADapter();
        }

        if (id == R.id.nav_cap3) {
            adapter = new MyRecyclerViewAdapter(MainActivity.this, feedsList_cap3);
            mySetADapter();
        }

        if (id == R.id.nav_cap4) {
            adapter = new MyRecyclerViewAdapter(MainActivity.this, feedsList_cap4);
            mySetADapter();
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        // Use a param to record whether the boom button has been initialized
        // Because we don't need to init it again when onResume()
        if (init) return;
        init = true;

        Drawable[] subButtonDrawables = new Drawable[3];
        int[] drawablesResource = new int[]{
                R.drawable.boom,
                R.drawable.java,
                R.drawable.github
        };
        for (int i = 0; i < 3; i++)
            subButtonDrawables[i] = ContextCompat.getDrawable(this, drawablesResource[i]);

        String[] subButtonTexts = new String[]{"BoomMenuButton", "View source code", "Follow me"};

        int[][] subButtonColors = new int[3][2];
        for (int i = 0; i < 3; i++) {
            subButtonColors[i][1] = ContextCompat.getColor(this, R.color.colorPrimary);
            subButtonColors[i][0] = Util.getInstance().getPressedColor(subButtonColors[i][1]);
        }

        // Now with Builder, you can init BMB more convenient
        new BoomMenuButton.Builder()
                .addSubButton(ContextCompat.getDrawable(this, R.drawable.boom), subButtonColors[0], "Acerca de y autores")
                .addSubButton(ContextCompat.getDrawable(this, R.drawable.java), subButtonColors[0], "Librerias y dependencias")
                .addSubButton(ContextCompat.getDrawable(this, R.drawable.github), subButtonColors[0], "Version de la app")
                .button(ButtonType.HAM)
                .boom(BoomType.PARABOLA)
                .place(PlaceType.HAM_3_1)
                .subButtonTextColor(ContextCompat.getColor(this, R.color.black))
                .subButtonsShadow(Util.getInstance().dp2px(2), Util.getInstance().dp2px(2))
                .init(boomMenuButton);


    }

    /**
     * cara las activadades cor capitulos
     */
    public void initCapitulos(){
        feedsList_cap1.add(new FeedItem("CH_01_01_ThemedActivity",ch01.example01_styles_themes.ThemedActivity.class));
        feedsList_cap1.add(new FeedItem("CH_01_01_StyleActivity",ch01.example01_styles_themes.StylesActivity.class));
        feedsList_cap1.add(new FeedItem("CH_01_02_SystemUI",ch01.example02_systemui.MainActivity.class));
        feedsList_cap1.add(new FeedItem("CH_01_03_CustomWidgets",ch01.example03_customwidgets.MyActivity.class));
        feedsList_cap1.add(new FeedItem("CH_01_04_FliperActivity",ch01.example04_animateproperty.FlipperActivity.class));
        feedsList_cap1.add(new FeedItem("CH_01_04_FlipperPauseActivity",ch01.example04_animateproperty.FlipperPauseActivity.class));
        feedsList_cap1.add(new FeedItem("CH_01_04_AnimateActivity",ch01.example04_animateviewproperty.AnimateActivity.class));
        feedsList_cap1.add(new FeedItem("CH_01_04_Animation XML",ch01.example04_animationxml.FlipperActivity.class));
        feedsList_cap1.add(new FeedItem("CH_01_05_Animation Layout",ch01.example05_animatelayout.MainActivity.class));
        feedsList_cap1.add(new FeedItem("CH_01_06_Universal App",ch01.example06_universalapp.UniversalActivity.class));
        feedsList_cap1.add(new FeedItem("CH_01_07_AdapterViewEmpty",ch01.example07_adapterviewempty.EmptyActivity.class));
        feedsList_cap1.add(new FeedItem("CH_01_08_Custom_list",ch01.example08_custom_list.MyActivity.class));
        feedsList_cap1.add(new FeedItem("CH_01_09_Section headers",ch01.example09_section_headers.SectionsActivity.class));
        feedsList_cap1.add(new FeedItem("CH_01_10_compound_controls",ch01.example10_compound_controls.MyActivity.class));
        feedsList_cap1.add(new FeedItem("CH_01_11_Activity_Transitions",ch01.example11_transition_animations.MainActivity.class));
        feedsList_cap1.add(new FeedItem("CH_01_11_Native_Activity",ch01.example11_transition_animations.NativeActivity.class));
        feedsList_cap1.add(new FeedItem("CH_01_11_Support_Activity",ch01.example11_transition_animations.SupportActivity.class));
        feedsList_cap1.add(new FeedItem("CH_01_12_Static Transforms",ch01.example12_static_transforms.MainActivity.class));
        feedsList_cap1.add(new FeedItem("CH_01_12_Static Transforms Scroll",ch01.example12_static_transforms.ScrollActivity.class));
        feedsList_cap1.add(new FeedItem("CH_01_13_RecyclerView",ch01.example13_recyclerview.SimpleRecyclerActivity.class));


//capitulo 2
        feedsList_cap2.add(new FeedItem("CH_02_Toggle Button",ch02.ejercicio_3_4.LockActivity.class));
        feedsList_cap2.add(new FeedItem("CH_02_Check Button",ch02.ejercicio_3_4.ManualRotationActivity.class));
        feedsList_cap2.add(new FeedItem("CH_02_5 context menu",ch02.ejercicio_5.ActionActivity.class));
        feedsList_cap2.add(new FeedItem("CH_02_6 custom Dialog",ch02.ejercicio_6.CustomItemActivity.class));
        feedsList_cap2.add(new FeedItem("CH_02_6 Dialog Activity",ch02.ejercicio_6.DialogActivity.class));
        feedsList_cap2.add(new FeedItem("CH_02_7 Option Menu",ch02.ejercicio_7.OptionsActivity.class));
        feedsList_cap2.add(new FeedItem("CH_02_8 Custom Back",ch02.ejercicio_8.MyActivity.class));
        feedsList_cap2.add(new FeedItem("CH_02_10 Custom Back",ch02.ejercicio_10.MyActivity.class));
        feedsList_cap2.add(new FeedItem("CH_02_11 Custom IME",ch02.ejercicio_11.MainActivity.class));
        feedsList_cap2.add(new FeedItem("CH_02_13_!4 ImageActivity",ch02.ejercicio_13_14.ImageActivity.class));
        feedsList_cap2.add(new FeedItem("CH_02_13_!4 DelegateActivity",ch02.ejercicio_13_14.DelegateActivity.class));
        feedsList_cap2.add(new FeedItem("CH_02_13_!4 PanScrollActivity",ch02.ejercicio_13_14.PanScrollActivity.class));
        feedsList_cap2.add(new FeedItem("CH_02_13_!4 RemoteScrollActivity",ch02.ejercicio_13_14.RemoteScrollActivity.class));





        feedsList_cap3.add(new FeedItem("CH3_01_Main Activity",ch03.ejercicio_1_2_webview.MyActivity.class));
        feedsList_cap3.add(new FeedItem("CH3_02_WEBview",ch03.ejercicio_1_2_webview.MyLocalActivity.class));
        feedsList_cap3.add(new FeedItem("CH3_03_javascript",ch03.ejercicio_3_javascript.MyActivity.class));
        feedsList_cap3.add(new FeedItem("CH3_05_DownloadActivity",ch03.ejercicio_5_dm_sample.DownloadActivity.class));
        feedsList_cap3.add(new FeedItem("CH3_06 SearchActivity",ch03.ejercicio_6_rest.SearchActivity.class));
        feedsList_cap3.add(new FeedItem("CH3_06 AuthActivity",ch03.ejercicio_6_rest.AuthActivity.class));
        feedsList_cap3.add(new FeedItem("CH3_07 JSON",ch03.ejercicio_7_json.MyActivity.class));
        feedsList_cap3.add(new FeedItem("CH3_08 xml PullFeedActivity",ch03.ejercicio_8_xmlpull.PullFeedActivity.class));
        feedsList_cap3.add(new FeedItem("CH3_08 sml PullParserActivity",ch03.ejercicio_8_xmlpull.PullParserActivity.class));
        feedsList_cap3.add(new FeedItem("CH3_08 xmlsax.FeedActivity",ch03.ejercicio_8_xmlsax.FeedActivity.class));
        feedsList_cap3.add(new FeedItem("CH3_09_10 sms Activity",ch03.ejercicio_9_10_sms.SmsActivity.class));
        feedsList_cap3.add(new FeedItem("CH3_09_11 bluetoothp2p.ExchangeActivity",ch03.ejercicio_11_bluetoothp2p.ExchangeActivity.class));
        feedsList_cap3.add(new FeedItem("CH3_09_12 Reachability",ch03.ejercicio_12_reachability.Reachability.class));
        feedsList_cap3.add(new FeedItem("CH3_09_14 usb host",ch03.ejercicio_14_usb_host.USBActivity.class));

        feedsList_cap4.add(new FeedItem("CH4_01 My Location",ch04.ejercicio_1_my_location.MainActivity.class));
        feedsList_cap4.add(new FeedItem("CH4_02_03 BasicMapActivity",ch04.ejercicio_2_3_mapper.BasicMapActivity.class));
        feedsList_cap4.add(new FeedItem("CH4_02_03 MarkerMapActivity",ch04.ejercicio_2_3_mapper.MarkerMapActivity.class));
        feedsList_cap4.add(new FeedItem("CH4_02_03 ShapeMapActivity",ch04.ejercicio_2_3_mapper.ShapeMapActivity.class));
        feedsList_cap4.add(new FeedItem("CH4_04 regionmonitor",ch04.ejercicio_4_regionmonitor.MainActivity.class));
        feedsList_cap4.add(new FeedItem("CH4_05 image capture",ch04.ejercicio_5_image_capture.MyActivity.class));
        feedsList_cap4.add(new FeedItem("CH4_06 camera overlay",ch04.ejercicio_6_camera_overlay.pic.PreviewActivity.class));
        feedsList_cap4.add(new FeedItem("CH4_07 RecognizeActivity",ch04.ejercicio_7_audioin.RecognizeActivity.class));
        feedsList_cap4.add(new FeedItem("CH4_08 Video capture",ch04.ejercicio_8_video_capture.MyActivity.class));
        feedsList_cap4.add(new FeedItem("CH4_08 video overlay",ch04.ejercicio_8_video_overlay.VideoCaptureActivity.class));
        feedsList_cap4.add(new FeedItem("CH4_09 SpeechRecognizer",ch04.ejercicio_9_SpeechRecognizer.RecognizeActivity.class));
        feedsList_cap4.add(new FeedItem("CH4_10 PlayerActivity",ch04.ejercicio_10_playback.PlayerActivity.class));
        feedsList_cap4.add(new FeedItem("CH4_10 VideoPlayerActivity",ch04.ejercicio_10_playback.VideoActivity.class));
        feedsList_cap4.add(new FeedItem("CH4_11 soundpool",ch04.ejercicio_11_soundpool.SoundPoolActivity.class));
        feedsList_cap4.add(new FeedItem("CH4_12 TiltActivity",ch04.ejercicio_12_tilt_sensor.TiltActivity.class));
        feedsList_cap4.add(new FeedItem("CH4_13 compas_monitor",ch04.ejercicio_13_compas_monitor.CompassActivity.class));
        feedsList_cap4.add(new FeedItem("CH4_14 metadata_retriever",ch04.ejercicio_14_metadata_retriever.MetadataActivity.class));
        feedsList_cap4.add(new FeedItem("CH4_15 usermotion_activit",ch04.ejercicio_15_usermotion_activity.MainActivity.class));


    }





    private void mySetADapter(){
        mRecyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(FeedItem item) {
                Toast.makeText(MainActivity.this, item.getTitulo(), Toast.LENGTH_LONG).show();
                //lanzamos la actividad correspondiente
                Intent intent =new Intent(MainActivity.this,item.getActividad());
                startActivity(intent);
            }
        });
    }
}

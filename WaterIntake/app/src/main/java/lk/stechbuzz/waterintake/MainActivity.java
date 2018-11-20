package lk.stechbuzz.waterintake;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public int drinkcount =0;
    public static int target=0;
    public TextView glassCount;
    public TextView mili;
    public TextView lblTarget;

    public ImageButton B1;
    public ImageButton B2;
    public ImageButton B3;
    public ImageButton B4;
    public ImageButton B5;
    public ImageButton B6;
    public ImageButton B7;
    public ImageButton B8;
    public ImageButton B9;
    public ImageButton B10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        glassCount = (TextView)findViewById(R.id.glassCount);
        mili = (TextView)findViewById(R.id.lblMiliLiters);
        lblTarget =(TextView)findViewById(R.id.lblTarget);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        B1 =(ImageButton)findViewById(R.id.p1);
        B2 =(ImageButton)findViewById(R.id.p2);
        B3 =(ImageButton)findViewById(R.id.p3);
        B4 =(ImageButton)findViewById(R.id.p4);
        B5 =(ImageButton)findViewById(R.id.p5);
        B6 =(ImageButton)findViewById(R.id.p6);
        B7 =(ImageButton)findViewById(R.id.p7);
        B8 =(ImageButton)findViewById(R.id.p8);
        B9 =(ImageButton)findViewById(R.id.p9);
        B10 =(ImageButton)findViewById(R.id.p10);





        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/

                startActivity(new Intent(MainActivity.this, Schedule.class));
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        Button btnAdd =(Button)findViewById(R.id.add_btn);
        btnAdd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if(target==0){
                    Snackbar.make(view, "add target", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    return;
                }

                if(target==drinkcount){
                    return;
                }

                drinkcount = drinkcount +1;
                calculate();
            }
        });

        Button btnRemv =(Button) findViewById(R.id.btnRemove);
        btnRemv.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                if(target==0){
                    Snackbar.make(view, "add target", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    return;
                }

                if(drinkcount ==0){
                    B1.setVisibility(View.INVISIBLE);
                    B2.setVisibility(View.INVISIBLE);
                    B3.setVisibility(View.INVISIBLE);
                    B4.setVisibility(View.INVISIBLE);
                    B5.setVisibility(View.INVISIBLE);
                    B6.setVisibility(View.INVISIBLE);
                    B7.setVisibility(View.INVISIBLE);
                    B8.setVisibility(View.INVISIBLE);
                    B9.setVisibility(View.INVISIBLE);
                    B10.setVisibility(View.INVISIBLE);
                    return;
                }
                drinkcount = drinkcount -1;
                calculate();

            }
        });
    }

    private void calculate() {
        glassCount.setText(Integer.toString(drinkcount));
        mili.setText(Integer.toString(drinkcount*250));

        if(target>0){

            int sum=(drinkcount*100/target);

            if(sum==0){
                B1.setVisibility(View.INVISIBLE);
                B2.setVisibility(View.INVISIBLE);
                B3.setVisibility(View.INVISIBLE);
                B4.setVisibility(View.INVISIBLE);
                B5.setVisibility(View.INVISIBLE);
                B6.setVisibility(View.INVISIBLE);
                B7.setVisibility(View.INVISIBLE);
                B8.setVisibility(View.INVISIBLE);
                B9.setVisibility(View.INVISIBLE);
                B10.setVisibility(View.INVISIBLE);

                return;
            }

            if(sum<10){
                B1.setVisibility(View.VISIBLE);
                B2.setVisibility(View.INVISIBLE);
                B3.setVisibility(View.INVISIBLE);
                B4.setVisibility(View.INVISIBLE);
                B5.setVisibility(View.INVISIBLE);
                B6.setVisibility(View.INVISIBLE);
                B7.setVisibility(View.INVISIBLE);
                B8.setVisibility(View.INVISIBLE);
                B9.setVisibility(View.INVISIBLE);
                B10.setVisibility(View.INVISIBLE);

                return;
            }
            if(sum<20){
                B1.setVisibility(View.VISIBLE);
                B2.setVisibility(View.VISIBLE);
                B3.setVisibility(View.INVISIBLE);
                B4.setVisibility(View.INVISIBLE);
                B5.setVisibility(View.INVISIBLE);
                B6.setVisibility(View.INVISIBLE);
                B7.setVisibility(View.INVISIBLE);
                B8.setVisibility(View.INVISIBLE);
                B9.setVisibility(View.INVISIBLE);
                B10.setVisibility(View.INVISIBLE);
                return;
            }
            if(sum<30){
                B1.setVisibility(View.VISIBLE);
                B2.setVisibility(View.VISIBLE);
                B3.setVisibility(View.VISIBLE);
                B4.setVisibility(View.INVISIBLE);
                B5.setVisibility(View.INVISIBLE);
                B6.setVisibility(View.INVISIBLE);
                B7.setVisibility(View.INVISIBLE);
                B8.setVisibility(View.INVISIBLE);
                B9.setVisibility(View.INVISIBLE);
                B10.setVisibility(View.INVISIBLE);
                return;
            }
            if(sum<40){
                B1.setVisibility(View.VISIBLE);
                B2.setVisibility(View.VISIBLE);
                B3.setVisibility(View.VISIBLE);
                B4.setVisibility(View.VISIBLE);
                B5.setVisibility(View.INVISIBLE);
                B6.setVisibility(View.INVISIBLE);
                B7.setVisibility(View.INVISIBLE);
                B8.setVisibility(View.INVISIBLE);
                B9.setVisibility(View.INVISIBLE);
                B10.setVisibility(View.INVISIBLE);
                return;
            }
            if(sum<50){
                B1.setVisibility(View.VISIBLE);
                B2.setVisibility(View.VISIBLE);
                B3.setVisibility(View.VISIBLE);
                B4.setVisibility(View.VISIBLE);
                B5.setVisibility(View.VISIBLE);
                B6.setVisibility(View.INVISIBLE);
                B7.setVisibility(View.INVISIBLE);
                B8.setVisibility(View.INVISIBLE);
                B9.setVisibility(View.INVISIBLE);
                B10.setVisibility(View.INVISIBLE);
                return;
            }
            if(sum<60){
                B1.setVisibility(View.VISIBLE);
                B2.setVisibility(View.VISIBLE);
                B3.setVisibility(View.VISIBLE);
                B4.setVisibility(View.VISIBLE);
                B5.setVisibility(View.VISIBLE);
                B6.setVisibility(View.VISIBLE);
                B7.setVisibility(View.INVISIBLE);
                B8.setVisibility(View.INVISIBLE);
                B9.setVisibility(View.INVISIBLE);
                B10.setVisibility(View.INVISIBLE);
                return;
            }
            if(sum<70){
                B1.setVisibility(View.VISIBLE);
                B2.setVisibility(View.VISIBLE);
                B3.setVisibility(View.VISIBLE);
                B4.setVisibility(View.VISIBLE);
                B5.setVisibility(View.VISIBLE);
                B6.setVisibility(View.VISIBLE);
                B7.setVisibility(View.VISIBLE);
                B8.setVisibility(View.INVISIBLE);
                B9.setVisibility(View.INVISIBLE);
                B10.setVisibility(View.INVISIBLE);
                return;
            }
            if(sum<80){
                B1.setVisibility(View.VISIBLE);
                B2.setVisibility(View.VISIBLE);
                B3.setVisibility(View.VISIBLE);
                B4.setVisibility(View.VISIBLE);
                B5.setVisibility(View.VISIBLE);
                B6.setVisibility(View.VISIBLE);
                B7.setVisibility(View.VISIBLE);
                B8.setVisibility(View.VISIBLE);
                B9.setVisibility(View.INVISIBLE);
                B10.setVisibility(View.INVISIBLE);
                return;
            }
            if(sum<90){
                B1.setVisibility(View.VISIBLE);
                B2.setVisibility(View.VISIBLE);
                B3.setVisibility(View.VISIBLE);
                B4.setVisibility(View.VISIBLE);
                B5.setVisibility(View.VISIBLE);
                B6.setVisibility(View.VISIBLE);
                B7.setVisibility(View.VISIBLE);
                B8.setVisibility(View.VISIBLE);
                B9.setVisibility(View.VISIBLE);
                B10.setVisibility(View.INVISIBLE);
                return;
            }
            if(sum<100){
                B1.setVisibility(View.VISIBLE);
                B2.setVisibility(View.VISIBLE);
                B3.setVisibility(View.VISIBLE);
                B4.setVisibility(View.VISIBLE);
                B5.setVisibility(View.VISIBLE);
                B6.setVisibility(View.VISIBLE);
                B7.setVisibility(View.VISIBLE);
                B8.setVisibility(View.VISIBLE);
                B9.setVisibility(View.VISIBLE);
                B10.setVisibility(View.VISIBLE);
                return;
            }

        }

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

            startActivity(new Intent(MainActivity.this, SettingsActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostResume() {

        lblTarget.setText(Integer.toString(target));
        super.onPostResume();
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



}

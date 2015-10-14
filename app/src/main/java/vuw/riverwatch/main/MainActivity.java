package vuw.riverwatch.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import vuw.riverwatch.R;
import vuw.riverwatch.colour_algorithm.CameraActivity;
import vuw.riverwatch.gallery;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            SubmitIncident();
        } else if (id == R.id.nav_gallery) {
            openGallery();
        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_feedback) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void SubmitIncident() {
        Intent cameraIntent = new Intent(MainActivity.this, CameraActivity.class);
        MainActivity.this.startActivity(cameraIntent);

        // startActivity(new Intent(MainScreenActivity.this,
        // SelectImageActivity.class));
//        try {
//            // checkPreviousBuilder();
////            submissionEventBuilder = SubmissionEventBuilder.getSubmissionEventBuilder(myApplication);
////            submissionEventBuilder.startNewSubmissionEvent();
////            File photo = new File(Environment.getExternalStorageDirectory(), "Pic.jpg");
//
//
//            Intent takePictureIntent = new Intent(this, MainActivity.class);
////			takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(photo));
////			cameraFileUri = Uri.fromFile(photo);
//            if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
//                startActivityForResult(takePictureIntent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION), Constants.REQUEST_CODE_TAKE_PICTURE);
//            }
//        } catch (Exception e) {
//            System.err.println("Camera Exception: " + e);
//            Toast.makeText(getApplicationContext(), "Couldn't load photo",
//                    Toast.LENGTH_LONG).show();
//        }
    }

    public void openGallery(){
        Intent myIntent = new Intent(MainActivity.this, gallery.class);
//        myIntent.putExtra("key", value); //Optional parameters
        MainActivity.this.startActivity(myIntent);
    }
}

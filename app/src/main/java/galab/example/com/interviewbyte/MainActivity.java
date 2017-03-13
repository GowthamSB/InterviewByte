package galab.example.com.interviewbyte;






import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import android.support.v4.view.MenuItemCompat;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ShareActionProvider;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import com.kobakei.ratethisapp.RateThisApp;

import es.dmoral.toasty.Toasty;
import layout.FragmentCourses;
import layout.FragmentInterview;
import layout.FragmentProgramming;
import layout.FragmentProgrammingContests;
import layout.FragmentQuestioning;
import layout.fragmenthome;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener ,
        FragmentCourses.OnFragmentInteractionListener ,
        fragmenthome.OnFragmentInteractionListener ,
        FragmentProgrammingContests.OnFragmentInteractionListener ,
        FragmentProgramming.OnFragmentInteractionListener ,
        FragmentInterview.OnFragmentInteractionListener ,
        FragmentQuestioning.OnFragmentInteractionListener
        {

            private NavigationView navigationView;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    public boolean viewIsAtHome;


             private TextView custom;
            private Typeface mycustomfont;
            private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Rating dialog
        // Custom criteria: 3 days and 4 launches
        // Set custom criteria (optional)
        RateThisApp.Config config = new RateThisApp.Config(3, 3);
        RateThisApp.init(config);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        /*TextView custom=(TextView)findViewById(R.id.logo);
        Typeface mycustomfont=Typeface.createFromAsset(getAssets(), "fonts/Niconne-Regular.ttf");
        custom.setTypeface(mycustomfont);*/
        Fragment fragment=null;
        fragment = new fragmenthome();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame, fragment);
        ft.commit();
        viewIsAtHome=true;



      fab = (FloatingActionButton) findViewById(R.id.fab);




        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "CodeBubble");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Now Learn coding and get technews with interviewbyte android app downloadit now");
                startActivity(Intent.createChooser(sharingIntent, "Share via"));

            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);




        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        else if (!viewIsAtHome) { //if the current view is not the home fragment
             //display the home fragment
            Fragment fragment=null;
            fragment = new fragmenthome();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            //ft.addToBackStack(null);
            ft.setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right);
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
            viewIsAtHome=true;

        }

        else  if(viewIsAtHome){
            Toasty.info(this,"Thank you :)", Toast.LENGTH_SHORT).show();
           // this.finish();
            //super.onBackPressed();
           //If view is in home fragment, exit application
           moveTaskToBack(true);
        }
        /*else if (getFragmentManager().getBackStackEntryCount() > 0) {
            //getFragmentManager().popBackStack();
            Fragment fragment=null;
            fragment = new fragmenthome();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            //ft.addToBackStack(null);
            ft.setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right);
            ft.replace(R.id.content_frame, fragment);
            ft.commit();

        }
        */else {
         // super.onBackPressed();

            Fragment fragment=null;
            fragment = new fragmenthome();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            //ft.addToBackStack(null);
            ft.setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right);

            ft.replace(R.id.content_frame, fragment);
            ft.commit();


        }
    }

    private ShareActionProvider mShareActionProvider;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        MenuItem item = menu.findItem(R.id.action_share);

        // Fetch and store ShareActionProvider
        mShareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(item);

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
            Intent intent=new Intent(this,settings.class);
            startActivity(intent);
            overridePendingTransition(R.anim.open_translate, R.anim.close_scale);
        }
        if(id==R.id.action_share){
            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String shareBody = "Here is the share content body";
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(sharingIntent, "Share via"));
        }

        if(id==R.id.action_about)
        {
            Intent intent=new Intent(this,About_Page.class);
            startActivity(intent);
            overridePendingTransition(R.anim.open_translate, R.anim.close_scale);
        }
        if(id==R.id.action_coffee)
        {
            Intent intent=new Intent(this,settings.class);
            startActivity(intent);
            overridePendingTransition(R.anim.open_translate, R.anim.close_scale);
        }

        if(id==R.id.action_Rate)
        {
            RateThisApp.showRateDialog(this);
        }

        return super.onOptionsItemSelected(item);
    }




    public void    onFragmentInteraction(Uri uri){
        //We can keep this empty
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment fragment=null;
        if(item.isChecked())
            item.setChecked(false);
        else navigationView.setCheckedItem(id);



        if (id == R.id.nav_home) {

            fragment = new fragmenthome();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            //ft.addToBackStack(null);
            ft.commit();
            viewIsAtHome=true;
        } else if (id == R.id.nav_courses) {

            fragment = new FragmentCourses();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.addToBackStack(null);
            ft.commit();
            viewIsAtHome=false;

        } else if (id == R.id.nav_programming) {
            fragment = new FragmentProgramming();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.addToBackStack(null);
            ft.commit();
            viewIsAtHome=false;

        } else if (id == R.id.nav_questioning) {
            fragment = new FragmentQuestioning();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.addToBackStack(null);
            ft.commit();
            viewIsAtHome=false;


        } else if (id == R.id.nav_interview_skills) {
            fragment = new FragmentInterview();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.addToBackStack(null);
            ft.commit();
            viewIsAtHome=false;

        } else if (id == R.id.nav_programming_contests) {
            //viewIsAtHome=false;
            fragment = new FragmentProgrammingContests();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.addToBackStack(null);
            ft.commit();
            viewIsAtHome=false;

        }



        else if (id == R.id.offline_home) {

           Intent intent=new Intent(MainActivity.this,Offline_home.class);
            startActivity(intent);
           // overridePendingTransition(R.anim.open_translate, R.anim.close_scale);
            //overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            viewIsAtHome=false;

        }
        else if (id == R.id.tutorials) {

            Intent intent=new Intent(MainActivity.this,offline_tutorials.class);
            startActivity(intent);
            //overridePendingTransition(R.anim.open_translate, R.anim.close_scale);
            //overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            viewIsAtHome=false;

        }
        else if (id == R.id.technical) {

            Intent intent=new Intent(MainActivity.this,Technical_Interview.class);
            startActivity(intent);
            viewIsAtHome=false;

        }
        else if (id == R.id.nontechnical) {

            Intent intent=new Intent(MainActivity.this,Non_Technical_Interview.class);
            startActivity(intent);
            //overridePendingTransition(R.anim.open_translate, R.anim.close_scale);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            viewIsAtHome=false;

        }

        else if (id == R.id.Placement_papers) {

            Intent intent=new Intent(MainActivity.this,Placement_papers.class);
            startActivity(intent);
            //overridePendingTransition(R.anim.open_translate, R.anim.close_scale);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            viewIsAtHome=false;

        }

        else if (id == R.id.Online_Placement_papers) {
            //viewIsAtHome=false;

            Intent intent=new Intent(MainActivity.this,Placement_papers.class);
            startActivity(intent);
            //overridePendingTransition(R.anim.open_translate, R.anim.close_scale);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            viewIsAtHome=false;

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onStart() {
        super.onStart();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        // Monitor launch times and interval from installation
        RateThisApp.onStart(this);
        // If the criteria is satisfied, "Rate this app" dialog will be shown
        RateThisApp.showRateDialogIfNeeded(this);
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://galab.example.com.interviewbyte/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://galab.example.com.interviewbyte/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }





}

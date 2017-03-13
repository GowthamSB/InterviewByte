package galab.example.com.interviewbyte;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.kobakei.ratethisapp.RateThisApp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Offline_home extends AppCompatActivity {
    private FloatingActionButton fab;



    String[] listviewTitle = new String[]{
            "Tutorials", "Technical Interview Skills", "Non-Technical Interview Skills", "Placement Papers"
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offline_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        this.setTitle("Offline");

        toolbar.setNavigationIcon(R.drawable.backarrow);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                                                 @Override
                                                 public void onClick(View view) {
                                                     onBackPressed();
                                                     overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                                                 }
                                             }
        );





        String[] listviewShortDescription = new String[]{
                "Algorithms and datastructures tutorials","Technical Interview questioniare",
                "GD topics and HR Interview questions","Subject wise and Company wise Placement papers"

        };

        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();


        for (int i = 0; i <4 ; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("listview_title", listviewTitle[i]);
            hm.put("listview_discription", listviewShortDescription[i]);
            aList.add(hm);
        }

        String[] from = { "listview_title", "listview_discription"};
        int[] to = {R.id.listview_item_title, R.id.listview_item_short_description};

         SimpleAdapter simpleAdapter = new SimpleAdapter(getBaseContext(), aList, R.layout.offline_list_view, from, to);
        ListView androidListView = (ListView) findViewById(R.id.list_view);
        androidListView.setAdapter(simpleAdapter);
        androidListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View container, int position, long id) {
                // Getting the Container Layout of the ListView
                LinearLayout linearLayoutParent = (LinearLayout) container;

                // Getting the inner Linear Layout
                LinearLayout linearLayoutChild = (LinearLayout) linearLayoutParent.getChildAt(1);

                // Getting the Country TextView
                //TextView title = (TextView) linearLayoutChild.getChildAt(0);

                String text = "Opening";

                switch (position) {
                    case 0: {
                        Intent intent = new Intent(Offline_home.this, offline_tutorials.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.open_translate, R.anim.close_scale);

                    }

                    break;
                    case 1: {
                        Intent intent = new Intent(Offline_home.this, Technical_Interview.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.open_translate, R.anim.close_scale);
                    }

                    break;

                    case 2: {
                        Intent intent = new Intent(Offline_home.this, Non_Technical_Interview.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.open_translate, R.anim.close_scale);
                    }

                    break;

                    case 3: {
                        Intent intent = new Intent(Offline_home.this, Offline_placement_papers.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.open_translate, R.anim.close_scale);
                    }

                    break;



                }
            }
        });
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
        if (id == R.id.action_about) {
            Intent intent=new Intent(this,About_Page.class);
            startActivity(intent);
            overridePendingTransition(R.anim.open_translate, R.anim.close_scale);

        }

        if (id == R.id.action_Rate) {
            RateThisApp.showRateDialog(this);

        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed()
    {
        Intent intent=new Intent(Offline_home.this,MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);


    }

}

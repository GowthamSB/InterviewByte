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

public class Offline_placement_papers extends AppCompatActivity {
    private FloatingActionButton fab;



    String[] listviewTitle = new String[]{
            "IBM Paper 1", "IBM Paper 2","IBM Paper 3","Oracle Paper 1","Oracle Paper 2","Oracle Paper 3","Oracle Paper 4","Oracle Paper 5","Oracle Paper 6","Oracle Database Paper", "L&T Infotech", "Samsung",
            "Sony Paper 1","Sony Paper 2","Sony Paper 3","Unisys Paper 1","Unisys Paper 2","Trianz","Mu-Sigma Paper 1","Mu-Sigma Paper 2",
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offline_placement_papers);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        this.setTitle("Placement Papers");

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
                "IBM Placement Paper(aptitude and technical)","IBM Placement Paper(aptitude and technical)",
                "IBM Placement Paper(aptitude and technical)","Oracle Placement Paper(aptitude and technical)",
                "Oracle Placement Paper(aptitude and technical)", "Oracle Placement Paper(aptitude and technical)",
                "Oracle Placement Paper(aptitude and technical)","Oracle Placement Paper(aptitude and technical)",
                "Oracle Placement Paper(aptitude and technical)", "Oracle Database Interview Paper",
                "L&T Infotech Aptitude Paper","Samsung Placement Paper(aptitude and technical)",
                "Sony Placement Paper(aptitude and technical)","Sony Placement Paper(aptitude and technical)",
                "Sony Placement Paper(aptitude and technical)",
                "Unisys Placement Paper(aptitude and technical)","Unisys Placement Paper(aptitude and technical)",
                "Trianz Placement Paper(aptitude and technical)",
                "Mu-sigma Placement Paper(aptitude and technical)","Mu-sigma Placement Paper(aptitude and technical)",

        };

        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();


        for (int i = 0; i <20 ; i++) {
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
                        Intent intent=new Intent(Offline_placement_papers.this,webviewtest.class);
                        intent.putExtra("url","file:///android_asset/webpages/Ibmpaper1.html");
                        intent.putExtra("title","IBM Paper 1");
                        startActivity(intent);
                        overridePendingTransition(R.anim.open_translate, R.anim.close_scale);

                    }
                    break;

                    case 1: {
                        Intent intent=new Intent(Offline_placement_papers.this,webviewtest.class);
                        intent.putExtra("url","file:///android_asset/webpages/ibmpaper2.html");
                        intent.putExtra("title","IBM Paper 2");
                        startActivity(intent);
                        overridePendingTransition(R.anim.open_translate, R.anim.close_scale);

                    }

                    break;
                    case 2: {
                        Intent intent=new Intent(Offline_placement_papers.this,webviewtest.class);
                        intent.putExtra("url","file:///android_asset/webpages/ibmpaper3.html");
                        intent.putExtra("title","IBM Paper 3");
                        startActivity(intent);
                        overridePendingTransition(R.anim.open_translate, R.anim.close_scale);

                    }

                    break;




                    case 3: {
                        Intent intent=new Intent(Offline_placement_papers.this,webviewtest.class);
                        intent.putExtra("url","file:///android_asset/webpages/Oraclepaper1.html");
                        intent.putExtra("title","Oracle Paper 1");
                        startActivity(intent);
                        overridePendingTransition(R.anim.open_translate, R.anim.close_scale);
                    }
                    break;

                    case 4: {
                        Intent intent=new Intent(Offline_placement_papers.this,webviewtest.class);
                        intent.putExtra("url","file:///android_asset/webpages/oraclepaper2.html");
                        intent.putExtra("title","Oracle Paper 2");
                        startActivity(intent);
                        overridePendingTransition(R.anim.open_translate, R.anim.close_scale);
                    }
                    break;

                    case 5: {
                        Intent intent=new Intent(Offline_placement_papers.this,webviewtest.class);
                        intent.putExtra("url","file:///android_asset/webpages/oraclepaper3.html");
                        intent.putExtra("title","Oracle Paper 3");
                        startActivity(intent);
                        overridePendingTransition(R.anim.open_translate, R.anim.close_scale);
                    }
                    break;

                    case 6: {
                        Intent intent=new Intent(Offline_placement_papers.this,webviewtest.class);
                        intent.putExtra("url","file:///android_asset/webpages/oraclepaper4.html");
                        intent.putExtra("title","Oracle Paper 4");
                        startActivity(intent);
                        overridePendingTransition(R.anim.open_translate, R.anim.close_scale);
                    }
                    break;

                    case 7: {
                        Intent intent=new Intent(Offline_placement_papers.this,webviewtest.class);
                        intent.putExtra("url","file:///android_asset/webpages/oraclepaper5.html");
                        intent.putExtra("title","Oracle Paper 5");
                        startActivity(intent);
                        overridePendingTransition(R.anim.open_translate, R.anim.close_scale);
                    }

                    break;

                    case 8: {
                        Intent intent=new Intent(Offline_placement_papers.this,webviewtest.class);
                        intent.putExtra("url","file:///android_asset/webpages/oraclepaper6.html");
                        intent.putExtra("title","Oracle Paper 6");
                        startActivity(intent);
                        overridePendingTransition(R.anim.open_translate, R.anim.close_scale);
                    }

                    break;

                    case 9: {
                        Intent intent=new Intent(Offline_placement_papers.this,webviewtest.class);
                        intent.putExtra("url","file:///android_asset/webpages/oracledbpaper.html");
                        intent.putExtra("title","Oracle DB");
                        startActivity(intent);
                        overridePendingTransition(R.anim.open_translate, R.anim.close_scale);
                    }
                    break;
                    case 10: {
                        Intent intent=new Intent(Offline_placement_papers.this,webviewtest.class);
                        intent.putExtra("url","file:///android_asset/webpages/L&Tplacementpaper.html");
                        intent.putExtra("title","L&T Infotech");
                        startActivity(intent);
                        overridePendingTransition(R.anim.open_translate, R.anim.close_scale);
                    }

                    break;

                    case 11: {
                        Intent intent=new Intent(Offline_placement_papers.this,webviewtest.class);
                        intent.putExtra("url","file:///android_asset/webpages/samsung1.html");
                        intent.putExtra("title","Samsung");
                        startActivity(intent);
                        overridePendingTransition(R.anim.open_translate, R.anim.close_scale);
                    }

                    break;

                    case 12: {
                        Intent intent=new Intent(Offline_placement_papers.this,webviewtest.class);
                        intent.putExtra("url","file:///android_asset/webpages/sony1.html");
                        intent.putExtra("title","Sony Paper 1");
                        startActivity(intent);
                        overridePendingTransition(R.anim.open_translate, R.anim.close_scale);
                    }

                    break;

                    case 13: {
                        Intent intent=new Intent(Offline_placement_papers.this,webviewtest.class);
                        intent.putExtra("url","file:///android_asset/webpages/sony2.html");
                        intent.putExtra("title","Sony Paper 2");
                        startActivity(intent);
                        overridePendingTransition(R.anim.open_translate, R.anim.close_scale);
                    }

                    break;

                    case 14: {
                        Intent intent=new Intent(Offline_placement_papers.this,webviewtest.class);
                        intent.putExtra("url","file:///android_asset/webpages/sony3.html");
                        intent.putExtra("title","Sony Paper 3");
                        startActivity(intent);
                        overridePendingTransition(R.anim.open_translate, R.anim.close_scale);
                    }

                    break;

                    case 15: {
                        Intent intent=new Intent(Offline_placement_papers.this,webviewtest.class);
                        intent.putExtra("url","file:///android_asset/webpages/unisys1.html");
                        intent.putExtra("title","Unisys Paper 1");
                        startActivity(intent);
                        overridePendingTransition(R.anim.open_translate, R.anim.close_scale);
                    }

                    break;
                    case 16: {
                        Intent intent=new Intent(Offline_placement_papers.this,webviewtest.class);
                        intent.putExtra("url","file:///android_asset/webpages/unisys2.html");
                        intent.putExtra("title","Unisys Paper 2");
                        startActivity(intent);
                        overridePendingTransition(R.anim.open_translate, R.anim.close_scale);
                    }

                    break;

                    case 17: {
                        Intent intent=new Intent(Offline_placement_papers.this,webviewtest.class);
                        intent.putExtra("url","file:///android_asset/webpages/trianz1.html");
                        intent.putExtra("title","Trianz");
                        startActivity(intent);
                        overridePendingTransition(R.anim.open_translate, R.anim.close_scale);
                    }

                    break;

                    case 18: {
                        Intent intent=new Intent(Offline_placement_papers.this,webviewtest.class);
                        intent.putExtra("url","file:///android_asset/webpages/musigma1.html");
                        intent.putExtra("title","Mu-Sigma Paper 1");
                        startActivity(intent);
                        overridePendingTransition(R.anim.open_translate, R.anim.close_scale);
                    }

                    break;

                    case 19: {
                        Intent intent=new Intent(Offline_placement_papers.this,webviewtest.class);
                        intent.putExtra("url","file:///android_asset/webpages/musigma2.html");
                        intent.putExtra("title","Mu-Sigma Paper 2");
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
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);


    }

}

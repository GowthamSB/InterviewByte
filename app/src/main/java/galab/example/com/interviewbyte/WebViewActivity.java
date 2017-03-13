package galab.example.com.interviewbyte;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

//import com.amnix.adblockwebview.ui.AdBlocksWebViewActivity;

import com.kobakei.ratethisapp.RateThisApp;

import es.dmoral.toasty.Toasty;


public class WebViewActivity extends ActionBarActivity {

    private WebView webView;
    private WebView myWebView;


    private Toolbar toolbar;


    ProgressBar progressBar;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        String url = getIntent().getStringExtra("url");
        String title=getIntent().getStringExtra("title");
         myWebView = (WebView) findViewById(R.id.webView2);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        progressBar.getIndeterminateDrawable().setColorFilter(
                Color.BLUE, android.graphics.PorterDuff.Mode.SRC_IN);
        //myWebView.setWebViewClient(new WebViewClient());
        progressBar.setIndeterminate(true);



       //myWebView.setWebViewClient(new WebViewClient());
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.setInitialScale(1);
        myWebView.getSettings().setLoadWithOverviewMode(true);
        myWebView.getSettings().setUseWideViewPort(true);
        myWebView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        myWebView.setScrollbarFadingEnabled(false);
        // Enable responsive layout
        //myWebView.getSettings().setUseWideViewPort(true);
        // Zoom out if the content width is greater than the width of the veiwport
        myWebView.getSettings().setLoadWithOverviewMode(true);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);



        toolbar.setNavigationIcon(R.drawable.backarrow);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                overridePendingTransition(R.anim.open_scale, R.anim.close_translate);
            }
        });

        final SwipeRefreshLayout swipeLayout = (SwipeRefreshLayout)findViewById(R.id.swipeToRefresh);
        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Insert your code here
                progressBar.setVisibility(View.GONE);
                myWebView.reload();
                // refreshes the WebView
            }
        });

        swipeLayout.setColorSchemeResources(R.color.orange, R.color.green, R.color.blue);








        myWebView.loadUrl(url);


       final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.webfab);




        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(WebViewActivity.this,MainActivity.class);
                startActivity(intent);
                //overridePendingTransition(R.anim.open_scale, R.anim.close_translate);



            }
        });

        myWebView.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                // TODO Auto-generated method stub
                progressBar.setVisibility(View.VISIBLE);
                progressBar.bringToFront();

                if(swipeLayout.isRefreshing())
                {
                    progressBar.setVisibility(View.GONE);
                }


                super.onPageStarted(view, url, favicon);

            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // TODO Auto-generated method stub
                progressBar.setVisibility(View.VISIBLE);


                if(swipeLayout.isRefreshing())
                {
                    progressBar.setVisibility(View.GONE);
                }



                view.loadUrl(url);


                return true;

            }


            @Override
            public void onPageFinished(WebView view, String url) {
                // TODO Auto-generated method stub
                super.onPageFinished(view, url);

                progressBar.setVisibility(View.GONE);
                Toasty.info(WebViewActivity.this,"Pull down to Refresh", Toast.LENGTH_LONG).show();
                swipeLayout.setRefreshing(false);
            }

            @SuppressWarnings("deprecation")
            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                // Handle the error

                try {
                    myWebView.stopLoading();
                } catch (Exception e) {
                }
                try {
                    myWebView.clearView();
                } catch (Exception e) {
                }
                fab.hide();
                if (myWebView.canGoBack()) {
                    myWebView.goBack();
                }
               // myWebView.loadUrl("file:///android_asset/ex.html");

               myWebView.loadUrl("about:blank");


                //Showing and creating an alet dialog
                AlertDialog alertDialog = new AlertDialog.Builder(WebViewActivity.this).create();
                alertDialog.setTitle("OOPS!");
                alertDialog.setMessage("No internet connection was found!");
                alertDialog.setButton("wifi", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                        //overridePendingTransition(R.anim.open_translate, R.anim.close_scale);
                        startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));



                    }
                });

                alertDialog.setButton2("Mobile data", new DialogInterface.OnClickListener()    {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                        //overridePendingTransition(R.anim.open_translate, R.anim.close_scale);
                        startActivity(new Intent(Settings.ACTION_DATA_ROAMING_SETTINGS));
                    }

                    });

                alertDialog.setOnKeyListener(new Dialog.OnKeyListener() {

                    @Override
                    public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
                            finish();
                            overridePendingTransition(R.anim.open_scale, R.anim.close_translate);


                            return true;
                        }
                        return false;
                    }
                });



                    alertDialog.show();





                if (myWebView.canGoBack()) {
                    myWebView.goBack();
                }




                //Don't forget to call supper!
                super.onReceivedError(myWebView, errorCode, description, failingUrl);

            }



            });


    }






    @Override
    public boolean onKeyDown ( int keyCode, KeyEvent event){
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    if (myWebView.canGoBack()) {
                        myWebView.goBack();
                    } else {
                        finish();
                        overridePendingTransition(R.anim.open_scale, R.anim.close_translate);
                    }
                    return true;
            }

        }
        return super.onKeyDown(keyCode, event);
    }

    private ShareActionProvider mShareActionProvider;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.webview, menu);
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

        if(id==R.id.menu_refresh)
        {
            progressBar.setVisibility(View.GONE);
            myWebView.reload();
        }

        return super.onOptionsItemSelected(item);
    }





}
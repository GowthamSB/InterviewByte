package galab.example.com.interviewbyte;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

public class About_Page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        View aboutPage = new AboutPage(this)
                .isRTL(false)
                .setImage(R.drawable.launcher)
                .setDescription(getString(R.string.app_desc))
                .addItem(new Element().setTitle("Version 1.0"))
                .addGroup("Connect with us")
                .addEmail("interviewbyte@gmail.com")
                .addWebsite("http://www.interviewbyteapp.blogspot.com")
                .addFacebook("interviewbyte")
                .addPlayStore("galab.example.com.interviewbyte")
                .addInstagram("interviewbyte")
                .create();

        setContentView(aboutPage);
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

    }





}
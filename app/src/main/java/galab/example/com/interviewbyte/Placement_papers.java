package galab.example.com.interviewbyte;

import java.io.File;
import java.io.IOException;

import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.kobakei.ratethisapp.RateThisApp;

import es.dmoral.toasty.Toasty;

public class Placement_papers extends AppCompatActivity {

    private String url;




    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placement_papers);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Placement Papers");
        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Please wait...\ndownloading pdf");
        pDialog.setCancelable(false);

        toolbar.setNavigationIcon(R.drawable.backarrow);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                                                 @Override
                                                 public void onClick(View view) {
                                                     onBackPressed();
                                                     overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                                                 }
                                             }
        );


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

    public void download1(View v)
    {
        File file = new File(Environment.getExternalStorageDirectory() + "/CodeBubble/" + "HCL.pdf");
        if(file.exists()){
            Toasty.info(this, "File is already Stored in internal storage/CodeBubble\nplease click VIEW button to open the file", Toast.LENGTH_LONG).show();
        }
        else {
            new DownloadFile().execute("https://firebasestorage.googleapis.com/v0/b/code-bubble.appspot.com/o/HCL.pdf?alt=media&token=c79207cf-d4da-4e41-ac7c-a4507701d85f", "HCL.pdf");

        }
    }

    public void view1(View v)
    {
        File pdfFile = new File(Environment.getExternalStorageDirectory() + "/CodeBubble/" + "HCL.pdf");  // -> filename = maven.pdf
        Uri path = Uri.fromFile(pdfFile);
        Intent pdfIntent = new Intent(Intent.ACTION_VIEW);
        pdfIntent.setDataAndType(path, "application/pdf");
        pdfIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        try{
            startActivity(pdfIntent);
        }catch(ActivityNotFoundException e){
            Toasty.error(Placement_papers.this, "No Application available to view PDF", Toast.LENGTH_SHORT).show();
        }
    }

    public void download2(View v)
    {
        File file = new File(Environment.getExternalStorageDirectory() + "/CodeBubble/" + "IBM1.pdf");
        if(file.exists()){
            Toasty.info(this, "File is already Stored in internal storage/CodeBubble\nplease click VIEW button to open the file", Toast.LENGTH_LONG).show();
        }
        else {
            new DownloadFile().execute("https://firebasestorage.googleapis.com/v0/b/code-bubble.appspot.com/o/IBM1.pdf?alt=media&token=f356036e-cd3d-4f50-8fe0-aaa6c5546b26", "IBM1.pdf");

        }
    }

    public void view2(View v)
    {
        File pdfFile = new File(Environment.getExternalStorageDirectory() + "/CodeBubble/" + "IBM1.pdf");  // -> filename = maven.pdf
        Uri path = Uri.fromFile(pdfFile);
        Intent pdfIntent = new Intent(Intent.ACTION_VIEW);
        pdfIntent.setDataAndType(path, "application/pdf");
        pdfIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        try{
            startActivity(pdfIntent);
        }catch(ActivityNotFoundException e){
            Toasty.error(Placement_papers.this, "No Application available to view PDF", Toast.LENGTH_SHORT).show();
        }
    }

    public void download3(View v)
    {
        File file = new File(Environment.getExternalStorageDirectory() + "/CodeBubble/" + "IBM2.pdf");
        if(file.exists()){
            Toasty.info(this, "File is already Stored in internal storage/CodeBubble\nplease click VIEW button to open the file", Toast.LENGTH_LONG).show();
        }
        else {
            new DownloadFile().execute("https://firebasestorage.googleapis.com/v0/b/code-bubble.appspot.com/o/IBM2.pdf?alt=media&token=4cca0977-eae7-47fe-bb4b-f2baba852c42", "IBM2.pdf");

        }
    }

    public void view3(View v)
    {
        File pdfFile = new File(Environment.getExternalStorageDirectory() + "/CodeBubble/" + "IBM2.pdf");  // -> filename = maven.pdf
        Uri path = Uri.fromFile(pdfFile);
        Intent pdfIntent = new Intent(Intent.ACTION_VIEW);
        pdfIntent.setDataAndType(path, "application/pdf");
        pdfIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);



        try{
            startActivity(pdfIntent);
        }catch(ActivityNotFoundException e){
            Toasty.error(Placement_papers.this, "No Application available to view PDF", Toast.LENGTH_SHORT).show();
        }
    }

    public void download4(View v)
    {
        File file = new File(Environment.getExternalStorageDirectory() + "/CodeBubble/" + "SYNTEL.pdf");
        if(file.exists()){
            Toasty.info(this, "File is already Stored in internal storage/CodeBubble\nplease click VIEW button to open the file", Toast.LENGTH_LONG).show();
        }
        else {
            new DownloadFile().execute("https://firebasestorage.googleapis.com/v0/b/code-bubble.appspot.com/o/SYNTEL.pdf?alt=media&token=69395472-ef2a-4898-b0cc-f4990372a01f", "SYNTEL.pdf");

        }
    }

    public void view4(View v)
    {
        File pdfFile = new File(Environment.getExternalStorageDirectory() + "/CodeBubble/" + "SYNTEL.pdf");  // -> filename = maven.pdf
        Uri path = Uri.fromFile(pdfFile);
        Intent pdfIntent = new Intent(Intent.ACTION_VIEW);
        pdfIntent.setDataAndType(path, "application/pdf");
        pdfIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        try{
            startActivity(pdfIntent);
        }catch(ActivityNotFoundException e){
            Toasty.error(Placement_papers.this, "No Application available to view PDF", Toast.LENGTH_SHORT).show();
        }
    }

    public void download5(View v)
    {
        File file = new File(Environment.getExternalStorageDirectory() + "/CodeBubble/" + "TCS.pdf");
        if(file.exists()){
            Toasty.info(this, "File is already Stored in internal storage/CodeBubble\nplease click VIEW button to open the file", Toast.LENGTH_LONG).show();
        }
        else {
            new DownloadFile().execute("https://firebasestorage.googleapis.com/v0/b/code-bubble.appspot.com/o/TCS.pdf?alt=media&token=67b90da6-54ef-4d83-b367-e90180010185", "TCS.pdf");

        }
    }

    public void view5(View v)
    {
        File pdfFile = new File(Environment.getExternalStorageDirectory() + "/CodeBubble/" + "TCS.pdf");  // -> filename = maven.pdf
        Uri path = Uri.fromFile(pdfFile);
        Intent pdfIntent = new Intent(Intent.ACTION_VIEW);
        pdfIntent.setDataAndType(path, "application/pdf");
        pdfIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        try{
            startActivity(pdfIntent);
        }catch(ActivityNotFoundException e){
            Toasty.error(Placement_papers.this, "No Application available to view PDF", Toast.LENGTH_SHORT).show();
        }
    }

    public void download6(View v)
    {
        File file = new File(Environment.getExternalStorageDirectory() + "/CodeBubble/" + "Tech_mahindra1.pdf");
        if(file.exists()){
            Toasty.info(this, "File is already Stored in internal storage/CodeBubble\nplease click VIEW button to open the file", Toast.LENGTH_LONG).show();
        }
        else {
            new DownloadFile().execute("https://firebasestorage.googleapis.com/v0/b/code-bubble.appspot.com/o/1.tech%20mahindra%20technical.pdf?alt=media&token=ae3936b9-fa85-43a0-af83-16b187e7750f", "Tech_mahindra1.pdf");

        }
    }

    public void view6(View v)
    {
        File pdfFile = new File(Environment.getExternalStorageDirectory() + "/CodeBubble/" + "Tech_mahindra1.pdf");  // -> filename = maven.pdf
        Uri path = Uri.fromFile(pdfFile);
        Intent pdfIntent = new Intent(Intent.ACTION_VIEW);
        pdfIntent.setDataAndType(path, "application/pdf");
        pdfIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        try{
            startActivity(pdfIntent);
        }catch(ActivityNotFoundException e){
            Toasty.error(Placement_papers.this, "No Application available to view PDF", Toast.LENGTH_SHORT).show();
        }
    }

    public void download7(View v)
    {
        File file = new File(Environment.getExternalStorageDirectory() + "/CodeBubble/" + "Tech_mahindra2.pdf");
        if(file.exists()){
            Toasty.info(this, "File is already Stored in internal storage/CodeBubble\nplease click VIEW button to open the file", Toast.LENGTH_LONG).show();
        }
        else {
            new DownloadFile().execute("https://firebasestorage.googleapis.com/v0/b/code-bubble.appspot.com/o/Tech_Mahindra_Apti.pdf?alt=media&token=d076ea16-b951-4405-b521-4d1dd4874d60", "Tech_mahindra2.pdf");

        }
    }

    public void view7(View v)
    {
        File pdfFile = new File(Environment.getExternalStorageDirectory() + "/CodeBubble/" + "Tech_mahindra2.pdf");  // -> filename = maven.pdf
        Uri path = Uri.fromFile(pdfFile);
        Intent pdfIntent = new Intent(Intent.ACTION_VIEW);
        pdfIntent.setDataAndType(path, "application/pdf");
        pdfIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        try{
            startActivity(pdfIntent);
        }catch(ActivityNotFoundException e){
            Toasty.error(Placement_papers.this, "No Application available to view PDF", Toast.LENGTH_SHORT).show();
        }
    }

    public void download8(View v)
    {
        File file = new File(Environment.getExternalStorageDirectory() + "/CodeBubble/" + "Tech_mahindra3.pdf");
        if(file.exists()){
            Toasty.info(this, "File is already Stored in internal storage/CodeBubble\nplease click VIEW button to open the file", Toast.LENGTH_LONG).show();
        }
        else {
            new DownloadFile().execute("https://firebasestorage.googleapis.com/v0/b/code-bubble.appspot.com/o/3.tech%20mahindra%20placement%20paper.pdf?alt=media&token=89127b69-dcc1-4d98-8b34-233703126131", "Tech_mahindra3.pdf");

        }
    }

    public void view8(View v)
    {
        File pdfFile = new File(Environment.getExternalStorageDirectory() + "/CodeBubble/" + "Tech_mahindra3.pdf");  // -> filename = maven.pdf
        Uri path = Uri.fromFile(pdfFile);
        Intent pdfIntent = new Intent(Intent.ACTION_VIEW);
        pdfIntent.setDataAndType(path, "application/pdf");
        pdfIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        try{
            startActivity(pdfIntent);
        }catch(ActivityNotFoundException e){
            Toasty.error(Placement_papers.this, "No Application available to view PDF", Toast.LENGTH_SHORT).show();
        }
    }

    public void download9(View v)
    {
        File file = new File(Environment.getExternalStorageDirectory() + "/CodeBubble/" + "WIPRO.pdf");
        if(file.exists()){
            Toasty.info(this, "File is already Stored in internal storage/CodeBubble\nplease click VIEW button to open the file", Toast.LENGTH_LONG).show();
        }
        else {
            new DownloadFile().execute("https://firebasestorage.googleapis.com/v0/b/code-bubble.appspot.com/o/Wipro.pdf?alt=media&token=bfe96df1-91b0-4bf3-a0f9-0c9878126b75", "WIPRO.pdf");

        }
    }

    public void view9(View v)
    {
        File pdfFile = new File(Environment.getExternalStorageDirectory() + "/CodeBubble/" + "WIPRO.pdf");  // -> filename = maven.pdf
        Uri path = Uri.fromFile(pdfFile);
        Intent pdfIntent = new Intent(Intent.ACTION_VIEW);
        pdfIntent.setDataAndType(path, "application/pdf");
        pdfIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        try{
            startActivity(pdfIntent);
        }catch(ActivityNotFoundException e){
            Toasty.error(Placement_papers.this, "No Application available to view PDF", Toast.LENGTH_SHORT).show();
        }
    }



   /* public void download10(View v)
    {
        File file = new File(Environment.getExternalStorageDirectory() + "/CodeBubble/" + "HCL.pdf");
        if(file.exists()){
            Toasty.info(this, "File is already Stored in internal storage/CodeBubble\nplease click VIEW button to open the file", Toast.LENGTH_LONG).show();
        }
        else {
            new DownloadFile().execute("https://firebasestorage.googleapis.com/v0/b/code-bubble.appspot.com/o/HCL.pdf?alt=media&token=c79207cf-d4da-4e41-ac7c-a4507701d85f", "HCL.pdf");
             
        }
    }

    public void view10(View v)
    {
        File pdfFile = new File(Environment.getExternalStorageDirectory() + "/CodeBubble/" + "HCL.pdf");  // -> filename = maven.pdf
        Uri path = Uri.fromFile(pdfFile);
        Intent pdfIntent = new Intent(Intent.ACTION_VIEW);
        pdfIntent.setDataAndType(path, "application/pdf");
        pdfIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        try{
            startActivity(pdfIntent);
        }catch(ActivityNotFoundException e){
            Toasty.error(Placement_papers.this, "No Application available to view PDF", Toast.LENGTH_SHORT).show();
        }
    }

    public void download11(View v)
    {
        File file = new File(Environment.getExternalStorageDirectory() + "/CodeBubble/" + "HCL.pdf");
        if(file.exists()){
            Toasty.info(this, "File is already Stored in internal storage/CodeBubble\nPlease click VIEW button to open the file", Toast.LENGTH_LONG).show();
        }
        else {
            new DownloadFile().execute("https://firebasestorage.googleapis.com/v0/b/code-bubble.appspot.com/o/HCL.pdf?alt=media&token=c79207cf-d4da-4e41-ac7c-a4507701d85f", "HCL.pdf");
            
        }
    }

    public void view11(View v)
    {
        File pdfFile = new File(Environment.getExternalStorageDirectory() + "/CodeBubble/" + "HCL.pdf");  // -> filename = maven.pdf
        Uri path = Uri.fromFile(pdfFile);
        Intent pdfIntent = new Intent(Intent.ACTION_VIEW);
        pdfIntent.setDataAndType(path, "application/pdf");
        pdfIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        try{
            startActivity(pdfIntent);
        }catch(ActivityNotFoundException e){
            Toasty.error(Placement_papers.this, "No Application available to view PDF", Toast.LENGTH_SHORT).show();
        }
    }*/

    private class DownloadFile extends AsyncTask<String, Void, Void>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            showpDialog();
        }

        @Override
        protected Void doInBackground(String... strings) {
            String fileUrl = strings[0];   // -> http://maven.apache.org/maven-1.x/maven.pdf
            String fileName = strings[1];  // -> maven.pdf
            String extStorageDirectory = Environment.getExternalStorageDirectory().toString();
            File folder = new File(extStorageDirectory, "CodeBubble");
            folder.mkdir();

            File pdfFile = new File(folder, fileName);

            try{
                pdfFile.createNewFile();
            }catch (IOException e){
                e.printStackTrace();
            }
            file_downloader.downloadFile(fileUrl, pdfFile,fileName);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            hidepDialog();
            Toasty.info(getApplicationContext(), "Stored in Internal_storage/CodeBubble", Toast.LENGTH_LONG).show();

            Log.d("Download complete", "----------");
        }

        private void showpDialog() {
            if (!pDialog.isShowing())
                pDialog.show();
        }

        private void hidepDialog() {
            if (pDialog.isShowing())
                pDialog.dismiss();
        }
    }


    @Override
    public void onBackPressed()
    {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }


    
}
   


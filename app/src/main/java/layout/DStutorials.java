package layout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import galab.example.com.interviewbyte.R;
import galab.example.com.interviewbyte.Stacks;
import galab.example.com.interviewbyte.webviewtest;


public class DStutorials extends Fragment {



    String[] listviewTitle = new String[]{
            "Stack Data Structure ",
            "Queue Data Structure",
            "Introduction To Linked List",
            "Linear Linked List",
            "Circular Linked List"

    };







    public DStutorials() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //getActivity().setTitle("Data Structures");
        // Inflate the layout for this fragment

        String[] listviewShortDescription = new String[]{
                "Brief explanantion about stacks with implementation","Brief explanation about stacks with implementation",
                "Introduction to linked lists","Linear linked list briefly explained with implementation","Learn Circular linked list with implementation"
        };
        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();


        for (int i = 0; i < 5; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("listview_title", listviewTitle[i]);
            hm.put("listview_discription", listviewShortDescription[i]);
            aList.add(hm);
        }

        String[] from = {"listview_title", "listview_discription"};
        int[] to = {R.id.listview_item_title, R.id.listview_item_short_description};
        View v = inflater.inflate(R.layout.fragment_dstutorials, container,false);

        SimpleAdapter simpleAdapter = new SimpleAdapter(getActivity().getBaseContext(), aList, R.layout.offline_list_view, from, to);
        ListView androidListView = (ListView)v.findViewById(R.id.list_view);
        androidListView.setAdapter(simpleAdapter);
        androidListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View container, int position, long id) {
                // Getting the Container Layout of the ListView
                LinearLayout linearLayoutParent = (LinearLayout) container;

                // Getting the inner Linear Layout
                LinearLayout linearLayoutChild = (LinearLayout ) linearLayoutParent.getChildAt(1);

                // Getting the Country TextView
                //TextView title = (TextView) linearLayoutChild.getChildAt(0);

                Fragment fragment=null;

                switch(position){
                    case 0:
                    {
                        Intent intent=new Intent(getActivity(),Stacks.class);
                        startActivity(intent);
                        getActivity().overridePendingTransition(R.anim.open_translate, R.anim.close_scale);

                    }


                    break;
                    case 1:{
                        Intent intent=new Intent(getActivity(),webviewtest.class);
                        intent.putExtra("url","file:///android_asset/webpages/queue.html");
                        intent.putExtra("title","Queue");
                        startActivity(intent);
                        getActivity().overridePendingTransition(R.anim.open_translate, R.anim.close_scale);
                    }
                    break;

                    case 2:
                    {Intent intent=new Intent(getActivity(),webviewtest.class);
                        intent.putExtra("url","file:///android_asset/webpages/linkedlistintro.html");
                        intent.putExtra("title","Linked List");
                        startActivity(intent);
                        getActivity().overridePendingTransition(R.anim.open_translate, R.anim.close_scale);
                    }
                    break;
                    case 3:
                    {Intent intent=new Intent(getActivity(),webviewtest.class);
                        intent.putExtra("url","file:///android_asset/webpages/linearlinkedlist.html");
                        intent.putExtra("title","Linear List");
                        startActivity(intent);
                        getActivity().overridePendingTransition(R.anim.open_translate, R.anim.close_scale);
                    }

                    break;

                    case 4:
                    {Intent intent=new Intent(getActivity(),webviewtest.class);
                        intent.putExtra("url","file:///android_asset/webpages/circularlinkedlist.html");
                        intent.putExtra("title","Circular List");
                        startActivity(intent);
                        getActivity().overridePendingTransition(R.anim.open_translate, R.anim.close_scale);
                    }
                    break;


                }
            }
        });

        return v;


    }




    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }



}

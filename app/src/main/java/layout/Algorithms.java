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

import galab.example.com.interviewbyte.Complexity;
import galab.example.com.interviewbyte.R;
import galab.example.com.interviewbyte.Searching;
import galab.example.com.interviewbyte.Sorting;
import galab.example.com.interviewbyte.algolist1;
import galab.example.com.interviewbyte.complexityplot;


public class Algorithms extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    String[] listviewTitle = new String[]{
            "An easy way to understand algorithm complexity and big O notation ",
            "Complexity Graph",
            "Sorting Algorithms",
            "Searching Algorithms",
            "Quick overview of sorting algorithms complexity"

    };







    public Algorithms() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Algorithms.
     */
    // TODO: Rename and change types and number of parameters
    public static Algorithms newInstance(String param1, String param2) {
        Algorithms fragment = new Algorithms();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        String[] listviewShortDescription = new String[]{
                "Learn about algorithm complexity","Complexity Graph","Basic Sorting Algorithms","Basic Searching Algorithms",
                "Time complexity and space complexity of all basic sorting  algorithms",""
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
        View v = inflater.inflate(R.layout.fragment_algorithms, container,false);

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
                        Intent intent=new Intent(getActivity(),algolist1.class);
                        startActivity(intent);
                        getActivity().overridePendingTransition(R.anim.open_translate, R.anim.close_scale);

                    }
                    break;

                    case 1:
                    {Intent intent=new Intent(getActivity(),complexityplot.class);
                        startActivity(intent);
                        getActivity().overridePendingTransition(R.anim.open_translate, R.anim.close_scale);
                    }

                    break;
                    case 2:{
                        Intent intent=new Intent(getActivity(),Sorting.class);
                        startActivity(intent);
                        getActivity().overridePendingTransition(R.anim.open_translate, R.anim.close_scale);
                    }
                    break;

                    case 3:
                    {Intent intent=new Intent(getActivity(),Searching.class);
                        startActivity(intent);
                        getActivity().overridePendingTransition(R.anim.open_translate, R.anim.close_scale);
                    }
                    break;
                    case 4:
                    {Intent intent=new Intent(getActivity(),Complexity.class);
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

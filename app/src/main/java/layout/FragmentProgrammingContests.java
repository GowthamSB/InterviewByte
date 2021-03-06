package layout;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import es.dmoral.toasty.Toasty;
import galab.example.com.interviewbyte.R;
import galab.example.com.interviewbyte.WebViewActivity;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentProgrammingContests.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentProgrammingContests#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentProgrammingContests extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    String[] listviewTitle = new String[]{
            "Hackerrank",
            "Hackerearth",
            "Leetcode",
            "Coderbyte",

    };

    int[] listviewImage = new int[]{
            R.mipmap.hackerrank, R.mipmap.hackerearth, R.mipmap.leetcode, R.mipmap.coderbyte,
            };




    private OnFragmentInteractionListener mListener;

    public FragmentProgrammingContests() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentProgrammingContests.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentProgrammingContests newInstance(String param1, String param2) {
        FragmentProgrammingContests fragment = new FragmentProgrammingContests();
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
        getActivity().setTitle("Contests");
        // Inflate the layout for this fragment
        String[] listviewShortDescription = new String[]{
                getString(R.string.hackerrank), getString(R.string.hackerearth),
                getString(R.string.Leetcode), getString(R.string.coderbyte),};

        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();


        for (int i = 0; i < 4; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("listview_title", listviewTitle[i]);
            hm.put("listview_discription", listviewShortDescription[i]);
            hm.put("listview_image", Integer.toString(listviewImage[i]));
            aList.add(hm);
        }

        String[] from = {"listview_image", "listview_title", "listview_discription"};
        int[] to = {R.id.listview_image, R.id.listview_item_title, R.id.listview_item_short_description};
        View v = inflater.inflate(R.layout.fragment_fragment_interview, container,false);

        SimpleAdapter simpleAdapter = new SimpleAdapter(getActivity().getBaseContext(), aList, R.layout.listview_activity, from, to);
        ListView androidListView = (ListView)v.findViewById(R.id.list_view);
        androidListView.setAdapter(simpleAdapter);
        androidListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View container, int position, long id) {
                // Getting the Container Layout of the ListView
                /*LinearLayout linearLayoutParent = (LinearLayout) container;

                // Getting the inner Linear Layout
                LinearLayout linearLayoutChild = (LinearLayout ) linearLayoutParent.getChildAt(1);

                // Getting the Country TextView
                TextView title = (TextView) linearLayoutChild.getChildAt(0);*/

                String text="Opening";

                switch(position){
                    case 0:
                    {Intent intent=new Intent(getActivity(),WebViewActivity.class);
                        intent.putExtra("url","https://www.hackerrank.com");
                        intent.putExtra("title",listviewTitle[position]);
                        Toasty.info(getActivity().getBaseContext(), listviewTitle[position], Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                        getActivity().overridePendingTransition(R.anim.open_translate, R.anim.close_scale);
                    }


                    break;
                    case 1:{Intent intent=new Intent(getActivity(),WebViewActivity.class);
                        intent.putExtra("url","https://www.hackerearth.com/");
                        intent.putExtra("title",listviewTitle[position]);
                        Toasty.info(getActivity().getBaseContext(), listviewTitle[position], Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                        getActivity().overridePendingTransition(R.anim.open_translate, R.anim.close_scale);
                    }
                    break;

                    case 2:
                    {Intent intent=new Intent(getActivity(),WebViewActivity.class);
                        intent.putExtra("url","https://leetcode.com/");
                        intent.putExtra("title",listviewTitle[position]);
                        Toasty.info(getActivity().getBaseContext(),listviewTitle[position], Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                        getActivity().overridePendingTransition(R.anim.open_translate, R.anim.close_scale);
                    }
                    break;

                    case 3:
                    {Intent intent=new Intent(getActivity(),WebViewActivity.class);
                        intent.putExtra("url","http://www.coderbyte.com/mobile");
                        intent.putExtra("title",listviewTitle[position]);
                        Toasty.info(getActivity().getBaseContext(),listviewTitle[position], Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                        getActivity().overridePendingTransition(R.anim.open_translate, R.anim.close_scale);
                    }
                    break;







                }
            }
        });

        return v;


    }



    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}

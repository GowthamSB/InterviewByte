package layout;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;


import galab.example.com.interviewbyte.CustomGridViewActivity;
import galab.example.com.interviewbyte.MainActivity;
import galab.example.com.interviewbyte.Offline_home;
import galab.example.com.interviewbyte.Placement_papers;
import galab.example.com.interviewbyte.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link fragmenthome.OnFragmentInteractionListener } interface
 * to handle interaction events.
 * Use the {@link fragmenthome#newInstance} factory method to
 * create an instance of this fragment.
 *

 */


public class fragmenthome extends Fragment{

    public MainActivity viewisathome;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    String[] gridViewString = {
            "Offline","Interview skills", "Programming",   "Programming Contests", "Courses","Questioning","Placement Papers"


    } ;
    int[] gridViewImageId = {
            R.mipmap.offline,R.mipmap.interview,R.mipmap.code, R.mipmap.programming_contests,R.mipmap.courses, R.mipmap.questioning,
           R.mipmap.placement_papers,



    };

    private OnFragmentInteractionListener mListener;

    public fragmenthome() {
        // Required empty public constructor
    }

    public static FragmentInterview newInstance(String param1, String param2) {
        FragmentInterview fragment = new FragmentInterview();
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
        getActivity().setTitle("Home");

        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_fragmenthome,container,false);


        viewisathome=(MainActivity) getActivity();
        CustomGridViewActivity adapterViewAndroid = new CustomGridViewActivity(getActivity().getBaseContext(), gridViewString, gridViewImageId);
        GridView androidGridView=(GridView)v.findViewById(R.id.grid_view_image_text);
        androidGridView.setAdapter(adapterViewAndroid);
        androidGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int i, long id) {
                switch(i)
                {
                    case 4:
                        /* Toast.makeText(getActivity().getBaseContext(), "GridView Item: " + gridViewString[+i], Toast.LENGTH_SHORT).show(); */
                        viewisathome.viewIsAtHome=false;
                        Fragment fragment=new FragmentCourses();
                        FragmentTransaction ft = getFragmentManager().beginTransaction();
                        ft.addToBackStack(null);
                        ft.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left);
                        ft.replace(R.id.content_frame, fragment);
                        ft.commit();
                        break;

                    case 2:
                        viewisathome.viewIsAtHome=false;
                        fragment=new FragmentProgramming();
                        ft = getFragmentManager().beginTransaction();
                        ft.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left);
                        ft.replace(R.id.content_frame, fragment);
                        ft.addToBackStack(null);
                        ft.commit();

                        break;

                    case 5:
                        viewisathome.viewIsAtHome=false;
                        fragment=new FragmentQuestioning();
                        ft = getFragmentManager().beginTransaction();
                        ft.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left);
                        ft.replace(R.id.content_frame, fragment);
                        ft.addToBackStack(null);
                        ft.commit();

                        break;

                    case 1:
                        viewisathome.viewIsAtHome=false;
                        fragment=new FragmentInterview();
                        ft = getFragmentManager().beginTransaction();
                        ft.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left);
                        ft.replace(R.id.content_frame, fragment);
                        ft.addToBackStack(null);
                        ft.commit();

                        break;

                    case 3:
                        viewisathome.viewIsAtHome=false;
                        fragment=new FragmentProgrammingContests();
                        ft = getFragmentManager().beginTransaction();
                        ft.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left);
                        ft.replace(R.id.content_frame, fragment);
                        ft.commit();

                        break;

                    case 0: {
                        viewisathome.viewIsAtHome = false;
                        Intent intent = new Intent(getActivity(), Offline_home.class);
                        startActivity(intent);
                        getActivity().overridePendingTransition(R.anim.open_translate, R.anim.close_scale);
                    }
                        break;

                    case 6:
                        viewisathome.viewIsAtHome=false;
                        Intent intent=new Intent(getActivity(), Placement_papers.class);
                        startActivity(intent);
                        getActivity().overridePendingTransition(R.anim.open_translate, R.anim.close_scale);
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





    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }



}
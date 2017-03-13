package layout;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import galab.example.com.interviewbyte.R;


public class JAVA extends Fragment {









    public JAVA() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment

        String[] listviewShortDescription = new String[]{
                getString(R.string.j1),getString(R.string.j2),getString(R.string.j3), getString(R.string.j4)
                ,getString(R.string.j5),getString(R.string.j6),getString(R.string.j7),
                getString(R.string.j8),getString(R.string.j9),getString(R.string.j10)
                ,getString(R.string.j11),getString(R.string.j12),getString(R.string.j13),
                getString(R.string.j14),getString(R.string.j15),getString(R.string.j16)
                ,getString(R.string.j17),getString(R.string.j18), getString(R.string.j19),getString(R.string.j20),
                getString(R.string.j21),getString(R.string.j22),getString(R.string.j23)
                ,getString(R.string.j24),getString(R.string.j25),getString(R.string.j26),
                getString(R.string.j27),getString(R.string.j28),getString(R.string.j29)
                ,getString(R.string.j30),getString(R.string.j31),getString(R.string.j32),
                getString(R.string.j33),getString(R.string.j34),getString(R.string.j35)
                ,getString(R.string.j36),getString(R.string.j37),getString(R.string.j38),
                getString(R.string.j39),getString(R.string.j40),getString(R.string.j41)
                ,getString(R.string.j42),getString(R.string.j43),getString(R.string.j44),
                getString(R.string.j45),getString(R.string.j46),getString(R.string.j47)
                ,getString(R.string.j48),getString(R.string.j49),getString(R.string.j50),
                getString(R.string.j51),getString(R.string.j52),getString(R.string.j53)
                ,getString(R.string.j54),getString(R.string.j55),getString(R.string.j56),
                getString(R.string.j57),getString(R.string.j58),getString(R.string.j59)

        };
        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();


        for (int i = 0; i < 59; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("listview_discription", listviewShortDescription[i]);
            aList.add(hm);
        }

        String[] from = {"listview_discription"};
        int[] to = { R.id.listview_item_short_description};
        View v = inflater.inflate(R.layout.fragment_jav, container,false);

        SimpleAdapter simpleAdapter = new SimpleAdapter(getActivity().getBaseContext(), aList, R.layout.offline_singledesc_card, from, to);
        ListView androidListView = (ListView)v.findViewById(R.id.list_view);
        androidListView.setAdapter(simpleAdapter);

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

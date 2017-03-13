package layout;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import galab.example.com.interviewbyte.R;


public class Operating_System extends Fragment {




    public Operating_System() {
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
        LayoutInflater lf = getActivity().getLayoutInflater();

        String htmlstring="<b>hello</b><h1>hello</h1>";
        View view= lf.inflate(R.layout.fragment_operating__system, container, false);
        TextView textview=(TextView) view.findViewById(R.id.os);
        textview.setText(Html.fromHtml(getString(R.string.butterfly_html)));
        return view;
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

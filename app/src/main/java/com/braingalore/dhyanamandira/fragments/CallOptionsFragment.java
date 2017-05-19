package com.braingalore.dhyanamandira.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.braingalore.dhyanamandira.R;
import com.braingalore.dhyanamandira.utils.AnimUtils;
import com.braingalore.dhyanamandira.utils.CallingUtils;

/**
 * Created by s92 on 5/4/2017.
 */

public class CallOptionsFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup vg,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_call_fragment, vg, false);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.call_fragment_container);
        AnimUtils.animate(linearLayout, getActivity());
        Button number1 = (Button) view.findViewById(R.id.number743);
        number1.setOnClickListener(clickListener);
        Button number2 = (Button) view.findViewById(R.id.number812);
        number2.setOnClickListener(clickListener);
        Button number3 = (Button) view.findViewById(R.id.number959);
        number3.setOnClickListener(clickListener);
        return view;
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String numberToDial = "";
            if (view.getId() == R.id.number812) {
                numberToDial = "+918123848682";
            }
            if (view.getId() == R.id.number743) {
                numberToDial = "+917349782713";
            }
            if (view.getId() == R.id.number959) {
                numberToDial = "+919916039959";
            }
            if (CallingUtils.isSimPresent(getActivity())) {
                CallingUtils.dialIntent(getActivity(), numberToDial, view);
            } else {
                Snackbar.make(view, "Insert SIM card to call Dhyana Mandira - Rajkumar", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        }
    };
}

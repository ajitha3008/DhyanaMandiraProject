package com.braingalore.dhyanamandira.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.braingalore.dhyanamandira.R;
import com.braingalore.dhyanamandira.adapter.AbhyasasExpandableListAdapter;
import com.braingalore.dhyanamandira.adapter.ExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by s92 on 5/4/2017.
 */

public class AbhyasasExpandableFragment extends Fragment {

    AbhyasasExpandableListAdapter listAdapter;

    ExpandableListView expListView;

    List<String> listDataHeader;

    HashMap<String, List<String>> listDataChild;

    public View onCreateView(LayoutInflater inflater, ViewGroup vg,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_mantras, vg, false);
        expListView = (ExpandableListView) view.findViewById(R.id.expandableListView);
        // preparing list data
        prepareListData();
        listAdapter = new AbhyasasExpandableListAdapter(getActivity(), listDataHeader, listDataChild);
        // setting list adapter
        expListView.setAdapter(listAdapter);
        return view;
    }

    /*
     * Preparing the list data
	 */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Breathing methods");
        listDataHeader.add("Breathing exercises");
        listDataHeader.add("Body Joint exercises");// 	[Chalane(movement)]	[Bhramana(rotation)]
        listDataHeader.add("Categories Of Asanas");
        listDataHeader.add("Sitting Asanas");
        listDataHeader.add("Standing Asanas");
        listDataHeader.add("Sleeping Asanas");
        listDataHeader.add("Special Asanas");
        listDataHeader.add("Relaxation Asanas");
        listDataHeader.add("Surya Namaskara Asanas");
        listDataHeader.add("Pranayama techniques");
        listDataHeader.add("Mudras");
        listDataHeader.add("Saptha Chakras");
        listDataHeader.add("Mantras");

        // Adding child data
        List<String> breathing_methods = new ArrayList<String>();
        breathing_methods.add("Pooraka (inhalation)");
        breathing_methods.add("Rechaka (exhalation)");
        breathing_methods.add("Antar-Kumbhaka (holding the breath inside)");
        breathing_methods.add("Bahya-Kumbhaka (holding the breath outside)");

        List<String> breathing_exercises = new ArrayList<String>();
        breathing_exercises.add("Udara Shwasa Kriya");
        breathing_exercises.add("Urah Shwasa Kriya");
        breathing_exercises.add("Greeva Shwasa Kriya");
        breathing_exercises.add("Poorna Shwasa Kriya");
        breathing_exercises.add("Maarjala Shwasa Kriya");
        breathing_exercises.add("Shwana Shwasa Kriya");
        breathing_exercises.add("Katishwasa Kriya");


        List<String> body_joint_exercises = new ArrayList<String>();
        body_joint_exercises.add("Hastha-Paada Anguli Chalane (Hands & Legs Fingers)");
        body_joint_exercises.add("Paada Chalane & Bhramana (Ankle joints)");
        body_joint_exercises.add("Jaanu sandhi Chalane & Bhramana (Knee joints)");
        body_joint_exercises.add("Ooru Sandhi Chalane & Bhramana (Hip joints)");
        body_joint_exercises.add("Kati Sandhi Chalane & Bhramana (Waist)");
        body_joint_exercises.add("Skanda Sandhi Chalane & Bhramana (Shoulder joints)");
        body_joint_exercises.add("Koorpra Sandhi Chalane & Bhramana (Elbow joints)");
        body_joint_exercises.add("Manibandha Sandhi Chalane & Bhramana (Wrist joints)");
        body_joint_exercises.add("Hasthanguli Sanchalana (Hands fingers fast exercises)");
        body_joint_exercises.add("Greeva Sandhi Chalane & Bhramana (Neck)");
        body_joint_exercises.add("Netha Chalane & Bhramana (Eyes)");
        body_joint_exercises.add("Running exercises");
        body_joint_exercises.add("Prasarita Paadotthanasana-Trikonasana-Hastha Parshwa Chalane (Backbone exercises)");

        List<String> categories_asanas = new ArrayList<String>();
        categories_asanas.add("Sitting Asanas");
        categories_asanas.add("Standing Asanas");
        categories_asanas.add("Sleeping Asanas");
        categories_asanas.add("Special Category Asanas");
        categories_asanas.add("Forward bending Asanas");
        categories_asanas.add("Backward bending Asanas");
        categories_asanas.add("Twisting Asanas");
        categories_asanas.add("Head down-Legs up Asanas");

        List<String> sitting_asanas = new ArrayList<String>();
        sitting_asanas.add("Sukhasana");
        sitting_asanas.add("Dandasana");
        sitting_asanas.add("Paadangusta Dandasana");
        sitting_asanas.add("Paada Pashchimothanasana");
        sitting_asanas.add("Oordhwa Hastha Dandasana");
        sitting_asanas.add("Oordhwa Namaskarasana");
        sitting_asanas.add("Baddhangulya Dandasana");
        sitting_asanas.add("Upavista Konasana");
        sitting_asanas.add("Paadangusta Upavista Konasana");
        sitting_asanas.add("Suptha Paadangusta Upavista Konasana");
        sitting_asanas.add("Eka-Paada Paschimothanasana");
        sitting_asanas.add("Badha Konasana");
        sitting_asanas.add("Suptha Badhakonasana");
        sitting_asanas.add("Vajrasana");
        sitting_asanas.add("Adhomukha Vajransana");
        sitting_asanas.add("Ardha Makarasana");
        sitting_asanas.add("Padmasana");
        sitting_asanas.add("Tolasana-Lolasana");
        sitting_asanas.add("Simhasana");
        sitting_asanas.add("Uthita-Jaanu Shirshasana");
        sitting_asanas.add("Parivrutha-Jaanu Shirshasana");
        sitting_asanas.add("TrayangaMukha Pada Paschimothanasana");
        sitting_asanas.add("Poorna Veerasana");
        sitting_asanas.add("Suptha Veerasana");
        sitting_asanas.add("Baddhangulya Veerasana");
        sitting_asanas.add("Mandookasana");
        sitting_asanas.add("Krounchasana");
        sitting_asanas.add("Gomukhasana");
        sitting_asanas.add("Mareechasana");
        sitting_asanas.add("Bharadhwajasana");
        sitting_asanas.add("Ardha-Matseyndhrasana");

        List<String> standing_asanas = new ArrayList<String>();
        standing_asanas.add("Taadasana");
        standing_asanas.add("Oordhwa-Hastha Taadasana");
        standing_asanas.add("Baddhangulya Taadasana");
        standing_asanas.add("Baddha-Hasta Taadasana");
        standing_asanas.add("Baddha-Hasta Utthanasana");
        standing_asanas.add("Utkatasana");
        standing_asanas.add("Paadangusta Utthansana");
        standing_asanas.add("Poorna Utthanasana");
        standing_asanas.add("Ardha Chakrasana");
        standing_asanas.add("Ardha Kati Chakrasana");
        standing_asanas.add("Gomukhasana");
        standing_asanas.add("Paschima-Namaskrarasana");
        standing_asanas.add("Vrukshasana");
        standing_asanas.add("Utthita-Trikonasana");
        standing_asanas.add("Parivruttha Trikonasana");
        standing_asanas.add("Utthita Parshwa Konasana");
        standing_asanas.add("Parivruttha Paarshwa Konasana");
        standing_asanas.add("Ardha Chandrasana");
        standing_asanas.add("Veerabhadrasana");
        standing_asanas.add("Parshwa Utthanasana");
        standing_asanas.add("Prasarita Paadotthansana");
        standing_asanas.add("Chatushpadasana");

        List<String> sleeping_asanas = new ArrayList<String>();
        sleeping_asanas.add("Suptha Taadasana");
        sleeping_asanas.add("Hastha-Paadangustasana");
        sleeping_asanas.add("Eka-Paada Halasana");
        sleeping_asanas.add("Poorna Halasana");
        sleeping_asanas.add("Sethu Bandhasana");
        sleeping_asanas.add("Jathara Parivartansana");
        sleeping_asanas.add("Anantasana");
        sleeping_asanas.add("Chaturanga");
        sleeping_asanas.add("Dandasana");
        sleeping_asanas.add("Oordhwa Mukha Dhanirasana");
        sleeping_asanas.add("Adhomukha Dhanurasana");
        sleeping_asanas.add("Matsyasana");
        sleeping_asanas.add("Mayurasana");
        sleeping_asanas.add("Hamsasana");
        sleeping_asanas.add("Eka-Pada Halasana");
        sleeping_asanas.add("Poorna Halasana");
        sleeping_asanas.add("Parshwa Halasana");
        sleeping_asanas.add("Vipareethakarani");

        List<String> special_asanas = new ArrayList<String>();
        special_asanas.add("Shrishasana");
        special_asanas.add("Sarvangasana");
        special_asanas.add("Adhomukha Vrukdshasana");
        special_asanas.add("Bakasana");
        special_asanas.add("BhujaPeedasana");
        special_asanas.add("Parighasana");
        special_asanas.add("Ustrasana");
        special_asanas.add("Karna Peedasana");

        List<String> relaxation_asanas = new ArrayList<String>();
        relaxation_asanas.add("Sukhasana");
        relaxation_asanas.add("Ardha-Makarasana");
        relaxation_asanas.add("Poorna-Makarasana");
        relaxation_asanas.add("Shashankasana");
        relaxation_asanas.add("Ardha-Shavasana");
        relaxation_asanas.add("Poorna-Shavasana");

        List<String> surya_namaskara_asanas = new ArrayList<String>();
        surya_namaskara_asanas.add("Namaskarasana");
        surya_namaskara_asanas.add("Oordhwa Namaskarasana");
        surya_namaskara_asanas.add("Utthanasana");
        surya_namaskara_asanas.add("Ekapaada Prasaranasana");
        surya_namaskara_asanas.add("Adhomukha Shwanasana");
        surya_namaskara_asanas.add("Shadangasana");
        surya_namaskara_asanas.add("Astangaprani Padasana");
        surya_namaskara_asanas.add("Bhujangasana");
        surya_namaskara_asanas.add("Adhomukha Shwanasana");
        surya_namaskara_asanas.add("Ekapada Prasaranasana");
        surya_namaskara_asanas.add("Oordhwa Namaskarasana");
        surya_namaskara_asanas.add("Namaskarasana");

        List<String> pranayamas = new ArrayList<String>();
        pranayamas.add("Anuloma –Viloma");
        pranayamas.add("Aumkara Pranayama");
        pranayamas.add("Chandranuloma");
        pranayamas.add("Suryanuloma");
        pranayamas.add("Chandrabedhana");
        pranayamas.add("Suryabedhana");
        pranayamas.add("Naadishodhana");
        pranayamas.add("Bhastrika");
        pranayamas.add("Kapalabhati");
        pranayamas.add("Sheethali");
        pranayamas.add("Sheetkari");
        pranayamas.add("Sadantha");
        pranayamas.add("Bhramari");

        List<String> mudras = new ArrayList<String>();
        mudras.add("Drona Mudra");
        mudras.add("Chin Mudra");
        mudras.add("Chinmaya Mudra");
        mudras.add("Adi Mudra");
        mudras.add("Akasha Mudra");
        mudras.add("Bramha Mudra");
        mudras.add("Bhairava Mudra");
        mudras.add("Mrugi Mudra");
        mudras.add("Shanmuga Mudra");
        mudras.add("Karna Mudra");
        mudras.add("Khechari Mudra");
        mudras.add("Bhoochari Mudra");

        List<String> chakras = new ArrayList<String>();
        chakras.add("Mooladhara Chakra");
        chakras.add("Swasdisthana Chakra");
        chakras.add("Manipoora Chakra");
        chakras.add("Anahata Chakra");
        chakras.add("Vishuddhi Chakra");
        chakras.add("Jnana Chakra");
        chakras.add("Sahasrara Chakra");

        List<String> mantras = new ArrayList<String>();
        mantras.add("Shanti Mantra");
        mantras.add("Gurusthuti Mantra");
        mantras.add("Surya Namaskrara Mantra");
        mantras.add("Surya Namaskara Phalashruti Mantra");
        mantras.add("Bhoo Namana Mantra");
        mantras.add("Yoga Mantra");
        mantras.add("Jyotir Mantra");
        mantras.add("Pranayama Mantra");
        mantras.add("Aikya Mantra");
        mantras.add("Ekatmata Stotra");

        listDataChild.put(listDataHeader.get(0), breathing_methods); // Header, Child data
        listDataChild.put(listDataHeader.get(1), breathing_exercises);
        listDataChild.put(listDataHeader.get(2), body_joint_exercises);
        listDataChild.put(listDataHeader.get(3), categories_asanas);
        listDataChild.put(listDataHeader.get(4), sitting_asanas);
        listDataChild.put(listDataHeader.get(5), standing_asanas);
        listDataChild.put(listDataHeader.get(6), sleeping_asanas);
        listDataChild.put(listDataHeader.get(7), special_asanas);
        listDataChild.put(listDataHeader.get(8), relaxation_asanas);
        listDataChild.put(listDataHeader.get(9), surya_namaskara_asanas);
        listDataChild.put(listDataHeader.get(10), pranayamas);
        listDataChild.put(listDataHeader.get(11), mudras);
        listDataChild.put(listDataHeader.get(12), chakras);
        listDataChild.put(listDataHeader.get(13), mantras);
    }
}

package com.braingalore.dhyanamandira.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.braingalore.dhyanamandira.R;
import com.braingalore.dhyanamandira.adapter.AbhyasasAdapter;
import com.braingalore.dhyanamandira.model.AbhyasasObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by s92 on 5/4/2017.
 */

public class AbhyasasFragment extends Fragment {

    RecyclerView abhyasasView;

    AbhyasasAdapter abhyasasAdapter;

    List<AbhyasasObject> abhyasasList;

    public View onCreateView(LayoutInflater inflater, ViewGroup vg,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler_view_layout, vg, false);
        abhyasasView = (RecyclerView) view.findViewById(R.id.recycler_view);
        //commentsList.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        abhyasasList = prepareAbhyasaData();
        abhyasasAdapter = new AbhyasasAdapter(abhyasasList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        abhyasasView.setLayoutManager(mLayoutManager);
        //commentsList.setItemAnimator(new DefaultItemAnimator());
        abhyasasView.setAdapter(abhyasasAdapter);
        abhyasasAdapter.notifyDataSetChanged();
        return view;
    }

    private List<AbhyasasObject> prepareAbhyasaData() {
        ArrayList<String> items = new ArrayList<>();
        items.add("Breathing methods");
        items.add("Breathing exercises");
        items.add("Body Joint exercises");
        items.add("Asanas");
        items.add("Pranayama techniques");
        items.add("Mudras");
        items.add("Chakras");
        items.add("Mantras");

        abhyasasList = new ArrayList<AbhyasasObject>();
        abhyasasList.add(new AbhyasasObject("Breathing methods", "Pooraka (inhalation), Rechaka (exhalation), Antar-Kumbhaka (holding the breath inside), Bahya-Kumbhaka (holding the breath outside).", ""));
        abhyasasList.add(new AbhyasasObject("Breathing exercises", "Udara Shwasa Kriya, Urah Shwasa Kriya, Greeva Shwasa Kriya, Poorna Shwasa Kriya, Maarjala Shwasa Kriya, Shwana Shwasa Kriya, Katishwasa Kriya.", ""));
        abhyasasList.add(new AbhyasasObject("Names of Body joints exercises [Chalane(movement)…Bhramana(rotation)] :", "Hastha-Paada Anguli Chalane (Hands & Legs Fingers )\n" +
                "Paada Chalane & Bhramana (Ankle joints)\n" +
                "Jaanu sandhi Chalane & Bhramana (Knee joints)\n" +
                "Ooru Sandhi Chalane & Bhramana (Hip joints)\n" +
                "Kati Sandhi Chalane & Bhramana (Waist)\n" +
                "Skanda Sandhi Chalane & Bhramana (Shoulder joints)\n" +
                "Koorpra Sandhi Chalane & Bhramana (Elbow joints)\n" +
                "Manibandha Sandhi Chalane & Bhramana (Wrist joints)\n" +
                "Hasthanguli Sanchalana (Hands fingers fast exercises)\n" +
                "Greeva Sandhi Chalane & Bhramana (Neck)\n" +
                "Netha Chalane & Bhramana (Eyes)\n" +
                "Running exercises\n" +
                "Prasarita Paadotthanasana-Trikonasana-Hastha Parshwa Chalane (Backbone exercises)\n", ""));
        abhyasasList.add(new AbhyasasObject("Categories of Asanas", "Sitting, Standing, Sleeping & Special category.\n" +
                "Forward bending, Backward bending, Twisting, Head down-Legs up  category.\n", ""));
        abhyasasList.add(new AbhyasasObject("Names of Sitting Asanas", "Sukhasana, Dandasana, Paadangusta Dandasana, Paada Pashchimothanasana, Oordhwa Hastha Dandasana, Oordhwa Namaskarasana, Baddhangulya Dandasana, Upavista Konasana, Paadangusta Upavista Konasana, Suptha Paadangusta Upavista Konasana, Eka-Paada Paschimothanasana, Badha Konasana, Suptha Badhakonasana, Vajrasana, Adhomukha Vajransana, Ardha Makarasana, Padmasana, Tolasana-Lolasana, Simhasana, Uthita-Jaanu Shirshasana, Parivrutha-Jaanu Shirshasana, TrayangaMukha Pada Paschimothanasana, Poorna Veerasana, Suptha Veerasana, Baddhangulya Veerasana, Mandookasana, Krounchasana, Gomukhasana, Mareechasana, Bharadhwajasana, Ardha-Matseyndhrasana.", ""));
        abhyasasList.add(new AbhyasasObject("Names of Standing Asanas", "Taadasana, Oordhwa-Hastha Taadasana, Baddhangulya Taadasana, Baddha-Hasta Taadasana, Baddha-Hasta Utthanasana, Utkatasana, Paadangusta Utthansana, Poorna Utthanasana, Ardha Chakrasana, Ardha Kati Chakrasana, Gomukhasana, Paschima-Namaskrarasana, Vrukshasana, Utthita-Trikonasana, Parivruttha Trikonasana, Utthita Parshwa Konasana, Parivruttha Paarshwa Konasana, Ardha Chandrasana, Veerabhadrasana, Parshwa Utthanasana, Prasarita Paadotthansana, Chatushpadasana", ""));
        abhyasasList.add(new AbhyasasObject("Names of Sleeping Asanas", "Suptha Taadasana, Hastha-Paadangustasana, Eka-Paada Halasana, Poorna Halasana, Sethu Bandhasana, Jathara Parivartansana, Anantasana, Chaturanga Dandasana, Oordhwa Mukha Dhanirasana, Adhomukha Dhanurasana, Matsyasana, Mayurasana, Hamsasana, Eka-Pada Halasana, Poorna Halasana, Parshwa Halasana, Vipareethakarani.", ""));
        abhyasasList.add(new AbhyasasObject("Other special Asanas", "Shrishasana, Sarvangasana, Adhomukha Vrukdshasana, Bakasana, BhujaPeedasana, Parighasana, Ustrasana, Karna Peedasana", ""));
        abhyasasList.add(new AbhyasasObject("Relaxation Asanas", "Sukhasana, Ardha-Makarasana, Poorna-Makarasana, Shashankasana, Ardha-Shavasana, Poorna-Shavasana.", ""));
        abhyasasList.add(new AbhyasasObject("Surya Namaskara Asanas", "Namaskarasana, Oordhwa Namaskarasana, Utthanasana, Ekapaada Prasaranasana, Adhomukha Shwanasana, Shadangasana, Astangaprani Padasana, Bhujangasana, Adhomukha Shwanasana, Ekapada Prasaranasana, Utthanasana, Oordhwa Namaskarasana, Namaskarasana.", ""));
        abhyasasList.add(new AbhyasasObject("Pranayama techniques", "Anuloma –Viloma, Aumkara Pranayama, Chandranuloma, Suryanuloma, Chandrabedhana, Suryabedhana, Naadishodhana, Bhastrika, Kapalabhati, Sheethali, Sheetkari, Sadantha, Bhramari.", ""));
        abhyasasList.add(new AbhyasasObject("Mudras", "Drona Mudra, Chin Mudra, Chinmaya Mudra, Adi Mudra, Akasha Mudra, Bramha Mudra, Bhairava Mudra, Mrugi Mudra, Shanmuga Mudra, Karna Mudra, Khechari Mudra, Bhoochari Mudra.", ""));
        abhyasasList.add(new AbhyasasObject("Saptha Chakra", "Mooladhara Chakra, Swasdisthana Chakra, Manipoora Chakra, Anahata Chakra, Vishuddhi Chakra, Jnana Chakra, Sahasrara Chakra.", ""));
        abhyasasList.add(new AbhyasasObject("Mantras", "Shanti Mantra, Gurusthuti Mantra, Surya Namaskrara Mantra, Surya Namaskara Phalashruti Mantra, Bhoo Namana Mantra, Yoga Mantra, Jyotir Mantra, Pranayama Mantra, Aikya Mantra, Ekatmata Stotra.", ""));
        return abhyasasList;
    }
}

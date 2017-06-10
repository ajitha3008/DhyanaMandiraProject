package com.braingalore.dhyanamandira.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ExpandableListView;

import com.braingalore.dhyanamandira.R;
import com.braingalore.dhyanamandira.adapter.ExpandableListAdapter;
import com.braingalore.dhyanamandira.utils.AnimUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by s92 on 5/4/2017.
 */

public class MantrasFragment extends Fragment {

    ExpandableListAdapter listAdapter;

    ExpandableListView expListView;

    List<String> listDataHeader;

    HashMap<String, List<String>> listDataChild;

    public View onCreateView(LayoutInflater inflater, ViewGroup vg,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_mantras, vg, false);
        expListView = (ExpandableListView) view.findViewById(R.id.expandableListView);
        // preparing list data
        prepareListData();
        listAdapter = new ExpandableListAdapter(getActivity(), listDataHeader, listDataChild);
        // setting list adapter
        expListView.setAdapter(listAdapter);
        expListView.setGroupIndicator(null);
        return view;
    }

    /*
     * Preparing the list data
	 */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Shanti Mantra(Beginning)");
        listDataHeader.add("Gurusthuti Mantra");
        listDataHeader.add("Suryanamaskara Mantra");
        listDataHeader.add("Surya Namaskara Phalashruti Mantra");
        listDataHeader.add("Bhoo Namana Mantra");
        listDataHeader.add("Pranayama mantra");
        listDataHeader.add("Shanti mantra(Ending)");

        // Adding child data
        List<String> shantiMantra = new ArrayList<String>();
        shantiMantra.add("Mantra:\n" + "Sahanaa Vavatu; Sahanau Bhunakthu; Sahaveeryam Karavavahaihi;\n" +
                "Tejasvinava Dheetamastu;\nMaa Vidvishavahaihi;\n" +
                "Aum Shanti Shanti Shanti Hi..!!\n" +
                "\n" +
                "Meaning:\n" +
                "Om, May we all be protected\n" +
                "May we all be nourished\n" +
                "May we work together with great energy\n" +
                "May our intellect be sharpened\n(may our study be effective)\n" +
                "Let there be no Animosity amongst us\n" +
                "Om, peace (in me), peace (in nature), peace (in divine forces)");


        List<String> guruSthuthi = new ArrayList<String>();
        guruSthuthi.add("Mantra:\n" + "Gururbramha-Gururvishnuhu;\nGururdevo Maheshwarah;\n" +
                "Gurusakshaat Parabramha;\nTasmaishri Gurave Namaha…!!\n\n" + "Meaning:\n" +
                "The Guru is Brahma,\nthe Guru is Vishnu,\nthe Guru Deva is Maheswara (Shiva),\n" +
                "The Guru is Verily the Para-Brahman\n(Supreme Brahman);\nSalutations to that Guru.");

        List<String> suryaNamaskaraMantra = new ArrayList<String>();
        suryaNamaskaraMantra.add("Mantra:\n" + "Om. Hiranmayena Paatrena,\n" +
                "Satyasyapi Hitham Mukham;\n" +
                "Tatvam Pooshanna Pavrnu;\n" +
                "Satya Dharmaya Drusthaye;\n\n" + "Meaning:\n" +
                "“The Truth is concealed by the\n" +
                "golden vessel.\n" +
                "O Sun! Open the entrance to\n" +
                "that cover, so that the Truth\n" +
                "that is concealed by you is\n" +
                "visible to me, a truthful devotee,\n" +
                "by your illuminating Grace.");

        suryaNamaskaraMantra.add("Mantra:\n" +
                "Om dhyeya sada savitra\nmandala madhyavarti |\n" +
                "Narayana sarasija\nsanasanni vishtah |\n" +
                "Keyuravana makarakundala\nvana kiriti |\n" +
                "Hari hiranmaya vapura\ndhritashankha chakrah ||\n" +
                "\n" +
                "Meaning:\n" +
                "One should meditate on the\n" +
                "form of Lord Narayana\n" +
                "situated in the sun globe.\n" +
                "He is seated on a lotus, with\n" +
                "golden bracelets, crown,\n" +
                "shark earrings; he is\n" +
                "golden in complexion,\n" +
                "and holds the shankha and\n" +
                "chakra in his hands.");

        suryaNamaskaraMantra.add("Mantra & Meaning:\n\n" + "Om Hraam Mitraya Namaha;\n" +
                "\tOne who is friendly to all.\n\n" +
                "Om Hreem Ravaye Namaha;\n" +
                "\tThe shining one, the radiant one.\n\n" +
                "Om Hroom Suryaya Namaha;\n" +
                "\tThe dispeller of darkness,\n" +
                "\tresponsible for generating activity.\n\n" +
                "Om Hraim Bhanave Namaha;\n" +
                "\tOne who illuminates or the bright one.\n\n" +
                "Om Hraum Khagaya Namaha;\n" +
                "\tOne who is all pervading, one who moves\n\tthrough the sky.\n\n" +
                "Om Hraha Pooshne Namaha;\n" +
                "\tGiver of nourishment and fulfillment.\n\n" +
                "Om Hraam Hiranya Garbhaaya Namaha;\n" +
                "\tOne who has a golden colored brilliance.\n\n" +
                "Om Hreem Mareechaye Namaha;\n" +
                "\tGiver of light with infinite rays.\n\n" +
                "Om Hroom Aadityaya Namaha;\n" +
                "\tThe son of Aditi, the cosmic divine mother.\n\n" +
                "Om Hraim Savitre Namaha;\n" +
                "\tOne who is responsible for life.\n\n" +
                "Om Hraum Arkaaya Namaha;\n" +
                "\tOne who is worthy of praise and glory.\n\n" +
                "Om Hraha Bhaskaraaya Namaha;\n" +
                "\tGiver of wisdom and cosmic illumination!!!");

        List<String> phalaShruthiMantra = new ArrayList<String>();
        phalaShruthiMantra.add("Mantra:\n" +
                "Aadityasya Namaskaraan,\n" +
                "Ye Kurvanti Dine Dine,\n" +
                "Aayuh Pragnabalam Veeryam,\n" +
                "Tejastheshancha Jaayate…!!\n" +
                "Om Namo Bhagavate Suryanarayanaya;\n" +
                "Om Namo Bhagavate Suryanarayanaya;\n" +
                "Om Namo Bhagavate Suryanarayanaya Namaha…!!\n" +
                "\n" +
                "Meaning:\n" +
                "It is said that the person who\n" +
                "does Surya Namaskar daily is\n" +
                "untouched by poverty for his\n" +
                "thousand lifetimes.");

        List<String> bhuNamanaMantra = new ArrayList<String>();
        bhuNamanaMantra.add("Mantra:\n" +
                "Samudra Vasane Devi,\n" +
                "Parvatasthana Mandele,\n" +
                "Vishnu Patni Namsthubhyam,\n" +
                "Paadasparsham Kshamasvame..!!\n" +
                "\n" +
                "Meaning:\n" +
                "(Oh Mother Earth) The Devi Who\n" +
                "is having Ocean as Her Garments\n" +
                "and Mountains as Her Bosom,\n" +
                "Who is the Consort of Sri Vishnu,\n" +
                "I Bow to You; Please Forgive me\n" +
                "for Touching You with my Feet.");

        List<String> pranayamaMantra = new ArrayList<String>();
        pranayamaMantra.add("Mantra:\n" +
                "Praanasyedam Vashessarvam;\n" +
                "Tridiveyat Pratisthitam; Maateva Putran\n" +
                "Rakshaswa;\n" +
                "Shreescha Prajnanscha Videhi Na Itihi..!\n" +
                "Om Shanti Shanti Shanti Hi…!!\n" +
                "\n" +
                "Meaning:\n" +
                "Whatever is there\n" +
                "on all the three places\n" +
                "(earth, space & heaven),\n" +
                "is all controlled by Prana,\n" +
                "the Life Force. O Prana, protect us, as the mother\n" +
                "protects the child. Please give us the wealth\n" +
                "& the intellect.");
        pranayamaMantra.add("Mantra:\n" +
                "Yogena Chithasya Padenavacha\n" +
                "Malam Shareerasya Cha Vaidyakenam\n" +
                "Yopakarotham Pravarammuneena\n" +
                "Pathanjalim Pranjalirana Thosmin\n" +
                "Abahu Purushakaram\n" +
                "Shanku Chakra Sidharinum\n" +
                "Sahasra Shirasum Shwetham\n" +
                "Pranamami Pathanjali\n" +
                "\n" +
                "Meaning:\n" +
                "I bow with folded hands to Patanjali,\n" +
                "the greatest of sages, who removed\n" +
                "the impurity of mind by his work on Yoga,\n" +
                "the impurity of speech by his work on\n" +
                "grammar and the impurity of body\n" +
                "by his work on medicine.");

        List<String> shantiMantraEnding = new ArrayList<String>();
        shantiMantraEnding.add("Mantra:\n" +
                "Asato ma sadgamaya\n" +
                "tamasoma jyotir gamaya\n" +
                "mrityormāamritam gamaya\n" +
                "Aum shanti shanti shantihi\n" +
                "\n" +
                "Meaning:\n" +
                "From ignorance, lead me to truth;\n" +
                "From darkness, lead me to light;\n" +
                "From death, lead me to immortality\n" +
                "Om peace, peace, peace");

        listDataChild.put(listDataHeader.get(0), shantiMantra); // Header, Child data
        listDataChild.put(listDataHeader.get(1), guruSthuthi);
        listDataChild.put(listDataHeader.get(2), suryaNamaskaraMantra);
        listDataChild.put(listDataHeader.get(3), phalaShruthiMantra);
        listDataChild.put(listDataHeader.get(4), bhuNamanaMantra);
        listDataChild.put(listDataHeader.get(5), pranayamaMantra);
        listDataChild.put(listDataHeader.get(6), shantiMantraEnding);
    }
}

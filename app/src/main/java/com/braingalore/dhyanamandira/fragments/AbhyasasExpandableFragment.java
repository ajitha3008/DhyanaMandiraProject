package com.braingalore.dhyanamandira.fragments;

import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.braingalore.dhyanamandira.Constants;
import com.braingalore.dhyanamandira.R;
import com.braingalore.dhyanamandira.adapter.AbhyasasExpandableListAdapter;

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

    List<String> mantras = new ArrayList<String>();

    public View onCreateView(LayoutInflater inflater, ViewGroup vg,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_mantras, vg, false);
        expListView = (ExpandableListView) view.findViewById(R.id.expandableListView);
        // preparing list data
        prepareListData();
        listAdapter = new AbhyasasExpandableListAdapter(getActivity(), listDataHeader, listDataChild);
        // setting list adapter
        expListView.setAdapter(listAdapter);
        //expListView.setOnChildClickListener(childOnClickListener);
        return view;
    }

    private ExpandableListView.OnChildClickListener childOnClickListener = new ExpandableListView.OnChildClickListener() {

        @Override
        public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
            if (groupPosition == Constants.MANTRAS_POSITION) {
                String title = mantras.get(childPosition);
                String data = getMantra(childPosition);
                showAlert(title, data);
            }
            return false;
        }
    };

    private String getMantra(int childPosition) {
        //0.Shanti Mantra 1.Gurusthuti Mantra 2.Surya Namaskrara Mantra 3.Surya Namaskara Phalashruti Mantra
        //4.Bhoo Namana Mantra 5.Yoga Mantra 6.Jyotir Mantra 7.Pranayama Mantra 8.Aikya Mantra 9.Ekatmata Stotra
        switch (childPosition) {
            case 0:
                return "Mantra:\n" + "Sahanaa Vavatu; Sahanau Bhunakthu; Sahaveeryam Karavavahaihi;\n" +
                        "Tejasvinava Dheetamastu;\nMaa Vidvishavahaihi;\n" +
                        "Aum Shanti Shanti Shanti Hi..!!\n" +
                        "\n" +
                        "Meaning:\n" +
                        "Om, May we all be protected\n" +
                        "May we all be nourished\n" +
                        "May we work together with great energy\n" +
                        "May our intellect be sharpened\n(may our study be effective)\n" +
                        "Let there be no Animosity amongst us\n" +
                        "Om, peace (in me), peace (in nature), peace (in divine forces)";
            case 1:
                return "Mantra:\n" + "Gururbramha-Gururvishnuhu;\nGururdevo Maheshwarah;\n" +
                        "Gurusakshaat Parabramha;\nTasmaishri Gurave Namaha…!!\n\n" + "Meaning:\n" +
                        "The Guru is Brahma,\nthe Guru is Vishnu,\nthe Guru Deva is Maheswara (Shiva),\n" +
                        "The Guru is Verily the Para-Brahman\n(Supreme Brahman);\nSalutations to that Guru.";
            case 2:
                return "Mantra:\n" + "Om. Hiranmayena Paatrena,\n" +
                        "Satyasyapi Hitham Mukham;\n" +
                        "Tatvam Pooshanna Pavrnu;\n" +
                        "Satya Dharmaya Drusthaye;\n\n" + "Meaning:\n" +
                        "“The Truth is concealed by the\n" +
                        "golden vessel.\n" +
                        "O Sun! Open the entrance to\n" +
                        "that cover, so that the Truth\n" +
                        "that is concealed by you is\n" +
                        "visible to me, a truthful devotee,\n" +
                        "by your illuminating Grace." + "\n\nMantra:\n" +
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
                        "chakra in his hands." + "\n\nMantra & Meaning:\n\n" + "Om Hraam Mitraya Namaha;\n" +
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
                        "\tGiver of wisdom and cosmic illumination!!!";
            case 3:
                return "Mantra:\n" +
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
                        "thousand lifetimes.";
            case 4:
                return "Mantra:\n" +
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
                        "for Touching You with my Feet.";
            case 5:
                return "Mantra:\n" +
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
                        "by his work on medicine.";
            case 6:
                return "Mantra:\n" +
                        "Asato ma sadgamaya\n" +
                        "tamasoma jyotir gamaya\n" +
                        "mrityormāamritam gamaya\n" +
                        "Aum shanti shanti shantihi\n" +
                        "\n" +
                        "Meaning:\n" +
                        "From ignorance, lead me to truth;\n" +
                        "From darkness, lead me to light;\n" +
                        "From death, lead me to immortality\n" +
                        "Om peace, peace, peace";
            case 7:
                return "Mantra:\n" +
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
                        "& the intellect.";
            default:
                return "";

        }
    }

    private void showAlert(String title, String data) {
        if (!TextUtils.isEmpty(title) && !TextUtils.isEmpty(data)) {
            AlertDialog.Builder builder;
            builder = new AlertDialog.Builder(getActivity());
            builder.setTitle(title);
            builder.setMessage(data)
                    .setPositiveButton(R.string.dialog_close, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .setIcon(getResources().getDrawable(R.mipmap.ic_launcher))
                    .setCancelable(false)
                    .show();
        }
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
        sleeping_asanas.add("Chaturanga Dandasana");
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
        surya_namaskara_asanas.add("Utthanasana");
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

        listDataChild.put(listDataHeader.get(Constants.BREATHING_METHODS_POSITION), breathing_methods); // Header, Child data
        listDataChild.put(listDataHeader.get(Constants.BREATHING_EXERCISES_POSITION), breathing_exercises);
        listDataChild.put(listDataHeader.get(Constants.BODY_JOINT_EXERCISES_POSITION), body_joint_exercises);
        listDataChild.put(listDataHeader.get(Constants.ASANA_CATEGORIES_POSITION), categories_asanas);
        listDataChild.put(listDataHeader.get(Constants.SITTING_ASANA_POSITION), sitting_asanas);
        listDataChild.put(listDataHeader.get(Constants.STANDING_ASANA_POSITION), standing_asanas);
        listDataChild.put(listDataHeader.get(Constants.SLEEPING_ASANA_POSITION), sleeping_asanas);
        listDataChild.put(listDataHeader.get(Constants.SPECIAL_ASANA_POSITION), special_asanas);
        listDataChild.put(listDataHeader.get(Constants.RELAXATION_ASANA_POSITION), relaxation_asanas);
        listDataChild.put(listDataHeader.get(Constants.SURYA_NAMASKARA_POSITION), surya_namaskara_asanas);
        listDataChild.put(listDataHeader.get(Constants.PRANAYAMA_POSITION), pranayamas);
        listDataChild.put(listDataHeader.get(Constants.MUDRAS_POSITION), mudras);
        listDataChild.put(listDataHeader.get(Constants.CHAKRAS_POSITION), chakras);
        listDataChild.put(listDataHeader.get(Constants.MANTRAS_POSITION), mantras);
    }
}

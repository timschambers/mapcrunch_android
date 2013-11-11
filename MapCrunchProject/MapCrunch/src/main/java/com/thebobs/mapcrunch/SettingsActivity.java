package com.thebobs.mapcrunch;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.widget.Toast;

import java.util.List;

public class SettingsActivity extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.basic_settings);

        final Preference button = (Preference)findPreference("btnClearRankings");

        if (button != null) {
            button.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                @Override
                public boolean onPreferenceClick(Preference arg0) {
                    //Alex - I know all the code for showing the button and registering the
                    //click is working. This crashes when you click the button, so I something must
                    //is wrong with the database stuff.
                    ScoreDataSource datasource = new ScoreDataSource(SettingsActivity.this);
                    datasource.open();
                    datasource.DropTable();
                    return true;
                }
            });
        }


    }

    /*
    @Override
    public void onBuildHeaders(List<Header> target) {
        loadHeadersFromResource(R.xml.preference_headers, target);
    }

    public static class BasicSettingsFragment extends PreferenceFragment {
        //Context context = getActivity().getApplicationContext();
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            addPreferencesFromResource(R.xml.basic_settings);

            /*Preference button = (Preference)findPreference("button");
            button.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                @Override

                public boolean onPreferenceClick(Preference arg0) {
                    ScoreDataSource datasource = new ScoreDataSource(context);
                    datasource.open();
                    datasource.DropTable();
                    return true;
                }
            });
        }
    }*/
}
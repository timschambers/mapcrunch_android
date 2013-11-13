package com.thebobs.mapcrunch;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.widget.Toast;

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

                    new AlertDialog.Builder(SettingsActivity.this)
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .setTitle("Clear rankings")
                            .setMessage("Are you sure you want to clear the rankings?")
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ScoreDataSource datasource = new ScoreDataSource(SettingsActivity.this);
                                    datasource.open();
                                    datasource.DropTable();
                                    Toast.makeText(getApplicationContext(), "Rankings cleared",
                                            Toast.LENGTH_SHORT).show();
                                }

                            })
                            .setNegativeButton("No", null)
                            .show();

                    return true;
                }
            });
        }
    }
}
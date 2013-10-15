package com.thebobs.mapcrunch;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;

import java.util.List;

public class SettingsActivity extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * Populate the activity with the top-level headers.
     */
    @Override
    public void onBuildHeaders(List<Header> target) {
        loadHeadersFromResource(R.xml.preference_headers, target);
    }

    /**
     * This fragment shows the preferences for the first header (basic settings)
     */
    public static class BasicSettingsFragment extends PreferenceFragment {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            //TODO: May need to set default value at some point - this is how it's done
            //PreferenceManager.setDefaultValues(getActivity(),
            //        R.xml.advanced_preferences, false);

            addPreferencesFromResource(R.xml.basic_settings);
        }
    }

    /**
     * This fragment shows the preferences for the second header (advanced settings)
     */
    public static class AdvSettingsFragment extends PreferenceFragment {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            //TODO: May need to set default value at some point - this is how it's done
            //PreferenceManager.setDefaultValues(getActivity(),
            //        R.xml.advanced_settings, false);

            // Load the preferences from an XML resource
            addPreferencesFromResource(R.xml.advanced_settings);
        }
    }
}
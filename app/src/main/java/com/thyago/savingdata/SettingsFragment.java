package com.thyago.savingdata;

import android.os.Bundle;
import android.preference.PreferenceFragment;

/**
 * Created by thyago on 5/29/16.
 */
public class SettingsFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }

}

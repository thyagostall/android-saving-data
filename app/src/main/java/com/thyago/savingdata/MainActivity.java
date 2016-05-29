package com.thyago.savingdata;

import android.app.Application;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private static final String FRAG_SETTINGS = "frag_settings";

    @Override
    @SuppressWarnings("ConstantConditions")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnPreferences = (Button) findViewById(R.id.btn_preferences);
        btnPreferences.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                preferences();
            }
        });
        Button btnReadPref = (Button) findViewById(R.id.btn_read_pref);
        btnReadPref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readPref();
            }
        });
        Button btnSavePref = (Button) findViewById(R.id.btn_save_pref);
        btnSavePref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savePref();
            }
        });
    }

    public void preferences() {
        FragmentManager fm = getFragmentManager();

        if (fm.findFragmentByTag(FRAG_SETTINGS) == null) {
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_container, new SettingsFragment(), FRAG_SETTINGS);
            ft.addToBackStack(FRAG_SETTINGS);
            ft.commit();
        }
    }

    @Override
    public void onBackPressed() {
        FragmentManager fm = getFragmentManager();
        if (fm.getBackStackEntryCount() > 0) {
            fm.popBackStack();
        } else {
            super.onBackPressed();
        }
    }

    public void readPref() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        boolean value = prefs.getBoolean("switch_preference", false);
        Toast.makeText(this, "switch_preference: " + value, Toast.LENGTH_SHORT).show();
    }

    public void savePref() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("switch_preference", false);
        editor.apply();
    }
}

package com.globalappinitiative.natakallam;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceGroup;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.support.customtabs.CustomTabsIntent;

public class SettingsFragment extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {

    private static final String aboutUrl = "https://natakallam.com/about/";


    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        for (int i = 0; i < getPreferenceScreen().getPreferenceCount(); i++) {
            Preference preference = getPreferenceScreen().getPreference(i);
            if (preference instanceof PreferenceGroup) {
                PreferenceGroup preferenceGroup = (PreferenceGroup) preference;
                for (int j = 0; j < preferenceGroup.getPreferenceCount(); j++) {
                    Preference singlePreference = preferenceGroup.getPreference(j);
                    updatePreference(singlePreference, singlePreference.getKey());
                }
            } else {
                updatePreference(preference, preference.getKey());
            }
        }
    }

    @Override
    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {

        String key = preference.getKey();
        switch (key) {
            case PreferenceKeys.email:
                startActivity(new Intent(getContext(), ChangeEmailActivity.class));
                break;
            case PreferenceKeys.password:
                startActivity(new Intent(getContext(), ChangePasswordActivity.class));
                break;
            case PreferenceKeys.skype_id:
                break;
            case PreferenceKeys.phone_number:
                break;
            case PreferenceKeys.taboo_topics:
                startActivity(new Intent(getContext(), TabooTopicsActivity.class));
                break;
            case PreferenceKeys.about_us:
                launchChromeTab();
                break;
            case PreferenceKeys.log_out:
                logOut();
                break;
        }
        return super.onPreferenceTreeClick(preferenceScreen, preference);
    }

    private void launchChromeTab() {
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        CustomTabsIntent customTabsIntent = builder.build();
        customTabsIntent.launchUrl(getActivity(), Uri.parse(aboutUrl));
    }

    private void logOut() {
        showDialog(getString(R.string.log_out_title), getString(R.string.log_out_confirm));
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

    private void showDialog(String title, String message) {
        new AlertDialog.Builder(getContext())
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(getString(R.string.yes), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ((MainActivity) getActivity()).loggedOut();
                    }
                })
                .setNegativeButton(getString(R.string.cancel), null)
                .show();
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        updatePreference(findPreference(key), key);
    }

    private void updatePreference(Preference preference, String key) {
        if (preference == null) {
            return;
        }
        if (preference instanceof ListPreference) {
            ListPreference listPreference = (ListPreference) preference;
            listPreference.setSummary(listPreference.getEntry());
            return;
        }
        /*
        SharedPreferences sharedPreferences = getPreferenceManager().getSharedPreferences();
        preference.setSummary(sharedPreferences.getString(key, ""));
        */
    }
}

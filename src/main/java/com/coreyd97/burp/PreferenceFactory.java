package com.coreyd97.burp;

import burp.api.montoya.MontoyaApi;
import com.coreyd97.BurpExtenderUtilities.IGsonProvider;
import com.coreyd97.BurpExtenderUtilities.Preferences;

public class PreferenceFactory extends com.coreyd97.BurpExtenderUtilities.PreferenceFactory {

    public PreferenceFactory(MontoyaApi montoyaApi, IGsonProvider gsonProvider) {
        super(montoyaApi, gsonProvider);
    }

    @Override
    protected void createDefaults() {

    }

    @Override
    protected void registerTypeAdapters() {

    }

    @Override
    protected void registerSettings() {
        this.prefs.register("Example", Boolean.class, true, Preferences.Visibility.GLOBAL);
    }
}

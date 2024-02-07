package com.coreyd97.burp;

import burp.api.montoya.BurpExtension;
import burp.api.montoya.MontoyaApi;
import com.coreyd97.BurpExtenderUtilities.DefaultGsonProvider;
import com.coreyd97.BurpExtenderUtilities.Preferences;
import com.coreyd97.burp.logging.LoggingController;
import com.coreyd97.burp.ui.Panel;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class YourBurpExtension implements BurpExtension {

    private static YourBurpExtension instance;

    @Getter
    public MontoyaApi montoya;
    @Getter
    private LoggingController loggingController;

    @Getter
    private Panel panel;
    @Getter
    private Preferences prefs;

    public YourBurpExtension() {
        instance = this;
    }

    @Override
    public void initialize(MontoyaApi api) {
        this.montoya = api;
        this.prefs = new PreferenceFactory(api, new DefaultGsonProvider()).buildPreferences();
        this.loggingController = new LoggingController(prefs.getGsonProvider(), montoya);

        this.panel = new Panel(this);
        api.userInterface().registerSuiteTab("Extension", panel);

        api.extension().registerUnloadingHandler(() -> {
            //Cleanup

        });
    }

    public static YourBurpExtension getInstance() {
        return instance;
    }
}

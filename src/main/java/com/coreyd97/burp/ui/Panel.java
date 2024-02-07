package com.coreyd97.burp.ui;

import com.coreyd97.burp.YourBurpExtension;
import lombok.extern.log4j.Log4j2;

import javax.swing.*;
import java.awt.*;

@Log4j2
public class Panel extends JPanel {

    private final YourBurpExtension plugin;

    public Panel(YourBurpExtension plugin) {
        super(new BorderLayout());
        this.plugin = plugin;
        //TODO Create UI here!
    }
}

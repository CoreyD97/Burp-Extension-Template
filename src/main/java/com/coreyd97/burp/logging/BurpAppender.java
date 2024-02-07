package com.coreyd97.burp.logging;

import burp.api.montoya.MontoyaApi;
import com.coreyd97.burp.YourBurpExtension;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.Core;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.layout.PatternLayout;

@Plugin(name="BurpAppender", category = Core.CATEGORY_NAME, elementType = Appender.ELEMENT_TYPE)
public class BurpAppender extends AbstractAppender {

    public BurpAppender(String name, Filter filter){
        super(name, filter, PatternLayout.createDefaultLayout(), false, null);
    }

    @PluginFactory
    public static BurpAppender createAppender(@PluginAttribute("name") String name, @PluginElement("Filter") Filter filter) {
        return new BurpAppender(name, filter);
    }

    @Override
    public void append(LogEvent event) {
        String message = new String(this.getLayout().toByteArray(event));
        MontoyaApi montoya = YourBurpExtension.getInstance().getMontoya();
        if(montoya == null) return;


        if (event.getLevel().isInRange(Level.WARN, Level.FATAL)) {
            montoya.logging().logToError(message);
        } else {
            montoya.logging().logToOutput(message);
        }
    }
}

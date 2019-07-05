package com.bigfishgames.gaeskeleton.di;

import com.bitheads.braincloud.s2s.Brainclouds2s;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class GaeSkeletonConfig {
    static protected String m_serverUrl = "https://sharedprod.braincloudservers.com/s2sdispatcher";
    static protected String m_appId = "12601";
    static protected String m_serverSecret = "e948eb16-8023-437e-be2e-432d2c3b6adb";
    static protected String m_serverName = "GAESkeleton";

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public Brainclouds2s brainclouds2s() {
        Brainclouds2s brainclouds2s = new Brainclouds2s();
        brainclouds2s.init(m_appId, m_serverName, m_serverSecret);
        brainclouds2s.setLogEnabled(true);
        return brainclouds2s;
    }
}

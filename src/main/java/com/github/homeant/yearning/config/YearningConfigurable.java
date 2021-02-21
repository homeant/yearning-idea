package com.github.homeant.yearning.config;

import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.NlsContexts;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

@Slf4j
public class YearningConfigurable implements Configurable, Configurable.NoMargin, Configurable.NoScroll{

    private YearningConfigurablePanel panel;

    private final Project project;


    public YearningConfigurable(Project project){
        this.project = project;
    }

    @Override
    public @NlsContexts.ConfigurableName String getDisplayName() {
        return "Yearning";
    }

    @Override
    public @Nullable JComponent createComponent() {
        if(panel==null){
            panel = new YearningConfigurablePanel(project);
        }
        return panel.getRootPanel();
    }

    @Override
    public boolean isModified() {
        return panel!=null && panel.isModified(project);
    }

    @Override
    public void apply() throws ConfigurationException {
        if (panel != null) {
            panel.save(project);
        }
    }

    @Override
    public void reset() {
        if (panel != null) {
            panel.reset(project);
        }
    }
}

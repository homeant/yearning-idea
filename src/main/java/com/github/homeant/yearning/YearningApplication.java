package com.github.homeant.yearning;

import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.project.Project;

import java.io.*;

public class YearningApplication{

    private final Project project;

    public static YearningApplication getInstance() {
        return ServiceManager.getService(YearningApplication.class);
    }

    public YearningApplication(Project project){
        this.project = project;
    }

}

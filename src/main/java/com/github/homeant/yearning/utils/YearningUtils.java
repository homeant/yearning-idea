package com.github.homeant.yearning.utils;

import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

public class YearningUtils {
    private static final Logger LOG = Logger.getInstance(YearningUtils.class);

    public static <T> T getService(Class<T> clazz) {
        T t = ServiceManager.getService(clazz);
        if (t == null) {
            LOG.error("Could not find service: " + clazz.getName());
            throw new IllegalArgumentException("Class not found: " + clazz.getName());
        }

        return t;
    }

    public static <T> T getService(@NotNull Project project, Class<T> clazz) {
        T t = ServiceManager.getService(project, clazz);
        if (t == null) {
            LOG.error("Could not find service: " + clazz.getName());
            throw new IllegalArgumentException("Class not found: " + clazz.getName());
        }
        return t;
    }
}

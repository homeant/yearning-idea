package com.github.homeant.yearning;

import com.intellij.openapi.util.IconLoader;

import javax.swing.*;
import java.awt.*;

public class Icons {

    public static final Icon FILE_SQL = load("/image/file/SQLFile.png");

    public static final Icon RUN = load("/image/run1.png");

    private static Icon load(String path) {
        try {
            return IconLoader.findIcon(path);
        } catch (Exception t) {
            return  load("/image/common/Warning.png");
        }
    }
}

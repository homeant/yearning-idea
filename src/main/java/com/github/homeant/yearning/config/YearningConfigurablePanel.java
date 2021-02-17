package com.github.homeant.yearning.config;

import com.github.homeant.yearning.YearningApplication;
import com.github.homeant.yearning.api.domain.Login;
import com.github.homeant.yearning.domain.YearningSettings;
import com.intellij.openapi.Disposable;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.util.ui.UIUtil;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import javax.swing.*;
import java.util.Optional;

import static com.github.homeant.yearning.utils.YearningUtils.getService;

@Slf4j
public class YearningConfigurablePanel implements Disposable {
    private JPanel rootPanel;
    private JCheckBox ldapLoginCheckBox;
    private JPasswordField passwordField;
    private JTextField usernameField;
    private JTextField urlField;
    private JButton TestButton;

    private boolean isLdap;

    public YearningConfigurablePanel(Project project) {
        YearningSettingsStore instance = YearningSettingsStore.getInstance(project);
        YearningSettings settings = instance.getState();
        if (settings != null) {
            urlField.setText(settings.getUrl());
            passwordField.setText(instance.getPassword());
            usernameField.setText(settings.getUsername());
            ldapLoginCheckBox.setSelected(Optional.ofNullable(settings.getIsLdap()).orElse(false));
        }
        TestButton.addActionListener(e -> {
            OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
            Request request = new Request.Builder().url(urlField.getText()).build();
            Call call = okHttpClient.newCall(request);
            try (Response response = call.execute()) {
                if (response.isSuccessful()) {
                    Messages.showMessageDialog(project, "test for login success!", "Tips", UIUtil.getInformationIcon());
                } else {
                    Messages.showErrorDialog(project, "test for login error,error info:" + response.body().string(), "Tips");
                }
            } catch (Exception ex) {
                log.error("test login error", ex);
                Messages.showErrorDialog(project, "test for login error!", "Tips");
            }
        });
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }


    @Override
    public void dispose() {

    }

    public void save(Project project) {
        YearningSettingsStore instance = YearningSettingsStore.getInstance(project);
        YearningSettings settings = instance.getState();
        settings.setUrl(urlField.getText());
        settings.setUsername(usernameField.getText());
        settings.setIsLdap(ldapLoginCheckBox.isSelected());
        instance.setPassword(settings.getPassword());
    }

    public boolean isModified(Project project) {
        return true;
    }


    public void reset(Project project) {
        YearningSettingsStore instance = YearningSettingsStore.getInstance(project);
        YearningSettings settings = instance.getState();
        urlField.setText(settings.getUrl());
        passwordField.setText(instance.getPassword());
        usernameField.setText(settings.getUsername());
        ldapLoginCheckBox.setSelected(Optional.ofNullable(settings.getIsLdap()).orElse(false));
    }
}

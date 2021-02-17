package com.github.homeant.yearning.config;

import com.github.homeant.yearning.api.service.YearningService;
import com.github.homeant.yearning.domain.YearningSettings;
import com.github.homeant.yearning.utils.YearningUtils;
import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.NlsContexts;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.Nullable;
import retrofit2.Retrofit;

import javax.swing.*;

import static com.github.homeant.yearning.utils.YearningUtils.getService;

@Slf4j
public class YearningConfigurable implements Configurable, Configurable.NoMargin, Configurable.NoScroll{

    private YearningConfigurablePanel panel;

    private final Project project;

    private YearningService yearningService;

    public YearningConfigurable(Project project){
        this.project = project;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        YearningSettings settings = YearningUtils.getService(project, YearningSettingsStore.class).getState();
        if(StringUtils.isNotBlank(settings.getUrl())) {
            Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(settings.getUrl()).build();
            // 生成ApiService接口代理
            yearningService = retrofit.create(YearningService.class);
        }
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

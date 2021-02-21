package com.github.homeant.yearning.config;

import com.github.homeant.yearning.domain.YearningSettings;
import com.intellij.credentialStore.CredentialAttributes;
import com.intellij.credentialStore.CredentialAttributesKt;
import com.intellij.credentialStore.Credentials;
import com.intellij.ide.passwordSafe.PasswordSafe;
import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static com.github.homeant.yearning.utils.YearningUtils.getService;

@State(name = "YearningSettings", storages = {@Storage("yearning-drivers.xml")})
public class YearningSettingsStore implements PersistentStateComponent<YearningSettings> {

    private YearningSettings settings = new YearningSettings();

    private final Project project;

    public YearningSettingsStore(Project project) {
        this.project = project;
    }


    public static YearningSettingsStore getInstance(Project project) {
        return getService(project,YearningSettingsStore.class);
    }

    @Override
    public @Nullable YearningSettings getState() {
        return settings;
    }

    @Override
    public void loadState(@NotNull YearningSettings state) {
        this.settings = state;
    }

    public void setPassword(String password){
        CredentialAttributes credentialAttributes = createCredentialAttributes(project.getName()); // see previous sample
        Credentials credentials = new Credentials(null, password);
        PasswordSafe.getInstance().set(credentialAttributes, credentials);
    }

    public String getPassword(){
        CredentialAttributes credentialAttributes = createCredentialAttributes(project.getName()); // see previous sample
        return PasswordSafe.getInstance().getPassword(credentialAttributes);
    }



    private CredentialAttributes createCredentialAttributes(String key) {
        return new CredentialAttributes(CredentialAttributesKt.generateServiceName("Yearning", key));
    }
}

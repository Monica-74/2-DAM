package org.example;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="Dim_language")
public class Dim_Language {
    private  String LanguageCode;
    private String Language;
    private LocalDateTime created_dt;
    private LocalDateTime update_dt;
    private List<Dim_Language> languages = new ArrayList<>();

    public void setLanguages(List<Dim_Language> languages) {
        this.languages = languages;
    }
    public void setUpdate_dt(LocalDateTime update_dt) {
        this.update_dt = update_dt;
    }
    public void setCreated_dt(LocalDateTime created_dt) {
        this.created_dt = created_dt;
    }
    public void setLanguage(String language) {
        this.Language = language;
    }
    public void setLanguageCode(String languageCode) {
        this.LanguageCode = languageCode;
    }
    public String getLanguageCode() {
        return LanguageCode;
    }
    public String getLanguage() {
        return Language;
    }
    public LocalDateTime getCreated_dt() {
        return created_dt;
    }
    public LocalDateTime getUpdate_dt() {
        return update_dt;
    }
    public List<Dim_Language> getLanguages() {
        return languages;
    }
}

package by.javaguru.profiler.persistence.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Builder(setterPrefix = "with")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "cvs_languages")
public class CvLanguage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "language_id", nullable = false)
    private Language language;

    @Enumerated(EnumType.STRING)
    @Column(name = "proficiency", nullable = false)
    private LanguageProficiencyEnum proficiency;

    @Column(name = "certificate_url", nullable = true, length = 255)
    private String certificateUrl;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CvLanguage cvLanguage = (CvLanguage) o;
        return Objects.equals(id, cvLanguage.id) && Objects.equals(language, cvLanguage.language)
                && Objects.equals(proficiency, cvLanguage.proficiency)
                && Objects.equals(certificateUrl, cvLanguage.certificateUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, language, proficiency, certificateUrl);
    }

    @Override
    public String toString() {
        return "CvLanguage{" +
                "id=" + id +
                ", language=" + language +
                ", proficiency=" + proficiency +
                ", certificateUrl='" + certificateUrl + '\'' +
                '}';
    }
}

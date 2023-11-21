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
@Table(name = "languages")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "language_name", nullable = false, length = 20)
    private String name;

    @Column(name = "is_top", nullable = false)
    private Boolean isTop;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Language language = (Language) o;
        return Objects.equals(id, language.id) && Objects.equals(name, language.name)
                && Objects.equals(isTop, language.isTop);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, isTop);
    }

    @Override
    public String toString() {
        return "Language{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isTop=" + isTop +
                '}';
    }
}

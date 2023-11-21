package by.javaguru.profiler.persistence.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Builder(setterPrefix = "with")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "additional_information")
public class AdditionalInformation {

    @Id
    @Column(name = "cv_id", nullable = false)
    private Long id;

    @Column(name = "additional_information", nullable = false, length = 150)
    private String additionalInfo;

    @Column(name = "hobby", length = 100)
    private String hobby;

    @ElementCollection
    @CollectionTable(name = "awards", joinColumns = @JoinColumn(name = "additional_information_id"))
    private List<Award> awards = new ArrayList<>();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdditionalInformation that = (AdditionalInformation) o;
        return Objects.equals(id, that.id)
                && Objects.equals(additionalInfo, that.additionalInfo)
                && Objects.equals(hobby, that.hobby)
                && Objects.equals(awards, that.awards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, additionalInfo, hobby, awards);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "id = " + id + ", " +
                "additionalInformation = " + additionalInfo + ", " +
                "hobby = " + hobby + ", " +
                "awards = " + awards + "}";
    }
}

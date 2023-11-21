package by.javaguru.profiler.persistence.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    @Getter
    private Long id;

    @GeneratedValue(strategy = GenerationType.UUID)
    @Column
    private UUID uuid;

    @Column
    @Setter
    @Getter
    private String email;

    @Column
    @Setter
    @Getter
    private String password;

    @Getter
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    @Setter
    @Getter
    private UserProfile profile;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(id, user.id) && Objects.equals(uuid, user.uuid) && Objects.equals(email, user.email)
                && Objects.equals(password, user.password) && Objects.equals(roles, user.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, uuid, email, password, roles);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", uuid=" + uuid +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }
}

package by.javaguru.profiler.persistence.repository;

import by.javaguru.profiler.persistence.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SkillRepository extends JpaRepository<Skill, Long> {

    List<Skill> findSkillsByPositionsIdOrderByName(Long positionId);

    List<Skill> findAllByOrderByName();

    @Query("SELECT (count(s) = ?2) FROM Skill s WHERE s.id IN (?1)")
    Boolean existsAllByIds(List<Long> skillIds, Integer size);
}

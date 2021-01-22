package se.ifmo.ru.lab4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.ifmo.ru.lab4.entities.Point;

@Repository
public interface PointsRepository extends JpaRepository<Point,Long> {
}

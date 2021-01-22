package se.ifmo.ru.lab4.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "points")
public class Point {
    @Id
    @SequenceGenerator(sequenceName = "points_id_seq", name = "points_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "points_id_seq")
    private long id;

    private double x;
    private double y;
    private double r;
    private boolean c;

    public Point(double x, double y, double r, boolean check) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.c = check;
    }
}

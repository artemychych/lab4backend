package se.ifmo.ru.lab4.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.ifmo.ru.lab4.entities.Point;
import se.ifmo.ru.lab4.entities.PointDTO;
import se.ifmo.ru.lab4.repositories.PointsRepository;
import se.ifmo.ru.lab4.services.PointsService;

import java.security.Principal;
import java.util.Collection;

@RestController
@RequestMapping("/points")
public class PointsController {
    @Autowired
    private PointsRepository pointsRepository;

    @Autowired
    private PointsService pointsService;

    @GetMapping
    @CrossOrigin
    Collection<Point> getEntries() {
        return pointsRepository.findAll();
    }

    @PostMapping
    @CrossOrigin
    Point addEntry(@RequestBody PointDTO pointDTO) {
        boolean result = pointsService.check(pointDTO.getX(), pointDTO.getY(), pointDTO.getR());
        Point point = new Point(pointDTO.getX(), pointDTO.getY(), pointDTO.getR(), result);
        System.out.println(result);
        System.out.println(point);
        return pointsService.addPoint(point);
    }

    @DeleteMapping
    @CrossOrigin
    void deleteEntries() {
        pointsRepository.deleteAll();
    }
}

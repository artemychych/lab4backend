package se.ifmo.ru.lab4.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import se.ifmo.ru.lab4.entities.Point;
import se.ifmo.ru.lab4.repositories.PointsRepository;

@Service
public class PointsService {

    @Autowired
    private PointsRepository pointsRepository;

    public boolean check(double x, double y, double r){
        boolean result;
        if (r > 0) {
            if (x >= 0 && y >= 0 && x <= r && y <= r/2){
                result = true;
            }
            else if (x <= 0 && y <= r/2 && x >= (-r/2) && y >= 0 && Math.abs(x) <= (r/2 - y)){
                result = true;
            }
            else result = x <= 0 && y <= 0 && (x * x) + (y * y) <= (r * r);
        } else if (r < 0) {
            if (x >= 0 && y >= 0 && (x * x) + (y * y) <= (r * r)) {
                result = true;
            } else if (x <= 0 && y <= 0 && x >= r && y >= r/2) {
                result = true;
            } else result = x >= 0 && y >= r / 2 && x <= (-r / 2) && y <= 0 && Math.abs(x) <= (Math.abs(r / 2) - Math.abs(y));
        } else {
            result = false;
        }
        
        return result;
    }

    public Point addPoint(Point point) {
        return pointsRepository.save(point);
    }

    public void deletePoint(Point point) {
        pointsRepository.deleteById(point.getId());
    }


}

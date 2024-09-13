package edu.vphs.stf.minesweeper.repo;

import edu.vphs.stf.minesweeper.domain.Reading;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ReadingRepo {

    private final MongoTemplate mongoTemplate;

    public void save(Reading reading) {
        mongoTemplate.save(reading);
    }
}

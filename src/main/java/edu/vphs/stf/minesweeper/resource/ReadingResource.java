package edu.vphs.stf.minesweeper.resource;

import edu.vphs.stf.minesweeper.domain.Reading;
import edu.vphs.stf.minesweeper.repo.ReadingRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/readings")
public class ReadingResource {

    private final ReadingRepo readingRepo;

    @PostMapping
    public ResponseEntity<String> saveReading(@RequestBody Reading reading) {
        log.trace("Saving reading: {}", reading);

        readingRepo.save(reading);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("");
    }
}

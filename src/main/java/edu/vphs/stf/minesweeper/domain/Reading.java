package edu.vphs.stf.minesweeper.domain;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@Document(collation = "reading")
public class Reading {

    @Id
    private String id;

    @JsonAlias("x")
    @Field("x-coordinate")
    private Float xCoordinate;

    @JsonAlias("y")
    @Field("y-coordinate")
    private Float yCoordinate;

    @JsonAlias("f")
    @Field("frequency")
    private Float frequency;

    @JsonAlias("t")
    @Field("timestamp")
    private ZonedDateTime timestamp;
}

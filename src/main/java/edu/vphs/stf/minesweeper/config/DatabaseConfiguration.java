package edu.vphs.stf.minesweeper.config;

import com.mongodb.MongoClientSettings;
import edu.vphs.stf.minesweeper.config.converter.ZonedDateTimeCodec;
import lombok.RequiredArgsConstructor;
import org.bson.BsonType;
import org.bson.codecs.BsonTypeClassMap;
import org.bson.codecs.DocumentCodecProvider;
import org.bson.codecs.configuration.CodecRegistries;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Map;

@Configuration
@RequiredArgsConstructor
@EnableMongoRepositories("edu.vphs.stf.minesweeper.repo")
public class DatabaseConfiguration {

    @Bean
    public MongoClientSettings mongoClientSettings() {
        var bsonTypeClassMap =  new BsonTypeClassMap(
                Map.of(
                        BsonType.DATE_TIME, ZonedDateTime.class,
                        BsonType.STRING, LocalDate.class
                )
        );

        var codecRegistry = CodecRegistries.fromRegistries(
                MongoClientSettings.getDefaultCodecRegistry(),
                CodecRegistries.fromProviders(new DocumentCodecProvider(bsonTypeClassMap)),
                CodecRegistries.fromCodecs(new ZonedDateTimeCodec())
        );

        return MongoClientSettings.builder()
                .codecRegistry(codecRegistry)
                .build();
    }
}

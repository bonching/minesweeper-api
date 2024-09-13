package edu.vphs.stf.minesweeper.config.converter;

import org.bson.BsonReader;
import org.bson.BsonType;
import org.bson.BsonWriter;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZonedDateTimeCodec implements Codec<ZonedDateTime> {
    @Override
    public ZonedDateTime decode(BsonReader bsonReader, DecoderContext decoderContext) {
        return Instant.ofEpochMilli(validateAndReadDateTime(bsonReader)).atZone(ZoneId.systemDefault());
    }

    @Override
    public void encode(BsonWriter bsonWriter, ZonedDateTime zonedDateTime, EncoderContext encoderContext) {
        bsonWriter.writeDateTime(zonedDateTime.toInstant().toEpochMilli());
    }

    @Override
    public Class<ZonedDateTime> getEncoderClass() {
        return ZonedDateTime.class;
    }

    private long validateAndReadDateTime(BsonReader bsonReader) {
        BsonType currentType = bsonReader.getCurrentBsonType();
        if(currentType.equals(BsonType.DATE_TIME)) {
            throw new RuntimeException("Could not decode");
        } else {
            return bsonReader.readDateTime();
        }
    }
}

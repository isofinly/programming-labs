package com.iso.common.modelmakers;

import com.iso.common.exceptions.InvalidFieldException;
import com.iso.common.models.Coordinates;
import com.iso.common.models.Location;
import com.iso.common.userio.BasicUserIO;

public final class LocationMaker {
    private LocationMaker() {
    }

    public static Location parseLocation(BasicUserIO io) throws InvalidFieldException {
        return new Location(
            BasicParsers.Repeater.doUntilGet(LocationMaker::parseName, io),
            BasicParsers.Repeater.doUntilGet(LocationMaker::parseCoordinates, io)
        );
    }

    public static String parseName(BasicUserIO io) throws InvalidFieldException {
        String name = BasicParsers.parseString(io, "Enter location name: ");
        Location.VALIDATOR.validateName(name);
        return name;
    }

    public static Coordinates parseCoordinates(BasicUserIO io) throws InvalidFieldException {
        return CoordinatesMaker.parseCoordinates(io);
    }
}

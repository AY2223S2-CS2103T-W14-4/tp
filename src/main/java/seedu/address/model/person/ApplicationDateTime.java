package seedu.address.model.person;

import java.time.LocalDateTime;
import java.util.Optional;

import seedu.address.logic.parser.DateTimeParser;
import seedu.address.logic.parser.exceptions.ParseException;


/**
 * Represents a Person's interview date and time in the address book.
 */
public class ApplicationDateTime {
    private final LocalDateTime dateTime;

    public InterviewDateTime(String dateTime) throws ParseException {
        this.dateTime = DateTimeParser.parseDateTime(dateTime);
    }

    /**
     * method to create InterviewDateTime, used in converting from json
     * @param dateTime String form of dateTime or empty string
     * @return null if empty String, InterviewDateTime object otherwise
     * @throws ParseException if dateTime String cannot be parsed
     */
    public static Optional<InterviewDateTime> createInterviewDateTime(String dateTime) throws ParseException {
        if (dateTime.equals("")) {
            return Optional.empty();
        } else {
            return Optional.of(new InterviewDateTime(dateTime));
        }
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    /**
     * Returns if a given dateTime string is valid
     * Use before invoking createInterviewDateTime to ensure it does not throw ParseException
     */
    public static boolean isValidDateTime(String dateTime) {
        try {
            DateTimeParser.parseDateTime(dateTime);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return DateTimeParser.datetimeFormatter(dateTime);
    }
}


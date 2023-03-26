package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.function.Predicate;

import seedu.address.logic.commands.SkillCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.NoteContainsKeywordsPredicate;
import seedu.address.model.person.Person;


/**
 * Parses input arguments and creates a new SkillCommand object
 */
public class SkillCommandParser implements Parser<SkillCommand> {

    public SkillCommand parse(String args) throws ParseException {
        Predicate<Person> findPredicate = x -> true; //always true predicate as default

        String trimmedArgs = args.trim();
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, SkillCommand.MESSAGE_USAGE));
        }
        String[] keywords = trimmedArgs.split("\\s+");
        for (String keyword : keywords) {
            findPredicate = findPredicate.and(new NoteContainsKeywordsPredicate(keyword));
        }

        return new SkillCommand(findPredicate);
    }
}

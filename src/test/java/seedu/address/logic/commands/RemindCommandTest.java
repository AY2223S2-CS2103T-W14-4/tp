package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.logic.commands.CommandTestUtil.showPersonAtIndex;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;

/**
 * Contains integration tests (interaction with the Model) and unit tests for RemindCommand.
 */
public class RemindCommandTest {
    private Model model;
    private Model expectedModel;

    @BeforeEach
    public void setup() {
        model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
        expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
    }

    @Test
    public void execute_remind_noPersonFound() {
        RemindCommand remindCommand = new RemindCommand();
        assertCommandSuccess(remindCommand, model, remindCommand.getSuccessMessage(model), expectedModel);
    }

    @Test
    public void execute_remind_showsEverything() {
        showPersonAtIndex(model, INDEX_FIRST_PERSON);
        RemindCommand remindCommand = new RemindCommand();
        assertCommandSuccess(remindCommand, model, remindCommand.getSuccessMessage(model), expectedModel);
    }
}

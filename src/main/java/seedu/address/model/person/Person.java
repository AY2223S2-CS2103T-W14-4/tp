package seedu.address.model.person;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import seedu.address.model.note.Note;

/**
 * Represents a Person in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Person {

    // Identity fields
    private final Name name;
    private final Phone phone;
    private final Email email;

    // Data fields
    private final Address address;
    private final Status status;
    private final Set<Note> notes = new HashSet<>();
    private final Optional<InterviewDateTime> interviewDateTime;
    private final ApplicationDateTime applicationDateTime;

    /**
     * Every field must be present and not null.
     */
    public Person(Name name, Phone phone, Email email, Address address, Status status,
                  Optional<InterviewDateTime> interviewDateTime, Set<Note> notes) {
        requireAllNonNull(name, phone, email, address, notes);
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.status = status;
        this.applicationDateTime = new ApplicationDateTime(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES));
        this.interviewDateTime = interviewDateTime;
        this.notes.addAll(notes);
    }

    /**
     * Constructor for updating status of person
     */
    public Person(Person person, Status newStatus) {
        this(person.getName(), person.getPhone(), person.getEmail(), person.getAddress(),
                newStatus, person.getInterviewDateTime(), person.getNotes());
    }

    /**
     * Constructor for updating status and interview date time of person
     */
    public Person(Person person, Status newStatus, Optional<InterviewDateTime> interviewDateTime) {
        this(person.getName(), person.getPhone(), person.getEmail(), person.getAddress(),
                newStatus, interviewDateTime, person.getNotes());
    }

    public Name getName() {
        return name;
    }

    public Phone getPhone() {
        return phone;
    }

    public Email getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public Status getStatus() {
        return status;
    }

    /**
     * Returns an immutable note set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Note> getNotes() {
        return Collections.unmodifiableSet(notes);
    }

    /**
     * Returns the {@code ApplicationDateTime} of the applicant.
     * @return Application date and time of the applicant.
     */
    public ApplicationDateTime getApplicationDateTime() {
        return applicationDateTime;
    }

    /**
     * Returns the {@code Optional<InterviewDateTime>} for the applicant.
     * @return Interview date of the applicant.
     */
    public Optional<InterviewDateTime> getInterviewDateTime() {
        return interviewDateTime;
    }

    /**
     * Returns String representation of {@code Optional<InterviewDateTime>}
     * for conversion to {@code JsonAdaptedPerson}
     * @return InterviewDateTime as String
     */
    public String getInterviewDateTimeString() {
        return interviewDateTime.map(InterviewDateTime::toString).orElse("");
    }

    public String getApplicationDateTimeString() {
        return applicationDateTime.toString();
    }

    /**
     * Returns a String to be displayed in the UI
     * @return desired String to be displayed for InterviewDateTime
     */
    public String getInterviewDateTimeDisplay() {
        if (this.getStatus() == Status.SHORTLISTED) {
            return interviewDateTime.map(InterviewDateTime::toString).orElse("");
        } else {
            return "";
        }
    }

    /**
     * Advances status of applicants, according to application cycle
     */
    public Person advancePerson(Optional<InterviewDateTime> interviewDateTime) {
        switch (this.status) {
        case APPLIED:
            return new Person(this, Status.SHORTLISTED, interviewDateTime);
        case SHORTLISTED:
            return new Person(this, Status.ACCEPTED);
        default:
            throw new AssertionError("This person's application status cannot be advanced!");
        }
    }

    /**
     * Changes the status of the applicant to Rejected
     */
    public Person rejectPerson() {
        return new Person(this, Status.REJECTED);
    }

    /**
     * Returns true if both persons have the same name.
     * This defines a weaker notion of equality between two persons.
     */
    public boolean isSamePerson(Person otherPerson) {
        if (otherPerson == this) {
            return true;
        }

        return otherPerson != null
                && otherPerson.getName().equals(getName());
    }

    /**
     * Returns true if the other person has the same interview date.
     * This is needed as Optional's equals method fails when two different Optional objects
     * are created with same value.
     */
    public boolean hasSameInterviewDate(Person other) {
        Optional<InterviewDateTime> idt1 = getInterviewDateTime();
        Optional<InterviewDateTime> idt2 = other.getInterviewDateTime();
        if (idt1.isEmpty() && idt2.isEmpty()) { //both dates are null
            return true;
        } else if (idt1.isPresent() && idt2.isPresent()) { //both dates exist
            return idt1.get().getDateTime().equals(idt2.get().getDateTime());
        } else { //only one exists
            return false;
        }
    }

    /**
     * Returns true if the other person has the same application date.
     * The application date is only precise until the nearest minute.
     */
    public boolean hasSameApplicationDate(Person other) {
        ApplicationDateTime app1 = getApplicationDateTime();
        ApplicationDateTime app2 = other.getApplicationDateTime();
        return app1.equals(app2);
    }

    /**
     * Returns true if both persons have the same identity and data fields.
     * This defines a stronger notion of equality between two persons.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Person)) {
            return false;
        }

        Person otherPerson = (Person) other;

        return otherPerson.getName().equals(getName())
                && otherPerson.getPhone().equals(getPhone())
                && otherPerson.getEmail().equals(getEmail())
                && otherPerson.getAddress().equals(getAddress())
                && otherPerson.getNotes().equals(getNotes())
                && otherPerson.getStatus().equals(getStatus())
                && otherPerson.hasSameInterviewDate(this)
                && otherPerson.hasSameApplicationDate(this);
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, phone, email, address, notes, status, interviewDateTime, applicationDateTime);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getName())
                .append("; Phone: ")
                .append(getPhone())
                .append("; Email: ")
                .append(getEmail())
                .append("; Address: ")
                .append(getAddress())
                .append("; Status: ")
                .append(getStatus())
                .append("; Application Date:")
                .append(getApplicationDateTimeString())
                .append("; Interview DateTime")
                .append(getInterviewDateTimeString());
        if (interviewDateTime.isPresent()) {
            builder.append("; InterviewDateTime: ")
                    .append(interviewDateTime.get());
        }

        Set<Note> notes = getNotes();
        if (!notes.isEmpty()) {
            builder.append("; Tags: ");
            notes.forEach(builder::append);
        }
        return builder.toString();
    }
}

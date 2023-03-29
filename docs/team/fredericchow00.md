---
layout: page
title: <Frederic Chow> Project Portfolio Page
---

### Project: HMHero

### What should be included

- [x] Code contributed
- [x] Enhancements implemented
- [x] Contributions to the UG (Optional)
- [x] Contributions to the DG (Optional)
- [x] Contributions to team-based tasks
- [x] Review/mentoring contributions
- [x] Contributions beyond the project team

(**Overview**)

- HMHero helps Hiring Managers track the statuses of candidates' applications

<br>

(**Summary of Contributions**)

(**Code contributions**)

- **Code contributed**: 
[RepoSense link](https://nus-cs2103-ay2223s2.github.io/tp-dashboard/?search=fredericchow00&breakdown=true)

- **Project management**:

  - Liaised with teammates on deadlines during meetings to ensure that everyone is on task.

(**Enhancements implemented**)

- **Features implemented**

1. Implemented `list` feature that lists out all applicants across all statuses,
   with a statistic that shows the number of applicants in each status

Example Input: `list`

Example Output:
```
Here are the list of all applicants:
1. John Doe (Applied)
2. Jane Doe (Shortlisted)
3. Joe Doe (Accepted)

There are a total of 3 applicants.
Applied: 1
Shortlisted: 1
Accepted: 1
Rejected: 0
```

2. Implemented `ApplicationDateTime` class that is an additional field under Person,
   so as to track the date of application for usage in other commands.

- **Enhancements to existing features**:

1. Enhanced `AdvanceCommand` and `AdvanceCommandParser` to detect when there should or should not be
   a need for the user to provide an interview date for the applicant when the user calls the `Advance` feature


> Example Situation: John Doe's application status is `Applied`, so calling the `Advance` command would change
John Doe's status to `Shortlisted`, where an interview date is mandatory.

Example Input: `advance n/John Doe p/(John Doe's number)`

Output: `Please provide an interview date and time! (dd-MM-yyyy HH:mm)`

Example Input: `advance n/John Doe p/(John Doe's number) d/05-05-2023 18:00`

Output: `Successfully advanced John Doe`

> Follow-up Situation: Calling `Advance` on John Doe again change John Doe's status to `Accepted` and hence, the command
would *NOT* require an interview date.

Example Input: `advance n/John Doe p/(John Doe's number) d/05-05-2023 18:00`

Output: `Interview date and time is not required!`

Example Input: `advance n/John Doe p/(John Doe's number)`

Output: `Successfully advanced John Doe`

2. Enhanced `AdvanceCommand` to detect for duplicate interview date and time when
advancing an applicant from `APPLIED` to `SHORTLISTED`.

> Example Situation: There is an applicant, Jane Goh, whose status is
`SHORTLISTED` with the `InterviewDateTime` of `05-05-2023 18:00`.

Example Input: `advance n/John Doe p/(John Doe's number) d/05-05-2023 18:00`

Output: `There is a clash of interview date and time with Jane Goh!`

3. Changed GUI to make the application look nicer.

- **Test Cases**:

1. Wrote test cases for RejectCommand

    - Test cases that covers possible paths taken by `execute(Model model)` and
   `equals()` in `RejectCommand` class.

2. Wrote test cases for RejectCommandParser

    - Test cases that covers possible paths taken by `parse(String args)`
   in `RejectCommandParser` class.


- **Documentation**:

  - User Guide
    - Added documentation for the features `list`
    - Added documentation for About and How to Use the User Guide.

  - Developer Guide
    - Added documentation for Product Scope and User Stories
    - Added documentation for Annex such as User Stories and Manual Testing.

- **Community**:

  - Reviewed Pull Requests (PRs) made by team members
  - Ensure timely closure of milestones and issues
  - Set deadlines before the hard deadline so that the team does not fall behind.



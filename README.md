## Table of contents

1. Overview
2. How to use this guide
3. Getting started
4. Feature list
5. Command summary
6. Trouble shooting/FAQ
7. Additional information

---

## Overview

HMHero is a tool that helps Hiring Managers easily track the statuses of candidates' applications.

In a conventional application cycle, the large influx of applicants makes it challenging for Hiring Managers to track and monitor the progress of each applicant. This application includes features such as quick searching of applicants, algorithm to prioritize applicants according to their strengths and tabs on every applicant's application status.

---

## How to use this Guide

---

## Getting started

1. Ensure you have `Java 11` or above installed in your computer
2. Download the latest `HMHero` from [here]()
3. Copy the file to the folder you want to use as the home folder for HMHero.
4. Open a command terminal, `cd` into the folder you put the jar file in, and use the `java -jar hmhero.jar` command to run the application.
5. A GUI similar to the one below should appear in a few seconds. Note how the app contains some sample data.

---

## Features

| Note                                                                                                                                                                                                                               |
| ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Words in UPPER_CASE are the parameters to be supplied by the user.<br>e.g. in `add n/NAME`, `NAME` is a parameter which can be used as `add n/John Doe`.                                                                           |
| Items in square brackets are optional.<br>e.g. `n/NAME [t/TAG]` can be used as `n/John Doe t/friend` or as `n/John Doe`.                                                                                                           |
| Items with `…​` after them can be used multiple times including zero times.<br>e.g. `[t/TAG]…​` can be used as ` `, `t/friend`, `t/friend t/family` etc.                                                                           |
| Parameters can be in any order.<br>e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.                                                                                              |
| If a parameter is expected only once in the command but you specified it multiple times, only the last occurrence of the parameter will be taken.<br>e.g. if you specify `p/12341234 p/56785678`, only `p/56785678` will be taken. |
| Extraneous parameters for commands that do not take in parameters (such as `help`, `list`, `exit` and `clear`) will be ignored.<br>e.g. if the command specifies `help 123`, it will be interpreted as `help`.                     |

---

### **Command**

### 1. Viewing help: `help`

- Format: `help`

### 2. Adding a person: `add`

- Format: `add n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [note/NOTES]`

- Examples: `add n/Jack Dill p/91234567 e/jackdill@example.com a/John Street, block 123 #01-01`

### 3. List applicant: `list`

- Format: `list`

### 4. Delete applicants: `delete`

- Format: `delete n/NAME p/PHONE_NUMBER`

- Examples:
  - `delete n/Jack Dill p/PHONE_NUMBER`

### 5. Advancing an applicant's status: `advance`

- Applied -> Shortlisted
- Shortlisted -> Accepted

Shortlists a candidate

- Format: `advance n/NAME p/PHONE_NUMBER`

- Examples:
  - `advance n/Jack Dill p/91234567`

### 6. Rejecting an applicant: `reject`

- Shortlisted -> Rejected
- Applied -> Rejected

Rejects a candidate or interviewee

- Format: `reject n/NAME p/PHONE_NUMBER`

- Examples:

  - `reject n/Jack Dill p/91234567`

---

## Command Summary

| Action  | Format, Examples                                                                                                                                                        |
| ------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Add     | `add n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [note/NOTES]…`<br>Example: `add n/James Ho p/91234567 e/jamesho@example.com a/123, Clementi Rd, 1234665 note/Entrepreneur` |
| Delete  | `delete n/NAME p/PHONE_NUMBER`<br>Example: `delete n/James Ho p/91234567`                                                                                               |
| Edit    | `edit INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [a/ADDRESS] [t/TAG]…`<br>Example: `edit 2 n/James Lee e/jameslee@example.com`                                           |
| List    | `list`                                                                                                                                                                  |
| Help    | `help`                                                                                                                                                                  |
| Advance | `advance n/NAME p/PHONE_NUMBER`<br>Example: `advance n/James Ho p/91234567`                                                                                             |

---

## Trouble shooting / FAQ

---

## Additional information(Glossary, Product specs)

![Ui](docs/images/Ui.png)

* This is a product for **Hiring Managers**.<br>
  Example usages:
  * as an application to easily track the statuses of applicants' applications
* The project simulates an ongoing software project for a desktop application (called HMHero) used for managing details and status for applicants.
  * It is **written in OOP fashion**. It provides a **reasonably well-written** code based **bigger** on the original project AB3.
  * It comes with a **reasonable level of user and developer documentation**.
* It is named `HMHero v1.1` because it was initially created as a part of a series of `HMHero` projects (`v1.1`, `v1.2`, `v1.3` ...).
* For the detailed documentation of this project, see the **[HMHero Product Website](https://nus-cs2103-ay2223s2.github.io/tp/)**.
* This project is based on the AddressBook-Level3 project created by the [SE-EDU initiative](https://se-education.org#https://se-education.org/#contributing).
# Prompt: convert a meeting transcript to a meeting note

---

Read `inbox/<transcript file>`, a reviewed transcript of a meeting on <date> about <subject>.

Write a meeting note in AsciiDoc to
`src/docs/asciidoc/appendices/meeting-notes/<date>-<short-subject>.adoc`, following the existing
notes, and include it from `src/docs/asciidoc/appendices/meeting-notes.adoc`, newest first.

The note has:

- the date, the subject and the participants by role, not by name;
- a summary of five sentences or fewer;
- the facts stated, each with the speaker's role;
- the assumptions made, numbered as the next free IDs of the assumptions register;
- the decisions, only where the meeting actually decided something, with who decided; proposals
  and preferences are not decisions;
- the open questions, numbered as the next free IDs of the open questions register;
- the actions, with owner and due date when stated.

Do not add anything that is not in the transcript. Where the transcript is unclear, say so in the
note rather than guessing. Leave out small talk and anything personal.

Do not update the rest of the repository yet. Run `mvn clean package` and fix any errors.

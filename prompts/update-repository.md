# Prompt: update the repository with new information

---

Review the whole repository in the light of <the meeting note
`src/docs/asciidoc/appendices/meeting-notes/<file>` | the following information: ...>.

1. Add its new assumptions to the assumptions register and its new open questions to the open
   questions register, with owners and dates.
2. Close the open questions it answers, with the answer and the source. Mark the assumptions it
   validates or invalidates, with the source.
3. Record its decisions in the decision log and the ADRs, with the status actually reached and who
   reached it. Do not move any decision to DECIDED without a source that records the decision.
4. Update every section whose content it changes, including diagrams, the glossary and the
   roadmap. Regenerate affected sections from their inputs rather than patching single sentences
   when the change is broad.
5. List everything in the document that now contradicts something else, and everything that
   depends on an invalidated assumption.

Run `mvn clean package` and fix every error and warning. Then summarize the changes, file by file,
and propose a commit message whose body includes this prompt.

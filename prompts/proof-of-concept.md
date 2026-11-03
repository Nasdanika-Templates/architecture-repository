# Prompt template: a proof of concept as an architecture project

Replace everything in angle brackets. Use it in a repository made from this template, for a proof
of concept or a spike, or in a `poc/<id>/` directory of an architecture repository.

---

You are helping me run a proof of concept and document it, in this repository. The repository is an
architecture repository as code: AsciiDoc sources in `src/docs/asciidoc`, compiled by
`mvn clean package` into one HTML page and one PDF. Read `src/docs/asciidoc/index.adoc` and the
chapter on proofs of concept (`src/docs/asciidoc/method/pocs.adoc`) first.

## The question

- Question: <the one question this proof of concept answers>
- Good enough: <the answer, or the measurement, that would settle it; agreed before the work>
- Who asked, and what they will decide with the answer: <decision, ADR, evaluation or assumption it
  feeds, in which architecture repository>
- Alternatives to try: <products, models, libraries, approaches>
- Within: <the organization baseline: regions, services, models, versions the proof of concept must
  stay within>
- Time box: <how long>
- Sources: <files in inbox/>

## What to produce

1. The vision: the question, the success criteria, the scope and what is out of it.
2. The code, in `<poc/ or src/>`, with tests that run in the build. Tests that call paid or
   non-deterministic services run on demand and record their requests, responses, measurements,
   versions and the date; the build checks and reports the recorded run.
3. An evaluation in `src/evaluations/` whose scores come from the measurements, each with a reason
   that cites the run.
4. The document: what was tried, how, the results, and the interesting parts of the code, included
   from the sources by tagged regions (`tag::name[]` and `end::name[]` comments), never pasted.
5. A recommendation as a PROPOSED ADR, for the people who own the decision.
6. What was not tested, as assumptions and open questions; the versions it ran against.

## Rules

As in `prompts/initial-architecture.md`. In addition: never type a measurement into the document;
the run writes it. The proof of concept is done when its document builds.

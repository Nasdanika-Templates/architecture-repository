# Prompt template: initial architecture documentation

Replace everything in angle brackets. Delete the lines that do not apply.

---

You are helping me write the architecture documentation for a project, in this repository. The
repository is an architecture repository as code: AsciiDoc sources in `src/docs/asciidoc`, compiled
by `mvn clean package` into one HTML page and one PDF. Read `src/docs/asciidoc/index.adoc` and
Part I (`src/docs/asciidoc/method/`) first: they explain the structure and the conventions. Do not
change Part I.

## The project

- Organization: <organization, industry, regulatory context>
- Existing context: <the systems, users and constraints that already exist>
- What the project is about: <the new capability, the problem it solves, for whom>
- Business drivers and goals: <why now; how success is measured>
- Scope: <in scope> / Out of scope: <out of scope>
- Constraints: <platforms, vendors, policies, budget, deadlines>
- Stakeholders: <roles and their concerns>
- Sources: <files in inbox/ to read, such as meeting transcripts and documents>

## What to produce

Replace the sample in Part II (`src/docs/asciidoc/architecture/`) and the appendices with this
project's architecture, keeping the file structure:

1. Architecture vision (ADM Phase A): problem, goals, success measures, stakeholders, scope,
   constraints. For an AI project, answer explicitly whether AI is the right solution.
2. System context (C4 level 1), as a C4-PlantUML diagram with a short narrative.
3. Business architecture (Phase B): capabilities, actors, the main use cases and the requirements.
4. Data architecture (Phase C): the data the solution needs, its sources, owners, classification
   and flows.
5. Application architecture (Phase C): a C4 container diagram, a component diagram for the
   containers the project builds, and a sequence diagram of the main flow.
6. Technology architecture (Phase D): platforms, environments, networking, security, deployment,
   and the organization baseline: every cloud or vendor offering the architecture relies on, such
   as regions, SKUs, services, tiers, AI models and versions, and quotas, as the organization's
   approved subset, with its source and status.
7. Alternatives and evaluation (Phase E). Identify the alternatives for <the solution
   architecture, and each major technology choice, such as <models, platforms, products>>. Define
   the criteria and their weights, totaling 100, and explain each weight. Score each alternative
   from 1 to 5 against each criterion, with a one-line reason per score, compute the weighted
   scores and rank the alternatives. Show how sensitive the ranking is to the weights. Recommend,
   and state what evidence would change the recommendation. Write each evaluation as data in
   `src/evaluations/`, and propose the proofs of concept that would replace drafted scores with
   measurements.
8. <For AI systems> AI risk and governance: risk classification under <regulations and
   frameworks>, the threat model, the evaluation plan with acceptance thresholds, human oversight,
   monitoring.
9. Roadmap (Phases E and F): phases and work packages, suitable to become Jira epics.
10. Decisions: an ADR per significant decision, and the decision log.

## Rules

- Separate fact, assumption and decision. A fact cites its source. Every assumption goes to the
  assumptions register with an owner and a way to validate it; every unknown goes to the open
  questions. Do not present an assumption as a fact.
- You draft; people decide. Mark your recommendations as PROPOSED, or PENDING when they wait for
  something specific, and name what they wait for. Never mark a decision DECIDED unless a source
  records the decision, and cite the source.
- Do not invent numbers, names, dates or product details. When you need one, use a clearly marked
  placeholder and add an open question. Mark product and model names that must be checked against
  current vendor catalogs as assumptions.
- Do not assume the public catalog. Organizations use a subset of their cloud providers' and
  vendors' offerings: approved regions, SKUs, services, models and versions. Anything the
  architecture relies on that is not confirmed by a source in `inbox/` goes to the baseline as an
  assumption, with the owner who can confirm it.
- Do not paste code into the document. Include it from the source file by a tagged region, so that
  the build fails if the code changes and the snippet would not.
- Use explicit section IDs and cross-references; add new terms to the glossary.
- Run `mvn clean package` and fix every error and warning until the build succeeds.
- When you are done, summarize what you produced, the main assumptions, the open questions, and
  anything you were unsure about.

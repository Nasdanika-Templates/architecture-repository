# Architecture Repository

Architecture as code with AI assistance and AsciiDoc.

This is a template for a Git-based architecture repository. The sources are plain text: AsciiDoc
for the prose, PlantUML with C4-PlantUML for the diagrams, YAML for evaluations, Markdown for the
prompts. A Maven build compiles them into **one versioned document**, as a single-file HTML page and
a PDF, and a GitHub workflow publishes both to GitHub Pages.

- **HTML:** https://nasdanika-templates.github.io/architecture-repository/
- **PDF:** https://nasdanika-templates.github.io/architecture-repository/architecture-repository-2026.11.0.pdf
  (the name follows the version in `pom.xml`)

The document explains the approach and shows it at work:

- **Part I, Architecture with AI Assistance:** the principles (AI drafts, people decide; everything
  is text, under version control; regenerate, don't patch; separate fact, assumption and decision),
  working with an AI assistant and meeting transcripts, why a compiled document instead of a wiki,
  Markdown pages or Jira, decision records and statuses, evaluations as data with AHP and
  "reactive" decisions, proofs of concept and spikes that feed the evaluations, with code snippets
  included from sources that ran, organization baselines of the approved cloud offerings, external
  information pulled at build time, branding, the prompts, and the
  alignment with TOGAF ADM, C4 and PMP/CPMAI, with mappings to AI governance frameworks (AIGP, NIST
  AI RMF, EU AI Act) that a specialist has not reviewed.
- **Part II, Sample Architecture:** an AI chat assistant added to the Internet Banking System of the
  C4 model's example, on Azure OpenAI, organized by ADM phase, with C4 diagrams, ranked alternatives
  for the solution pattern, the embedding model and the chat model, an organization baseline, AI
  risk and governance, a roadmap with the proofs of concept that will replace drafted scores, and a
  decision log with eleven ADRs.
- **Appendices:** assumptions, open questions, meeting notes and a glossary.

## Building locally

You need Java 17 or later and Maven 3.9 or later. Nothing else: the diagrams are rendered by
PlantUML inside the build, without Graphviz.

```
mvn clean package
```

The results are in `target/`:

| Path | What it is |
|---|---|
| `target/site/index.html` | The document as one self-contained HTML page, as published |
| `target/site/architecture-repository-<version>.pdf` | The document as a PDF, as published |
| `target/document/` | The same two files under their build names, and the rendered diagrams |
| `target/generated-docs/evaluations/` | The AsciiDoc generated from `src/evaluations/` |

The build fails on a broken cross-reference, a missing include, an undefined attribute, an invalid
evaluation or inconsistent AHP comparisons. That is the point: the document is compiled like code.

Leave the editor's notes out, for example for a version sent for approval:

```
mvn clean package -Ddocument.editor-notes=false
```

## Making it yours

1. Create a repository from this template.
2. In `pom.xml`, change the `groupId`, `artifactId`, `name`, `url` (your GitHub Pages address) and
   `scm`, and start the version over.
3. In the repository's **Settings > Pages**, set **Source** to **GitHub Actions**. The workflow in
   `.github/workflows/maven.yml` builds every push and pull request and publishes every push to
   `main`.
4. Apply your brand: copy your logo to `branding/logo.png`, put or reference your brand guidelines
   in `branding/guidelines/`, and give `prompts/branding.md` to your AI assistant.
5. Replace the sample: put your meeting transcripts and documents in `inbox/`, fill in
   `prompts/initial-architecture.md`, and give it to your AI assistant. Review the changes in Git,
   build, and commit.

## Other languages

The document does not need Java, only this build does. AsciiDoc has Ruby, JVM and JavaScript
implementations, so sibling templates for Python or TypeScript can be created from this repository,
keeping the document, the prompts and the theme and replacing the build. The document's chapter on
proofs of concept explains how.

## Layout

| Path | What it holds |
|---|---|
| `src/docs/asciidoc/` | The document: `index.adoc` includes the front matter, `method/`, `architecture/` and `appendices/` |
| `src/evaluations/` | Evaluations as data: alternatives, criteria, weights (direct or AHP), scores |
| `prompts/` | The prompts, ready to paste into an AI assistant; the document includes them |
| `inbox/` | Raw inputs: reviewed meeting transcripts, notes, documents |
| `branding/` | Brand inputs: the logo and the guidelines |
| `theme/` | The look: the PDF theme, the HTML stylesheets, derived from the Nasdanika Zephyr Books |
| `tools/` | Build helpers, run with the JDK's source launcher: evaluations and the logo |
| `poc/` | Not in the template: proofs of concept that live in the repository, one directory each, when you need them |

## License

The template structural files and scripts are licensed under MIT.
The architecture documentation and content you generate or author using this template belong entirely to you and may be licensed or kept proprietary at your discretion.

Bootswatch, in `theme/zephyr/`, is licensed under MIT; see `theme/zephyr/BOOTSWATCH-LICENSE.txt`.

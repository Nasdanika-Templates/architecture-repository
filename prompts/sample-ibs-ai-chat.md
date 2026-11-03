# Sample prompt: Internet Banking System AI Chat

The prompt template in `initial-architecture.md`, filled in for the sample in Part II.

---

You are helping me write the architecture documentation for a project, in this repository. The
repository is an architecture repository as code: AsciiDoc sources in `src/docs/asciidoc`, compiled
by `mvn clean package` into one HTML page and one PDF. Read `src/docs/asciidoc/index.adoc` and
Part I (`src/docs/asciidoc/method/`) first: they explain the structure and the conventions. Do not
change Part I.

## The project

- Organization: Big Bank plc, a retail bank, regulated, with a model risk management function and an
  AI governance board. The bank is a Microsoft customer: Azure is its strategic cloud and Azure
  OpenAI is its approved source of large language models.
- Existing context: the Internet Banking System from the C4 model's example
  (https://c4model.com). Personal banking customers use it through a single-page web application and
  a mobile app to view their accounts and make payments. Its API application reads from and writes
  to the Mainframe Banking System, which is the system of record, and sends e-mail through the
  bank's Microsoft Exchange system.
- What the project is about: an AI chat assistant in the web and mobile apps. Signed-in customers
  ask questions in natural language about the bank's products, fees and procedures, and about their
  own accounts and recent transactions ("why was I charged this fee?"). The assistant answers from
  the bank's approved content and, read-only, from the customer's own account data. It hands over to
  a human agent when it cannot help, when the customer asks, or when the topic is sensitive.
- Business drivers and goals: reduce the volume of routine contact-center calls and messages;
  answer customers at any hour; keep or improve customer satisfaction.
- Scope: the chat in the web and mobile apps, English first; read-only access to the customer's
  accounts and transactions; handover to the contact center. Out of scope for the first release:
  payments or any other change from the chat, advice on investments or credit, voice.
- Constraints: models run on Azure OpenAI in the bank's own tenant; customer data stays in the
  bank's Azure regions; all traffic is private; the bank's AI governance and model risk processes
  apply; the existing Internet Banking System's API application is the only way to the mainframe.
- Stakeholders: Head of Digital Channels (sponsor), Contact Center operations, Enterprise
  Architecture, Information Security, Model Risk Management, AI Governance Board, Compliance and
  Legal, Data Protection Officer, the Internet Banking System's product and engineering teams.
- Sources: `inbox/2026-10-28-kickoff-transcript.txt`.

## What to produce

Everything listed in the prompt template, and in particular:

- Identify alternatives for the solution architecture (for example, a custom RAG orchestrator, a
  managed agent service, a low-code copilot platform, a third-party conversational banking product),
  for the embedding model and for the chat model. Define criteria and weights suitable for a
  regulated bank, rank each set of alternatives against its criteria, and show the sensitivity of
  the ranking to the weights.
- Treat model names and their availability in the bank's regions as assumptions to be checked
  against the current Azure catalog and the bank's approved model list. Record every Azure offering
  the architecture relies on, such as regions, deployment types, models, service tiers and quotas,
  in an organization baseline, to be confirmed by the cloud platform team.
- Propose the proofs of concept that would replace drafted scores with measurements, and say which
  evaluation, assumption or decision each one feeds.
- Cover AI risk and governance: EU AI Act classification, NIST AI RMF, OWASP Top 10 for LLM
  Applications, the bank's model risk management, transparency to customers, human oversight and
  monitoring.

## Rules

As in the prompt template.

# Theme

The look of the document, derived from the Nasdanika Zephyr Books (Nasdanika SDK Runtime 2026.10.0,
`doc/zephyr`).

| Path | What it is | Change it? |
|---|---|---|
| `pdf/architecture-theme.yml` | The Asciidoctor PDF theme; brand colors in its BRAND block | Brand block: yes |
| `pdf/title-band.svg` | The band across the title page | Its two colors: yes |
| `brand.css` | The HTML brand: the organization's name and the colors | Yes |
| `architecture.css` | Decision status badges and other document styles | Rarely |
| `zephyr/bootstrap.min.css` | Bootswatch Zephyr 5.3.3, vendored and pinned | No |
| `zephyr/BOOTSWATCH-LICENSE.txt` | The MIT license of Bootswatch | No |
| `zephyr/zephyr-bridge.css` | Styles Asciidoctor's HTML through Bootstrap's CSS variables | No |

The build concatenates `zephyr/bootstrap.min.css`, `zephyr/zephyr-bridge.css`, the logo (generated
from `branding/logo.png` by `tools/LogoCss.java`), `architecture.css` and `brand.css` into one
stylesheet, which Asciidoctor embeds, so the HTML is a single file that loads nothing.

To rebrand, see the chapter "Branding with AI Assistance" in the document and the prompt in
`prompts/branding.md`.

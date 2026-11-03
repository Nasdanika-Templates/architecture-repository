# Prompt: apply the brand

Replace everything in angle brackets. Copy your logo to `branding/logo.png` (or `branding/logo.svg`
and set `brand.logo` in `pom.xml`) and put the brand guidelines in `branding/guidelines/`, or give
their location below, before you run it.

---

Apply our brand to the look of this document. The look is in `theme/`; the brand inputs are in
`branding/`. Read `theme/pdf/architecture-theme.yml`, `theme/pdf/title-band.svg` and
`theme/brand.css` first; the comments marked BRANDING say what may change.

- Organization name, as it should appear at the top left of the web page: <name>
- Logo: `branding/logo.png`
- Brand guidelines: <`branding/guidelines/<file>` | <URL> | none>
- Brand colors, if not in the guidelines:
  - primary: <#RRGGBB>, used for the title band, headings, links and table headers
  - primary dark: <#RRGGBB>, the edge of the title band and links on hover
  - text: <#RRGGBB>; titles: <#RRGGBB>; muted text: <#RRGGBB>
  - light background for code and sidebars: <#RRGGBB>; rules and borders: <#RRGGBB>
- Other instructions from the guidelines: <for example, "the logo needs clear space of half its
  height", "never put the logo on a colored background other than the primary color">

Then:

1. Change only the BRAND block of `architecture-theme.yml`, the two colors of `title-band.svg`, and
   `brand.css`: the organization name and the `--bs-*` variables, including the RGB triplets and the
   subtle tints derived from the primary color.
2. Check that text keeps a contrast ratio of at least 4.5:1 against its background (WCAG AA),
   including white title text on the primary color and links on white. If a brand color fails,
   say so and propose the nearest compliant shade instead of using it.
3. Check that the logo reads well on the title band; if it does not, say what kind of logo variant
   (for example, a white or reversed version) the guidelines offer.
4. Run `mvn clean package`, and list the changes with the before and after colors.

Do not change anything outside `theme/` and `pom.xml`.

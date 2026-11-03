import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;

import javax.imageio.ImageIO;

/**
 * Writes the logo as a CSS variable, --zb-logo, for the brand at the top left of the HTML document.
 * The logo is embedded as a data URI, so the HTML is a single file that loads nothing.
 *
 * A raster logo larger than 96 pixels is scaled down to 96, twice its displayed size; an SVG logo is
 * embedded as is. The build runs it with the JDK's source launcher, so it needs no compilation:
 *
 *     java tools/LogoCss.java branding/logo.png target/theme/logo.css
 */
public class LogoCss {

	private static final int SIZE = 96;

	public static void main(String[] args) throws IOException {
		Path source = Path.of(args[0]);
		Path target = Path.of(args[1]);
		String name = source.getFileName().toString().toLowerCase();

		String mediaType;
		byte[] data;
		if (name.endsWith(".svg")) {
			mediaType = "image/svg+xml";
			data = Files.readAllBytes(source);
		} else {
			mediaType = "image/png";
			BufferedImage image = ImageIO.read(source.toFile());
			if (image == null) {
				throw new IOException("Not an image ImageIO can read: " + source);
			}
			data = png(scale(image));
		}

		String css = """
				/* The logo, generated from %s by tools/LogoCss.java */
				:root {
					--zb-logo: url("data:%s;base64,%s");
				}
				""".formatted(source.getFileName(), mediaType, Base64.getEncoder().encodeToString(data));
		Files.createDirectories(target.toAbsolutePath().getParent());
		Files.writeString(target, css, StandardCharsets.UTF_8);
	}

	private static BufferedImage scale(BufferedImage image) {
		int longest = Math.max(image.getWidth(), image.getHeight());
		if (longest <= SIZE) {
			return image;
		}
		int width = Math.max(1, image.getWidth() * SIZE / longest);
		int height = Math.max(1, image.getHeight() * SIZE / longest);
		BufferedImage scaled = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		var graphics = scaled.createGraphics();
		graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
		graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		graphics.drawImage(image.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0, null);
		graphics.dispose();
		return scaled;
	}

	private static byte[] png(BufferedImage image) throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ImageIO.write(image, "png", out);
		return out.toByteArray();
	}

}

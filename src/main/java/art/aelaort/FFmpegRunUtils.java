package art.aelaort;

import com.google.common.collect.ImmutableList;
import net.bramp.ffmpeg.probe.FFmpegProbeResult;
import org.bytedeco.ffmpeg.ffmpeg;
import org.bytedeco.javacpp.Loader;

import java.io.IOException;

import static art.aelaort.FFmpegFactory.argsBuilder;

public class FFmpegRunUtils {
	public static String quotes(String s) {
		return "\"" + s + "\"";
	}

	private static String ffmpegPath() {
		return Loader.load(ffmpeg.class);
	}

	public static FFmpegProbeResult probe(String mediaPath) {
		try {
			return FFmpegFactory.ffprobe().probe(mediaPath);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}

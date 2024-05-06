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

	public static Process run(ImmutableList.Builder<String> builder) {
		ImmutableList.Builder<String> command = argsBuilder()
				.add(ffmpegPath())
				.addAll(builder.build());
		return SystemProcess.callProcess(command.build());
	}

	public static Process run(String command) {
		return SystemProcess.callProcess(argsBuilder().add(ffmpegPath(), command).build());
	}

	private static String ffmpegPath() {
		return Loader.load(ffmpeg.class);
	}

	public static String[] args(String s) {
		return s.split(" ");
	}

	public static FFmpegProbeResult probe(String mediaPath) {
		try {
			return FFmpegFactory.ffprobe().probe(mediaPath);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}

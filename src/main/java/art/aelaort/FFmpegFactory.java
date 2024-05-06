package art.aelaort;

import com.google.common.collect.ImmutableList;
import net.bramp.ffmpeg.FFprobe;
import org.bytedeco.ffmpeg.ffmpeg;
import org.bytedeco.ffmpeg.ffprobe;
import org.bytedeco.javacpp.Loader;

import java.io.IOException;

public class FFmpegFactory {
	public static ImmutableList.Builder<String> argsBuilder() {
		return new ImmutableList.Builder<>();
	}

	public static FFprobe ffprobe() {
		try {
			return new FFprobe(Loader.load(ffprobe.class));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static String ffmpegPath() {
		return Loader.load(ffmpeg.class);
	}
}

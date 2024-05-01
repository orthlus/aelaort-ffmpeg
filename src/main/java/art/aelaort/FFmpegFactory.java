package art.aelaort;

import net.bramp.ffmpeg.FFmpeg;
import net.bramp.ffmpeg.FFmpegExecutor;
import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.builder.FFmpegBuilder;
import org.bytedeco.ffmpeg.ffmpeg;
import org.bytedeco.ffmpeg.ffprobe;
import org.bytedeco.javacpp.Loader;

import java.io.IOException;

public class FFmpegFactory {
	public static FFmpegExecutor ffmpegExecutor() {
		return new FFmpegExecutor(ffmpeg(), ffprobe());
	}

	public static FFmpegBuilder ffmpegBuilder() {
		return ffmpeg().builder();
	}

	public static FFmpeg ffmpeg() {
		try {
			return new FFmpeg(Loader.load(ffmpeg.class));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static FFprobe ffprobe() {
		try {
			return new FFprobe(Loader.load(ffprobe.class));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}

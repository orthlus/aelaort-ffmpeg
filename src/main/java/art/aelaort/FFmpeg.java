package art.aelaort;

import org.bytedeco.ffmpeg.ffmpeg;
import org.bytedeco.javacpp.Loader;

import java.io.IOException;

public class FFmpeg extends net.bramp.ffmpeg.FFmpeg {
	public FFmpeg() throws IOException {
		super(Loader.load(ffmpeg.class));
	}
}

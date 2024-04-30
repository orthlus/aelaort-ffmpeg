package art.aelaort;

import org.bytedeco.ffmpeg.ffprobe;
import org.bytedeco.javacpp.Loader;

import java.io.IOException;

public class FFprobe extends net.bramp.ffmpeg.FFprobe {
	public FFprobe() throws IOException {
		super(Loader.load(ffprobe.class));
	}
}

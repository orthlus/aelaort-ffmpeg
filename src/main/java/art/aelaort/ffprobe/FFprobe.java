package art.aelaort.ffprobe;

import art.aelaort.FFmpegPaths;
import art.aelaort.SystemResponse;
import art.aelaort.ffprobe.models.FFprobeResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

@Slf4j
public class FFprobe {
	private static final ObjectMapper mapper = new ObjectMapper();

	public static FFprobeResult probe(String mediaPath) {
		List<String> command = List.of(
				FFmpegPaths.FFPROBE_PATH,
				"-v", "quiet",
				"-output_format", "json",
				"-show_error",
				"-show_format",
				"-show_streams",
				"-show_chapters",
				mediaPath
		);
		return parse(call(command));
	}

	private static FFprobeResult parse(SystemResponse response) {
		if (!response.stderr().isEmpty()) {
			log.error("ffprobe parse error. stderr: {}", response.stderr());
			throw new FFprobeException(response);
		}

		try {
			return mapper.readValue(response.stdout(), FFprobeResult.class);
		} catch (JsonProcessingException e) {
			log.error("ffprobe json error. json: {}", response.stdout(), e);
			throw new FFprobeException(response, true);
		}
	}

	private static SystemResponse call(List<String> command) {
		try {
			Process p = new ProcessBuilder(command).start();

			StringBuilder stdout = new StringBuilder();
			try (BufferedReader b = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
				String line;
				while ((line = b.readLine()) != null) {
					stdout.append(line);
				}
			}

			StringBuilder stderr = new StringBuilder();
			try (BufferedReader b = new BufferedReader(new InputStreamReader(p.getErrorStream()))) {
				String line;
				while ((line = b.readLine()) != null) {
					stderr.append(line);
				}
			}

			p.waitFor();

			return new SystemResponse(stdout.toString(), stderr.toString());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}

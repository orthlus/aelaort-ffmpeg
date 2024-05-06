package art.aelaort.ffprobe.models;

import java.util.List;

/** TODO Make this immutable */
public class FFprobeResult {
  public Error error;
  public Format format;
  public List<Stream> streams;
  public List<Chapter> chapters;

  public Error getError() {
    return error;
  }

  public boolean hasError() {
    return error != null;
  }

  public Format getFormat() {
    return format;
  }

  public List<Stream> getStreams() {
    if (streams == null) return List.of();
    return streams;
  }

  public List<Chapter> getChapters() {
    if (chapters == null) return List.of();
    return chapters;
  }
}

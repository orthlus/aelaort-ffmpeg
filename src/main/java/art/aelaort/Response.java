package art.aelaort;

public class Response {
	private final Integer exitCode;
	private final String stdout;
	private final String stderr;

	Response(String stdout, String stderr) {
		this.exitCode = null;
		this.stdout = stdout;
		this.stderr = stderr;
	}

	Response(Integer exitCode, String stdout, String stderr) {
		this.exitCode = exitCode;
		this.stdout = stdout;
		this.stderr = stderr;
	}

	public Integer getExitCode() {
		return exitCode;
	}

	public String getStdout() {
		return stdout;
	}

	public String getStderr() {
		return stderr;
	}
}

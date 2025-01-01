package categorycounter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WorkerTest {

	@Test
	void testConstructor() {
		new Worker("src/main/resources/test.csv");
	}

}

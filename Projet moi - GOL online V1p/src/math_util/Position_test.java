package math_util;

import static org.junit.Assert.*;
import org.junit.Test;

public class Position_test {

	@Test
	public void testGetVoisinesI() {
		Position p1 = new Position(1, 1);

		String result = "[Position [positionX : 0, positionY : 0]" + ", Position [positionX : 0, positionY : 1]"
				+ ", Position [positionX : 0, positionY : 2]" + ", Position [positionX : 1, positionY : 0]"
				+ ", Position [positionX : 1, positionY : 2]" + ", Position [positionX : 2, positionY : 0]"
				+ ", Position [positionX : 2, positionY : 1]" + ", Position [positionX : 2, positionY : 2]" + "]";

		assertTrue(result.equals(p1.getVoisines().toString()));
	}

	@Test
	public void testGetVoisinesII() {
		Position p1 = new Position(2, 2);

		String result = "[Position [positionX : 1, positionY : 1]" + ", Position [positionX : 1, positionY : 2]"
				+ ", Position [positionX : 1, positionY : 3]" + ", Position [positionX : 2, positionY : 1]"
				+ ", Position [positionX : 2, positionY : 3]" + ", Position [positionX : 3, positionY : 1]"
				+ ", Position [positionX : 3, positionY : 2]" + ", Position [positionX : 3, positionY : 3]" + "]";

		assertTrue(result.equals(p1.getVoisines().toString()));
	}

	@Test
	public void testGetVoisinesIII() {
		Position p1 = new Position(4, -1);

		String result = "[Position [positionX : 3, positionY : -2]" + ", Position [positionX : 3, positionY : -1]"
				+ ", Position [positionX : 3, positionY : 0]" + ", Position [positionX : 4, positionY : -2]"
				+ ", Position [positionX : 4, positionY : 0]" + ", Position [positionX : 5, positionY : -2]"
				+ ", Position [positionX : 5, positionY : -1]" + ", Position [positionX : 5, positionY : 0]" + "]";

		assertTrue(result.equals(p1.getVoisines().toString()));
	}

}
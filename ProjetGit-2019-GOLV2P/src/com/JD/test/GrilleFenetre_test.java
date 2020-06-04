package com.JD.test;

import static org.junit.Assert.*;

import java.util.LinkedList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.JD.core.GrilleFenetre;
import com.JD.mathUtil.Position;

public class GrilleFenetre_test {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testApparaitDansFenetre() {
		GrilleFenetre g = new GrilleFenetre(100, 10);

		LinkedList<Position> positionsDedans = new LinkedList<Position>();
		positionsDedans.add(new Position(0, 0));
		positionsDedans.add(new Position(5, 2));
		positionsDedans.add(new Position(1, 3));
		positionsDedans.add(new Position(10, 10));

		LinkedList<Position> positionsPasDedans = new LinkedList<Position>();
		positionsPasDedans.add(new Position(800, 0));
		positionsPasDedans.add(new Position(100, 100));
		positionsPasDedans.add(new Position(Integer.MAX_VALUE, Integer.MAX_VALUE));
		positionsPasDedans.add(new Position(3, 200));

		for (Position p : positionsDedans)
			assertTrue(g.apparaitDansFenetre(p));

		for (Position p : positionsPasDedans)
			assertFalse(g.apparaitDansFenetre(p));
	}

	@Test
	public void testGetPositionGrille() {
		GrilleFenetre g = new GrilleFenetre(100, 10);

		LinkedList<Position> positionsBase = new LinkedList<Position>();
		positionsBase.add(new Position(800, 800));
		positionsBase.add(new Position(8, 8));
		positionsBase.add(new Position(0, 0));
		positionsBase.add(new Position(30, 12));

		LinkedList<Position> positionsAtendu = new LinkedList<Position>();
		positionsAtendu.add(new Position(80, 80));
		positionsAtendu.add(new Position(0, 0));
		positionsAtendu.add(new Position(0, 0));
		positionsAtendu.add(new Position(3, 1));

		LinkedList<Position> positionsObtenu = new LinkedList<Position>();
		for (Position p : positionsBase) {
			positionsObtenu.add(g.getPositionGrille(p));
		}

		for (int i = 0; i < positionsAtendu.size(); i++)
			assertTrue(positionsAtendu.get(i).equals(positionsObtenu.get(i)));

	}

}

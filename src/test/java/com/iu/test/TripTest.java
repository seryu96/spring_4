package com.iu.test;

import javax.inject.Inject;

// import static org.junit.Assert.*;

import org.junit.Test;

import com.iu.aop.Trip;
import com.iu.s4.AbstractTest;

public class TripTest extends AbstractTest {

	@Inject
	private Trip trip;
	
	@Test
	public void test() {
		trip.go();
	}

}

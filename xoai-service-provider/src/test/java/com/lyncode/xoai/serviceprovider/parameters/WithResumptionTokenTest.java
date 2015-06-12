package com.lyncode.xoai.serviceprovider.parameters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class WithResumptionTokenTest {

	private Parameters parameters;
	
	private String metadataPrefix;
	private Date until;
	private String set;
	private Date from;
	
	@Before
	public void setUp() {
		metadataPrefix = "metadataPrefix";
		until = new Date();
		set = "set";
		from = new Date();
		
		parameters = new Parameters();
		parameters.withMetadataPrefix(metadataPrefix);
		parameters.withUntil(until);
		parameters.withSet(set);
		parameters.withFrom(from);
		
		assertEquals(metadataPrefix, parameters.getMetadataPrefix());
		assertEquals(until, parameters.getUntil());
		assertEquals(set, parameters.getSet());
		assertEquals(from, parameters.getFrom());
	}
	
	@Test
	public void happyPath() {
		parameters.withResumptionToken("resumptionToken");
		
		assertEquals("resumptionToken", parameters.getResumptionToken());
		assertNull(parameters.getMetadataPrefix());
		assertNull(parameters.getUntil());
		assertNull(parameters.getSet());
		assertNull(parameters.getFrom());
	}
	
	@Test
	public void agrisMetadataPrefix() {
		metadataPrefix = "oai_dc_agris";
		parameters.withMetadataPrefix(metadataPrefix);
		
		parameters.withResumptionToken("resumptionToken");
		
		assertEquals("resumptionToken", parameters.getResumptionToken());
		assertEquals(metadataPrefix, parameters.getMetadataPrefix());
		assertNull(parameters.getUntil());
		assertNull(parameters.getSet());
		assertNull(parameters.getFrom());
	}
	
}

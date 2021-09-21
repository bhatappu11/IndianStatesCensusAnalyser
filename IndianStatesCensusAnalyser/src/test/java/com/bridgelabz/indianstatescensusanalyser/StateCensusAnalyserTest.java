package com.bridgelabz.indianstatescensusanalyser;

import org.junit.Test;
import org.junit.Assert;

public class StateCensusAnalyserTest {
	private static final String INDIA_CENSUS_CSV_FILE_PATH = "./src/test/resources/IndiaStateCensusData.csv";
	
	@Test
	public void givenStateCensusCsvFile_ShouldReturn_CorrectNumberOfRecords() {
		try {	
			StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
			int numOfRecords;
			numOfRecords = censusAnalyser.loadIndianCensusData(INDIA_CENSUS_CSV_FILE_PATH);
			Assert.assertEquals(29, numOfRecords);
		} catch (CensusAnalyserException e) {
			e.printStackTrace();
		}
		
	}
}

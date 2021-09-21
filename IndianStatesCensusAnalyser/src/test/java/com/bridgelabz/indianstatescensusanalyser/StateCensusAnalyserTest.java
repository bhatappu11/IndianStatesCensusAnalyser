package com.bridgelabz.indianstatescensusanalyser;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Assert;

public class StateCensusAnalyserTest {
	private static final String INDIA_CENSUS_CSV_FILE_PATH = "./src/test/resources/IndiaStateCensusData.csv";
	private static final String WRONG_CSV_FILE_PATH = "./main/resources/StateCensusData.csv";
	private static final String WRONG_FILE_TYPE = "./src/test/resources/IndiaStateCensusData.txt";
	private static final String CSV_WITH_WRONG_DELIMITER = "./src/test/resources/CensusDataWithWrongDelimiter.csv";
	private static final String CSV_WITH_INCORRECT_HEADER = "./src/test/resources/CensusDataIncorrectHeader.csv";
	
	private static final String INDIAN_STATE_CODES = "./src/test/resources/IndiaStateCode.csv";
	private static final String STATE_CODES_WITH_WRONG_FILEPATH = "./src/main/resources/IndianStateCodes.csv";
	private static final String STATE_CODES_WITH_WRONG_FILE_FORMAT = "./src/test/resources/IndianStateCodeWithWrongFormat.txt";
	
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
	@Test
	public void givenStateCensusCsvFile_IfIncorrect_ReturnsACustomException() {
		try {
			StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyser.loadIndianCensusData(WRONG_CSV_FILE_PATH);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
			System.out.println("Wrong path: "+e.getMessage());
		}
	}
	@Test
	public void givenStateCensusFile_WithWrongFileType_ShouldThrowCustomException() {
		try {
			StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyser.loadIndianCensusData(WRONG_FILE_TYPE);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_INCORRECT_FILE_FORMAT, e.type);
			System.out.println(e.getMessage());
		}
	}
	@Test
	public void givenStateCensusCsvFile_WhenCorrectButIncorrectDelimiter_ShouldThrowException() {
		try {
			StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyser.loadIndianCensusData(CSV_WITH_WRONG_DELIMITER);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_WRONG_DELIMITER_OR_HEADER, e.type);
			System.out.println(e.getMessage());
		}
	}
	@Test
    public void givenStateCensusCsvFile_WhenCorrectButHeaderIncorrect_ShouldThrowException() {
		try {
			StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyser.loadIndianCensusData(CSV_WITH_INCORRECT_HEADER );
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_WRONG_DELIMITER_OR_HEADER, e.type);
			System.out.println(e.getMessage());
		}
    }
	@Test
	public void givenIndianStateCodeCsvFile_ShouldReturn_NumberOfRecords() {
	        try {
	        	StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
				int numOfRecords = censusAnalyser.loadIndianStateCode(INDIAN_STATE_CODES);
	            Assert.assertEquals(5,numOfRecords);
	        } catch (CensusAnalyserException e) { 
	        	e.printStackTrace();
	        }
	}
	@Test
	public void givenIndianStateCodeCsvFile_WithIncorrectFilePath_ShouldThrowException() {
		try {
			StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyser.loadIndianStateCode(STATE_CODES_WITH_WRONG_FILEPATH);
		}catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
			System.out.println("wrong path: "+e.getMessage());
		}
	}
	
	 @Test
	 public void givenIndianStateCodeCSVFile_WithWrongFileFormat_ShouldThrowException() {
			try	{
				StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
				ExpectedException exceptionRule = ExpectedException.none();
				exceptionRule.expect(CensusAnalyserException.class);
				censusAnalyser.loadIndianStateCode(STATE_CODES_WITH_WRONG_FILE_FORMAT);
			}catch (CensusAnalyserException e) {
				Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_INCORRECT_FILE_FORMAT, e.type);
				System.out.println(e.getMessage());
			}
	    }


}

package com.leon.wholesail.utils;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * <p>Class <tt>CsvUtils</tt> used to help us
 * populate and read the CSV content, recommend
 * to use this util to parse CSV content dut to
 * the quote escape case has already handled by
 * it.
 *
 * @see CSVRecord
 * @see CSVParser
 * @since 1.0.0
 */
public class CSVUtil {

    /**
     * Get CSV records
     *
     * @return {@code CSVRecord} collection
     */
    public static List<CSVRecord> getCsvRecords(Reader in) throws IOException {
        CSVParser csvFileParser = new CSVParser(in, CSVFormat.RFC4180);
        return csvFileParser.getRecords();
    }
}

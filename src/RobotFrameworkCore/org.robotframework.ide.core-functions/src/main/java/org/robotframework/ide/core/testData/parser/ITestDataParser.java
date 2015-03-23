package org.robotframework.ide.core.testData.parser;

import org.robotframework.ide.core.testData.parser.result.ParseResult;


/**
 * Handle logic regarding mapping files from disk to objector representation.
 * 
 * @author wypych
 * @serial RobotFramework 2.8.6
 * @serial 1.0
 * 
 * @param <InputFormatType>
 * @param <OutputModelElementType>
 */
public interface ITestDataParser<InputFormatType, OutputModelElementType> {

    /**
     * The first, we should check if data could be handle by this parser. This
     * method shouldn't change anything in original data taken as parameter
     * <code>testData</code>
     * 
     * 
     * @param testData
     * @return
     */
    boolean canHandle(InputFormatType testData);


    /**
     * Converts <code>testData</code> to memory representation. It doesn't
     * throws any exception, the fail result should be included inside
     * {@link ParseResult} object return by this method.
     * 
     * @param testData
     * @return
     */
    ParseResult<InputFormatType, OutputModelElementType> parse(
            InputFormatType testData);
}

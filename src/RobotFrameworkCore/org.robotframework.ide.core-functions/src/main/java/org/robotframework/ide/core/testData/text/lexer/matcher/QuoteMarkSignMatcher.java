package org.robotframework.ide.core.testData.text.lexer.matcher;

import org.robotframework.ide.core.testData.text.lexer.RobotTokenType;


/**
 * Matcher responsible for handling {@code QUOTE_MARK ('"')}.
 * 
 * @author wypych
 * @since JDK 1.7 update 74
 * @version Robot Framework 2.9 alpha 2
 * 
 * @see RobotTokenMatcher
 * @see RobotTokenType#SINGLE_QUOTE_MARK
 */
public class QuoteMarkSignMatcher extends AOnlyMapCharToToken {

    public QuoteMarkSignMatcher() {
        super(RobotTokenType.SINGLE_QUOTE_MARK);
    }
}

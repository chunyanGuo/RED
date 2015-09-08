package org.robotframework.ide.core.testData.model.table.userKeywords.mapping;

import java.util.List;
import java.util.Stack;

import org.robotframework.ide.core.testData.model.FilePosition;
import org.robotframework.ide.core.testData.model.IRobotFileOutput;
import org.robotframework.ide.core.testData.model.table.mapping.ElementsUtility;
import org.robotframework.ide.core.testData.model.table.mapping.IParsingMapper;
import org.robotframework.ide.core.testData.model.table.userKeywords.KeywordTeardown;
import org.robotframework.ide.core.testData.model.table.userKeywords.UserKeyword;
import org.robotframework.ide.core.testData.text.read.IRobotTokenType;
import org.robotframework.ide.core.testData.text.read.ParsingState;
import org.robotframework.ide.core.testData.text.read.RobotLine;
import org.robotframework.ide.core.testData.text.read.recognizer.RobotToken;
import org.robotframework.ide.core.testData.text.read.recognizer.RobotTokenType;


public class KeywordTeardownArgumentMapper implements IParsingMapper {

    private final ElementsUtility utility;


    public KeywordTeardownArgumentMapper() {
        this.utility = new ElementsUtility();
    }


    @Override
    public RobotToken map(RobotLine currentLine,
            Stack<ParsingState> processingState,
            IRobotFileOutput robotFileOutput, RobotToken rt, FilePosition fp,
            String text) {
        List<IRobotTokenType> types = rt.getTypes();
        types.remove(RobotTokenType.UNKNOWN);
        types.add(0, RobotTokenType.KEYWORD_SETTING_TEARDOWN_KEYWORD_ARGUMENT);
        rt.setRaw(new StringBuilder(text));
        rt.setText(new StringBuilder(text));
        List<UserKeyword> keywords = robotFileOutput.getFileModel()
                .getKeywordTable().getKeywords();
        UserKeyword keyword = keywords.get(keywords.size() - 1);
        List<KeywordTeardown> teardowns = keyword.getTeardowns();
        KeywordTeardown teardown = teardowns.get(teardowns.size() - 1);
        teardown.addArgument(rt);

        processingState
                .push(ParsingState.KEYWORD_SETTING_TEARDOWN_KEYWORD_ARGUMENT);

        return rt;
    }


    @Override
    public boolean checkIfCanBeMapped(IRobotFileOutput robotFileOutput,
            RobotLine currentLine, RobotToken rt, String text,
            Stack<ParsingState> processingState) {
        boolean result = false;
        ParsingState state = utility.getCurrentStatus(processingState);
        if (state == ParsingState.KEYWORD_SETTING_TEARDOWN) {
            List<UserKeyword> keywords = robotFileOutput.getFileModel()
                    .getKeywordTable().getKeywords();
            List<KeywordTeardown> teardowns = keywords.get(keywords.size() - 1)
                    .getTeardowns();
            result = utility.checkIfHasAlreadyKeywordName(teardowns);
        } else if (state == ParsingState.KEYWORD_SETTING_TEARDOWN_KEYWORD
                || state == ParsingState.KEYWORD_SETTING_TEARDOWN_KEYWORD_ARGUMENT) {
            result = true;
        }

        return result;
    }

}

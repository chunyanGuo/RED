package org.robotframework.ide.core.testData.text.read.recognizer.settings;

import java.util.regex.Pattern;

import org.robotframework.ide.core.testData.text.read.recognizer.ATokenRecognizer;
import org.robotframework.ide.core.testData.text.read.recognizer.RobotToken.RobotTokenType;


public class LibraryDeclarationRecognizer extends ATokenRecognizer {

    public static final Pattern EXPECTED = Pattern.compile("[ ]?("
            + createUpperLowerCaseWord("Library") + "[\\s]*:" + "|"
            + createUpperLowerCaseWord("Library") + ")");


    public LibraryDeclarationRecognizer() {
        super(EXPECTED, RobotTokenType.SETTING_LIBRARY_DECLARATION);
    }
}

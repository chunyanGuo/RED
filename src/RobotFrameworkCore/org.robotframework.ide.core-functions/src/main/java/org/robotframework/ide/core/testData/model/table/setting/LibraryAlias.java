package org.robotframework.ide.core.testData.model.table.setting;

import org.robotframework.ide.core.testData.model.AModelElement;
import org.robotframework.ide.core.testData.model.FilePosition;
import org.robotframework.ide.core.testData.model.ModelType;
import org.robotframework.ide.core.testData.text.read.recognizer.RobotToken;


public class LibraryAlias extends AModelElement {

    private final RobotToken libraryAliasDeclaration;
    private RobotToken libraryAlias;


    public LibraryAlias(final RobotToken aliasDeclaration) {
        this.libraryAliasDeclaration = aliasDeclaration;
    }


    public RobotToken getLibraryAlias() {
        return libraryAlias;
    }


    public void setLibraryAlias(RobotToken libraryAlias) {
        this.libraryAlias = libraryAlias;
    }


    public RobotToken getLibraryAliasDeclaration() {
        return libraryAliasDeclaration;
    }


    @Override
    public boolean isPresent() {
        return (libraryAliasDeclaration != null);
    }


    @Override
    public ModelType getModelType() {
        return ModelType.LIBRARY_IMPORT_ALIAS_SETTING;
    }


    @Override
    public FilePosition getPosition() {
        return getLibraryAliasDeclaration().getFilePosition();
    }
}

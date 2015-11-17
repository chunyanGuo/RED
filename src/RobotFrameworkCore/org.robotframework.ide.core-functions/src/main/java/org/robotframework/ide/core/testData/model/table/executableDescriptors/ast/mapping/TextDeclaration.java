/*
 * Copyright 2015 Nokia Solutions and Networks
 * Licensed under the Apache License, Version 2.0,
 * see license.txt file for details.
 */
package org.robotframework.ide.core.testData.model.table.executableDescriptors.ast.mapping;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.robotframework.ide.core.testData.model.FilePosition;
import org.robotframework.ide.core.testData.model.table.executableDescriptors.TextPosition;
import org.robotframework.ide.core.testData.model.table.executableDescriptors.ast.ContainerElementType;


public class TextDeclaration implements IElementDeclaration {

    private IElementDeclaration levelUpElement;
    private final List<IElementDeclaration> elementsDeclaredInside = new LinkedList<>();
    private TextPosition text;
    private ContainerElementType mappedType;
    private FilePosition robotTokenPosition;


    public TextDeclaration(final TextPosition text,
            final ContainerElementType mappedType) {
        this.text = text;
        this.mappedType = mappedType;
    }


    public void setLevelUpElement(final IElementDeclaration levelUpElement) {
        this.levelUpElement = levelUpElement;
    }


    @Override
    public void setRobotTokenPosition(final FilePosition robotTokenPosition) {
        this.robotTokenPosition = robotTokenPosition;
    }


    private FilePosition getRobotTokenPosition() {
        return robotTokenPosition;
    }


    @Override
    public TextPosition getStart() {
        return text;
    }


    @Override
    public FilePosition getStartFromFile() {
        FilePosition position = findRobotTokenPosition();
        position = new FilePosition(position.getLine(), position.getColumn()
                + text.getStart(), position.getOffset() + text.getStart());
        return position;
    }


    @Override
    public TextPosition getEnd() {
        return text;
    }


    @Override
    public FilePosition getEndFromFile() {
        FilePosition position = findRobotTokenPosition();
        position = new FilePosition(position.getLine(), position.getColumn()
                + text.getEnd(), position.getOffset() + text.getEnd());
        return position;
    }


    @Override
    public FilePosition findRobotTokenPosition() {
        FilePosition position = getRobotTokenPosition();
        if (position == null) {
            position = this.levelUpElement.findRobotTokenPosition();
        }

        return position;
    }


    public int getLength() {
        int length = 0;
        if (text != null) {
            length = text.getLength();
        }
        return length;
    }


    @Override
    public List<IElementDeclaration> getElementsDeclarationInside() {
        return Collections.unmodifiableList(elementsDeclaredInside);
    }


    @Override
    public IElementDeclaration getLevelUpElement() {
        return levelUpElement;
    }


    @Override
    public void addElementDeclarationInside(IElementDeclaration elementToAdd) {
        throw new UnsupportedOperationException(
                "Adding elements to TEXT declaration is not allowed please use container class for it.");
    }


    @Override
    public void removeElementDeclarationInside(final int indexOfElementToRemove) {
        throw new UnsupportedOperationException(
                "Removing elements to TEXT declaration is not allowed please use container class for it.");

    }


    @Override
    public void removeExactlyTheSameInstance(IElementDeclaration elementToRemove) {
        throw new UnsupportedOperationException(
                "Removing elements to TEXT declaration is not allowed please use container class for it.");

    }


    @Override
    public List<ContainerElementType> getTypes() {
        return Arrays.asList(mappedType);
    }


    @Override
    public boolean isComplex() {
        return false;
    }

}

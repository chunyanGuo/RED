/*
 * Copyright 2015 Nokia Solutions and Networks
 * Licensed under the Apache License, Version 2.0,
 * see license.txt file for details.
 */
package org.robotframework.ide.eclipse.main.plugin.project.build.validation.versiondependent;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.rf.ide.core.testdata.model.RobotVersion;
import org.rf.ide.core.testdata.model.table.SettingTable;
import org.rf.ide.core.testdata.model.table.setting.TestTemplate;
import org.robotframework.ide.eclipse.main.plugin.model.RobotSettingsSection;

import com.google.common.collect.Range;

/**
 * @author Michal Anglart
 */
public class DuplicatedTemplateValidator extends ADuplicatedValidator<TestTemplate> {

    public DuplicatedTemplateValidator(final IFile file, final RobotSettingsSection section) {
        super(file, section);
    }

    @Override
    protected Range<RobotVersion> getApplicableVersionRange() {
        return Range.atLeast(new RobotVersion(3, 0));
    }

    @Override
    protected List<TestTemplate> getElements() {
        final SettingTable table = (SettingTable) section.getLinkedElement();
        return table.getTestTemplates();
    }
}

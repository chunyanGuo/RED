package org.robotframework.ide.eclipse.main.plugin.wizards;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;


class WizardNewRobotSuiteFileCreationPage extends WizardNewFileCreationPage {

    WizardNewRobotSuiteFileCreationPage(final String pageName, final IStructuredSelection selection) {
        super(pageName, selection);
    }

    @Override
    protected InputStream getInitialContents() {
        return new ByteArrayInputStream("*** Test Cases ***".getBytes(StandardCharsets.UTF_8));
    }
}

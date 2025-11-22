package com.zair.application.services;

import com.zair.application.ports.in.ApplicationUseCase;
import com.zair.application.ports.out.OutputPort;

public class ApplicationService implements ApplicationUseCase {
    private final OutputPort outputPort;

    public ApplicationService(OutputPort outputPort) {
        this.outputPort = outputPort;
    }

    @Override
    public void execute() {
        outputPort.action();
    }
}

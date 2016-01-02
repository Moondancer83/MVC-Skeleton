package hu.kalee.skeleton.backend.service;

import hu.kalee.skeleton.backend.model.BackendInputDTO;
import hu.kalee.skeleton.backend.model.BackendOutputDTO;
import hu.kalee.skeleton.backend.model.BackendResult;
import hu.kalee.skeleton.backend.model.ResultStatus;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Mock service.
 *
 * @author Moondancer
 * @since 2015.12.30..
 */
@Component
public class MockService {
    /**
     * Entry point of backend.
     *
     * @param input The input data
     * @return The backend result
     * @throws java.lang.RuntimeException whem some error happens
     */
    public BackendResult call(final BackendInputDTO input) {
        BackendResult result;

        switch (input.getData()) {
            case 204:
                // No content
                result = getWarningResult();
                break;
            case 406:
                // Service warning
                result = getErrorResult();
                break;
            case 500:
                // Service error
                throw new RuntimeException("Service error.");
            case 200:
            default:
                result = getOkResult();
                break;
        }

        return result;
    }

    private BackendResult getErrorResult() {
        BackendResult result = new BackendResult();
        result.setStatus(ResultStatus.ERROR);
        result.setDto(new BackendOutputDTO());
        result.addMessage("message", "System crash...");

        return result;
    }

    private BackendResult getWarningResult() {
        BackendResult result = new BackendResult();
        result.setStatus(ResultStatus.WARNING);
        result.setDto(new BackendOutputDTO());
        result.addMessage("message", "Warning");
        result.addMessage("warning", "No match found.");

        return result;
    }

    private BackendResult getOkResult() {
        BackendResult result = new BackendResult();
        result.setStatus(ResultStatus.OK);
        result.setDto(new BackendOutputDTO());
        result.getDto().setCreated(new Date());
        result.addMessage("message", "Success!");

        return result;
    }
}

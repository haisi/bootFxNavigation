package ch.fhnw.springfx.presentation;

import java.util.Map;

/**
 * Used to pass parameters between controllers.
 *
 * @author Hasan Kara <hasan.kara@fhnw.ch>
 */
public interface PassableParameters {

    /**
     * @param parameters which are passed from one controller to the next
     */
    void setPassedParameters(Map<String, Object> parameters);

}

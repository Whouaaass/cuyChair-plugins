package co.edu.unicauca.cuychair.common.notificationPlugin;

import domain.Conference;
import domain.Paper;

public interface IEmailPlugin {

    void notifySendJobs(Paper job, Conference confe);
}

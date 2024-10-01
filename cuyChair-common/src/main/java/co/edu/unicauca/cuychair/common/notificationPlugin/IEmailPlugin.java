package co.edu.unicauca.cuychair.common.notificationPlugin;

import domain.Conference;
import domain.Paper;
import domain.User;

public interface IEmailPlugin {

    void notifySendJobs(Paper job, Conference confe, User author);
}

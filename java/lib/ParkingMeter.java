/*
Author  : Micahel Borden
Date    : Feb 7, 2019
Update  : Feb 7, 2019

Purpose : Design and implement a class 'ParkingMeter' for parking meters. The 
class has three member variables: 'maxTime' for maximum parking minutes, 'rate' 
for parking rate (minutes per quarter), and 'time' for remaining parking time. 
The class should provide member functions for the client to insert quarters and 
check remaining parting time. The constructor should take the maximum parking 
minutes and the rate.
*/
package lib;
import java.time.LocalDateTime;
import java.time.Duration;

class ParkingMeter {
    public long maxTime, rate;
    private LocalDateTime startTime, endTime, timeLimit;
    boolean active = false;
    public ParkingMeter(long maxTime, long rate) {
        assert rate <= maxTime: "ERROR: rate > maxTime";
        this.maxTime = maxTime;
        this.rate = rate;
    }
    
    public boolean add(long quarters) {
        long minutes = quarters * this.rate;
        if(!this.active) {
            this.active = true;
            this.startTime = LocalDateTime.now();
            this.timeLimit = this.startTime.plusMinutes(maxTime);
        }
        LocalDateTime endTime = this.endTime.plusMinutes(minutes);
        if (endTime.isBefore(this.timeLimit)) {
            this.endTime = endTime;
            return true;
        }
        else
            return false;
    }
    
    public Duration timeRemaining() {
        if (this.endTime.isBefore(LocalDateTime.now()))
            this.active = false;
        Duration df = Duration.between(LocalDateTime.now(), this.endTime);
        return df;
    }
}

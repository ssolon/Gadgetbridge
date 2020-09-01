package nodomain.freeyourgadget.gadgetbridge.service.devices.sonyswr12.entities.alarm;

import java.util.Arrays;

import nodomain.freeyourgadget.gadgetbridge.model.Alarm;
import nodomain.freeyourgadget.gadgetbridge.service.devices.sonyswr12.util.UIntBitWriter;

public class AlarmRepeat {
    private final boolean[] repeat = new boolean[7];

    public AlarmRepeat(Alarm alarm) {
        super();
        setRepeatOnDay(0, alarm.getRepetition(Alarm.ALARM_MON));
        setRepeatOnDay(1, alarm.getRepetition(Alarm.ALARM_TUE));
        setRepeatOnDay(2, alarm.getRepetition(Alarm.ALARM_WED));
        setRepeatOnDay(3, alarm.getRepetition(Alarm.ALARM_THU));
        setRepeatOnDay(4, alarm.getRepetition(Alarm.ALARM_FRI));
        setRepeatOnDay(5, alarm.getRepetition(Alarm.ALARM_SAT));
        setRepeatOnDay(6, alarm.getRepetition(Alarm.ALARM_SUN));
    }

    @Override
    public boolean equals(Object o) {
        if (this != o) {
            if (o == null || this.getClass() != o.getClass()) {
                return false;
            }
            return Arrays.equals(this.repeat, ((AlarmRepeat) o).repeat);
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(this.repeat);
    }

    public void setRepeatOnDay(int i, boolean b) {
        this.repeat[i] = b;
    }

    public int toInt() {
        UIntBitWriter uIntBitWriter = new UIntBitWriter(7);
        uIntBitWriter.appendBoolean(this.repeat[6]);
        uIntBitWriter.appendBoolean(this.repeat[5]);
        uIntBitWriter.appendBoolean(this.repeat[4]);
        uIntBitWriter.appendBoolean(this.repeat[3]);
        uIntBitWriter.appendBoolean(this.repeat[2]);
        uIntBitWriter.appendBoolean(this.repeat[1]);
        uIntBitWriter.appendBoolean(this.repeat[0]);
        return (int) uIntBitWriter.getValue();
    }
}

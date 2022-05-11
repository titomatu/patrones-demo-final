package edu.patrones.demo.event.rnec;

import edu.patrones.demo.dto.RNECRequestDto;
import edu.patrones.demo.event.Event;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
public class RNECEvent implements Event {
    private final UUID eventId = UUID.randomUUID();
    private final Date date = new Date();
    private RNECRequestDto rnecRequestDto;
    private RNECStatus rnecStatus;

    public RNECEvent(RNECRequestDto rnecRequestDto, RNECStatus rnecStatus) {
        this.rnecRequestDto = rnecRequestDto;
        this.rnecStatus = rnecStatus;
    }

    @Override
    public UUID getEventId() {
        return this.eventId;
    }

    @Override
    public Date getDate() {
        return this.date;
    }

    public RNECRequestDto getRnecRequestDto() {
        return rnecRequestDto;
    }

    public RNECStatus getRnecStatus() {
        return rnecStatus;
    }
}

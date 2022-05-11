package edu.patrones.demo.event.centrales;

import edu.patrones.demo.dto.CentralesRequestDto;
import edu.patrones.demo.event.Event;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
public class CentralesEvent implements Event {
    private final UUID eventId = UUID.randomUUID();
    private final Date date = new Date();

    private CentralesRequestDto centralesRequestDto;
    private CentralesStatus centralesStatus;

    public CentralesEvent(CentralesRequestDto centralesRequestDto, CentralesStatus centralesStatus) {
        this.centralesRequestDto = centralesRequestDto;
        this.centralesStatus = centralesStatus;
    }

    @Override
    public UUID getEventId() {
        return this.eventId;
    }

    @Override
    public Date getDate() {
        return this.date;
    }

    public CentralesRequestDto getCentralesRequestDto() {
        return centralesRequestDto;
    }

    public CentralesStatus getCentralesStatus() {
        return centralesStatus;
    }
}

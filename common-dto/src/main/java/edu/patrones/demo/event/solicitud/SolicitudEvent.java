package edu.patrones.demo.event.solicitud;

import edu.patrones.demo.dto.SolicitudDto;
import edu.patrones.demo.event.Event;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
public class SolicitudEvent implements Event {

    private final UUID eventId = UUID.randomUUID();
    private final Date date = new Date();
    private SolicitudDto solicitudDto;
    private SolicitudStatus solicitudStatus;

    public SolicitudEvent(SolicitudDto solicitudDto, SolicitudStatus solicitudStatus) {
        this.solicitudDto = solicitudDto;
        this.solicitudStatus = solicitudStatus;
    }

    @Override
    public UUID getEventId() {
        return this.eventId;
    }

    @Override
    public Date getDate() {
        return this.date;
    }

    public SolicitudDto getSolicitudDto() {
        return solicitudDto;
    }

    public SolicitudStatus getSolicitudStatus() {
        return solicitudStatus;
    }
}

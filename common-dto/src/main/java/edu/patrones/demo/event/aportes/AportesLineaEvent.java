package edu.patrones.demo.event.aportes;

import edu.patrones.demo.dto.AportesLineaDto;
import edu.patrones.demo.event.Event;
import edu.patrones.demo.event.rnec.RNECStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
public class AportesLineaEvent implements Event {
    private final UUID eventId = UUID.randomUUID();
    private final Date date = new Date();
    private AportesLineaDto aportesLineaDto;
    private AportesLineaStatus aportesLineaStatus;

    //
    public AportesLineaEvent(AportesLineaDto aportesLineaDto, AportesLineaStatus aportesLineaStatus) {
        this.aportesLineaDto = aportesLineaDto;
        this.aportesLineaStatus = aportesLineaStatus;
    }

    @Override
    public UUID getEventId() {
        return this.eventId;
    }

    @Override
    public Date getDate() {
        return this.date;
    }

    public AportesLineaDto getAportesLineaDto() {
        return aportesLineaDto;
    }

    public AportesLineaStatus getAportesLineaStatus() {
        return aportesLineaStatus;
    }
}

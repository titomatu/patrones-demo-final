package edu.patrones.demo.event.estudio;

import edu.patrones.demo.dto.EstudioRequestDto;
import edu.patrones.demo.dto.MotorReglaResponseDto;
import edu.patrones.demo.event.Event;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
public class EstudioEvent implements Event {
    private final UUID eventId = UUID.randomUUID();
    private final Date date = new Date();

    private EstudioRequestDto estudioRequestDto;
    private EstudioStatus estudioStatus;
    private MotorReglaResponseDto motorReglaResponseDto;

    //


    public EstudioEvent(EstudioRequestDto estudioRequestDto, MotorReglaResponseDto motorReglaResponseDto, EstudioStatus estudioStatus) {
        this.estudioRequestDto = estudioRequestDto;
        this.motorReglaResponseDto = motorReglaResponseDto;
        this.estudioStatus = estudioStatus;
    }

    @Override
    public UUID getEventId() {
        return this.eventId;
    }

    @Override
    public Date getDate() {
        return this.date;
    }

    public EstudioRequestDto getEstudioRequestDto() {
        return estudioRequestDto;
    }

    public EstudioStatus getEstudioStatus() {
        return estudioStatus;
    }
}

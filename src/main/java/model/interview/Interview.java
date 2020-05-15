package model.interview;

import model.candidat.Candidat;
import model.common.*;
import model.recruiter.Recruiter;
import model.room.Room;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public class Interview {
    private UUID interviewUuid;
    private Candidat interviewCandidat;
    private Recruiter interviewRecruiter;
    private UUID roomUuid;
    private Slot slot;
    private Status status;
    
    public Interview(CandidatDTO candidatDTO, SlotDTO slotDTO) {
        this.interviewCandidat = candidatDTO.DtoToCandidat();

        this.slot = slotDTO.DtoToSlot();
    }

    public void planified() {
        setStatus(Status.PLANIFIED);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Interview interview = (Interview) o;
        return Objects.equals(interviewUuid, interview.interviewUuid) &&
                Objects.equals(interviewCandidat, interview.interviewCandidat) &&
                Objects.equals(interviewRecruiter, interview.interviewRecruiter) &&
                Objects.equals(roomUuid, interview.roomUuid) &&
                Objects.equals(slot, interview.slot) &&
                status == interview.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(interviewUuid, interviewCandidat, interviewRecruiter, roomUuid, slot, status);
    }

    public void setRecruiter(List<RecruiterDTO> recruitersDTO) throws model.recruiter.exception.RecruiterException {
        Optional<Recruiter> recruiterStream = recruitersDTO.stream()
                .map(recruiterDTO -> recruiterDTO.DtoToRecruiter())
                .filter(recruiter -> recruiter.canTestCandidat(interviewCandidat.getSkills()))
                .findFirst();

        if(!recruiterStream.isPresent()){
            throw new model.recruiter.exception.RecruiterException("No recruiter is available");
        }

        this.interviewRecruiter = recruiterStream.get();
    }

    public void plan(List<RecruiterDTO> recruitersDTO, List<RoomDTO> roomsDTO) {
        setRecruiter(recruitersDTO);
        Room room = getAvailableRoom(roomsDTO, slot);
        this.interviewUuid = UUID.randomUUID();

        setStatus(Status.PLANIFIED);
        setRoomUuid(room.getRoomUuid());
    }

    public Room getAvailableRoom(List<RoomDTO> roomsDTO, Slot slot) throws model.room.exception.RoomException {
        Optional<Room> roomSteam = roomsDTO.stream()
                .map(roomDTO -> roomDTO.DtoToRoom())
                .filter(room -> room.getFreeRoom(slot))
                .findFirst();

        if(!roomSteam.isPresent()){
            throw new model.room.exception.RoomException("No room is available");
        }

        return roomSteam.get();
    }

    public InterviewDTO InterviewToDTO(){
        return new InterviewDTO(interviewCandidat,
                interviewRecruiter,
                roomUuid,
                slot,
                status);
    }

    public void setRoom(UUID roomUuid) {
        setRoomUuid(roomUuid);
    }

    public void setInterviewUuid(UUID interviewUuid) {
        this.interviewUuid = interviewUuid;
    }

    public UUID getRoomUuid() {
        return roomUuid;
    }

    public void setRoomUuid(UUID roomUuid) {
        this.roomUuid = roomUuid;
    }

    public UUID getInterviewUuid() {
        return interviewUuid;
    }

    public Candidat getInterviewCandidat() {
        return interviewCandidat;
    }

    public void setInterviewCandidat(Candidat interviewCandidat) {
        this.interviewCandidat = interviewCandidat;
    }

    public Recruiter getInterviewRecruiter() {
        return interviewRecruiter;
    }

    public void setInterviewRecruiter(Recruiter interviewRecruiter) {
        this.interviewRecruiter = interviewRecruiter;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void confirmInterview() {
        this.setStatus(Status.CONFIRMED);
    }

    public void cancelInterview() {
        this.setStatus(Status.CANCELED);
    }

    // TODO : Faire le changement de la salle
    public void postPonedInterview(Slot slot) {
        this.setSlot(slot);
        this.setStatus(Status.POSTPONED);
    }
}

package workforcemanger.workforce.mapper;

import workforcemanger.workforce.dto.AbsenceDTO;
import workforcemanger.workforce.entity.Absence;

public class AbsenceDTOMapper {

    public AbsenceDTOMapper() {}

    public Absence dtoToAbsence(AbsenceDTO absenceDTO) {
        try {
            Absence absence = new Absence();
            absence.setId(absenceDTO.getId());
            absence.setType(absenceDTO.getType());
            absence.setDate(absenceDTO.getDate());
            absence.setDuration(absenceDTO.getDuration());
            return absence;
        } catch (Exception e) {
            throw new RuntimeException("Error mapping AbsenceDTO to Absence", e);
        }
    }

    public AbsenceDTO absenceToDto(Absence absence) {
        try {
            AbsenceDTO absenceDTO = new AbsenceDTO();
            absenceDTO.setId(absence.getId());
            absenceDTO.setType(absence.getType());
            absenceDTO.setDate(absence.getDate());
            absenceDTO.setDuration(absence.getDuration());
            return absenceDTO;
        } catch (Exception e) {
            throw new RuntimeException("Error mapping Absence to AbsenceDTO", e);
        }
    }
}

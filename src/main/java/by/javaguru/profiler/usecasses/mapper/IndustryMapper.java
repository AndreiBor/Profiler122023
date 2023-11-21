package by.javaguru.profiler.usecasses.mapper;

import by.javaguru.profiler.persistence.model.Industry;
import by.javaguru.profiler.usecasses.dto.IndustryResponseDto;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        builder = @Builder(disableBuilder = true))
public interface IndustryMapper {

    IndustryResponseDto fromEntityToDto(Industry industry);

}

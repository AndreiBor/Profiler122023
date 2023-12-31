package by.javaguru.profiler.api.controllers;

import by.javaguru.profiler.usecasses.ExperienceService;
import by.javaguru.profiler.usecasses.annotation.IsCvExists;
import by.javaguru.profiler.usecasses.annotation.SequenceNumbersValidation;
import by.javaguru.profiler.usecasses.dto.ExperienceRequestDto;
import by.javaguru.profiler.usecasses.dto.ExperienceResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Tag(name = "Experience Controller", description = "API for working with experience")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cvs/{uuid}/experience")
@Slf4j
@Validated
public class ExperienceApiController {

    private final ExperienceService experienceService;

    @Operation(summary = "Save list of jobs in the user's cv")
    @ApiResponse(responseCode = "201", description = "CREATE",
            content = @Content(mediaType = APPLICATION_JSON_VALUE,
                    array = @ArraySchema(schema = @Schema(implementation = ExperienceResponseDto.class))))
    @PostMapping
    public ResponseEntity<List<ExperienceResponseDto>> add(
            @RequestBody
            @NotEmpty(message = "List of jobs must not be empty")
            @Size(max = 5, message = "Amount of jobs should not be more than 5")
            @SequenceNumbersValidation
            List<@Valid ExperienceRequestDto> request,
            @PathVariable(name = "uuid") @IsCvExists String uuid
    ) {
        log.debug("Input data for creating list of experience: {}", request);
        List<ExperienceResponseDto> response = experienceService.save(request, uuid);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Operation(summary = "Get list of user experience by CV uuid")
    @ApiResponse(responseCode = "200", description = "GET", content = @Content(mediaType = APPLICATION_JSON_VALUE,
            array = @ArraySchema(schema = @Schema(implementation = ExperienceResponseDto.class))))
    @GetMapping
    public ResponseEntity<List<ExperienceResponseDto>> getExperienceByCvUuid(@PathVariable(name = "uuid") @IsCvExists String cvUuid) {
        List<ExperienceResponseDto> experienceResponseDtos = experienceService.getExperienceByCvUuid(cvUuid);
        return ResponseEntity.ok(experienceResponseDtos);
    }
}

package by.javaguru.profiler.usecasses.impl;

import by.javaguru.profiler.persistence.model.Language;
import by.javaguru.profiler.persistence.repository.LanguageRepository;
import by.javaguru.profiler.usecasses.dto.LanguageResponseDto;
import by.javaguru.profiler.usecasses.mapper.LanguageMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static by.javaguru.profiler.util.LanguageTestData.createLanguage;
import static by.javaguru.profiler.util.LanguageTestData.createLanguageResponseDto;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LanguageServiceImplTest {

    @InjectMocks
    private LanguageServiceImpl languageService;

    @Mock
    private LanguageMapper languageMapper;

    @Mock
    private LanguageRepository languageRepository;

    @Test
    void testGetLanguagesShouldReturnLanguages() {
        Language language = createLanguage().build();
        LanguageResponseDto languageResponseDto = createLanguageResponseDto();

        when(languageRepository.findAllByOrderByName()).thenReturn(List.of(language));
        when(languageMapper.fromEntityToDto(language)).thenReturn(languageResponseDto);

        List<LanguageResponseDto> languages = languageService.getLanguages();
        assertEquals(1, languages.size());
    }

}

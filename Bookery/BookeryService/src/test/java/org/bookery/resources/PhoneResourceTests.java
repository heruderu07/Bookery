package org.bookery.resources;
 
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.bookery.mappers.PhoneMapper;
import org.bookery.models.Phone;
import org.bookery.repositories.PhoneRepository;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

@SpringBootTest
@AutoConfigureMockMvc
public class PhoneResourceTests
{
	@Autowired
	PhoneMapper mapper = new PhoneMapper();
	
	@Autowired
	PhoneResource resource;

	@MockBean
	PhoneRepository repository;

	EasyRandom generator = new EasyRandom();
	
	@Test
	public void Given_PhoneExists_When_FindById_Then_ReturnOk() throws Exception
	{
		// Arrange
		var model = generator.nextObject(Phone.class);
		var projection = mapper.project(model);
		var expectedResponse = HttpStatus.OK;

		doReturn(Optional.of(model))
			.when(repository)
			.findById(model.getId());

		// Act
		var output = resource.findById(model.getId());
		var outputBody = output.getBody();

		// Assert
		assertNotNull(outputBody);
		assertEquals(projection.getId(), outputBody.getId());
		assertEquals(expectedResponse, output.getStatusCode());
		verify(repository, times(1)).findById(model.getId());
		verifyNoMoreInteractions(repository);
	}

	@Test
	public void Given_PhoneDoesNotExist_When_FindById_Then_ReturnNotFound() throws Exception
	{
		// Arrange
		var expectedStatus = HttpStatus.NOT_FOUND;
		var correctId = UUID.fromString("00000000-0000-0000-0000-000000000001");
		var wrongId = UUID.fromString("00000000-0000-0000-0000-000000000011");
		var model = generator.nextObject(Phone.class);

		model.setId(correctId);

		doReturn(Optional.of(model))
			.when(repository)
			.findById(correctId);

		// Act
		var output = resource.findById(wrongId);
		var outputBody = output.getBody();

		// Assert
		assertNull(outputBody);
		assertEquals(expectedStatus, output.getStatusCode());
		verify(repository, times(1)).findById(wrongId);
		verifyNoMoreInteractions(repository);
	}

	@Test
	public void Given_PhoneExists_When_Delete_Then_ReturnOk() throws Exception
	{
		// Arrange
		var model = generator.nextObject(Phone.class);
		var expectedResponse = HttpStatus.OK;

		doReturn(Optional.of(model))
			.when(repository)
			.findById(model.getId());

		// Act
		var actualResponse = resource.delete(model.getId());

		// Assert
		assertEquals(expectedResponse, actualResponse.getStatusCode());
		verify(repository, times(1)).findById(model.getId());
		verify(repository, times(1)).deleteById(model.getId());
		verifyNoMoreInteractions(repository);
	}

	@Test
	public void Given_PhoneDoesNotExist_When_Delete_Then_ReturnNotFound() throws Exception
	{
		// Arrange
		var model = generator.nextObject(Phone.class);
		var expectedResponse = HttpStatus.NOT_FOUND;

		// Act
		var actualResponse = resource.delete(model.getId());

		// Assert
		assertEquals(expectedResponse, actualResponse.getStatusCode());
		verify(repository, times(1)).findById(model.getId());
		verifyNoMoreInteractions(repository);
	}

	@Test
	public void Given_PhonesExist_When_List_Then_ReturnOk() throws Exception
	{
		// Arrange
		var models = generator.objects(Phone.class, 5).collect(Collectors.toList());
		var expectedResponse = HttpStatus.OK;

		doReturn(models)
			.when(repository)
			.findAll();

		// Act
		var actualResponse = resource.list();

		// Assert
		assertEquals(expectedResponse, actualResponse.getStatusCode());
		verify(repository, times(1)).findAll();
		verifyNoMoreInteractions(repository);
	}
	@Test
	public void Given_PhonesDoNotExist_When_List_Then_ReturnNotFound() throws Exception
	{
		// Arrange
		var models = generator.objects(Phone.class, 0).collect(Collectors.toList());
		var expectedResponse = HttpStatus.NOT_FOUND;

		doReturn(models)
			.when(repository)
			.findAll();

		// Act
		var actualResponse = resource.list();

		// Assert
		assertEquals(expectedResponse, actualResponse.getStatusCode());
		verify(repository, times(1)).findAll();
		verifyNoMoreInteractions(repository);
	}
}
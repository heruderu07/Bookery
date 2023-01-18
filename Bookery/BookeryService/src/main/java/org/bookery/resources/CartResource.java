package org.bookery.resources;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.bookery.mappers.CartMapper;
import org.bookery.projections.CartProjection;
import org.bookery.repositories.CartRepository;
import org.bookery.utilities.MappingUtility;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.var;

@RestController
@RequestMapping("/api/cart")
public class CartResource 
{
	@Autowired
	private CartRepository repository;

	@Autowired
	private CartMapper mapper;
	
	@GetMapping
	public ResponseEntity<List<CartProjection>> list()
	{
		var projections = repository
			.findAll()
			.stream()
			.map(model -> mapper.project(model))
			.collect(Collectors.toList());

		var response = HttpStatus.OK;

		if(projections.isEmpty())
		{
			response = HttpStatus.NOT_FOUND;
		}

		for(var projection : projections)
		{
			UUID id = projection.getId();
			projection.add(linkTo(methodOn(CartResource.class).findById(id)).withSelfRel());
		}

		return new ResponseEntity<List<CartProjection>>(projections, response);
			
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CartProjection> findById(@PathVariable UUID id) 
	{
		var optionalModel = repository
			.findById(id)
			.stream()
			.map(model -> mapper.project(model))
			.findFirst();
		
			optionalModel.get().add(linkTo(methodOn(CartResource.class).list()).withRel("Cart List: "));
		return new ResponseEntity<CartProjection>(optionalModel.get(), HttpStatus.OK);
			
	}
	
	@PostMapping
	public ResponseEntity<CartProjection> create(@Valid @RequestBody CartProjection projection, HttpServletResponse response) 
	{
		var model = mapper.unproject(projection);

		var entity = repository
			.save(model);

		var uri = (URI)ServletUriComponentsBuilder
			.fromCurrentRequestUri()
			.path("/{id}")
			.buildAndExpand(entity
				.getId())
			.toUri();

		return ResponseEntity
			.created(uri)
			.body(projection);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CartProjection> update(@PathVariable UUID id, @RequestBody CartProjection projection)
	{
		var existingProjection = repository
			.findById(id)
			.stream()
			.map(model -> mapper.project(model))
			.findFirst()
			.get();

		BeanUtils
			.copyProperties(projection, existingProjection, MappingUtility.getNullPropertyNames(projection));
		
		var model = mapper.unproject(existingProjection);

		repository
			.save(model);

		return ResponseEntity
			.ok(existingProjection);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<UUID> delete(@PathVariable UUID id)
	{
		var optionalModel = repository
			.findById(id)
			.stream()
			.map(model -> mapper.project(model))
			.findFirst();

		if(!optionalModel.isPresent())
		{
			return new ResponseEntity<UUID>(HttpStatus.NOT_FOUND); 
		}
		
		repository
			.deleteById(id);

		return ResponseEntity
			.ok(id);
	}
}
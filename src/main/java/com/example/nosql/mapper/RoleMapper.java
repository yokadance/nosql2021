package com.example.nosql.mapper;

import com.example.nosql.dto.role.request.CreateRoleDto;
import com.example.nosql.dto.role.response.ReadRoleDto;
import com.example.nosql.model.Role;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
  unmappedTargetPolicy = ReportingPolicy.IGNORE,
  componentModel = "spring",
  injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface RoleMapper {
  ReadRoleDto roleToReadRoleDto(Role role);

  Role createRoleDtoTORole(CreateRoleDto createRoleDto);
}
